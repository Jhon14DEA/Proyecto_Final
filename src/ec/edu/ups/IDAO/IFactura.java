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
    public void create(List<Factura> factura);
    public List<Factura> readDetalleFactura(int numeroDeFactura);
    public Factura readFactura(int numeroDeFactura);
    public void anularFactura(int numeroDeFactura);
    public List<Factura> findAllFacturasDisponibles();
    public List<Factura> findAllFacturasAnuladas();
    public int getCodigoActual();
}
