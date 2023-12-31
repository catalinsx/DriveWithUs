import rentacar.customers.Customer;
import rentacar.vehicles.Car;
import rentacar.vehicles.Luxury;
import rentacar.vehicles.Premium;
import rentacar.vehicles.Sport;
import rentacar.logging.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Admin {

    JPanel panel1;
    private JButton afiseazaListaDeClientiButton;
    private JTextField marcaAdmin;
    private JTextField modelAdmin;
    private JTextField pretNou;
    private JButton actualizeazaPretButton;
    private JButton afiseazaDiagramaUMLButton;

    public Admin(){

        afiseazaListaDeClientiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logger logger = FileLogger.getInstance();
                logger.logEvent("The list of clients has been displayed.");
                JFrame clientFrame = new JFrame("Lista de clienti");
                JPanel panel1 = new JPanel();
                panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
                clientFrame.setLocationRelativeTo(null);
                clientFrame.setContentPane(panel1);
                clientFrame.setSize(800, 600);
                clientFrame.setResizable(false);
                clientFrame.setVisible(true);

                try(FileInputStream fileInputStream = new FileInputStream("customerData.ser");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
                    ArrayList<Customer> customers = (ArrayList<Customer>) objectInputStream.readObject();
                    for(Customer customer : customers){
                        JLabel clientLabel = new JLabel(customer.toString());
                        panel1.add(clientLabel);
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        actualizeazaPretButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(marcaAdmin.getText().isEmpty() || modelAdmin.getText().isEmpty() || pretNou.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "!!!ERROR-COMPLETE ALL TEXTFIELDS!!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    String marca = marcaAdmin.getText();
                    String model = modelAdmin.getText();
                    String pret = pretNou.getText();
                    if(pretNou.getText().matches("\\d+(\\.\\d+)?"))
                    {
                        try(FileInputStream fileInputStream = new FileInputStream("cars.ser");
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
                        ArrayList<Car> cars = (ArrayList<Car>) objectInputStream.readObject();
                        boolean okMasina=false;
                        for(Car car : cars){
                            if(car instanceof Sport sport){
                                if(sport.getBrand().equals(marca) && sport.getModel().equals(model)){
                                    okMasina=true;
                                    sport.setPricePerDay(Double.parseDouble(pret));
                                    Logger logger = FileLogger.getInstance();
                                    logger.logEvent("The price has been updated.");
                                    JOptionPane.showMessageDialog(null, "Pretul a fost actualizat cu succes");
                                }
                            }
                            else if(car instanceof Luxury luxury){
                                if(luxury.getBrand().equals(marca) && luxury.getModel().equals(model)){
                                    okMasina=true;
                                    luxury.setPricePerDay(Double.parseDouble(pret));
                                    Logger logger = FileLogger.getInstance();
                                    logger.logEvent("The price has been updated.");
                                    JOptionPane.showMessageDialog(null, "Pretul a fost actualizat cu succes");
                                }
                            }
                            else if(car instanceof Premium premium){
                                if(premium.getBrand().equals(marca) && premium.getModel().equals(model)){
                                    okMasina=true;
                                    premium.setPricePerDay(Double.parseDouble(pret));
                                    Logger logger = FileLogger.getInstance();
                                    logger.logEvent("The price has been updated.");
                                    JOptionPane.showMessageDialog(null, "Pretul a fost actualizat cu succes");
                                }
                        }
                    }
                        if(!okMasina)
                        {
                            JOptionPane.showMessageDialog(null, "!!!ERROR: THE CAR DOESN'T EXIST!!!");
                        }
                    try(FileOutputStream fileOutputStream = new FileOutputStream("cars.ser");
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                        objectOutputStream.writeObject(cars);
                        System.out.println("Am salvat masiniile in fisier");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                }
                    else{
                        JOptionPane.showMessageDialog(null, "!!!ERROR: THE PRICE MUST CONTAIN NUMBERS ONLY!!!");
                    }
            }
            }
        });
        afiseazaDiagramaUMLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logger logger = FileLogger.getInstance();
                logger.logEvent("The UML diagram has been displayed.");
                JFrame frameUML = new JFrame("Diagrama UML a programului");
                JPanel panel1 = new JPanel();
                JLabel labelUML=new JLabel();
                ImageIcon imagineUML=new ImageIcon("src/Images/DiagramaUML.png");
                labelUML.setIcon(imagineUML);

                JScrollPane scrollBar=new JScrollPane(panel1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                frameUML.add(scrollBar);
                panel1.add(labelUML);
                frameUML.setSize(1920, 1080);
                frameUML.setLocationRelativeTo(null);
                frameUML.setResizable(false);
                frameUML.setVisible(true);
            }
        });
    }
}
