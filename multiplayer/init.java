import java.util.UUID;
import java.util.Arrays;
import java.awt.*;
import javax.swing.*;
public class init
{
    
    public static void main(String args[])
    {
        
        UUID uuid = UUID.randomUUID();
        
        String[] rand = new String[2];
        
        rand[0] = uuid.toString().substring(0,6);
        
        JFrame frame = new JFrame();
        
        rand[1] = (String)JOptionPane.showInputDialog(
                    frame,
                    "Your id is:  "+rand[0]+"\n"
                    + "Enter your partners ID to play",
                    "Customized Dialog",
                    JOptionPane.PLAIN_MESSAGE);
                    
        Arrays.sort(rand);
        
        String id = rand[0]+rand[1];
        
        multiplayer.connect(id);
        
    }
}
