import javax.swing.*;
import java.awt.*;

public class Board_button extends JPanel {
    Board_button(){
        //config
        this.setLayout(new GridLayout(3,3));
        this.setSize(200,200);
        this.setBounds(1024 / 6 + 520 + 20, 720 / 7 + 45*4 + 13 + 7,250, 250);
        this.setBackground(Color.black);
        Font stringFont = new Font( "SansSerif", Font.BOLD, 50);
        JButton [] buttons = new JButton[9];
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton(Integer.toString(i+1));
//            buttons[i].setText();
            buttons[i].setFont(stringFont);
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setBackground(Color.BLACK);
            this.add(buttons[i]);
        }



//        for(int i = 0; i < buttons.length; i++){
//            buttons[i] = new RoundButton(Integer.toString(i));
////            buttons[i].setText();
//            buttons[i].setFont(stringFont);
//            buttons[i].setForeground(Color.WHITE);
//            buttons[i].setBackground(Color.BLACK);
//            this.add(buttons[i]);
//        }








    }
}
