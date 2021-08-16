package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import mx.com.gm.peliculas.domain.*;
import mx.com.gm.peliculas.excepciones.*;

//Aqui se implementan las conductas de la interfaces AccesoDatos
public class AccesoDatosImp implements IAccesoDatos {

    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {

        var archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> Listar(String nombreRecurso) throws LecturaDatosEx {

        var archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();

        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                var pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();

            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();

            //aqui se agrega la excepcion
            throw new LecturaDatosEx("Excepcion al listar peliculas:" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas:" + ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, Boolean anexar) throws EscrituraDatosEx {

        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("se ha escrito informacion al archivo:" + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepcion al escribir  peliculas:" + ex.getMessage());

        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {

        var archivo = new File(nombreRecurso);
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            var indice = 1;
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula" + linea + "encontrada en el indice " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;

            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar  peliculas:" + ex.getMessage());

        } catch (IOException ex) {

            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar  peliculas:" + ex.getMessage());

        }
        return buscar;

    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {

        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("se ha creado el archivo");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear  peliculas:" + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreRecurso) {

        var archivo = new File(nombreRecurso);
        if (archivo.exists()) {
            archivo.delete();
            System.out.println("se ha borrado el archivo");
        }

    }

}
