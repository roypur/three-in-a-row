import java.net.*;
import java.io.*;
import com.google.gson.*;

public class multiplayer extends game
{
    
    public static void get(String id)
    {
    
        String update = "";
        
        while (true)
        {
            String received;
            try
            {
            
                BufferedReader reader;
            
                URL url = new URL("https://k8icb.firebaseio.com/tmp/"+id+".json");
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                httpCon.setRequestMethod("GET");
            
                reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
 
                received = reader.readLine();
                
                if(received.equals(update)==false)
                {
                    update = received;
                    
                    Gson gson = new Gson();
                    
                    data d = gson.fromJson(update, data.class);
                    
                    
                    updateGame(d.x, d.y, d.player);

                }    

            }
            catch (MalformedURLException e)
            {
                //e.printStackTrace();
            }
            catch (ProtocolException e)
            {
                //e.printStackTrace();
            }
            catch (IOException e)
            {
                //e.printStackTrace();
            }                
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }
    }
    
    public static void set(String id, int x, int y, int player)
    {
    
        data obj = new data(x,y,player);
        
        Gson gson = new Gson();
        
        String json = gson.toJson(obj);
        
        try
        {
            URL url = new URL("https://k8icb.firebaseio.com/tmp/"+id+".json");
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("PUT");
            OutputStreamWriter out = new OutputStreamWriter(
            httpCon.getOutputStream());
            out.write(json);
            out.close();
            httpCon.getInputStream();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (ProtocolException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}

class data
{
    int x;
    int y;
    int player;
    data(int x, int y, int player)
    {
        this.x = x;
        this.y = y;
        this.player = player;
    }
}
