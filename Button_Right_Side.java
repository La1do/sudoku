
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;


public class Button_Right_Side extends JPanel  {
    private final int Width = 250;
    private final int Height = 520;
    JButton Validate_B = new JButton("Validate");
    JButton Hint_B = new JButton("Hint");
    JButton Number_F_I_B = new JButton("Number-First Input");
    static JButton Notes_B = new JButton("Notes");

    static boolean Notes_mode = false;

    Button_Right_Side(ActionListener listener) {


        // buttons

        //
        Validate_B.addActionListener(listener);
        Hint_B.addActionListener(listener);
        Number_F_I_B.addActionListener(listener);
        Notes_B.addActionListener(listener);
        //
        // Size buttons
        Dimension buttonSize = new Dimension(250, 45);
        Validate_B.setPreferredSize(buttonSize);
        Validate_B.setMaximumSize(buttonSize);
        Validate_B.setMinimumSize(buttonSize);
        Validate_B.setFocusable(Boolean.FALSE);

        Hint_B.setPreferredSize(buttonSize);
        Hint_B.setMaximumSize(buttonSize);
        Hint_B.setMinimumSize(buttonSize);
        Hint_B.setFocusable(Boolean.FALSE);

        Number_F_I_B.setPreferredSize(buttonSize);
        Number_F_I_B.setMaximumSize(buttonSize);
        Number_F_I_B.setMinimumSize(buttonSize);
        Number_F_I_B.setFocusable(Boolean.FALSE);

        Notes_B.setPreferredSize(buttonSize);
        Notes_B.setMaximumSize(buttonSize);
        Notes_B.setMinimumSize(buttonSize);
        Notes_B.setFocusable(Boolean.FALSE);

        // background color of button
        Validate_B.setBackground(new Color(0x211B1B));
        Hint_B.setBackground(new Color(0x211B1B));
        Number_F_I_B.setBackground(new Color(0x211B1B));
        Notes_B.setBackground(new Color(0x211B1B));
        Validate_B.setForeground(Color.WHITE);
        Hint_B.setForeground(Color.WHITE);
        Number_F_I_B.setForeground(Color.WHITE);
        Notes_B.setForeground(Color.WHITE);

        // panel config
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(this.Width, this.Height));
        this.setBounds(1024 / 6 + 520 + 20, 720 / 7, this.Width, this.Height);

        //add
        this.add(Validate_B);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(Hint_B);
        this.add(Box.createRigidArea(new Dimension(0, 7)));
        this.add(Number_F_I_B);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(Notes_B);



    }


}


