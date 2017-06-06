package unicauca.movil.libros.models;

/**
 * Created by darfe on 21/05/2017.
 */

public class Book {

    Long idlibro;
    String nombre, autor;
    int paginas;

    public Book(String nombre, String autor, int paginas) {
        this.nombre = nombre;
        this.autor = autor;
        this.paginas = paginas;
    }

    public Long getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(Long idlibro) {
        this.idlibro = idlibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
}
