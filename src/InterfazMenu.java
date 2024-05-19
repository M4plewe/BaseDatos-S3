import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class InterfazMenu {
    public JPanel panel1;
    private JButton buscarEventoButton;
    private JButton inscribirseAEventoButton;
    private JScrollPane scrollPane;
    private JButton cerrarSesionButton;
    private JButton mostrarEventosInscritoButton;
    private JButton eventosRecomendadosButton;

    private JPanel eventPanel; // Panel que contendrá todos los eventos

    UserManager userManager;
    ArbolBinario arbolEventos;
    String usuarioActual;

    public InterfazMenu(UserManager userManager, ArbolBinario arbolEventos, String usuarioActual) {
        this.userManager = userManager;
        this.arbolEventos = arbolEventos;
        this.usuarioActual = usuarioActual;

        mostrarEventos();

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
        buscarEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del evento a buscar");
                Evento evento = arbolEventos.buscar(nombre);

                if (evento != null) {
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

                    JOptionPane.showMessageDialog(panel1, panelEvento, "Evento encontrado", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(panel1, "Evento no encontrado");
                }

            }
        });
        inscribirseAEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        //Agregar usuario usando UserManager metodo addEventToUser
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del evento al que desea inscribirse");
                Evento evento = arbolEventos.buscar(nombre);

                if (evento != null) {
                    userManager.addEventToUser(usuarioActual, evento);
                    evento = arbolEventos.buscar(nombre);
                    evento.GenteInscrita++;
                    JOptionPane.showMessageDialog(panel1, "Inscrito al evento");
                } else {
                    JOptionPane.showMessageDialog(panel1, "Evento no encontrado");
                }

            }
        });
        mostrarEventosInscritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
                List<Evento> eventos = userManager.getUserEvents(usuarioActual);
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
                    JLabel labelGenteInscrita = new JLabel("Gente inscrita: " + evento.GenteInscrita);

                    panelEvento.add(labelNombre);
                    panelEvento.add(labelCategoria);
                    panelEvento.add(labelUbicacion);
                    panelEvento.add(labelDescripcion);
                    panelEvento.add(labelGenteInscrita);

                    panelEventos.add(panelEvento);

                    JSeparator separator = new JSeparator();
                    separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
                    panelEventos.add(separator);

                    panelEventos.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio de 10 píxeles
                }

                JOptionPane.showMessageDialog(panel1, panelEventos, "Eventos inscritos", JOptionPane.PLAIN_MESSAGE);
            }

        });
        eventosRecomendadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Evento> eventos = arbolEventos.obtenerEventos();
                eventos.sort((e1, e2) -> Integer.compare(e2.getGenteInscrita(), e1.getGenteInscrita())); // Ordenar eventos por cantidad de gente inscrita

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
                    JLabel labelInscritos = new JLabel("Inscritos: " + evento.getGenteInscrita());

                    panelEvento.add(labelNombre);
                    panelEvento.add(labelCategoria);
                    panelEvento.add(labelUbicacion);
                    panelEvento.add(labelDescripcion);
                    panelEvento.add(labelInscritos);

                    panelEventos.add(panelEvento);

                    JSeparator separator = new JSeparator();
                    separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
                    panelEventos.add(separator);

                    panelEventos.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio de 10 píxeles
                }

                // Envolver el panel de eventos dentro de un JScrollPane
                JScrollPane scrollPane = new JScrollPane(panelEventos);
                scrollPane.setPreferredSize(new Dimension(800, 600)); // Limitar el tamaño del JScrollPane a 800x600

                // Mostrar los eventos en un JOptionPane
                JOptionPane.showMessageDialog(panel1, scrollPane, "Eventos Recomendados", JOptionPane.PLAIN_MESSAGE);
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