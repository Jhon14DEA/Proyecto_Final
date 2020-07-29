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
            bodegaDAO = new BodegaDAO();
            productoDAO = new ProductoDAO(bodegaDAO);
            clienteDAO = new ClienteDAO();
            codigo=0;
        } catch (FileNotFoundException e) {
            System.out.println("Error escritura y lectura [ProductoDAO]");
            System.out.println(e);
        }

    }
    
    /**
     * Create.
     * 
     * Este método recibe una lista de tipo Factura en la cual con esa lista
     * extraemos los datos y los vamos agregando a los dos archivos individuales
     * que se tiene para la factura. En un archivo se recorre un for Each en la 
     * cual solamente se carga el numero de la factura, la cantidad vendida, 
     * y el código del producto. En el otro archivo se guardan los datos 
     * importantes de la factura la cual es el numero de la factura, 
     * la cedula del cliente, el subtotal, el IVA, el total y el estado 
     * de la factura. 
     * 
     * @param facturas 
     */
    @Override
    public void create(List<Factura> facturas) {
        try {
            for (Factura facturaLista : facturas) {
                producto = new Producto();
                archivoDetalleFactura.seek(archivoDetalleFactura.length());
                archivoDetalleFactura.writeInt(facturaLista.getNumeroDeFactura()); //Repetitivo
                archivoDetalleFactura.writeInt(facturaLista.getCantidadVendida());                
                archivoDetalleFactura.writeUTF(facturaLista.getProducto().getCodigo());
                //estes metodo resta la cantidad de los prodcutos
                producto=productoDAO.read(facturaLista.getProducto().getNombreDeProducto());
                int cantidad = producto.getCantidad() - facturaLista.getCantidadVendida();
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

    /**
     * readDetalleFactura.
     * 
     * Este método recibe en sus parámetros un objeto de tipo entero. 
     * Este método primero inicializa una lista, después con un while(), 
     * se recorre todo el archivo del detalle de la factura. Después se hace 
     * una condición en la cual se compara si es que el numero de la factura
     * es igual el entero que se encuentra en el parámetro, se agrega ese 
     * objeto de tipo factura a la lista, sino cumple no lo agrega a la lista.
     * Al final retorna la lista de tipo factura o sino retorna un null si es 
     * que nunca lo encontró. 
     * 
     * @param numeroDeFactura
     * @return listadoDetalle o null.
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
                    factura.setProducto(productoDAO.readCodigo(codigo));                 
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
    
    /**
     * 
     * readFactura.
     * 
     * Este método recibe en sus parámetros un objeto de tipo entero. 
     * Este método va consultando en el archivo factura si es que el entero que
     * esta en su parámetro existe en el archivo factura, y va saltando de dato 
     * en dato. Si es que lo encuentra retorna ese objeto de tipo factura sino 
     * retorna un null. 
     * 
     * @param numeroDeFactura
     * @return factura o null.
     */
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

    /**
     * findAllFacturasDisponibles.
     * 
     * Este método lee todas las facturas dentro del archivo Facturas y lee el 
     * estado de la factura. Si es que el estado de la factura es verdadero lo
     * agrega a una lista de tipo factura. Al final retorna esta lista o sino 
     * retorna un null.
     * 
     * @return facturasA o null.
     */
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

    /**
     * findAllFacturasAnuladas.
     * 
     * Este método lee todas las facturas dentro del archivo Facturas y lee el 
     * estado de la factura. Si es que el estado de la factura es falso lo 
     * agrega a una lista de tipo factura. Al final retorna esta lista o sino 
     * retorna un null.
     * 
     * @return facturasanuladas o null.
     */
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

    /**
     * getCodigoActual.
     * 
     * Este método los que hace es leer el ultimo numero que existe en el
     * archivo factura una vez que encuentra el ultimo numero de la factura 
     * lo retorna y le suma un valor mas para que al facturar se produzca un 
     * nuevo numero y no un repetido. 
     * 
     * @return codigo.
     */
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

    /**
     * anularFactura.
     * 
     * Este método recibe en sus parámetros un objeto de tipo entero. A este 
     * método se le pase el numero de la factura que quieren anular. Después 
     * busca ese numero de la factura dentro del archivo Factura, cuando lo 
     * encuentra cambia el estado de la factura de verdadero a falso. 
     * Por ultimo se retorna todos los objetos dentro de esa factura a 
     * sus bodegas. 
     * 
     * @param numeroDeFactura 
     */
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
    
    /**
     * regresarProductos.
     * 
     * Este método recibe en sus parámetros un objeto de tipo entero.  Este 
     * método lo que hace es buscar todas la facturas que tengan el mismo numero
     * que esta en sus parámetros y después llama al productoDAO para que 
     * actualice ese producto con los datos que se le están agregando. 
     * 
     * @param numeroFactura 
     */
    public void regresarProductos(int numeroFactura){
        long inicio = 0;
        try{
            long sizeArchivoDetalleFactura = archivoDetalleFactura.length();

                while (inicio < sizeArchivoDetalleFactura) {
                    archivoDetalleFactura.seek(inicio);
                    int num = archivoDetalleFactura.readInt(); //Repetitivo
                    if(num==numeroFactura){
                        producto=new Producto();
                        int cantidad =archivoDetalleFactura.readInt();
                        String codigo =archivoDetalleFactura.readUTF();
                        producto=productoDAO.readCodigo(codigo); 

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
