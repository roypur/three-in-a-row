import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  //notice javax
public class game extends JFrame implements ActionListener
{
    public static int round = 0;
    public static JFrame frame = new JFrame();
    
    public static JButton[][] grid;
    
    
    
    public static boolean endgame = false;
    
    JButton reset = new JButton("reset");
    
    public static JLabel playerText = new JLabel("Player1");
    
    public game()
    {
        int myPlayer = init.player;

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
                if(round%2==0)
                {
                    playerText.setText("Player1");
                }
                else
                {
                    playerText.setText("Player2");
                }
                round++;
            }
            getWinner();
        }
    }
    
    public void actionPerformed(ActionEvent event)
    {
        int myPlayer = init.player;
        
        Object source = event.getSource();

        if(((myPlayer==1) && (round%2==0)) || ((myPlayer==2) && round%2==1))
        {
            round++;

            if(source==reset)
            {
                for(int x=0; x<3; x++)
                {
                    for(int y=0; y<3; y++)
                    {
                        grid[x][y].setText("");
                        round = 0;
                        playerText.setText("Player1");
                        endgame=false;
                    }
                }
            }
            else if(endgame==false)
            {
                for(int x=0; x<3; x++)
                {
                    for(int y=0; y<3; y++)
                    {
                        if(source==grid[x][y])
                        {
                            if(grid[x][y].getText().equals(""))
                            {
                                multiplayer.set(init.id, x, y, myPlayer);
                                if(round%2==0)
                                {
                                    grid[x][y].setText("2");
                                    playerText.setText("Player1");
                                }
                                else
                                {
                                    grid[x][y].setText("1");
                                    playerText.setText("Player2");
                                }
                            }
                        }
                    }
                }
            }    
        }
        getWinner();
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
                JOptionPane.showMessageDialog(frame,"Player 1 wins","tic-tac-toe",JOptionPane.PLAIN_MESSAGE);
                endgame=true;
            }
            else if(row2==3)
            {
                JOptionPane.showMessageDialog(frame,"Player 2 wins","tic-tac-toe",JOptionPane.PLAIN_MESSAGE);
                endgame=true;
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
                JOptionPane.showMessageDialog(frame,"Player 1 wins","tic-tac-toe",JOptionPane.PLAIN_MESSAGE);
                endgame=true;
            }
            else if(column2==3)
            {
                JOptionPane.showMessageDialog(frame,"Player 2 wins","tic-tac-toe",JOptionPane.PLAIN_MESSAGE);
                endgame=true;
            }
                    
        }
            
        if(grid[1][1].getText().equals("1"))
        {
            if((grid[0][0].getText().equals("1") && grid[2][2].getText().equals("1")) || grid[0][2].getText().equals("1") && grid[2][0].getText().equals("1"))
            {
                JOptionPane.showMessageDialog(frame,"Player 1 wins","tic-tac-toe",JOptionPane.PLAIN_MESSAGE);
                endgame=true;
            }
        }
        else if(grid[1][1].getText().equals("2"))
        {
            if((grid[0][0].getText().equals("2") && grid[2][2].getText().equals("2")) || grid[0][2].getText().equals("2") && grid[2][0].getText().equals("2"))
            {
                JOptionPane.showMessageDialog(frame,"Player 2 wins","tic-tac-toe",JOptionPane.PLAIN_MESSAGE);
                endgame=true;
            }
        }
    }
}   
