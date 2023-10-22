import javax.swing.*;

public class Dashboard {
    private JPanel dashboardPanel;
    private JLabel imageLabel;
    private JLabel imageLogoLabel;
    private JComboBox comboBox1;
    private JCheckBox doYouHaveACheckBox;
    private JButton searchForACarButton;

    public Dashboard(){
        // test;
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
