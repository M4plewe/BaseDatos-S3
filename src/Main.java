import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        // Establecer FlatDarkLaf como Look and Feel
        try {
            UIManager.setLookAndFeel(new FlatGitHubIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }



        UserManager userManager = new UserManager();
        ArbolBinario arbolEventos = new ArbolBinario();

        arbolEventos.eventosPredeterminados(arbolEventos);

        JFrame frame = new JFrame("InterfazInicio");
        frame.setContentPane(new InterfazInicio(userManager, arbolEventos).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600); // Establecer el tamaño de la ventana a 800x600
        frame.setLocationRelativeTo(null); // Esto centrará la ventana
        frame.setResizable(false); // Hacer que la ventana no sea redimensionable
        frame.setVisible(true);


    }
}
