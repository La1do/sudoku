
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;


public class Button_Right_Side extends JPanel  {
    private final int Width = 250;
    private final int Height = 520;
    JButton Validate_B = new JButton("Validate                  ");
    JButton Hint_B = new JButton("Hint                        ");
    JButton Number_F_I_B = new JButton("Number-First Input ");
    static JButton Notes_B = new JButton("Notes                     ");

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

        //seticon
        ImageIcon icon1 = new ImageIcon("validate.png");
        Image img1 = icon1.getImage();
        Image imgScale1 = img1.getScaledInstance(26,26, Image.SCALE_SMOOTH);
        ImageIcon sacledIcon1 = new ImageIcon(imgScale1);
        Validate_B.setIcon(sacledIcon1);
        Validate_B.setHorizontalTextPosition(Validate_B.RIGHT);
        Validate_B.setIconTextGap(10);
        Validate_B.setFont(new Font("Comic Sans",Font.PLAIN, 20));
        
        ImageIcon icon2 = new ImageIcon("bulb.png");
        Image img2 = icon2.getImage();
        Image imgScale2 = img2.getScaledInstance(26,26, Image.SCALE_SMOOTH);
        ImageIcon sacledIcon2 = new ImageIcon(imgScale2);
        Hint_B.setIcon(sacledIcon2);
        Hint_B.setHorizontalTextPosition(Hint_B.RIGHT);
        Hint_B.setIconTextGap(10);
        Hint_B.setFont(new Font("Comic Sans",Font.PLAIN, 20));
        
        ImageIcon icon3 = new ImageIcon("padlock.png");
        Image img3 = icon3.getImage();
        Image imgScale3 = img3.getScaledInstance(26,26, Image.SCALE_SMOOTH);
        ImageIcon sacledIcon3 = new ImageIcon(imgScale3);
        Number_F_I_B.setIcon(sacledIcon3);
        Number_F_I_B.setHorizontalTextPosition(Number_F_I_B.RIGHT);
        Number_F_I_B.setIconTextGap(10);
        Number_F_I_B.setFont(new Font("Comic Sans",Font.PLAIN, 20));
        
        ImageIcon icon4 = new ImageIcon("note.png");
        Image img4 = icon4.getImage();
        Image imgScale4 = img4.getScaledInstance(26,26, Image.SCALE_SMOOTH);
        ImageIcon sacledIcon4 = new ImageIcon(imgScale4);
        Notes_B.setIcon(sacledIcon4);
        Notes_B.setHorizontalTextPosition(Notes_B.RIGHT);
        Notes_B.setIconTextGap(10);
        Notes_B.setFont(new Font("Comic Sans",Font.PLAIN, 20));

        // panel config
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(this.Width, this.Height));
        this.setBounds(1024 / 6 + 520 + 15 + 40, 720 / 7, this.Width, this.Height);

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


