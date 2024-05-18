public class Nodo {
    Evento evento;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(Evento evento) {
        this.evento = evento;
        this.izquierdo = null;
        this.derecho = null;
    }

}