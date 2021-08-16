//package mx.com.gm.peliculas.datos;
//
//import java.io.*;
//import java.util.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import mx.com.gm.peliculas.domain.*;
//import mx.com.gm.peliculas.excepciones.*;
//import mx.com.gm.peliculas.excepciones.*;
//import mx.com.gm.peliculas.excepciones.*;
//
//public class AccesoDatosImpl implements IAccesoDatos {
//
//    @Override
//    public boolean existe(String nombreRecurso) throws AccesoDatosEx {
//
//        var archivo = new File(nombreRecurso);
//
//        return archivo.exists();
//    }
//
//    @Override
//    public List<Pelicula> Listar(String nombreRecurso) throws LecturaDatosEx {
//
//        var archivo = new File(nombreRecurso);
//
//        List<Pelicula> pelicula = new ArrayList<>();
//
//        try {
//            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
//        } catch (FileNotFoundException ex) {
//
//            ex.printStackTrace();
//            throw new LecturaDatosEx("Excepcion al listar pelicula:" + ex.getMessage());
//        }
//        
//        
//
//    }
//
//    @Override
//    public void escribir(Pelicula pelicula, String nombreRecurso, Boolean anexar) throws EscrituraDatosEx {
//
//    }
//
//    @Override
//    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
//
//    }
//
//    @Override
//    public void crear(String nombreRecurso) throws AccesoDatosEx {
//
//        @Override
//        public void borrar
//        (String nombreRecurso) throws AccesoDatosEx {
//
//        }
//
//    }
