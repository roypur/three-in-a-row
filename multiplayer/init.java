import java.util.UUID;
import java.util.Arrays;
import java.awt.*;
import javax.swing.*;
public class init
{

    public static void main(String args[])
    {
        multiplayer mp = new multiplayer();
        
        UUID uuid = UUID.randomUUID();
        
        String[] rand = new String[2];
        
        rand[0] = uuid.toString().substring(0,6);
        
        String me = rand[0];
        
        JFrame frame = new JFrame();
        
        rand[1] = (String)JOptionPane.showInputDialog(
                    frame,
                    "Your id is:  "+me+"\n"
                    + "Enter your partners ID to play",
                    "Customized Dialog",
                    JOptionPane.PLAIN_MESSAGE);
                    
        Arrays.sort(rand);
        
        String id = rand[0]+rand[1];
        
        int player;
        
        if(me.equals(rand[0]))
        {
            player=1;
        }
        else
        {
            player=2;
        }
        
        
        
        mp.get(id);
        
    }
}
