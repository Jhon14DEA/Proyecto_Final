/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.IDAO;

import ec.edu.ups.modelo.Bodega;
import java.util.List;

/**
 *
 * @author Dutan2000
 */
public interface IBodega {
    public void create(Bodega bodega);
    public Bodega read(String nombre);
    public void update(Bodega bodega);
    public void delete(String nombre);
    public List<Bodega> findAllBodegas();
    
}
