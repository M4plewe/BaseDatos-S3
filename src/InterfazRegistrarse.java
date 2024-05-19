import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazRegistrarse {
    JPanel panel1;
    private JPasswordField passwordField2;
    private JButton aceptarButton;
    private JButton iniciarSesionButton;
    private JPasswordField passwordField3;
    private JTextField textField1;
    UserManager userManager;
    ArbolBinario arbolEventos;

    public InterfazRegistrarse(UserManager userManager, ArbolBinario arbolEventos) {
        this.userManager = userManager;
        this.arbolEventos = arbolEventos;

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Leer el texto en JTextField y JPasswordField para agregar un nuevo usuario

                String username = textField1.getText();
                String password = new String(passwordField2.getPassword());
                String password2 = new String(passwordField3.getPassword());

                //Chequear si las contraseñas son iguales y luego mandar eso a UserManager metodo addUser
                if (!username.equals("admin")) {
                    if (password.equals(password2)) {
                        if (userManager.addUser(username, password)) {
                            //Mandar mensaje de Usuario Creado
                            JOptionPane.showMessageDialog(panel1, "Usuario creado, redirifiendo a Inicio de Sesion");
                            //Redirigir a InterfazMenu
                            JFrame frame = new JFrame("InterfazInicio");
                            frame.setContentPane(new InterfazInicio(userManager, arbolEventos).panel1);
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
                            JOptionPane.showMessageDialog(panel1, "El usuario ya existe");
                        }
                    } else {
                        JOptionPane.showMessageDialog(panel1, "Las contraseñas no coinciden");
                    }
                }else {
                    JOptionPane.showMessageDialog(panel1, "El nombre de usuario no puede ser 'admin'");
                }

            }
        });
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Simplemente redirigir a InterfazInicio

                JFrame frame = new JFrame("InterfazInicio");
                frame.setContentPane(new InterfazInicio(userManager, arbolEventos).panel1);
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
    }
}
