
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;

public class Button_Right_Side extends JPanel  {
    private final int Width = 250;
    private final int Height = 520;

    Button_Right_Side(ActionListener listener) {
        // buttons
        JButton Validate_B = new JButton("Validate");
        JButton Hint_B = new JButton("Hint");
        JButton Number_F_I_B = new JButton("Number-First Input");
        JButton Notes_B = new JButton("Notes");
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

        Hint_B.setPreferredSize(buttonSize);
        Hint_B.setMaximumSize(buttonSize);
        Hint_B.setMinimumSize(buttonSize);

        Number_F_I_B.setPreferredSize(buttonSize);
        Number_F_I_B.setMaximumSize(buttonSize);
        Number_F_I_B.setMinimumSize(buttonSize);

        Notes_B.setPreferredSize(buttonSize);
        Notes_B.setMaximumSize(buttonSize);
        Notes_B.setMinimumSize(buttonSize);

        // background color of button
        Validate_B.setBackground(Color.GREEN);
        Hint_B.setBackground(Color.GREEN);
        Number_F_I_B.setBackground(Color.GREEN);
        Notes_B.setBackground(Color.GREEN);

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


