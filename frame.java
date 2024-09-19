import javax.swing.*;
import java.awt.*;

public class frame {
    public static void main(String[] args) {
        board board = new board();
        board.setBackground(Color.black);
        JFrame frame = new JFrame();
        frame.setSize(1024, 720);
        frame.setTitle("sudoku test");
        frame.getContentPane().setBackground(Color.black);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(board);

    }
}