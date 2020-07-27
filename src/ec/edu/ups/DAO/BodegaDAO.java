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
     * String nombre -> 25 bytes String direccion -> 50 bytes
     *
     * total registro = 79
     */
    
    /**
     * Atributos para la clase BodegaDAO que nos permitira hacer casi todo de 
     * forma sesilla con un fichero es unas de las facilidades que nos da la clase
     * RandomAccessFile
     */
    private RandomAccessFile archivo;
    private int tamañoRegistro;

    /**
     * Metodo bodegaDAO
     * 
     * Este metodo de accesibilidad publica esta intanciados el arhico que es de tipo 
     * RandomAccesFile que nos sirve para  un fichero en este caso para la lectura 
     * y escritura  dentro del arhivo datos esta creado un objeto de tipo dat  donde 
     * se ejecutaran varios comandos para el desarrollo del proyecyo, comandos que
     * se llevaran a cabo desde el GUI
     * 
     */
    public BodegaDAO() {
        tamañoRegistro = 79;
        try {
            archivo = new RandomAccessFile("datos/bodega.dat", "rw");
        } catch (IOException e) {
            System.out.println("Error de lectura y escritura (BodegaDAO Bodega DAO)");
            e.printStackTrace();
        }
    }
    
    /**
     * Metodo Create Bodega
     * 
     * El metodo create traducido seria crea, que vamos a crear?
     * en este caso creariamos  bodejgas q ya que esta ricibiendo como parametros
     * bodega. entonces a finalidad de esto en la codificacion es decir que este metodo 
     * nos va a crear o registrar los datos de la  bodega y utilizando el metodo seek nos ubicariamos
     * con el puntero  en l posision del   fichero y ese empezara a leer o escribir en  esa posision
     *  ademas de  esto estamos haciendo uso de writeUTF donde le decimos   que nos escriba un texto 
     * en un formato de tipo aString o utf -8 pero claro esto de debe  hacer con sus respectivas 
     * excepciones lanzando y atrpaango las excepciones
     * 
     * @param bodega 
     */

    @Override
    public void create(Bodega bodega) {
        try {
            archivo.seek(archivo.length());
            archivo.writeUTF(bodega.getDireccion());
            archivo.writeUTF(bodega.getNombre());

        } catch (IOException e) {
            System.out.println("Error de  lectura y escritura(create: BodegaDAO)");
            e.printStackTrace();

        }
    }

    /**
     * Metodo read Bodega
     * 
     * El metodo leer bodega se encarga de leer todo dentro de  el fichero especificado 
     * con el RandomAccesFile,  ya que podra leer el nombre  lo estamos pasando como 
     * parametros un dato de tipo String nombre y nos estamos ayudandonos con 
     * los saltos para poder controlar donde se crearan ya que el seek tambien puede ubicarse 
     * en el final del fichero para poder hacer dichas gestiones especificados.
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
                String bodegaArchivo = archivo.readUTF();
                if (bodegaArchivo.equals(bodegaArchivo)) {
                    Bodega bodega = new Bodega(nombre, bodegaArchivo);
                    return bodega;
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
     * Metodo update Bodega
     * 
     * El memetodo actualizar bodega esta reicibiendo como parametr bodega
     * donde nos estamos ubicandonos en el unicio con ell seek y esto hara que el usuario
     * despuesde que pase por eso la cofificaion el usuario ingrese los nuevos datos que se le daran 
     * al  ala clase bodega con todos sus atributos es decir 
     * la infomacion antigua sera suplantada por una nueva que sera ingresada por el usuario
     * 
     */
    @Override
    public void update(Bodega bodega) {
        try {
            int salto = 0;

            while (salto < archivo.length()) {
                archivo.seek(salto);
                String nombreArchivo = archivo.readUTF();

                if (nombreArchivo.equals(bodega.getNombre())) {
                    archivo.writeUTF(bodega.getDireccion());
                    archivo.writeUTF(bodega.getNombre());
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
 * Metodo Delete
 * 
 * El metodo eliminar   esta resibiendo coomo parametro un nombre de tipo string ya que 
 * para eliminar primero tenemos que buscarle ala bodega y despues de eso estamos
 * indicadno que bodega sera eliminadaa para que el metodo le elimine desde esa psosicion en a
 * adelante con todos sus atributos incluidos
 * 
 * @param nombre 
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
                    archivo.writeUTF(String.format("%-" + 25 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 50 + "s", cadena));
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
     * Este metodo nos dara a conocer una lista de bodegas gracias ala clase list 
     * podremos hacer que este metodo se ejecute de una manera correcta para ellos debemo
     * controlar los saltos que demos dentro del archivo para poder recoorer todo 
     * y encontrar todas las bodegas disponibles para poder  despues agregar los datos e
     * datos encontrados  para posteriomente ser listads y que el GUI  pueda observar 
     * todo lo que esta dentro de los ficheros y pueda hacer consutltas posteriormente en 
     * otras  interfaces
     * 
     */
    
    @Override
    public List<Bodega> findAllBodegas() {
        List<Bodega> bodegaLista = new ArrayList<>();
        int salto = 0;
        int registro = 128;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                Bodega bodega = new Bodega(archivo.readUTF(), archivo.readUTF());

                bodegaLista.add(bodega);
                salto += registro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (List : BodegaDAO)");
            ex.printStackTrace();
        }
        return bodegaLista;
    }

}
