import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListofCars {
     JPanel panel1;
    private JPanel panelPoza;
    private JPanel panelInfo;
    ArrayList<String> carLink = new ArrayList<>();
    public ListofCars(){
        carLink.add("src/Images/arteon.jpg");
        carLink.add("src/Images/bmw.jpg");
        carLink.add("src/Images/mercedes.jpg");
        panelPoza.setLayout(new BoxLayout(panelPoza, BoxLayout.Y_AXIS));
        for(String link : carLink){
            JLabel imageLabel = new JLabel();
            ImageIcon imageIcon = new ImageIcon(link);
            imageLabel.setIcon(imageIcon);
            panelPoza.add(imageLabel);
        }
    }
}
