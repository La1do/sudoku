import javax.swing.*;
import java.awt.*;

public class frame extends JFrame {


    Board board = new Board();
    static Board_button B_t = new Board_button();
    Button_Right_Side Right_Side = new Button_Right_Side();
    Mode Mode = new Mode();
    Button_on_top top = new Button_on_top();
    frame(){
        ImageIcon icon = new ImageIcon("icon.jpg");
        //panels
        //board
        // button
        
        Mode.setBackground(new Color(0x372E2E));
        
        Right_Side.setBackground(new Color(0x372E2E));
        
        //frame config
        this.add(B_t);
        this.add(board);
        this.add(Right_Side);
        this.add(Mode);
        this.add(top);
        this.setIconImage(icon.getImage());
        this.setSize(1024, 720);
        this.setTitle("Sudoku");
        this.getContentPane().setBackground(new Color(0x372E2E));
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

}
