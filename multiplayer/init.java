import java.util.UUID;
import java.util.Arrays;
import java.awt.*;
import javax.swing.*;
public class init
{
    public static int player;
    public static String id;
    
    public static void main(String args[])
    {
        multiplayer mp = new multiplayer();
        
        UUID uuid = UUID.randomUUID();
        
        String[] rand = new String[2];
        
        rand[0] = uuid.toString().substring(0,3);
        
        String me = rand[0];
        
        JFrame frame = new JFrame();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        rand[1] = (String)JOptionPane.showInputDialog(
                    frame,
                    "Your id is:  "+me+"\n"
                    + "Enter your partners ID to play",
                    "Enter ID",
                    JOptionPane.PLAIN_MESSAGE);
                    
        Arrays.sort(rand);
        
        id = rand[0]+rand[1];
        
        
        
        if(me.equals(rand[0]))
        {
            player=1;
        }
        else
        {
            player=2;
        }
        
        mp.set(id, 4, 4, 1);
        
        mp.get(id);
        
        
    }
}
