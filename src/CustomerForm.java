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
    private JTextField daysTextField;
    private ArrayList<Customer> customers;
    public CustomerForm(JFrame billFrame) {
        ImageIcon imageIcon = new ImageIcon("src/Images/rentalform.png");
        imageLabel.setIcon(imageIcon);
        customers = loadCustomers(); // Încărcați lista de clienți la pornirea formularului

        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (firstNameTextField.getText().isEmpty() || lastNameTextField.getText().isEmpty() || addressTextField.getText().isEmpty() ||
                        phoneTextField.getText().isEmpty() || emailTextField.getText().isEmpty() || cnpTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "!!!ERROR-COMPLETE ALL TEXTFIELDS!!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    if(firstNameTextField.getText().matches("^[a-zA-Z\\-]+$")) {
                        if (lastNameTextField.getText().matches("^[a-zA-Z]+$")) {
                            if (phoneTextField.getText().matches("\\d+")) {
                                if (emailTextField.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                                    if (cnpTextField.getText().matches("\\d{13}")) {
                                        String firstName = firstNameTextField.getText();
                                        String lastName = lastNameTextField.getText();
                                        String address = addressTextField.getText();
                                        String phone = phoneTextField.getText();
                                        String email = emailTextField.getText();
                                        String cnp = cnpTextField.getText();
                                        Customer customer = new Customer(firstName, lastName, cnp, address, phone, email);
                                        customers.add(customer);

                                        saveCustomers(customers);

                                        System.out.println("Customer data was successfully saved.");

                                        ImageIcon imageIcon1 = new ImageIcon("src/Images/thanku.png");
                                        imageThanku.setIcon(imageIcon1);

                                    } else {
                                        JOptionPane.showMessageDialog(null, "!!!ERROR-INVALID CNP!!!", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "!!!ERROR-INVALID E-MAIL!!!", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "!!!ERROR-PHONE NUMBER TEXT FIELD MUST CONTAIN NUMBERS ONLY!!!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "!!!ERR0R-INVALID LAST NAME!!!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "!!!ERROR-INVALID FIRST NAME!!!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    private ArrayList<Customer> loadCustomers() {
        try (FileInputStream fileInputStream = new FileInputStream("customerData.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (ArrayList<Customer>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
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
