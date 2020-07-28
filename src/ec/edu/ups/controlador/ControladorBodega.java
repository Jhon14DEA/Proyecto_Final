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

    private Bodega bodega;
    private BodegaDAO bodegaDAO;

    public ControladorBodega() {
        this.bodegaDAO = bodegaDAO;
    }

    public ControladorBodega(Bodega bodega, BodegaDAO bodegaDAO) {
        this.bodega = bodega;
        this.bodegaDAO = bodegaDAO;
    }

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
    
    public Bodega devolverBodega(){
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

    public void eliminarBodega(String nombre) {
        bodegaDAO.delete(nombre);

    }

    public List<Bodega> listarBodegas() {
        List<Bodega> listaBodega = bodegaDAO.findAllBodegas();
        return listaBodega;

    }

}
