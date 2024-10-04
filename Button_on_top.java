import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Font;
public class Button_on_top extends JPanel{
    Button_on_top(){
        this.setBounds(400, 0, 624, 50);
        this.setBackground(new Color(0x372E2E));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JButton res = new JButton("Restart");
        res.setBackground(new Color(0x372E2E));
        res.setForeground(Color.WHITE);
        res.setFont(new Font("Comic Sans", Font.BOLD, 20));
        res.setHorizontalAlignment(SwingConstants.LEFT);
        res.setFocusable(Boolean.FALSE);
        res.setIcon(new ImageIcon(mode.class.getResource("restart.png")));
        
        JButton new_game = new JButton("New game");
        new_game.setBackground(new Color(0x372E2E));
        new_game.setForeground(Color.WHITE);
        new_game.setFont(new Font("Comic Sans", Font.BOLD, 20));
        new_game.setHorizontalAlignment(SwingConstants.LEFT);
        new_game.setFocusable(Boolean.FALSE);
        new_game.setIcon(new ImageIcon(mode.class.getResource("pluss.png")));

        JButton cal = new JButton("Calculator all note");
        cal.setBackground(new Color(0x372E2E));
        cal.setForeground(Color.WHITE);
        cal.setFont(new Font("Comic Sans", Font.BOLD, 20));
        cal.setHorizontalAlignment(SwingConstants.LEFT);
        cal.setFocusable(Boolean.FALSE);
        cal.setIcon(new ImageIcon(mode.class.getResource("calculator.png")));

        this.add(res);
        this.add(new_game);
        this.add(cal);
    }
}
