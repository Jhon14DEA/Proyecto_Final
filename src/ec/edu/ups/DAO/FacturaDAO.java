/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.DAO;

import ec.edu.ups.IDAO.IFactura;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Factura;
import ec.edu.ups.modelo.Producto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class FacturaDAO implements IFactura {

    /**
     * private int numeroDeFactura; | 4 bytes 
     * private int cantidadVendida; | 4
     * bytes private boolean estado; | 1 byte 
     * private double subtotal; | 8 bytes
     * private double iva; | 8 bytes 
     * private double total; | 8 bytes 
     * private Cliente cliente (cedula)| 10 bytes + 2 bytes 
     * private Producto producto (codigo) | 10 bytes + 2 bytes
     *
     * total= 57 bytes
     * 
     * total detalleOrden = 4+4+10+2 =20 bytes
     * total factura = 4+1+8+8+8+10+2=41 bytes
     */
    
    private RandomAccessFile archivoFactura;
    private RandomAccessFile archivoDetalleFactura;
    
    
    private Factura factura;
    private Bodega bodega;
    private Producto producto;
    private Cliente cliente;
    
    private BodegaDAO bodegaDAO;
    private ClienteDAO clienteDAO;
    private ProductoDAO productoDAO;
    
    private int codigo;
    private int tamañoArchivoDetalleFactura;
    private int tamañoArchivoFactura;

    public FacturaDAO() {
        try {
            archivoDetalleFactura = new RandomAccessFile("datos/detalleFactura.dat", "rw");
            archivoFactura = new RandomAccessFile("datos/Factura.dat", "rw");
            tamañoArchivoDetalleFactura = 20;
            tamañoArchivoFactura=41;
            codigo=0;
        } catch (FileNotFoundException e) {
            System.out.println("Error escritura y lectura [ProductoDAO]");
            System.out.println(e);
        }

    }

    @Override
    public void create(List<Factura> facturas) {
        try {
            for (Factura factura : facturas) {
                archivoDetalleFactura.seek(archivoDetalleFactura.length());
                archivoDetalleFactura.writeInt(factura.getNumeroDeFactura()); //Repetitivo
                archivoDetalleFactura.writeInt(factura.getCantidadVendida());                
                archivoDetalleFactura.writeUTF(factura.getProducto().getCodigo());
                //estes metodo resta la cantidad de los prodcutos
                producto=productoDAO.read(factura.getProducto().getCodigo());
                int cantidad = producto.getCantidad() - factura.getCantidadVendida();
                producto.setCantidad(cantidad);                
                productoDAO.update(producto);
            }
            archivoFactura.seek(archivoFactura.length());
            archivoFactura.writeInt(facturas.get(0).getNumeroDeFactura());
            archivoFactura.writeUTF(facturas.get(0).getCliente().getCedula());
            archivoFactura.writeDouble(facturas.get(0).getSubtotal());
            archivoFactura.writeDouble(facturas.get(0).getIva());
            archivoFactura.writeDouble(facturas.get(0).getTotal());
            archivoFactura.writeBoolean(true);

        } catch (IOException e) {
            System.out.println("Error escritura y lectura [create FacturaDAO]");
            System.out.println(e);
        }
    }
    /*
        controlador metodo readFacturaseleccionadoDetalle(int numeroFactura){
        List<Factura> factura = Facturadao.readDetallefactura
        }
    
        controlador metodo readFacturaseleccionado(int numeroFactura){
        Factura factura = Facturadao.readFactura;
        }
    */

    @Override
    public List<Factura> readDetalleFactura(int numeroDeFactura) {
        long inicio = 0;
        List<Factura> listadoDetalle = new ArrayList<>();
        try {
            long sizeArchivoDetalleFactura = archivoDetalleFactura.length();
            while (inicio < sizeArchivoDetalleFactura) {
                archivoDetalleFactura.seek(inicio);
                factura = new Factura();
                factura.setNumeroDeFactura(archivoDetalleFactura.readInt());
                if (factura.getNumeroDeFactura() == numeroDeFactura) {
                    factura.setCantidadVendida(archivoDetalleFactura.readInt());
                    String codigo =archivoDetalleFactura.readUTF();
                    factura.setProducto(productoDAO.read(codigo));                 
                    listadoDetalle.add(factura);
                }
                inicio+=tamañoArchivoDetalleFactura;
            }
            return listadoDetalle;
        } catch (IOException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Factura readFactura(int numeroDeFactura) {
        long inicio = 0;
        try {
            long sizeArchivoFactura = archivoFactura.length();
            while (inicio < sizeArchivoFactura) {
                archivoFactura.seek(inicio);
                factura = new Factura();
                factura.setNumeroDeFactura(archivoFactura.readInt());
                if (factura.getNumeroDeFactura() == numeroDeFactura) {
                    //LEER TODOS LOS DATOS
                    String cedula=archivoFactura.readUTF();
                    factura.setCliente(clienteDAO.read(cedula));
                    factura.setSubtotal(archivoFactura.readDouble());
                    factura.setIva(archivoFactura.readDouble());
                    factura.setTotal(archivoFactura.readDouble());
                    factura.setEstado(archivoFactura.readBoolean());
                    return factura;
                }
                inicio+=tamañoArchivoFactura;
            }
        } catch (IOException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Factura> findAllFacturasDisponibles() {
        List <Factura> facturasA=new ArrayList<>();
        int salto=0;
        try {
            while(salto<archivoFactura.length()){
                archivoFactura.seek(salto);
                factura=new Factura();
                factura.setNumeroDeFactura(archivoFactura.readInt());
                String cedula=archivoFactura.readUTF(); 
                factura.setCliente(clienteDAO.read(cedula));   
                factura.setSubtotal(archivoFactura.readDouble());
                factura.setIva(archivoFactura.readDouble());
                factura.setTotal(archivoFactura.readDouble());                            
                factura.setEstado(archivoFactura.readBoolean());
                if (factura.isEstado()==true){
                    facturasA.add(factura);
                }
                salto+=tamañoArchivoFactura;
            }
            return facturasA;
        } catch (IOException e) {
            System.out.println("Error escritura y lectura [findAllFacturasDisponibles FacturaDAO]");
        }
        return null;
    }

    @Override
    public List<Factura> findAllFacturasAnuladas() {
        List<Factura> facturasanuladas=new ArrayList<>();
        int salto=0;
        try {
            while(salto<archivoFactura.length()){
                archivoFactura.seek(salto);
                factura=new Factura();
                factura.setNumeroDeFactura(archivoFactura.readInt());
                String cedula=archivoFactura.readUTF(); 
                factura.setCliente(clienteDAO.read(cedula));   
                factura.setSubtotal(archivoFactura.readDouble());
                factura.setIva(archivoFactura.readDouble());
                factura.setTotal(archivoFactura.readDouble());                            
                factura.setEstado(archivoFactura.readBoolean());
                if (factura.isEstado()!=true){
                    facturasanuladas.add(factura);
                }
                salto+=tamañoArchivoFactura;
            }
            return facturasanuladas;
        } catch (IOException e) {
            System.out.println("Error escritura y lectura [findAllFacturasAnuladas FacturaDAO]");
        }
        return null;
    }

    @Override
    public int getCodigoActual() {
        try {
            codigo=0;
            int tamanototal=(int)archivoFactura.length();
            if(archivoFactura.length()>0){
                    tamanototal-=tamañoArchivoFactura;
                    archivoFactura.seek(tamanototal);
                    codigo+=archivoFactura.readInt();                
            }
        } catch (IOException e) {
            System.out.println("Error escritura y lectura [CodigoActual FacturaDAO]");
            System.out.println(e);
        }
        return codigo+1;
    }

    @Override
    public void anularFactura(int numeroDeFactura) {
        long inicio = 0;
        try {
            long sizeArchivoFactura = archivoFactura.length();
            while (inicio < sizeArchivoFactura) {
                archivoFactura.seek(inicio);
                factura = new Factura();
                factura.setNumeroDeFactura(archivoFactura.readInt());
                if (factura.getNumeroDeFactura() == numeroDeFactura) {
                    //LEER TODOS LOS DATOS
                    archivoFactura.seek(inicio+40);
                    archivoFactura.writeBoolean(false);
                    regresarProductos(numeroDeFactura);
                    break;
                }
                inicio+=tamañoArchivoFactura;
            }
        } catch (IOException e) {
            System.out.println("Error escritura y lectura [anularFactura FacturaDAO]");
            System.out.println(e);
        }
    }
    
    public void regresarProductos(int numeroFactura){
        long inicio = 0;
        try{
            long sizeArchivoDetalleFactura = archivoDetalleFactura.length();

                while (inicio < sizeArchivoDetalleFactura) {
                    archivoDetalleFactura.seek(inicio);
                    int num = archivoDetalleFactura.readInt(); //Repetitivo
                    if(num==numeroFactura){
                        int cantidad =archivoDetalleFactura.readInt();
                        String codigo =archivoDetalleFactura.readUTF();
                        producto=productoDAO.read(codigo); 

                        cantidad = producto.getCantidad() + cantidad;
                        producto.setCantidad(cantidad);                
                        productoDAO.update(producto);
                    }
                    inicio+=tamañoArchivoDetalleFactura;
                }
        } catch (IOException e) {
                System.out.println("Error escritura y lectura [regresarProductos FacturaDAO]");
                System.out.println(e);

        }
    }


}
