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


    public void actualizar(Evento evento) {
        eliminar(evento.nombre);
        agregar(evento);
    }
}