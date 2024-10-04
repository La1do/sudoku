
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class mode extends JPanel {
    
    
        mode(){
        
        this.setBounds(0,720 / 7,(1024 / 6) + 35, 350 );
        GridLayout gridLayout = new GridLayout(7,1,5,5);
        
        this.setLayout(gridLayout);
        
        
        //nut 1
        JButton a1 = new JButton("Easy");
        a1.setBackground(new Color(0x211B1B));
        a1.setForeground(Color.WHITE);
        a1.setFont(new Font("Serif", Font.BOLD, 20));
        a1.setHorizontalAlignment(SwingConstants.LEFT);
        a1.setFocusable(Boolean.FALSE);
        a1.setIcon(new ImageIcon(mode.class.getResource("easy.png")));
        
        //nut 2
        JButton a2 = new JButton("Medium"); 
        a2.setBackground(new Color(0x211B1B));
        a2.setForeground(Color.WHITE);
        a2.setFont(new Font("Serif", Font.BOLD, 20));
        a2.setHorizontalAlignment(SwingConstants.LEFT);
        a2.setFocusable(Boolean.FALSE);
        a2.setIcon(new ImageIcon(mode.class.getResource("medium.png"))); 
        
        //nut 3
        JButton a3 = new JButton("Hard");  
        a3.setBackground(new Color(0x211B1B));
        a3.setForeground(Color.WHITE);
        a3.setFont(new Font("Serif", Font.BOLD, 20));
        a3.setHorizontalAlignment(SwingConstants.LEFT);
        a3.setFocusable(Boolean.FALSE);
        a3.setIcon(new ImageIcon(mode.class.getResource("hard.png"))); 
        //nut 4
        JButton a4 = new JButton("Evil"); 
        a4.setBackground(new Color(0x211B1B));
        a4.setForeground(Color.WHITE);
        a4.setFont(new Font("Serif", Font.BOLD, 20));
        a4.setHorizontalAlignment(SwingConstants.LEFT);
        a4.setFocusable(Boolean.FALSE);
        a4.setIcon(new ImageIcon(mode.class.getResource("evil.png"))); 
        
        JButton a5 = new JButton("GOD"); 
        a5.setBackground(new Color(0x211B1B));
        a5.setForeground(Color.WHITE);
        a5.setFont(new Font("Serif", Font.BOLD, 20));
        a5.setHorizontalAlignment(SwingConstants.LEFT);
        a5.setFocusable(Boolean.FALSE);
        a5.setIcon(new ImageIcon(mode.class.getResource("god.png"))); 

        JButton a6 = new JButton("Daily Challenges"); 
        a6.setBackground(new Color(0x211B1B));
        a6.setForeground(Color.WHITE);
        a6.setFont(new Font("Serif", Font.BOLD, 20));
        a6.setHorizontalAlignment(SwingConstants.LEFT);
        a6.setFocusable(Boolean.FALSE);
        a6.setIcon(new ImageIcon(mode.class.getResource("challenges.png"))); 

        JButton a7 = new JButton("How to Play"); 
        a7.setBackground(new Color(0x211B1B));
        a7.setForeground(Color.WHITE);
        a7.setFont(new Font("Serif", Font.BOLD, 20));
        a7.setHorizontalAlignment(SwingConstants.LEFT);
        a7.setFocusable(Boolean.FALSE);
        a7.setIcon(new ImageIcon(mode.class.getResource("how.png"))); 

        this.add(a1);
        this.add(a2);
        this.add(a3);
        this.add(a4);
        this.add(a5);
        this.add(a6);
        this.add(a7);
      
    }
    
    
    
}
