/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.IDAO;

import ec.edu.ups.modelo.Producto;
import java.util.List;

/**
 *
 * @author Dutan2000
 */
public interface IProducto {
    public void create(Producto producto);
    public Producto read(String codigo);
    public void update(Producto producto);
    public void delete(String codigo);
    public List<Producto> findAllProductos();
    
}
