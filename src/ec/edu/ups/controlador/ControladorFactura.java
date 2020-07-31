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

    
    /**
     * CrearFactura.
     * 
     * Este metodo recibe en su parametro una lista de tipo Factura. Pasa esa lista
     * al facturaDAO.
     * 
     * @param facturas. 
     */
    public void crearFactura(List<Factura> facturas){
        facturaDao.create(facturas);
    }
    /**
     * buscarDetalleFactura.
     * 
     * este método recibe en su parámetro un objeto de tipo entero.  
     * Este método llama al FacuturaDAO y le pasa el numero de la factura 
     * para que le retorne el detalle de la factura con el mismo numero. 
     * 
     * @param factura.
     * @return List o null. 
     */
    public List<Factura> buscarDetalleFactura(int factura){
        return facturaDao.readDetalleFactura(factura);
    }
    /**
     * buscarFactura
     * 
     * este método recibe en su parámetro un objeto de tipo entero.  
     * Este método llama al FacuturaDAO y le pasa el numero de la factura 
     * para que le retorne el detalle de la factura con el mismo numero. 
     * 
     * @param factura.
     * @return factura o null. 
     */
    public Factura buscarFactura(int factura){
        return facturaDao.readFactura(factura);
    }
    /**
     * listarFacturasActivas.
     * 
     * Este método llama al facturaDAO y le pide que le encuentre la lista de 
     * facturas que son validas y que las retorne.  
     * 
     * @return List o null.
     */
    public List<Factura> listarFacturasActivas(){
        return facturaDao.findAllFacturasDisponibles();
    }
    /**
     * listarFacturasAnuladas.
     * 
     * Este método llama al facturaDAO y le pide que le encuentre la lista de 
     * facturas que no son validas y que las retorne.  
     * 
     * @return List o null.
     */
    public List<Factura> listarFacturasAnuladas(){
        return facturaDao.findAllFacturasAnuladas();
    }
    /**
     * AnularFacturas.
     * 
     * Este método recibe en sus parámetros un objeto de tipo entero y llama 
     * al FacturaDAO para que anule la factura que tiene el mismo numero de 
     * factura que se tiene en el parámetro.
     * 
     * @param factura.
     */
    public void AnularFacturas(int factura){
        facturaDao.anularFactura(factura);
    }
    /**
     * codigo.
     * 
     * Este método consigue el siguiente código de la factura y lo retorna. 
     * @return  int codigo.
     */
    public int codigo(){
        return facturaDao.getCodigoActual();
    }
    
}
