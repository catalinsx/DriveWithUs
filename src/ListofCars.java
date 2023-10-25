import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ListofCars {
    public JPanel panel1;

    ArrayList<String> carLink = new ArrayList<>();
    public ListofCars(JFrame carsFrame) {
        carLink.add("src/Images/arteon.jpg");
        carLink.add("src/Images/bmw.jpg");
        carLink.add("src/Images/mercedes.jpg");
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        Font font = new Font("Arial", Font.ITALIC, 20);
       for(String link : carLink){
           JLabel numeLabel = new JLabel("Nume: Volkswagen");
           numeLabel.setForeground(Color.black);
           numeLabel.setFont(font);
           JLabel modelLabel = new JLabel("Model: Arteon");
           modelLabel.setForeground(Color.black);
           modelLabel.setFont(font);
           JLabel anLabel = new JLabel("An: 2019");
           anLabel.setForeground(Color.BLACK);
           anLabel.setFont(font);
           JLabel pretLabel = new JLabel("Pret: 1000");
           pretLabel.setForeground(Color.black);
           pretLabel.setFont(font);
           panel1.add(numeLabel);
           panel1.add(modelLabel);
           panel1.add(anLabel);
           panel1.add(pretLabel);
           JLabel imageLabel = new JLabel();
           ImageIcon imageIcon = new ImageIcon(link);
           imageLabel.setIcon(imageIcon);
           imageLabel.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                   JFrame billFrame = new JFrame("Bill");
                   JPanel billPanel = new JPanel();
                   billFrame.setResizable(false);
                   billFrame.setSize(400, 300);
                   billFrame.setLocationRelativeTo(null);
                   billFrame.setVisible(true);
                   billFrame.setContentPane(billPanel);
                   carsFrame.dispose();
               }
           });
           panel1.add(imageLabel);
           panel1.add(Box.createRigidArea(new Dimension(15, 35)));
           panel1.add(new JSeparator(SwingConstants.HORIZONTAL));
           panel1.add(Box.createRigidArea(new Dimension(15, 35)));

       }

    }
}