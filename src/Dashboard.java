import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Objects;
import rentacar.logging.*;

import rentacar.logging.FileLogger;
import rentacar.logging.Logger;
import rentacar.vehicles.*;
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

        classComboBox.addItem("Luxury");
        classComboBox.addItem("Sport");
        classComboBox.addItem("Premium");

        brandComboBox.addItem("Any");
        brandComboBox.addItem("Acura");
        brandComboBox.addItem("Alfa Romeo");
        brandComboBox.addItem("Audi");
        brandComboBox.addItem("BMW");
        brandComboBox.addItem("Cadillac");
        brandComboBox.addItem("Jaguar");
        brandComboBox.addItem("Land Rover");
        brandComboBox.addItem("Lexus");
        brandComboBox.addItem("Mercedes-Benz");
        brandComboBox.addItem("Porsche");
        brandComboBox.addItem("Toyota");
        brandComboBox.addItem("Volkswagen");

        gearBoxComboBox.addItem("Any");
        gearBoxComboBox.addItem("Manual");
        gearBoxComboBox.addItem("Automatic");

        tractionComboBox.addItem("Any");
        tractionComboBox.addItem("FWD");
        tractionComboBox.addItem("RWD");
        tractionComboBox.addItem("AWD");

        fuelTypeComboBox.addItem("Any");
        fuelTypeComboBox.addItem("Petrol");
        fuelTypeComboBox.addItem("Diesel");
        fuelTypeComboBox.addItem("Hybrid");

        adminIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Logger logger = FileLogger.getInstance();
                logger.logEvent("The loginFrame was opened.");
                JFrame loginFrame = new JFrame("Login");
                LoginForm loginForm = new LoginForm(loginFrame);
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
                if(doYouHaveACheckBox.isSelected()){
                    Car.setOneYearExperience(true);
                }
                else {
                    Car.setOneYearExperience(false);
                }
                Logger logger = FileLogger.getInstance();
                logger.logEvent("The cars are displayed depending on what was selected in the comboBoxes.");
                String clasaCautata= Objects.requireNonNull(classComboBox.getSelectedItem()).toString();
                String brandCautat= Objects.requireNonNull(brandComboBox.getSelectedItem()).toString();
                String gearBoxCautat= Objects.requireNonNull(gearBoxComboBox.getSelectedItem()).toString();
                String tractionCautat= Objects.requireNonNull(tractionComboBox.getSelectedItem()).toString();
                String fuelTypeCautat= Objects.requireNonNull(fuelTypeComboBox.getSelectedItem()).toString();
                if(Objects.equals(fuelTypeCautat, "Petrol"))
                    fuelTypeCautat="Benzina";
                JFrame carsFrame = new JFrame("Cars");
                ListofCars listofCars = new ListofCars(carsFrame,clasaCautata,brandCautat,gearBoxCautat,tractionCautat,fuelTypeCautat);
                if(ListofCars.existaMasini(listofCars.getCars(),clasaCautata,brandCautat,gearBoxCautat,tractionCautat,fuelTypeCautat))
                {
                JScrollPane sp = new JScrollPane(listofCars.panel1);
                sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                sp.getVerticalScrollBar().setUnitIncrement(20);
                carsFrame.add(sp);
                carsFrame.setSize(650, 1080);
                carsFrame.setResizable(false);
                carsFrame.setLocationRelativeTo(null);
                carsFrame.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "!!!NU AVEM PE STOC MASINI CU ACESTE SPECIFICATII!!!", "Error", JOptionPane.ERROR_MESSAGE);
                    carsFrame.setVisible(false);
                }
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
        Logger logger= FileLogger.getInstance();
        logger.logEvent("DriveWithUs is online!");
    }
}
