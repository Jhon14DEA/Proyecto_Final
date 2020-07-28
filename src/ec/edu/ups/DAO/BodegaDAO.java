/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.DAO;

import ec.edu.ups.IDAO.IBodega;
import ec.edu.ups.modelo.Bodega;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class BodegaDAO implements IBodega {

    /**
     * Dimensiones del archivo
     *
     * String nombre -> 25 bytes + 2 
     * String direccion -> 50 bytes + 2 String
     * cuidad ->25 bytes + 2
     *
     * total registro = 106
     */
    
    /**
     * Atributos para la clase BodegaDAO que nos permitira hacer casi todo de 
     * forma sesilla con un fichero es unas de las facilidades que nos da la clase
     * RandomAccessFile
     */
    private RandomAccessFile archivo;
    private int tamañoRegistro;
    private Bodega bodegaInterna;
    String eliminar50bytes;
    String eliminar25bytes;
    
    /**
     * Bodega MetodoDAO
     * 
     * Este método de accesibilidad publica esta intanciados el arhico que es de tipo 
     * RandomAccesFile que nos sirve para un archivo en este caso para la lectura 
     * y escritura dentro del arhivo datos esta creado un objeto de tipo dat donde 
     * se ejecutan varios comandos para el desarrollo del proyecto, comandos que
     * se llevaran a cabo desde el GUI
     */
  
    
    public BodegaDAO() {
        
        try {
            archivo = new RandomAccessFile("datos/bodega.dat", "rw");
            tamañoRegistro = 106;
            bodegaInterna = new Bodega();
            eliminar50bytes="                                                  ";
            eliminar25bytes="                         ";
        } catch (IOException e) {
            System.out.println("Error de lectura y escritura (BodegaDAO Bodega DAO)");
            e.printStackTrace();
        }
    }
    /**
     * Metodo Crear Bodega
     *  
     * El metodo crea traducido seria crea, que vamos a crear?
     * en este caso creariamos bodejgas q ya que esta ricibiendo como parámetros
     * bodega. entonces a propósito de esto en la codificación es decir que este método
     * nos va a crear o registrar los datos de la bodega y usar el método buscar nos ubicariamos
     * con el puntero en l posición del archivo y ese empezara a leer o escribir en esa posición
     * ademas de esto estamos haciendo uso de writeUTF donde le decimos que nos escriba un texto 
     * en un formato de tipo aString o utf -8 pero claro esto de debe hacer con sus respectivas 
     * limitaciones lanzando y atrpaango las pérdidas
     * 
     * @param bodega 
     */
    @Override
    public void create(Bodega bodega) {
        try {
            archivo.seek(archivo.length());
            archivo.writeUTF(bodega.getNombre());
            archivo.writeUTF(bodega.getDireccion());
            archivo.writeUTF(bodega.getCuidad());
            
        } catch (IOException e) {
            System.out.println("Error de  lectura y escritura(create: BodegaDAO)");
            e.printStackTrace();
            
        }
    }
    
    /**
     * Metodo lee Bodega
     * 
     * El metodo leer bodega se encarga de leer todo dentro del archivo especificado 
     * con el RandomAccesFile, ya que podras leer el nombre lo estamos pasando como 
     * parametros un dato de tipo String nombre y nos estamos ayudando con 
     * los saltos para poder controlar donde se crea ya que el buscar también puede ubicarse 
     * en el final del archivo para poder hacer las transacciones específicas especificadas.
     * 
     * 
     * @param nombre
     * @return 
     */
    @Override
    public Bodega read(String nombre) {
        try {
            int salto = 0;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                bodegaInterna.setNombre(archivo.readUTF());
                bodegaInterna.setDireccion(archivo.readUTF());
                bodegaInterna.setCuidad(archivo.readUTF());
                if (bodegaInterna.getNombre().equals(nombre)) {
                    return bodegaInterna;
                }
                salto += tamañoRegistro;
                
            }
        } catch (IOException e) {
            System.out.println("Error de lectura (read: BodegaDAO)");
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     *  Actualización de Metodo Bodega
     * 
     * El memetodo actualizar bodega esta reicibiendo como parametr bodega
     * donde nos ubicamos en el unicio con ell buscar y esto hara que el usuario
     * despuesde que pase por eso la cofificación el usuario ingrese los nuevos datos que se le daran 
     * al ala clase bodega con todos sus atributos es decir 
     * la infomacion antigua sera suplantada por una nueva que sera ingresada por el usuario
     * 
     * 
     * @param bodega 
     */
    
    @Override
    public void update(Bodega bodega) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                bodegaInterna.setNombre(archivo.readUTF());
                if (bodega.getNombre().equals(bodegaInterna.getNombre())) {
                    archivo.seek(salto + 27);
                    archivo.writeUTF(bodega.getDireccion());
                    archivo.writeUTF(bodega.getCuidad());
                    break;
                    
                }
                salto += tamañoRegistro;
                
            }
            
        } catch (IOException e) {
            System.out.println("Error de lectura (update: BodegaDAO)");
            e.printStackTrace();
            
        }
    }
    
    /**
     * 
     * Eliminar Metodo
 * 
 * El metodo eliminar esta resibiendo coomo parametro un nombre de tipo string ya que 
 * para eliminar primero tenemos que buscarle ala bodega y despues de eso estamos
 * indica que bodega sera eliminadaa para que el metodo le elimine desde esa psosicion en a
 * adelante con todos sus atributos incluidos
     * 
     * 
     * @param  nombre
     */
    @Override
    public void delete(String nombre) {
        String cadena = "";
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String nombreArchivo = archivo.readUTF();
                if (nombreArchivo.equals(nombre)) {
                    archivo.seek(salto);
                    archivo.writeUTF(eliminar25bytes);
                    archivo.writeUTF(eliminar50bytes);
                    archivo.writeUTF(eliminar25bytes);
                    break;
                }
                salto += tamañoRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (Delte :Bodega DAO)");
            ex.printStackTrace();
            
        }
        
    }
    
    /**
     * El metodos listar Bodegas
     * 
     * Este método nos dara a conocer una lista de bodegas gracias ala lista de clases 
     * podremos hacer que este método se ejecute de una manera correcta para ellos debemo
     * controlar los saltos que demos dentro del archivo para poder recoorer todo 
     * y encontrar todas las bodegas disponibles para poder despues agregar los datos e
     * datos encontrados para posteriomente ser listads y que el GUI puede observar 
     * todo lo que esta dentro de los términos y pueda hacer consutltas posteriormente en 
     * otras interfaces
     * 
     */
    
    @Override
    public List<Bodega> findAllBodegas() {
        List<Bodega> bodegaLista = new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                bodegaInterna= new Bodega();
                bodegaInterna.setNombre(archivo.readUTF());
                bodegaInterna.setDireccion(archivo.readUTF());
                bodegaInterna.setCuidad(archivo.readUTF());
                if(!bodegaInterna.getNombre().equals(eliminar25bytes)){
                  bodegaLista.add(bodegaInterna);  
                }
                
                salto += tamañoRegistro;
            }
            
            return bodegaLista;
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (List : BodegaDAO)");
            ex.printStackTrace();
        }
        return null;
    }
    
}
