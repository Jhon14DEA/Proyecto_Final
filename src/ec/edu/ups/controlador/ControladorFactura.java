/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;
import ec.edu.ups.DAO.*;
import ec.edu.ups.modelo.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dutan2000
 */
public class ControladorFactura {
    private Factura factura;
    private Bodega bodega;
    private Producto producto;
    private Cliente cliente;
    
    private BodegaDAO bodegaDAO;
    private ClienteDAO clienteDAO;
    private ProductoDAO productoDAO;
    private FacturaDAO facturaDao;

    public ControladorFactura() {
        this.factura = new Factura();
        this.bodega = new Bodega();
        this.producto = new Producto();
        this.cliente = new Cliente();
        this.bodegaDAO = new BodegaDAO();
        this.clienteDAO = new ClienteDAO();
        this.productoDAO = new ProductoDAO(bodegaDAO);
        this.facturaDao = new FacturaDAO();
    }

    
    
    public void crearFactura(List<Factura> facturas){
        facturaDao.create(facturas);
    }
    
    public List<Factura> buscarDetalleFactura(int factura){
        return facturaDao.readDetalleFactura(factura);
    }
    public Factura buscarFactura(int factura){
        return facturaDao.readFactura(factura);
    }
    public List<Factura> listarFacturasActivas(){
        return facturaDao.findAllFacturasDisponibles();
    }
    public List<Factura> listarFacturasAnuladas(){
        return facturaDao.findAllFacturasAnuladas();
    }
    public void AnularFacturas(int factura){
        facturaDao.anularFactura(factura);
    }
    public int codigo(){
        return facturaDao.getCodigoActual();
    }
    
}
