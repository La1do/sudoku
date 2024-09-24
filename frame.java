import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame extends JFrame implements ActionListener {

    public static void main(String[] args) {
       new frame();
    }
    board board = new board();

    frame(){
        ImageIcon icon = new ImageIcon("icon.jpg");
        // panels
        //board

        board.setBackground(Color.black);
        // button
        Button_Right_Side Right_Side = new Button_Right_Side(this);
        Right_Side.setBackground(Color.black);
        //frame config
        this.setIconImage(icon.getImage());
        this.setSize(1024, 720);
        this.setTitle("Sudoku");
        this.getContentPane().setBackground(Color.black);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(board);
        this.add(Right_Side);

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

}
