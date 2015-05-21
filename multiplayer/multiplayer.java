import java.net.*;
import java.io.*;
import com.google.gson.*;

public class multiplayer
{
    public static void get(String id)
    {
        
        try
        {
            URL url = new URL("https://k8icb.firebaseio.com/tmp/"+id+".json");
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("GET");
            OutputStreamWriter out = new OutputStreamWriter(
            httpCon.getOutputStream());
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
    
    public static void set(String id, int x, int y, int player)
    {
    
        data obj = new data(x,y,player);
        
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        
        System.out.println(json);
        
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
    private int x;
    private int y;
    private int player;
    data(int x, int y, int player)
    {
        this.x = x;
        this.y = y;
        this.player = player;
    }
}
