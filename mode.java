
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
        
        this.setBounds(0,720 / 7,1024 / 6, 150 );
        this.setBackground(Color.BLACK);
        GridLayout gridLayout = new GridLayout(4,1,5,5);
        
        this.setLayout(gridLayout);
        
        
        //nut 1
        JButton a1 = new JButton("Easy");
        a1.setBackground(new Color(0x211B1B));
        a1.setForeground(Color.WHITE);
        a1.setFont(new Font("Serif", Font.BOLD, 15));
        a1.setHorizontalAlignment(SwingConstants.LEFT);
        a1.setFocusable(Boolean.FALSE);
        a1.setIcon(new ImageIcon(mode.class.getResource("star0.png")));
        
        //nut 2
        JButton a2 = new JButton("Medium"); 
        a2.setBackground(new Color(0x211B1B));
        a2.setForeground(Color.WHITE);
        a2.setFont(new Font("Serif", Font.BOLD, 15));
        a2.setHorizontalAlignment(SwingConstants.LEFT);
        a2.setFocusable(Boolean.FALSE);
        a2.setIcon(new ImageIcon(mode.class.getResource("star1.png"))); 
        
        //nut 3
        JButton a3 = new JButton("Hard");  
        a3.setBackground(new Color(0x211B1B));
        a3.setForeground(Color.WHITE);
        a3.setFont(new Font("Serif", Font.BOLD, 15));
        a3.setHorizontalAlignment(SwingConstants.LEFT);
        a3.setFocusable(Boolean.FALSE);
        a3.setIcon(new ImageIcon(mode.class.getResource("starsnow.png"))); 
        //nut 4
        JButton a4 = new JButton("Evil"); 
        a4.setBackground(new Color(0x211B1B));
        a4.setForeground(Color.WHITE);
        a4.setFont(new Font("Serif", Font.BOLD, 15));
        a4.setHorizontalAlignment(SwingConstants.LEFT);
        a4.setFocusable(Boolean.FALSE);
        a4.setIcon(new ImageIcon(mode.class.getResource("starred.png"))); 
        
        this.add(a1);
        this.add(a2);
        this.add(a3);
        this.add(a4);
    
        
      
    }
    
    
    
}
