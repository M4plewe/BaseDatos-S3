public class Evento {
    String nombre;
    String categoria;
    String ubicacion;
    String descripcion;
    int GenteInscrita = 0;

    public Evento(String nombre, String categoria, String ubicacion, String descripcion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }

    public int getGenteInscrita() {
        return GenteInscrita;
    }
}