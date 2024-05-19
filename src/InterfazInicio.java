import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazInicio{

    JPanel panel1;
    private JPasswordField passwordField2;
    private JButton aceptarButton;
    private JButton registrarseButton;
    private JTextField textField1;
    private JButton cambiarTemaButton;
    UserManager userManager;
    ArbolBinario arbolEventos;

    public InterfazInicio(UserManager userManager, ArbolBinario arbolEventos){
        this.userManager = userManager;
        this.arbolEventos = arbolEventos;

       aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Leer el texto en JTextField y JPasswordField para comprobar y luego redirigir a InterfazMenu

                String username = textField1.getText();
                String password = new String(passwordField2.getPassword());

                //Chequear si el usuario y contraseña son correctos y luego mandar eso a UserManager metodo checkUser

                if (username.equals("admin") && password.equals("admin")) {
                    //Abrir menu admin
                    JFrame frame = new JFrame("InterfazMenuAdmin");
                    frame.setContentPane(new InterfazMenuAdmin(userManager, arbolEventos).panel1);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setLocationRelativeTo(null); // Esto centrará la ventana
                    frame.setSize(800, 600); // Establecer el tamaño de la ventana a 800x600
                    frame.setResizable(false); // Hacer que la ventana no sea redimensionable
                    frame.setVisible(true);
                    // Cerrar la ventana actual
                    JFrame frame2 = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                    frame2.dispose();

                    //Chequear si el usuario y contraseña son correctos y luego mandar eso a UserManager metodo checkUser
                } else if (userManager.checkUser(username, password)) {
                    //Mandar mensaje de Usuario Correcto
                    JOptionPane.showMessageDialog(panel1, "Usuario Correcto, redirifiendo a Menu");
                    //Redirigir a InterfazMenu
                    JFrame frame = new JFrame("InterfazMenu");
                    frame.setContentPane(new InterfazMenu(userManager, arbolEventos, username).panel1);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setLocationRelativeTo(null); // Esto centrará la ventana
                    frame.setSize(800, 600); // Establecer el tamaño de la ventana a 800x600
                    frame.setResizable(false); // Hacer que la ventana no sea redimensionable
                    frame.setVisible(true);
                    // Cerrar la ventana actual
                    JFrame frame2 = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                    frame2.dispose();
                } else {
                    JOptionPane.showMessageDialog(panel1, "Usuario o contraseña incorrectos");

                }
            }

        });


        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Redirigir a InterfazRegistrarse
                JFrame frame = new JFrame("InterfazRegistrarse");
                frame.setContentPane(new InterfazRegistrarse(userManager, arbolEventos).panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null); // Esto centrará la ventana
                frame.setSize(800, 600); // Establecer el tamaño de la ventana a 800x600
                frame.setResizable(false); // Hacer que la ventana no sea redimensionable
                frame.setVisible(true);
                // Cerrar la ventana actual
                JFrame frame2 = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame2.dispose();


            }
        });
        cambiarTemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Cambiar el tema de la interfaz de FlatGitHubIJTheme a FlatGitHubDarkIJTheme y viceversa
                try {
                    if (UIManager.getLookAndFeel() instanceof FlatGitHubIJTheme) {
                        UIManager.setLookAndFeel(new FlatGitHubDarkIJTheme());
                    } else {
                        UIManager.setLookAndFeel(new FlatGitHubIJTheme());
                    }
                    SwingUtilities.updateComponentTreeUI(panel1);
                } catch (UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
}
