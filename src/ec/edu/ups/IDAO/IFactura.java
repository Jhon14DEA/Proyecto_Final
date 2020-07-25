/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.IDAO;

import ec.edu.ups.modelo.Factura;
import java.util.List;

/**
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public interface IFactura {

    public void create(Factura factura);

    public Factura read(int numeroDeFactura);

    public List<Factura> findAllFacturas();

    public List<Factura> findAllFacturasAnuladas();

    public int getCodigoActual();
}
