import java.net.*;
import java.io.*;
import com.google.gson.*;

public class multiplayer
{
    public void connect(String id)
    {    
        
        data obj = new data();
        
        obj.x = 88;
        
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        
        System.out.println(json);
        
        try
        {
            URL url = new URL("https://k8icb.firebaseio.com/"+id+".json");
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
    int x = 0;
    int y = 0;
    String player = "d";

    data()
    {        
        this.x = 0;
        this.y = 0;
        this.player = "";
    }
}
