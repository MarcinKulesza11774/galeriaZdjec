import javax.swing.*;

public class PhotoFrame extends JFrame {
    PhotoFrame(Icon zdjecie){
        setSize(zdjecie.getIconWidth(), zdjecie.getIconHeight());

        JLabel etykietaNaZdjecie = new JLabel(zdjecie);
        add(etykietaNaZdjecie);
        setResizable(false);

        setVisible(true);
    }
}
 