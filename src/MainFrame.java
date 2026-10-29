import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    int indeksAktualnieWyswietlanegoZdjecia;
    ArrayList<Icon> zdjecia = new ArrayList<>();
    JLabel oknoZeZdjeciem;

    MainFrame() {
        setSize(1100, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Galeria zdjęć");
        getRootPane().setBorder(new EmptyBorder(20, 20, 20, 20));
        setLayout(new BorderLayout());

        for (int i = 1; i <= 4; i++) {
            zdjecia.add(new ImageIcon("src/Images/gory" + i + ".jpg"));
        }

        oknoZeZdjeciem = new JLabel(zdjecia.get(indeksAktualnieWyswietlanegoZdjecia));
        add(oknoZeZdjeciem, BorderLayout.CENTER);

        add(stworzPanel("←", () -> zmienZdjecie(false)), BorderLayout.WEST);
        add(stworzPanel("→", () -> zmienZdjecie(true)), BorderLayout.EAST);
        add(stworzPanel("Pokaż w nowym oknie",
                        () -> new PhotoFrame(zdjecia.get(indeksAktualnieWyswietlanegoZdjecia))),
                BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel stworzPanel(String tekst, Runnable akcja) {
        JPanel panel = new JPanel(new GridBagLayout());
        JButton przycisk = new JButton(tekst);
        przycisk.addActionListener(e -> akcja.run());
        przycisk.setBorder(new EmptyBorder(20, 50, 20, 50));
        panel.add(przycisk);
        return panel;
    }

    public void zmienZdjecie(boolean czyNastepne) {
        indeksAktualnieWyswietlanegoZdjecia = Math.floorMod(
                indeksAktualnieWyswietlanegoZdjecia + (czyNastepne ? 1 : -1),
                zdjecia.size()
        );

        oknoZeZdjeciem.setIcon(zdjecia.get(indeksAktualnieWyswietlanegoZdjecia));
    }
}