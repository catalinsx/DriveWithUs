import rentacar.vehicles.Car;
import rentacar.vehicles.Luxury;
import rentacar.vehicles.Premium;
import rentacar.vehicles.Sport;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

public class ListofCars {
    public JPanel panel1;
    public  ArrayList<Car> cars;

    public ListofCars(JFrame carsFrame) {
        cars = new ArrayList<>();
        try(FileInputStream fileInputStream = new FileInputStream("cars.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            cars = (ArrayList<Car>) objectInputStream.readObject(); // tre sa vad ce naiba e eroarea asta
            System.out.println("Am citit masinile din fisier");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); // modific sa mi afiseze cu logger
        }
//        try(FileOutputStream fileOutputStream = new FileOutputStream("cars.ser");
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
//            objectOutputStream.writeObject(cars);
//            System.out.println("Am salvat masiniile in fisier");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        Font font = new Font("Arial", Font.ITALIC, 20);
       for(Car car : cars){
           if(car instanceof Sport sport){
               // Blocul de cod se execută doar dacă obiectul 'car' este o instanță a clasei 'Sport'
               // sau a unei subclase a clasei 'Sport'
               // Acest lucru vă permite să verificați tipul obiectului înainte de a-l utiliza
               JLabel numeLabel = new JLabel("Brand: "+ sport.getBrand());
               numeLabel.setForeground(Color.black);
               numeLabel.setFont(font);
               JLabel modelLabel = new JLabel("Model: " + sport.getModel());
               modelLabel.setForeground(Color.black);
               modelLabel.setFont(font);
               JLabel gearbox = new JLabel("Gearbox: " + sport.getGearBox());
               gearbox.setForeground(Color.BLACK);
               gearbox.setFont(font);
               JLabel traction = new JLabel("Traction: " + sport.getTraction());
               traction.setForeground(Color.black);
               traction.setFont(font);
               JLabel fuelType = new JLabel("Fuel Type: " + sport.getFuelType());
               fuelType.setForeground(Color.black);
               fuelType.setFont(font);
               JLabel features = new JLabel("Features: " + sport.getFeatures());
               features.setForeground(Color.black);
               features.setFont(font);
               JLabel pricePerDay = new JLabel("Price/day: " + sport.getPricePerDay());
               pricePerDay.setForeground(Color.RED);
               pricePerDay.setFont(font);
               panel1.add(numeLabel);
               panel1.add(modelLabel);
               panel1.add(gearbox);
               panel1.add(traction);
               panel1.add(fuelType);
               panel1.add(features);
               panel1.add(pricePerDay);
               JLabel imageLabel = getImageLabel(carsFrame, sport);
               panel1.add(imageLabel);
               panel1.add(Box.createRigidArea(new Dimension(15, 35)));
               panel1.add(new JSeparator(SwingConstants.HORIZONTAL));
               panel1.add(Box.createRigidArea(new Dimension(15, 35)));
           }
           else if(car instanceof Luxury luxury)
           {
               JLabel numeLabel = new JLabel("Brand: "+ luxury.getBrand());
               numeLabel.setForeground(Color.black);
               numeLabel.setFont(font);
               JLabel modelLabel = new JLabel("Model: " + luxury.getModel());
               modelLabel.setForeground(Color.black);
               modelLabel.setFont(font);
               JLabel gearbox = new JLabel("Gearbox: " + luxury.getGearBox());
               gearbox.setForeground(Color.BLACK);
               gearbox.setFont(font);
               JLabel traction = new JLabel("Traction: " + luxury.getTraction());
               traction.setForeground(Color.black);
               traction.setFont(font);
               JLabel fuelType = new JLabel("Fuel Type: " + luxury.getFuelType());
               fuelType.setForeground(Color.black);
               fuelType.setFont(font);
               JLabel features = new JLabel("Features: " + luxury.getFeatures());
               features.setForeground(Color.black);
               features.setFont(font);
               JLabel pricePerDay = new JLabel("Price/day: " + luxury.getPricePerDay());
               pricePerDay.setForeground(Color.RED);
               pricePerDay.setFont(font);
               panel1.add(numeLabel);
               panel1.add(modelLabel);
               panel1.add(gearbox);
               panel1.add(traction);
               panel1.add(fuelType);
               panel1.add(features);
               panel1.add(pricePerDay);
               JLabel imageLabel = getImageLabel(carsFrame, luxury);
               panel1.add(imageLabel);
               panel1.add(Box.createRigidArea(new Dimension(15, 35)));
               panel1.add(new JSeparator(SwingConstants.HORIZONTAL));
               panel1.add(Box.createRigidArea(new Dimension(15, 35)));
           }
           else if(car instanceof Premium premium)
           {
               JLabel numeLabel = new JLabel("Brand: "+ premium.getBrand());
               numeLabel.setForeground(Color.black);
               numeLabel.setFont(font);
               JLabel modelLabel = new JLabel("Model: " + premium.getModel());
               modelLabel.setForeground(Color.black);
               modelLabel.setFont(font);
               JLabel gearbox = new JLabel("Gearbox: " + premium.getGearBox());
               gearbox.setForeground(Color.BLACK);
               gearbox.setFont(font);
               JLabel traction = new JLabel("Traction: " + premium.getTraction());
               traction.setForeground(Color.black);
               traction.setFont(font);
               JLabel fuelType = new JLabel("Fuel Type: " + premium.getFuelType());
               fuelType.setForeground(Color.black);
               fuelType.setFont(font);
               JLabel features = new JLabel("Features: " + premium.getFeatures());
               features.setForeground(Color.black);
               features.setFont(font);
               JLabel pricePerDay = new JLabel("Price/day: " + premium.getPricePerDay());
               pricePerDay.setForeground(Color.RED);
               pricePerDay.setFont(font);
               panel1.add(numeLabel);
               panel1.add(modelLabel);
               panel1.add(gearbox);
               panel1.add(traction);
               panel1.add(fuelType);
               panel1.add(features);
               panel1.add(pricePerDay);
               JLabel imageLabel = getImageLabel(carsFrame, premium);
               panel1.add(imageLabel);
               panel1.add(Box.createRigidArea(new Dimension(15, 35)));
               panel1.add(new JSeparator(SwingConstants.HORIZONTAL));
               panel1.add(Box.createRigidArea(new Dimension(15, 35)));
           }
       }
    }

