/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

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

    private Bodega bodega;
    private IBodega bodegaDAO;

    public ControladorBodega() {
    }

    public ControladorBodega(Bodega bodega, IBodega bodegaDAO) {
        this.bodega = bodega;
        this.bodegaDAO = bodegaDAO;
    }

    public void crearBodega(String direccion, String nombre) {
        bodega = new Bodega(nombre, direccion);
        bodegaDAO.create(bodega);

    }

    public Bodega buscarBodega(String nombre) {

        bodega = bodegaDAO.read(nombre);
        if (bodega != null) {
            return bodega;
        } else {
            return null;
        }
    }

    public void actualizarBodega(String direccion, String nombre) {

        if (bodega != null) {
            bodegaDAO.update(bodega);
        }
    }

    public void eliminarBodega(String nombre) {

        bodegaDAO.delete(nombre);

    }

    public List<Bodega> listarBodegas() {

        List<Bodega> listaBodega = bodegaDAO.findAllBodegas();
        return listaBodega;

    }

}
