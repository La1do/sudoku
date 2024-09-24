import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Button_Right_Side extends JPanel  {
    private final int Width = 200;
    private final int Height = 520;
    Button_Right_Side(){
        //button
        JButton Validate_B = new JButton("Validate");

        Validate_B.setBackground(Color.GREEN);
//        Validate_B.setSize(200, 70);
        JButton Hint_B = new JButton("Hint");
        Hint_B.setBackground(Color.GREEN);
//        Hint_B.setSize(200, 50);
        JButton Number_F_I_B = new JButton("Number-First Input");
        Number_F_I_B.setBackground(Color.GREEN);
//        Number_F_I_B.setSize(200, 50);
        JButton Notes_B = new JButton("Notes");
        Notes_B.setBackground(Color.GREEN);
        Notes_B.setSize(200, 50);
        //config panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setSize(this.Width,this.Height);
        this.setBounds(1024 / 6 + 520 + 20,720 / 7,this.Width,this.Height);
        this.add(Validate_B);
        this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(Hint_B);
        this.add(Box.createRigidArea(new Dimension(0,20)));
        this.add(Number_F_I_B);
        this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(Notes_B);
        this.add(Box.createRigidArea(new Dimension(0,5)));
    }

}
