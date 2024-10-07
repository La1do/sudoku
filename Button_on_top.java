import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Container;
import java.awt.Component;
public class Button_on_top extends JPanel{
    public static boolean mode_new_game = false;
    JButton res = new JButton("Restart");
    static JButton new_game = new JButton("New game");
    JButton cal = new JButton("Calculator all note");
    Board board = new Board();
    Create_topic create = new Create_topic();
    Button_on_top(){
        this.setBounds(400, 0, 624, 50);
        this.setBackground(new Color(0x372E2E));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        create = Board.create_topic;
        
        res.setBackground(new Color(0x372E2E));
        res.setForeground(Color.WHITE);
        res.setFont(new Font("Comic Sans", Font.BOLD, 20));
        res.setHorizontalAlignment(SwingConstants.LEFT);
        res.setFocusable(Boolean.FALSE);
        res.setIcon(new ImageIcon(Mode.class.getResource("restart.png")));
        res.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("res click");
            }
        });
        
        
        new_game.setBackground(new Color(0x372E2E));
        new_game.setForeground(Color.WHITE);
        new_game.setFont(new Font("Comic Sans", Font.BOLD, 20));
        new_game.setHorizontalAlignment(SwingConstants.LEFT);
        new_game.setFocusable(Boolean.FALSE);
        new_game.setIcon(new ImageIcon(Mode.class.getResource("pluss.png")));

        // new_game.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e){
        //         SwingUtilities.invokeLater(() -> {
        //             try {
        //                 New_game.call_new_game();
        //                 create_topic.printBoard(); 
        //                 Board.removeAll(); 
        //                 Board.revalidate();
        //                 Board.repaint(); 
        //             } catch (Exception ex) {
        //                 JOptionPane.showMessageDialog(Board, "Error: " + ex.getMessage());
        //             }   
        //         });
        //     }
        // });
        
        new_game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if(create.getLevel()!=0){
                                // Gọi phương thức tạo game mới
                            New_game.call_new_game();
                            
                            // Tạo board mới và thiết lập kích thước, vị trí
                            Board newBoard = new Board();
                            newBoard.setBounds(board.getBounds());
                            newBoard.setOpaque(true); // Đảm bảo board không trong suốt
                            
                            // Lấy container cha của Button_on_top
                            Container parent = Button_on_top.this.getParent();
                            
                            // Tìm và xóa board cũ
                            for (Component comp : parent.getComponents()) {
                                if (comp instanceof Board) {
                                    parent.remove(comp);
                                    break;
                                }
                            }
                            
                            // Thêm board mới
                            parent.add(newBoard);
                            
                            // Đảm bảo board mới được vẽ đúng cách
                            newBoard.revalidate();
                            newBoard.repaint();
                            
                            // Cập nhật lại giao diện
                            parent.revalidate();
                            parent.repaint();
                            
                            // Đảm bảo board mới được khởi tạo với dữ liệu
                            
                            JOptionPane.showMessageDialog(board, "New game created.");
                            }
                            else{
                                JOptionPane.showMessageDialog(board, "Please choose level first.");
                            }
                            
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(board, "Error: " + ex.getMessage());
                            ex.printStackTrace();
                        }
                    }
                });
            }
        });


        
        cal.setBackground(new Color(0x372E2E));
        cal.setForeground(Color.WHITE);
        cal.setFont(new Font("Comic Sans", Font.BOLD, 20));
        cal.setHorizontalAlignment(SwingConstants.LEFT);
        cal.setFocusable(Boolean.FALSE);
        cal.setIcon(new ImageIcon(Mode.class.getResource("calculator.png")));
        cal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("calculator click");
            }
        });

        this.add(res);
        this.add(new_game);
        this.add(cal);
    }
}
