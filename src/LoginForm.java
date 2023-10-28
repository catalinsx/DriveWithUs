import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm {
    JPanel panel1;
    JLabel imageLock;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton logInButton;
    private final String username = "admin";
    private final String password = "admin";

    LoginForm(){
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(username.equals(textField1.getText()) && password.equals(passwordField1.getText())){
                    JFrame adminFrame = new JFrame("Admin");
                    Admin admin = new Admin();

                }
                else{
                    JOptionPane.showMessageDialog(null, "Datele introduse sunt gresite");
                }
            }
        });
    }
}
