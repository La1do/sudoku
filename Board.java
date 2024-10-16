import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements KeyListener, MouseListener {

    public final int Dimention = 9;
    public final int SIZE = 520;
    public final int SQ_SIZE = SIZE / 9;
    //Clicked Positon
    private static  int CHOSED_SQ_X=-1;
    private static  int CHOSED_SQ_Y =-1;
    static Create_topic create_topic = new Create_topic();
    
    Board() {
        this.setLayout(null);
        this.setSize(SIZE, SIZE);
        this.setBounds(1024 / 6 + 40, 720 / 7, SIZE, SIZE);
        this.addMouseListener(this);
        this.setBackground(new Color(0x372E2E));
        this.setOpaque(true);
        Timer timer = new Timer(60/1000,frame.B_t);
        timer.start();
    }


    public void paint(Graphics g) {

        super.paint(g);

        Draw_Sudoku_Quest(g);
        DrawBoard(g);
        Draw_Input();
        repaint();

    }
    void DrawBoard(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < (Dimention + 1); i++) {
            g2d.setPaint(new Color(0xC9B6B6));
            g2d.setStroke(new BasicStroke(2));
            if (i % 3 == 0) {
                continue;
            }
            g2d.drawLine(i * SQ_SIZE, 0, i * SQ_SIZE, SIZE);
        }
        // columns
        for (int j = 0; j < (Dimention + 1); j++) {
            g2d.setPaint(new Color(0xC9B6B6));
            g2d.setStroke(new BasicStroke(2));
            if (j % 3 == 0) {
                continue;
            }
            g2d.drawLine(0, j * SQ_SIZE, SIZE, j * SQ_SIZE);
        }
        //different line blue line
        for (int i = 1; i < Dimention; i++) {
            if (i % 3 == 0) {
                g2d.setPaint(new Color(0x3399FF));
                g2d.setStroke(new BasicStroke(4));
                g2d.drawLine(0, i * SQ_SIZE, SIZE, i * SQ_SIZE);
                g2d.drawLine(i * SQ_SIZE, 0, i * SQ_SIZE, SIZE);
            }
        }

        // Draw the blue border
        g2d.setPaint(new Color(0x3399FF));
        g2d.setStroke(new BasicStroke(5));
        // 50 is the arc width and height for rounded corners
        g2d.drawRoundRect(0, 0, SIZE, SIZE, 50, 50);

    }
    void Draw_Sudoku_Quest(Graphics g){
        // int[][] b = new int[0][];
        // int[][] s = new int[0][];
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.white);
        Font stringFont = new Font( "SansSerif", Font.PLAIN, 50);
        g2d.setFont(stringFont);
//        topic.Change(b, s);
        // Create_topic.Change();
        
        for(int i =0 ; i <9;i ++) {
            for(int j =0 ;j <9;j ++) {

                String tmp = Integer.toString(create_topic.getIndexBoard(i, j));
                if (create_topic.getIndexBoard(i, j) != 0) {
                    g2d.drawString(tmp, j * SQ_SIZE + 16, i * SQ_SIZE + SQ_SIZE - 11);
                }
            }
//            g2d.drawString(tmp, i* SQ_SIZE + 16, 0* SQ_SIZE + SQ_SIZE - 11);
        }
    }
    void Draw_Input(){

        if(frame.B_t.getNum() != 0 && CHOSED_SQ_X != -1 && CHOSED_SQ_Y != -1) {
            create_topic.setIndexBoard(CHOSED_SQ_Y, CHOSED_SQ_X, frame.B_t.getNum());
            create_topic.printBoard();
            frame.B_t.setNum(0);
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        // Your code here
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Your code here
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Your code here
    }


    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println("Mouse Clicked");
        if(CHOSED_SQ_X == CHOSED_SQ_X && CHOSED_SQ_Y == CHOSED_SQ_Y ) {
            CHOSED_SQ_X = -1;
            CHOSED_SQ_Y = -1;
        }
        CHOSED_SQ_X = e.getX()/SQ_SIZE;
        CHOSED_SQ_Y = e.getY()/SQ_SIZE;
        System.out.println(e.getX()/SQ_SIZE);
        System.out.println(e.getY()/SQ_SIZE);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Your code here
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // Your code here
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        // Your code here
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Your code here
    }


}
