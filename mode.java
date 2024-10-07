
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.Component;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;


public class Mode extends JPanel{
        Create_topic create = new Create_topic();
        Board board = new Board();
    
        Mode(){
        
        this.setBounds(0,720 / 7,(1024 / 6) + 35, 350 );
        GridLayout gridLayout = new GridLayout(7,1,5,5);
        
        this.setLayout(gridLayout);
        
        create = Board.create_topic;

        //nut 1
        JButton a1 = new JButton("Easy");
        a1.setBackground(new Color(0x211B1B));
        a1.setForeground(Color.WHITE);
        a1.setFont(new Font("Serif", Font.BOLD, 20));
        a1.setHorizontalAlignment(SwingConstants.LEFT);
        a1.setFocusable(Boolean.FALSE);
        a1.setIcon(new ImageIcon(Mode.class.getResource("easy.png")));
        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // Gọi phương thức tạo game mới
                            create.setLevel(1);
                            New_game.call_new_game();
                            
                            // Tạo board mới và thiết lập kích thước, vị trí
                            Board newBoard = new Board();
                            newBoard.setBounds(board.getBounds());
                            newBoard.setOpaque(true); // Đảm bảo board không trong suốt
                            
                            // Lấy container cha của Button_on_top
                            Container parent = Mode.this.getParent();
                            
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
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(board, "Error: " + ex.getMessage());
                            ex.printStackTrace();
                        }
                    }
                });
            }
        });
        
        //nut 2
        JButton a2 = new JButton("Medium"); 
        a2.setBackground(new Color(0x211B1B));
        a2.setForeground(Color.WHITE);
        a2.setFont(new Font("Serif", Font.BOLD, 20));
        a2.setHorizontalAlignment(SwingConstants.LEFT);
        a2.setFocusable(Boolean.FALSE);
        a2.setIcon(new ImageIcon(Mode.class.getResource("medium.png"))); 
        a2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // Gọi phương thức tạo game mới
                            create.setLevel(2);
                            New_game.call_new_game();
                            
                            // Tạo board mới và thiết lập kích thước, vị trí
                            Board newBoard = new Board();
                            newBoard.setBounds(board.getBounds());
                            newBoard.setOpaque(true); // Đảm bảo board không trong suốt
                            
                            // Lấy container cha của Button_on_top
                            Container parent = Mode.this.getParent();
                            
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
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(board, "Error: " + ex.getMessage());
                            ex.printStackTrace();
                        }
                    }
                });
            }
        });
        
        //nut 3
        JButton a3 = new JButton("Hard");  
        a3.setBackground(new Color(0x211B1B));
        a3.setForeground(Color.WHITE);
        a3.setFont(new Font("Serif", Font.BOLD, 20));
        a3.setHorizontalAlignment(SwingConstants.LEFT);
        a3.setFocusable(Boolean.FALSE);
        a3.setIcon(new ImageIcon(Mode.class.getResource("hard.png"))); 
        a3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // Gọi phương thức tạo game mới
                            create.setLevel(3);
                            New_game.call_new_game();
                            
                            // Tạo board mới và thiết lập kích thước, vị trí
                            Board newBoard = new Board();
                            newBoard.setBounds(board.getBounds());
                            newBoard.setOpaque(true); // Đảm bảo board không trong suốt
                            
                            // Lấy container cha của Button_on_top
                            Container parent = Mode.this.getParent();
                            
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
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(board, "Error: " + ex.getMessage());
                            ex.printStackTrace();
                        }
                    }
                });
            }
        });

        //nut 4
        JButton a4 = new JButton("Evil"); 
        a4.setBackground(new Color(0x211B1B));
        a4.setForeground(Color.WHITE);
        a4.setFont(new Font("Serif", Font.BOLD, 20));
        a4.setHorizontalAlignment(SwingConstants.LEFT);
        a4.setFocusable(Boolean.FALSE);
        a4.setIcon(new ImageIcon(Mode.class.getResource("evil.png"))); 

        a4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // Gọi phương thức tạo game mới
                            create.setLevel(4);
                            New_game.call_new_game();
                            
                            // Tạo board mới và thiết lập kích thước, vị trí
                            Board newBoard = new Board();
                            newBoard.setBounds(board.getBounds());
                            newBoard.setOpaque(true); // Đảm bảo board không trong suốt
                            
                            // Lấy container cha của Button_on_top
                            Container parent = Mode.this.getParent();
                            
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
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(board, "Error: " + ex.getMessage());
                            ex.printStackTrace();
                        }
                    }
                });
            }
        });
        
        JButton a5 = new JButton("GOD"); 
        a5.setBackground(new Color(0x211B1B));
        a5.setForeground(Color.WHITE);
        a5.setFont(new Font("Serif", Font.BOLD, 20));
        a5.setHorizontalAlignment(SwingConstants.LEFT);
        a5.setFocusable(Boolean.FALSE);
        a5.setIcon(new ImageIcon(Mode.class.getResource("god.png"))); 

        a5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // Gọi phương thức tạo game mới
                            create.setLevel(5);
                            New_game.call_new_game();
                            
                            // Tạo board mới và thiết lập kích thước, vị trí
                            Board newBoard = new Board();
                            newBoard.setBounds(board.getBounds());
                            newBoard.setOpaque(true); // Đảm bảo board không trong suốt
                            
                            // Lấy container cha của Button_on_top
                            Container parent = Mode.this.getParent();
                            
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
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(board, "Error: " + ex.getMessage());
                            ex.printStackTrace();
                        }
                    }
                });
            }
        });

        JButton a6 = new JButton("Daily Challenges"); 
        a6.setBackground(new Color(0x211B1B));
        a6.setForeground(Color.WHITE);
        a6.setFont(new Font("Serif", Font.BOLD, 20));
        a6.setHorizontalAlignment(SwingConstants.LEFT);
        a6.setFocusable(Boolean.FALSE);
        a6.setIcon(new ImageIcon(Mode.class.getResource("challenges.png"))); 

        JButton a7 = new JButton("How to Play"); 
        a7.setBackground(new Color(0x211B1B));
        a7.setForeground(Color.WHITE);
        a7.setFont(new Font("Serif", Font.BOLD, 20));
        a7.setHorizontalAlignment(SwingConstants.LEFT);
        a7.setFocusable(Boolean.FALSE);
        a7.setIcon(new ImageIcon(Mode.class.getResource("how.png"))); 

        this.add(a1);
        this.add(a2);
        this.add(a3);
        this.add(a4);
        this.add(a5);
        this.add(a6);
        this.add(a7);
      
    }
    
    
    
}
