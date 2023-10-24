import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard {
    private JPanel dashboardPanel;
    private JLabel imageLabel;
    private JLabel imageLogoLabel;
    private JComboBox comboBox1;
    private JCheckBox doYouHaveACheckBox;
    private JButton searchForACarButton;

    public Dashboard(){
        // test;
        searchForACarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame carsFrame = new JFrame("Cars");
                ListofCars listofCars = new ListofCars();
                carsFrame.setContentPane(listofCars.panel1);
                carsFrame.setSize(1920, 1080);
                carsFrame.setResizable(false);
                carsFrame.setLocationRelativeTo(null);
                carsFrame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dashboard");
        Dashboard dashboard = new Dashboard();
        frame.setContentPane(dashboard.dashboardPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon("src/Images/lexusRemove.png");
        ImageIcon imageLogoIcon = new ImageIcon("src/Images/Drivewithus.png");
        dashboard.imageLogoLabel.setIcon(imageLogoIcon);
        dashboard.imageLabel.setIcon(imageIcon);
        frame.setVisible(true);
        frame.setSize(1366, 768 );
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}
