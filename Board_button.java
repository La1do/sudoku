import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

public class Board_button extends JPanel implements ActionListener {
    public static boolean mode_note = Button_Right_Side.Notes_mode;
    JPanel Square_button = new JPanel();
    JPanel Round_button = new JPanel();
    Board_button(){
        //buttons panel config
        Square_button.setLayout(new GridLayout(3,3));
        Round_button.setLayout(new GridLayout(3,3));


        //config
        this.setLayout(new BorderLayout());
        this.setSize(200,200);
        this.setBounds(1024 / 6 + 520 + 15 + 40, 720 / 7 + 45*4 + 13 + 7 ,250, 250);
        this.setBackground(Color.black);
        Font stringFont = new Font( "SansSerif", Font.BOLD, 50);
        JButton [] buttons = new JButton[9];
        JButton [] R_buttons = new RoundButton[9];
        Border emptyBorder = BorderFactory.createEmptyBorder();

            for (int i = 0; i < buttons.length; i++) {
                buttons[i] = new JButton(Integer.toString(i + 1));
//            buttons[i].setText();
                buttons[i].setFont(stringFont);
                buttons[i].setFocusable(Boolean.FALSE);
                buttons[i].setForeground(Color.WHITE);
                buttons[i].setBackground(Color.BLACK);
                buttons[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton source = (JButton) e.getSource();
                        for(int i = 1; i <= 9 ; i++){
                            if(source.getText().equals(Integer.toString(i))){
                                System.out.println(i);
                            }
                        }
                    }
                });
                Square_button.add(buttons[i]);
            }
        Round_button.setBackground(new Color(0x372E2E));
            Square_button.setBackground(new Color(0x372E2E));
            this.setBackground(new Color(0x372E2E));
        for(int i = 0; i < buttons.length; i++){

            R_buttons[i] = new RoundButton(Integer.toString(i+1));
            R_buttons[i].setBorder(emptyBorder);
            R_buttons[i].setFocusable(Boolean.FALSE);
            R_buttons[i].setFont(stringFont);
            R_buttons[i].setForeground(Color.WHITE);
            R_buttons[i].setBackground(Color.BLACK);
            R_buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton) e.getSource();
                    for(int i = 1; i <= 9 ; i++){
                        if(source.getText().equals(Integer.toString(i))){
                            System.out.println(i);
                        }
                    }
                }
            });
            Round_button.add(R_buttons[i]);
        }
//        this.add(Square_button, BorderLayout.CENTER);
//        this.add(Round_button, BorderLayout.CENTER);
        System.out.println(mode_note);
        if (mode_note) {
            this.add(Round_button, BorderLayout.CENTER);
        } else {
            this.add(Square_button, BorderLayout.CENTER);
        }
        Button_Right_Side.Notes_B.addActionListener(e -> switchPanels());




    }
    private void switchPanels() {
        SwingUtilities.invokeLater(() -> {
            this.removeAll();
            if (mode_note) {
                this.add(Square_button, BorderLayout.CENTER);
            } else {
                this.add(Round_button, BorderLayout.CENTER);
            }
            mode_note = !mode_note;
            this.revalidate();
            this.repaint();
        });
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == "1") {
            System.out.println("1");
        }
        
    }
}
