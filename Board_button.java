import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class Board_button extends JPanel {
    public static boolean mode_note = false;
    Board_button(){
        //config
        this.setLayout(new GridLayout(3,3));
        this.setSize(200,200);
        this.setBounds(1024 / 6 + 520 + 20, 720 / 7 + 45*4 + 13 + 7,250, 250);
        this.setBackground(Color.black);
        Font stringFont = new Font( "SansSerif", Font.BOLD, 50);
        JButton [] buttons = new JButton[9];
        Border emptyBorder = BorderFactory.createEmptyBorder();

        if(mode_note == true) {
            for (int i = 0; i < buttons.length; i++) {
                buttons[i] = new JButton(Integer.toString(i + 1));
//            buttons[i].setText();
                buttons[i].setFont(stringFont);
                button.setForcusable(False)
                buttons[i].setForeground(Color.WHITE);
                buttons[i].setBackground(Color.BLACK);
                this.add(buttons[i]);
            }

        }else {
            this.setBackground(new Color(0x372E2E));
        for(int i = 0; i < buttons.length; i++){

            buttons[i] = new RoundButton(Integer.toString(i+1));
            buttons[i].setBorder(emptyBorder);
            button.setForcusable(False)
            buttons[i].setFont(stringFont);
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setBackground(Color.BLACK);
            this.add(buttons[i]);
        }

        }






    }
}
