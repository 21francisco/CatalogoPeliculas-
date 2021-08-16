package mx.com.gm.peliculas.presentacion;

import java.util.Scanner;
import mx.com.gm.peliculas.servicio.*;

public class CatalogoPeliculasPresentacion {

    public static void main(String[] args) {
        var opcion = -1;
        var scanner = new Scanner(System.in);
        IcatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while (opcion != 0) {

            System.out.println("Elige una opcion: \n"
                    + "1. Iniciar catalogo de peliculas\n"
                    + "2. agregar pelicula\n"
                    + "3. listar peliculas\n"
                    + "4. Buscar pelicula\n"
                    + "0. Salir\n");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {

                case 1:

                    catalogo.iniciarCatalogoPelicula();
                    break;

                case 2:
                    System.out.println("Introdue nombre de la pelicula");
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;

                case 3:

                    catalogo.ListarPeliculas();
                    break;

                case 4:

                    System.out.println("Introduce una pelicula a buscar");

                    var buscar = scanner.nextLine();
                    catalogo.BuscarPelicula(buscar);
                    break;

                case 0 :

                    System.out.println("Hasta Pronto");
                    break;
                    
                      default :

                          System.out.println("Opcion no reconocido");
                    break;

            }

        }
    }

}
