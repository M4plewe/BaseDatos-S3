import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InterfazMenuAdmin {
    public JPanel panel1;
    private JButton eliminarEventoButton;
    private JButton button1;
    private JScrollPane scrollPane;
    private JButton cerrarSesionButton;
    private JButton actualizarEventoButton;
    ArbolBinario arbolEventos;
    UserManager userManager;

    public InterfazMenuAdmin(UserManager userManager, ArbolBinario arbolEventos) {
        this.userManager = userManager;
        this.arbolEventos = arbolEventos;

        mostrarEventos();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del evento");
                String categoria = JOptionPane.showInputDialog("Ingrese la categoría del evento");
                String ubicacion = JOptionPane.showInputDialog("Ingrese la ubicación del evento");
                String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del evento");
                Evento evento = new Evento(nombre, categoria, ubicacion, descripcion);
                arbolEventos.agregar(evento);
                mostrarEventos();
            }
        });
        eliminarEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del evento a eliminar");
                arbolEventos.eliminar(nombre);
                mostrarEventos();
            }
        });
        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        actualizarEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del evento a actualizar");
                String nombreNuevo = JOptionPane.showInputDialog("Ingrese el nuevo nombre del evento");
                String categoria = JOptionPane.showInputDialog("Ingrese la categoría del evento");
                String ubicacion = JOptionPane.showInputDialog("Ingrese la ubicación del evento");
                String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del evento");
                Evento evento = arbolEventos.buscar(nombre);
                evento.nombre = nombreNuevo;
                evento.categoria = categoria;
                evento.ubicacion = ubicacion;
                evento.descripcion = descripcion;

                mostrarEventos();

            }
        });
    }

    private void mostrarEventos() {
        List<Evento> eventos = arbolEventos.obtenerEventos();
        JPanel panelEventos = new JPanel();
        panelEventos.setLayout(new BoxLayout(panelEventos, BoxLayout.Y_AXIS));

        for (Evento evento : eventos) {
            JPanel panelEvento = new JPanel();
            panelEvento.setLayout(new BoxLayout(panelEvento, BoxLayout.Y_AXIS));
            panelEvento.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel labelNombre = new JLabel("Nombre: " + evento.nombre);
            JLabel labelCategoria = new JLabel("Categoría: " + evento.categoria);
            JLabel labelUbicacion = new JLabel("Ubicación: " + evento.ubicacion);
            JLabel labelDescripcion = new JLabel("Descripción: " + evento.descripcion);

            panelEvento.add(labelNombre);
            panelEvento.add(labelCategoria);
            panelEvento.add(labelUbicacion);
            panelEvento.add(labelDescripcion);

            panelEventos.add(panelEvento);

            JSeparator separator = new JSeparator();
            separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
            panelEventos.add(separator);

            panelEventos.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio de 10 píxeles
        }

        scrollPane.setViewportView(panelEventos);
    }
}