import java.util.ArrayList;
import java.util.List;

public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void agregar(Evento evento) {
        if (raiz == null) {
            raiz = new Nodo(evento);
        } else {
            agregarRecursivo(raiz, evento);
        }
    }

    private void agregarRecursivo(Nodo nodoActual, Evento nuevoEvento) {
        if (nuevoEvento.nombre.compareTo(nodoActual.evento.nombre) < 0) {
            if (nodoActual.izquierdo == null) {
                nodoActual.izquierdo = new Nodo(nuevoEvento);
            } else {
                agregarRecursivo(nodoActual.izquierdo, nuevoEvento);
            }
        } else if (nuevoEvento.nombre.compareTo(nodoActual.evento.nombre) > 0) {
            if (nodoActual.derecho == null) {
                nodoActual.derecho = new Nodo(nuevoEvento);
            } else {
                agregarRecursivo(nodoActual.derecho, nuevoEvento);
            }
        }
    }

    public List<Evento> obtenerEventos() {
        List<Evento> eventos = new ArrayList<>();
        obtenerEventosRecursivo(raiz, eventos);
        return eventos;
    }

    private void obtenerEventosRecursivo(Nodo nodoActual, List<Evento> eventos) {
        if (nodoActual != null) {
            obtenerEventosRecursivo(nodoActual.izquierdo, eventos);
            eventos.add(nodoActual.evento);
            obtenerEventosRecursivo(nodoActual.derecho, eventos);
        }
    }

    public void eliminar(String nombre) {
        raiz = eliminarRecursivo(raiz, nombre);
    }

    private Nodo eliminarRecursivo(Nodo nodoActual, String nombre) {
        if (nodoActual == null) {
            return null;
        }

        if (nombre.compareTo(nodoActual.evento.nombre) < 0) {
            nodoActual.izquierdo = eliminarRecursivo(nodoActual.izquierdo, nombre);
        } else if (nombre.compareTo(nodoActual.evento.nombre) > 0) {
            nodoActual.derecho = eliminarRecursivo(nodoActual.derecho, nombre);
        } else {
            // Nodo encontrado: procedemos a eliminarlo
            // Caso 1: no hay hijos
            if (nodoActual.izquierdo == null && nodoActual.derecho == null) {
                return null;
            }
            // Caso 2: solo un hijo
            else if (nodoActual.izquierdo == null) {
                return nodoActual.derecho;
            } else if (nodoActual.derecho == null) {
                return nodoActual.izquierdo;
            }
            // Caso 3: dos hijos
            else {
                Nodo sucesor = encontrarSucesor(nodoActual.derecho);
                nodoActual.evento = sucesor.evento;
                nodoActual.derecho = eliminarRecursivo(nodoActual.derecho, sucesor.evento.nombre);
            }
        }
        return nodoActual;
    }

    private Nodo encontrarSucesor(Nodo nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }


    public Evento buscar(String nombre) {
        return buscarRecursivo(raiz, nombre);
    }

    private Evento buscarRecursivo(Nodo nodoActual, String nombre) {
        if (nodoActual == null) {
            return null;
        }

        if (nombre.compareTo(nodoActual.evento.nombre) == 0) {
            return nodoActual.evento;
        } else if (nombre.compareTo(nodoActual.evento.nombre) < 0) {
            return buscarRecursivo(nodoActual.izquierdo, nombre);
        } else {
            return buscarRecursivo(nodoActual.derecho, nombre);
        }
    }

    public void eventosPredeterminados(ArbolBinario arbolEventos){

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

    }

}