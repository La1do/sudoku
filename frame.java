import javax.swing.*;
import java.awt.*;

public class frame {
    public static void main(String[] args) {


        ImageIcon icon = new ImageIcon("icon.jpg");
        board board = new board();
        board.setBackground(Color.black);
        JFrame frame = new JFrame();
        frame.setIconImage(icon.getImage());
        frame.setSize(1024, 720);
        frame.setTitle("Sudoku");
        frame.getContentPane().setBackground(Color.black);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(board);

    }
}