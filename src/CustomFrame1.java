import javax.swing.*;
import java.awt.*;

/**
 * Created by lloison on 08/01/2017.
 */
public class CustomFrame1 extends JFrame {
    public CustomFrame1(String title) {
        super(title);
        Container con = new Container();
        JPanel pane1 = new JPanel(new BorderLayout());
        JPanel pane2 = new JPanel(new GridLayout(0, 1));
        JLabel label2 = new JLabel("Veuillez saisir l'emplacement du fichier :");
        JLabel label3 = new JLabel("Exemple : bin/exemples/figure1.txt");
        pane1.add(label2, BorderLayout.NORTH);
        pane1.add(pane2, BorderLayout.CENTER);
        pane2.add(label3);
        JButton button = new JButton("Entrer");
        JTextField text = new JTextField(100);
        pane2.add(text);
        pane2.add(button);
        con.add(pane1, BorderLayout.CENTER);
    }
}
