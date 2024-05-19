import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        // Establecer FlatDarkLaf como Look and Feel
        try {
            UIManager.setLookAndFeel(new FlatArcOrangeIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }



        UserManager userManager = new UserManager();
        ArbolBinario arbolEventos = new ArbolBinario();

        Evento evento1 = new Evento("Concierto de Rock", "Música", "Madrid", "Un concierto de rock con bandas locales e internacionales.");
        arbolEventos.agregar(evento1);

        Evento evento2 = new Evento("Feria del Libro", "Cultura", "Barcelona", "Una feria que reúne a autores y editoriales para presentar sus últimas obras.");
        arbolEventos.agregar(evento2);

        Evento evento3 = new Evento("Maratón de Ciudad", "Deportes", "Valencia", "Una maratón anual que recorre las principales calles de la ciudad.");
        arbolEventos.agregar(evento3);

        Evento evento4 = new Evento("Festival de Cine", "Cine", "San Sebastián", "Un festival que premia las mejores películas del año.");
        arbolEventos.agregar(evento4);

        Evento evento5 = new Evento("Exposición de Arte Moderno", "Arte", "Bilbao", "Una exposición de obras de arte moderno de artistas emergentes.");
        arbolEventos.agregar(evento5);

        Evento evento6 = new Evento("Conferencia de Tecnología", "Tecnología", "Sevilla", "Una conferencia sobre las últimas innovaciones en tecnología.");
        arbolEventos.agregar(evento6);

        Evento evento7 = new Evento("Feria de Gastronomía", "Gastronomía", "Zaragoza", "Un evento que presenta lo mejor de la gastronomía local e internacional.");
        arbolEventos.agregar(evento7);

        Evento evento8 = new Evento("Torneo de Ajedrez", "Deportes", "Granada", "Un torneo de ajedrez abierto a jugadores de todos los niveles.");
        arbolEventos.agregar(evento8);

        Evento evento9 = new Evento("Musical en el Teatro", "Teatro", "Málaga", "Un musical basado en una famosa película de Hollywood.");
        arbolEventos.agregar(evento9);

        Evento evento10 = new Evento("Festival de Jazz", "Música", "Cádiz", "Un festival con las mejores bandas de jazz nacionales e internacionales.");
        arbolEventos.agregar(evento10);

        Evento evento11 = new Evento("Competencia de Surf", "Deportes", "Las Palmas", "Una competencia de surf en las playas de Gran Canaria.");
        arbolEventos.agregar(evento11);

        Evento evento12 = new Evento("Feria de Artesanía", "Cultura", "Alicante", "Una feria que muestra el trabajo de artesanos locales.");
        arbolEventos.agregar(evento12);

        Evento evento13 = new Evento("Carrera de Bicicletas", "Deportes", "Pamplona", "Una carrera de bicicletas por las calles y caminos de la ciudad.");
        arbolEventos.agregar(evento13);

        Evento evento14 = new Evento("Festival de Danza", "Danza", "Valladolid", "Un festival con presentaciones de danza clásica y contemporánea.");
        arbolEventos.agregar(evento14);

        Evento evento15 = new Evento("Torneo de Videojuegos", "Tecnología", "Madrid", "Un torneo de e-sports con los mejores jugadores del país.");
        arbolEventos.agregar(evento15);

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
