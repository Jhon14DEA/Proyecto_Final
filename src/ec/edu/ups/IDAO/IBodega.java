/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.IDAO;

import ec.edu.ups.modelo.Bodega;
import java.util.List;

/**
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public interface IBodega {
     
/**
 * Metodo crear bodega 
 * 
 *  El metodo crear bodega es usado cuando el usuario inicia la sesion, una ves
 * hecho esto, el usuario podra agrefar  una odega en su lista de bodegas. Recibiendo 
 * como parametro   una bodega que en el momento ya creado y lo aniada ala lista de bodegas. 
 * despues de pasar por esto el usuario podra ver sus bodegas ya en la lista cuadno se 
 * actualice la misma 
 * 
 * @param bodega 
 */
    public void create(Bodega bodega);
    /**
     * Metodo leer  bodega
     * 
     * El metodo leer boodega es la encargada de recibir un parametro nombre 
     * que nos servira para poder leer en los archivos binarios y darnos cuenta de que 
     * su existenica sea confiable y viable pero sobre todo de  sabes si existe ono
     * 
     * @param nombre
     * @return 
     */

    public Bodega read(String nombre);
    /**
     * Metodo update Bodega 
     * 
     * El  metodo actualizar bodega resibe como parametro del paquete bodega
     * una bodega con todos sus atributos y esto hara que cuando el usuario inicie
     * la sesion pueda hacer unas determinadas actualizaciones de su bodega ya que en 
     * la implementacion del metodo crud nos da esa facilidad
     * 
     * @param bodega 
     */

    public void update(Bodega bodega);
    /**
     * Metodo delete Bodega
     * El metodo eliminar  con las accesibilidad de tipo public y de tipo vacio 
     * hace que cuando le pasemos un nombre de una bodega determinada este pueda
     * eliminarla con todos sus atributos pertinenes y asosiados a la misma.
     * 
     * @param nombre 
     */

    public void delete(String nombre);
    /**
     * El metodo listas bodegas
     * 
     * El metod  codificado a continuacion nos creara una lista de bodegas  usando 
     * la clase list que s puede ver, esto nos servira para poder interactuar con el 
     * ususario dentro de los limintes establecidos en la interfaz el podra analizar todo 
     * solo ahi gracias al metodo listar bodegas
     * 
     * @return 
     */

    public List<Bodega> findAllBodegas();

}
