import rentacar.customers.Customer;
import rentacar.vehicles.Car;
import rentacar.vehicles.Luxury;
import rentacar.vehicles.Premium;
import rentacar.vehicles.Sport;

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

    public Admin(){

        afiseazaListaDeClientiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                String marca = marcaAdmin.getText();
                String model = modelAdmin.getText();
                String pret = pretNou.getText();
                try(FileInputStream fileInputStream = new FileInputStream("cars.ser");
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
                    ArrayList<Car> cars = (ArrayList<Car>) objectInputStream.readObject();
                    for(Car car : cars){
                        if(car instanceof Sport sport){
                            if(sport.getBrand().equals(marca) && sport.getModel().equals(model)){
                                sport.setPricePerDay(Double.parseDouble(pret));
                                JOptionPane.showMessageDialog(null, "Pretul a fost actualizat cu succes");
                            }
                        }
                        else if(car instanceof Luxury luxury){
                            if(luxury.getBrand().equals(marca) && luxury.getModel().equals(model)){
                                luxury.setPricePerDay(Double.parseDouble(pret));
                                JOptionPane.showMessageDialog(null, "Pretul a fost actualizat cu succes");
                            }
                        }
                        else if(car instanceof Premium premium){
                            if(premium.getBrand().equals(marca) && premium.getModel().equals(model)){
                                premium.setPricePerDay(Double.parseDouble(pret));
                                JOptionPane.showMessageDialog(null, "Pretul a fost actualizat cu succes");
                            }
                        }
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
        });
    }
}