    private static JLabel getImageLabel(JFrame carsFrame, Sport sport) {
        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(sport.getImageLink());
        imageLabel.setIcon(imageIcon);
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame billFrame = new JFrame("Bill");
                CustomerForm customerForm = new CustomerForm();
                billFrame.setContentPane(customerForm.panel1);
                billFrame.setResizable(false);
                billFrame.setSize(700, 600);
                billFrame.setLocationRelativeTo(null);
                billFrame.setVisible(true);
                carsFrame.dispose();
            }
        });
        return imageLabel;
    }
    private static JLabel getImageLabel(JFrame carsFrame, Premium premium) {
        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(premium.getImageLink());
        imageLabel.setIcon(imageIcon);
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame billFrame = new JFrame("Bill");
                CustomerForm customerForm = new CustomerForm();
                billFrame.setContentPane(customerForm.panel1);
                billFrame.setResizable(false);
                billFrame.setSize(700, 600);
                billFrame.setLocationRelativeTo(null);
                billFrame.setVisible(true);
                carsFrame.dispose();
            }
        });
        return imageLabel;
    }
    private static JLabel getImageLabel(JFrame carsFrame, Luxury luxury) {
        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(luxury.getImageLink());
        imageLabel.setIcon(imageIcon);
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame billFrame = new JFrame("Bill");
                CustomerForm customerForm = new CustomerForm();
                billFrame.setContentPane(customerForm.panel1);
                billFrame.setResizable(false);
                billFrame.setSize(700, 600);
                billFrame.setLocationRelativeTo(null);
                billFrame.setVisible(true);
                carsFrame.dispose();
            }
        });
        return imageLabel;
    }
}