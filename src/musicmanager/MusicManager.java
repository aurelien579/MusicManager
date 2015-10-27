package musicmanager;

import musicmanager.gui.MainFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MusicManager {

    public static void main(String[] args) {
        setLookAndFeel();
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    public static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
