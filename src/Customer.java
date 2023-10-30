import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Customer {
    public JPanel panel1;
    private JLabel imageLabel;
    private JTextField textField1;
    private JButton completeButton;
    private JLabel imageThanku;

    public Customer(){
        ImageIcon imageIcon = new ImageIcon("src/Images/rentalform.png");
        imageLabel.setIcon(imageIcon);
        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon imageIcon1 = new ImageIcon("src/Images/thanku.png");
                imageThanku.setIcon(imageIcon1);
            }
        });
    }
}
