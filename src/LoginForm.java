import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rentacar.logging.*;
public class LoginForm {
    JPanel panel1;
    JLabel imageLock;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton logInButton;
    private final String username = "admin";
    private final String password = "admin";

    LoginForm(JFrame loginFrame){
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(username.equals(textField1.getText()) && password.equals(passwordField1.getText())){
                    JFrame adminFrame = new JFrame("Admin");
                    Admin admin = new Admin();
                    adminFrame.setContentPane(admin.panel1);
                    adminFrame.setVisible(true);
                    adminFrame.setSize(700, 250);
                    adminFrame.setLocationRelativeTo(null);
                    adminFrame.setResizable(false);
                    Logger logger = FileLogger.getInstance();
                    logger.logEvent("Logging was successfully.");
                    loginFrame.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Datele introduse sunt gresite");
                    Logger logger=FileLogger.getInstance();
                    logger.logEvent("Unauthorized login(Someone tried to access admin panel).");
                }
            }
        });
    }
}
