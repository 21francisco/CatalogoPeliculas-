package mx.com.gm.peliculas.servicio;

// Interface orientada al uso el usuario
public interface IcatalogoPeliculas {

    String NOMBRE_RECURSO = "peliculas.txt";

    void agregarPelicula(String nombrePelicula);

    void ListarPeliculas();

    void BuscarPelicula(String buscar);

    void iniciarCatalogoPelicula();

}
