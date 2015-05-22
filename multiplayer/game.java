import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  //notice javax
public class game extends JFrame implements ActionListener
{
    public static int round = 0;
    
    public static JFrame frame = new JFrame("tic-tac-toe Player"+Integer.toString(init.player));
    
    public static JButton[][] grid;
    
    
    
    public static boolean endgame = false;
    
    JButton reset = new JButton("reset");
    
    public static JLabel playerText = new JLabel();
    
    
    
    
    
    public game()
    {

        if(init.player==1)
        {
            playerText.setText("you");
        }
        else
        {
            playerText.setText("enemy");
        }

        frame.setLayout(new GridLayout(4,3));
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grid = new JButton[3][3];
        
        for(int x=0; x<3; x++)
        {
            for(int y=0; y<3; y++)
            {
                grid[x][y] = new JButton("");
                frame.add(grid[x][y]);
                
                grid[x][y].addActionListener(this);
                
            }
        }
        
        reset.addActionListener(this);
        
        frame.add(new JLabel("Player:"));
        frame.add(playerText);
        frame.add(reset);
        
        frame.pack();
        frame.setVisible(true);
        
    }
    public static void updateGame(int x, int y, int player)
    {
        if((x<4) && (y<4))
        {
            if(grid[x][y].getText().equals(""))
            {
                grid[x][y].setText(Integer.toString(player));
                
                round++;
                if(round%2==0)
                {
                    if(init.player==1)
                    {
                        playerText.setText("you");
                    }
                    else
                    {
                        playerText.setText("enemy");
                    }
                }
                else
                {
                    if(init.player==2)
                    {
                        playerText.setText("you");
                    }
                    else
                    {
                        playerText.setText("enemy");
                    }
                }
                
            }
            getWinner();
        }
    }
    
    public void actionPerformed(ActionEvent event)
    {
        
        Object source = event.getSource();
        
        boolean full = true;
        
        for(int x=0; x<3; x++)
        {
            for(int y=0; y<3; y++)
            {
                if(grid[x][y].getText().equals(""))
                {
                    full = false;
                }
            }
        }
         
        if((source==reset) && ((endgame==true) || (full==true)))
        {
            for(int x=0; x<3; x++)
            {
                for(int y=0; y<3; y++)
                {
                    grid[x][y].setText("");
                    round = 0;
                    if(init.player==1)
                    {
                        playerText.setText("you");
                    }
                    else
                    {
                        playerText.setText("enemy");
                    }
                    endgame=false;
                }
            }
        }

        if(((init.player==1) && (round%2==0)) || ((init.player==2) && round%2==1))
        {
            round++;

            if(endgame==false)
            {
                for(int x=0; x<3; x++)
                {
                    for(int y=0; y<3; y++)
                    {
                        if(source==grid[x][y])
                        {
                            if(grid[x][y].getText().equals(""))
                            {
                                multiplayer.set(init.id, x, y, init.player);
                                if(round%2==0)
                                {
                                    grid[x][y].setText("2");
                                    
                                    if(init.player==1)
                                    {
                                        playerText.setText("you");
                                    }
                                    else
                                    {
                                        playerText.setText("enemy");
                                    }
                                }
                                else
                                {
                                    grid[x][y].setText("1");
                                    if(init.player==2)
                                    {
                                        playerText.setText("you");
                                    }
                                    else
                                    {
                                        playerText.setText("enemy");
                                    }
                                }
                            }
                        }
                    }
                }
            }    
        }
        //getWinner();
    }
    public static void getWinner()
    {
        
            //horizontal win
        for(int x=0; x<3; x++)
        {
            int row1 = 0;
            int row2 = 0;
                    
            for(int y=0; y<3; y++)
            {
                if(grid[x][y].getText().equals("1"))
                {
                    row1++;
                }
                else if(grid[x][y].getText().equals("2"))
                {
                    row2++;
                }
            }
                
            if(row1==3)
            {
                winner(1);
            }
            else if(row2==3)
            {
                winner(2);
            }
                    
        }
        
        //vertical win
        for(int y=0; y<3; y++)
        {
            int column1 = 0;
            int column2 = 0;
                        
            for(int x=0; x<3; x++)
            {
                if(grid[x][y].getText().equals("1"))
                {
                    column1++;
                }
                else if(grid[x][y].getText().equals("2"))
                {
                    column2++;
                }
            }
                
            if(column1==3)
            {
                winner(1);
            }
            else if(column2==3)
            {
                winner(2);
            }
                    
        }
            
        if(grid[1][1].getText().equals("1"))
        {
            if((grid[0][0].getText().equals("1") && grid[2][2].getText().equals("1")) || grid[0][2].getText().equals("1") && grid[2][0].getText().equals("1"))
            {
                winner(1);
            }
        }
        else if(grid[1][1].getText().equals("2"))
        {
            if((grid[0][0].getText().equals("2") && grid[2][2].getText().equals("2")) || grid[0][2].getText().equals("2") && grid[2][0].getText().equals("2"))
            {
                winner(2);
            }
        }
    }
    public static void winner(int player)
    {
        if(player==init.player)
        {
            JOptionPane.showMessageDialog(frame,"You win!","tic-tac-toe",JOptionPane.PLAIN_MESSAGE);
            endgame = true;
        }
        else
        {
            JOptionPane.showMessageDialog(frame,"You loose!","tic-tac-toe",JOptionPane.PLAIN_MESSAGE);
            endgame = true;            
        }
    }
}   
