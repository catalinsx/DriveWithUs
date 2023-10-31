import rentacar.customers.Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


public class CustomerForm {
    public JPanel panel1;
    private JLabel imageLabel;
    private JTextField firstNameTextField;
    private JButton completeButton;
    private JLabel imageThanku;
    private JTextField lastNameTextField;
    private JTextField addressTextField;
    private JTextField phoneTextField;
    private JTextField emailTextField;
    private JTextField cnpTextField;
    private ArrayList<Customer> customers;
    public CustomerForm() {
        ImageIcon imageIcon = new ImageIcon("src/Images/rentalform.png");
        imageLabel.setIcon(imageIcon);
        customers = loadCustomers(); // Încărcați lista de clienți la pornirea formularului

        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon imageIcon1 = new ImageIcon("src/Images/thanku.png");
                imageThanku.setIcon(imageIcon1);
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String address = addressTextField.getText();
                String phone = phoneTextField.getText();
                String email = emailTextField.getText();
                String cnp = cnpTextField.getText();
                Customer customer = new Customer(firstName, lastName, cnp, address, phone, email);
                customers.add(customer);

                // Salvare clienți actualizați în fișier
                saveCustomers(customers);

                System.out.println("Customer data was successfully saved.");
            }
        });
    }

    private ArrayList<Customer> loadCustomers() {
        try (FileInputStream fileInputStream = new FileInputStream("customerData.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (ArrayList<Customer>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            // În cazul în care nu există niciun fișier serializat, returnați o listă goală
            return new ArrayList<>();
        }
    }

    private void saveCustomers(ArrayList<Customer> customerList) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("customerData.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(customerList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
