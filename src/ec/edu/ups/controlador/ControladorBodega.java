/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.DAO.BodegaDAO;
import ec.edu.ups.IDAO.IBodega;
import ec.edu.ups.modelo.Bodega;
import java.util.List;

/**
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class ControladorBodega {

    /**
     * Declaracion de atributos para la fuincionalidad de la clase controlador
     * bodega ya que debemos de hacer esto para poder modificar los datos del
     * paquete modelo(Bodega) y la bodega dao para el crud
     */
    private Bodega bodega;
    private BodegaDAO bodegaDAO;

    /**
     * Metodo constructor vacio
     */
    public ControladorBodega() {
        this.bodegaDAO = bodegaDAO;
    }

    /**
     * Metodo ControladorBodega
     *
     * El metodo constructor bodega hace que un elemento de la clase controlador
     * Bodega cuyo identificador coincide con el de la clase bodega y que tiene
     * por objetivo obligar a y controlar cómo se inicializa una instancia de
     * una determinada clase, ya que el lenguaje Java no permite que las
     * variables miembro de una nueva instancia queden sin inicializar.
     *
     * @param bodega
     * @param bodegaDAO
     */

    public ControladorBodega(Bodega bodega, BodegaDAO bodegaDAO) {
        this.bodega = bodega;
        this.bodegaDAO = bodegaDAO;
    }

    /**
     * Metodo crearBodega
     *
     * El metodo crear bodega nos ayuda con la facilidad nesearia y se puede
     * desarrolllar con normalidad debido a que resive como parametros los
     * atributos de Bodega que son de tipo String y estos seran los que se
     * ecnargen de crearo registrar o actualizar bodegas en este caso solo
     * tendremos la facilidad para crear una bodega llamando ala bodega dao para
     * poder lleva acabo el codigo
     *
     * @param direccion
     * @param nombre
     */
    public void crearBodega(String nombre, String direccion, String cuidad) {
        for (int i =nombre.length(); i < 25; i++) {
            nombre+=" ";
        }
        nombre= nombre.substring(0, 25);
        
        for (int i = direccion.length(); i < 50; i++) {
            direccion+=" ";
        }
        direccion=direccion.substring(0, 50);
        
        for (int i = cuidad.length(); i < 25; i++) {
            cuidad+=" ";
        }
        cuidad=cuidad.substring(0, 25);
        
        bodega = new Bodega(nombre, direccion, cuidad);
    }

    /**
     * Metodo buscarBodega
     *
     * El metod buscar bodega se va a ubicar dentro del fichero ya especiicado
     * en el dao de el proyecto y esto servira para poder identificar donde esta
     * y que modificaciones se puede llevar a cabo entonces la funciolidad de
     * este metodo es con valores de retorno ya que si contiene una bodega nos
     * retornara una bodega de caso contrario un null
     *
     * @param nombre
     * @return
     */
    
    public Bodega buscarBodega(String nombre) {

        bodega = bodegaDAO.read(nombre);
        if (bodega != null) {
            return bodega;
        } else {
            return null;
        }
    }

    public Bodega devolverBodega() {
        return bodega;
    }

    public void actualizarBodega(String nombre, String direccion, String cuidad) {
        for (int i = nombre.length(); i < 25; i++) {
            nombre+=" ";
        }
        nombre=nombre.substring(0, 25);
        
        for (int i = direccion.length(); i < 50; i++) {
            direccion+=" ";
        }
        direccion=direccion.substring(0, 50);
        
        for (int i = cuidad.length(); i < 25; i++) {
            cuidad+=" ";
        }
        cuidad=cuidad.substring(0, 25);
        
        bodega=new Bodega(nombre, direccion, cuidad);
        bodegaDAO.update(bodega);
    }

    /**
     * Metodo eliminar Bodega
     *
     * Para llevar a cabo el metodo eliminar es necesario considerar que
     * necesita un parametro de entrada para poder buscar eh identificar donde
     * esta la bodega especificada para poder hacer efectivo este metodo es
     * necesario llamar al dao que proseda a su busqueda y posteriormente
     * econtrada a ser eliminada
     *
     * @param nombre
     */
    public void eliminarBodega(String nombre) {
        bodegaDAO.delete(nombre);

    }

    /**
     * Metodo listarBodegas
     *
     * Este metodo es primordial ya que nos ayuda aque la GUI pueda ver observar
     * interactuar con las bodegas entonces teneidno como resultados bodegas
     * modificables o fijas en caso de que el usuario solo quiera consultar
     * cosas o productos dentro de la mismo pero considerando que la
     * funcionalidad de este metodo se debe en su totalidad ala clase llama que
     * esta dentro del paquete DAO (bodegaDAO).
     *
     * @return
     */
    public List<Bodega> listarBodegas() {
        List<Bodega> listaBodega = bodegaDAO.findAllBodegas();
        return listaBodega;

    }

}
