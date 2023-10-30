import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashboard {
    private JPanel dashboardPanel;
    private JLabel imageLabel;
    private JLabel imageLogoLabel;
    private JComboBox<String> classComboBox;
    private JCheckBox doYouHaveACheckBox;
    private JButton searchForACarButton;
    private JLabel adminIcon;
    private JComboBox<String> brandComboBox;
    private JComboBox<String> gearBoxComboBox;
    private JComboBox<String> tractionComboBox;
    private JComboBox<String> fuelTypeComboBox;

    public Dashboard(){
        // test;
        classComboBox.addItem("Luxury");
        classComboBox.addItem("Sport");
        classComboBox.addItem("Premium");

        gearBoxComboBox.addItem("Manual");
        gearBoxComboBox.addItem("Automatic");

        tractionComboBox.addItem("Front-Wheel Drive - FWD");
        tractionComboBox.addItem("Rear-Wheel Drive - RWD");
        tractionComboBox.addItem("All-Wheel Drive - AWD");

        fuelTypeComboBox.addItem("Petrol");
        fuelTypeComboBox.addItem("Diesel");
        fuelTypeComboBox.addItem("Hybrid");
        adminIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame loginFrame = new JFrame("Login");
                LoginForm loginForm = new LoginForm();
                loginFrame.setContentPane(loginForm.panel1);
                ImageIcon imageIcon = new ImageIcon("src/Images/adminIcon.jpg");
                loginForm.imageLock.setIcon(imageIcon);
                loginFrame.setVisible(true);
                loginFrame.setSize(400,300);
                loginFrame.setResizable(false);
                loginFrame.setLocationRelativeTo(null);
            }
        });
        searchForACarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame carsFrame = new JFrame("Cars");
                ListofCars listofCars = new ListofCars(carsFrame);
                JScrollPane sp = new JScrollPane(listofCars.panel1);
                sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                sp.getVerticalScrollBar().setUnitIncrement(20);
                carsFrame.add(sp);
                carsFrame.setSize(650, 768);
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
        ImageIcon adminIcon = new ImageIcon("src/Images/loginIcon.png");
        dashboard.imageLogoLabel.setIcon(imageLogoIcon);
        dashboard.imageLabel.setIcon(imageIcon);
        dashboard.adminIcon.setIcon(adminIcon);
        frame.setVisible(true);
        frame.setSize(1366, 668 );
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}
