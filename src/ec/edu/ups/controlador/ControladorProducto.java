/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.DAO.*;
import ec.edu.ups.modelo.*;
import java.util.List;

/**
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class ControladorProducto {

    private Bodega bodega;
    private Producto producto;
    private BodegaDAO bodegaDAO;
    private ProductoDAO productoDAO;

    public ControladorProducto() {
        this.productoDAO=productoDAO;
    }

    public ControladorProducto(Bodega bodega, BodegaDAO bodegaDAO, ProductoDAO productoDAO, Producto producto) {
        this.bodega = bodega;
        this.bodegaDAO = bodegaDAO;
        this.productoDAO = productoDAO;
        this.producto=producto;
    }

    public void crearNuevoProducto(String codigo, String nombreDeProducto, double precioDeProdcuto, int cantidad, String bodega) {
        for (int i = codigo.length(); i < 10; i++) {
            codigo += " ";
        }
        codigo=codigo.substring(0, 10);
        
        for (int i = nombreDeProducto.length(); i < 25; i++) {
            nombreDeProducto += " ";
        }
        nombreDeProducto=nombreDeProducto.substring(0, 25);
        
        this.bodega=bodegaDAO.read(bodega);
        producto = new Producto(codigo, nombreDeProducto, precioDeProdcuto, cantidad);
        producto.setBodega(this.bodega);
        productoDAO.create(producto);
        
    }

    public Producto verProducto(String nombre) {
        producto = productoDAO.read(nombre);
        return producto;
    }

    public void actualizarProducto(String codigo, String nombreDeProducto, double precioDeProdcuto, int cantidad, String bodega) {
        for (int i = codigo.length(); i < 10; i++) {
            codigo += " ";
        }
        codigo=codigo.substring(0, 10);
        
        for (int i = nombreDeProducto.length(); i < 25; i++) {
            nombreDeProducto += " ";
        }
        nombreDeProducto=nombreDeProducto.substring(0, 25);
        
        this.bodega=bodegaDAO.read(bodega);
        producto = new Producto(codigo, nombreDeProducto, precioDeProdcuto, cantidad);
        producto.setBodega(this.bodega);
        productoDAO.update(producto);
    }

    public void eliminarProducto(String codigo){
        productoDAO.delete(codigo);
    }
    
    public List<Producto> verProductosGeneral(){
        List <Producto> list =productoDAO.findAllProductos();
        return list;
    }
    
    public List<Producto> verProductosPorBodega(String bodega){
        return productoDAO.ListarProductosPorBodega(bodega);
    }
}
