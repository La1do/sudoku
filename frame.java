import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame extends JFrame implements ActionListener {


    board Board = new board();
    Board_button B_t = new Board_button();
    frame(){
        ImageIcon icon = new ImageIcon("icon.jpg");
        // panels
        //board

        Board.setBackground(new Color(0x372E2E));
        // button
        Button_Right_Side Right_Side = new Button_Right_Side(this);
        Right_Side.setBackground(new Color(0x372E2E));
        //frame config
        this.setIconImage(icon.getImage());
        this.setSize(1024, 720);
        this.setTitle("Sudoku");
        this.getContentPane().setBackground(new Color(0x372E2E));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(Board);
        this.add(Right_Side);
        this.add(B_t);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source.getText().equals("Validate")) {
            System.out.println("Validate button clicked");
        } else if (source.getText().equals("Hint")) {
            System.out.println("Hint button clicked");
        } else if (source.getText().equals("Number-First Input")) {
            System.out.println("Number-First Input button clicked");
        } else if (source.getText().equals("Notes")) {
            System.out.println("Notes button clicked");
        }
    }
    public static void main(String[] args) {
        new frame();
    }
}
