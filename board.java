import javax.swing.*;
import java.awt.*;

public class board extends JPanel {
    public final int Dimention = 9;
    public final int SIZE = 520;
    public final int SQ_SIZE = SIZE / 9;

    board() {
        this.setLayout(null);
        this.setSize(SIZE, SIZE);
        this.setBounds(1024 / 6, 720 / 7, SIZE, SIZE);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g);

        //rows
        for (int i = 0; i < (Dimention + 1); i++) {
            g2d.setPaint(Color.DARK_GRAY);
            g2d.setStroke(new BasicStroke(1));
            if (i % 3 == 0) {
                continue;
            }
            g2d.drawLine(i * SQ_SIZE, 0, i * SQ_SIZE, SIZE);
        }
        // columns
        for (int j = 0; j < (Dimention + 1); j++) {
            g2d.setPaint(Color.DARK_GRAY);
            g2d.setStroke(new BasicStroke(1));
            if (j % 3 == 0) {
                continue;
            }
            g2d.drawLine(0, j * SQ_SIZE, SIZE, j * SQ_SIZE);
        }
        //different line
        for (int i = 1; i < Dimention; i++) {
            if (i % 3 == 0) {
                g2d.setPaint(Color.BLUE);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawLine(0, i * SQ_SIZE, SIZE, i * SQ_SIZE);
                g2d.drawLine(i * SQ_SIZE, 0, i * SQ_SIZE, SIZE);
            }
        }

        // Draw the yellow border
        g2d.setPaint(Color.BLUE);
        g2d.setStroke(new BasicStroke(5));
        // 50 is the arc width and height for rounded corners
        g2d.drawRoundRect(0, 0, SIZE, SIZE, 50, 50);
    }
}
