/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.DAO;

import ec.edu.ups.IDAO.IProducto;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Producto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ClASE PRODUCTO DAO
 * 
 * Declaracion de los artibutos para el manejor de la clase  ya que neccesitaremos 
 * para poder  implementar el DRUD dentro de la misma.
 * 
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class ProductoDAO implements IProducto {

    /**
     *
     * private String codigo | 10 caracteres + 2 bytes private String
     * nombreDeProducto | 25 caracteres + 2 bytes 
     * private double precioDeProdcuto | 8 bytes 
     * private int cantidad | 4 bytes private Bodega
     * bodega (nombre de Bodega) | 25 caracteres + 2 bytes
     *
     * total= 78 bytes
     *
     */
    private RandomAccessFile archivoProductos;
    private int tamañoDeArchivo;

    private Producto productoInterno;
    private Bodega bodegaInterna;
    private BodegaDAO bodegaDao;

    private String eliminar10bytes;
    private String eliminar25bytes;

    public ProductoDAO(BodegaDAO bodegaDao) {
        try {
            archivoProductos = new RandomAccessFile("datos/producto.dat", "rw");
            this.bodegaDao = bodegaDao;
            productoInterno = new Producto();
            tamañoDeArchivo = 78;
            eliminar10bytes = "          ";
            eliminar25bytes = "                         ";
        } catch (FileNotFoundException e) {
            System.out.println("Error escritura y lectura [ProductoDAO]");
            System.out.println(e);
        }
    }

    /**
     * Metodo create.
     * 
     * El metodo crear producto en primer lugar se ocupa en la posicion final del archivo en la 
     * ruta ya especificada despues de esp procedera a escribir en la posicion ya encontrada 
     * con anterioridad estableciendo un codigo, producto, cantidad, nombre ala bodega pero dento de
     * la bodega
     * 
     * @param producto 
     */
    @Override
    public void create(Producto producto) {
        try {
            archivoProductos.seek(archivoProductos.length());
            archivoProductos.writeUTF(producto.getCodigo());
            archivoProductos.writeUTF(producto.getNombreDeProducto());
            archivoProductos.writeDouble(producto.getPrecioDeProdcuto());
            archivoProductos.writeInt(producto.getCantidad());
            archivoProductos.writeUTF(producto.getBodega().getNombre());

        } catch (IOException e) {
            System.out.println("Error escritura y lectura [create ProductoDAO]");
            System.out.println(e);
        }
    }

    /**
     * Metodo read.
     * 
     * Dentro del metodo read  lo que aremos en leer el ficher pero con los procesos que se 
     * requieran en dicho metodo por ejemplo  en este caso tendremos un fichero de productos 
     * donde se procedera a  establceer los valores a cada atributo de  factura en este caso 
     * crenando un  producto interno donde se  estableceran el codigo, numero, producto, direccion
     * y la cantidad de productos.
     * 
     * @param nombre
     * @return productoInterno o null.
     * 
     */
    @Override
    public Producto read(String nombre) {
        int salto = 0;
        try {
            while (salto < archivoProductos.length()) {
                archivoProductos.seek(salto);
                productoInterno=new Producto();
                productoInterno.setCodigo(archivoProductos.readUTF());
                productoInterno.setNombreDeProducto(archivoProductos.readUTF());
                productoInterno.setPrecioDeProdcuto(archivoProductos.readDouble());
                productoInterno.setCantidad(archivoProductos.readInt());
                String bodega = archivoProductos.readUTF();
                productoInterno.setBodega(bodegaDao.read(bodega));
                if (nombre.equals(productoInterno.getNombreDeProducto())) {
                    return productoInterno;                    
                }
                salto += tamañoDeArchivo;
            }
        } catch (IOException e) {
            System.out.println("Error escritura y lectura [read ProductoDAO]");
        }
        return null;
    }

    /**
     * Metodo read Codigo.
     * 
     * El metodo para leer el codigo nos ayudara para establecer siertos valores alos atributos de la c
     * clase   producto en ellos analizaremos la manera en que son establecidos los calores alos atributos pero 
     * esta ves solo  podremos observar los datos en caso de que este metodo sea llamado en la GUI
     * 
     * @param codigo
     * @return productoInterno o null.
     */
        @Override
    public Producto readCodigo(String codigo) {
        int salto = 0;
        try {
            while (salto < archivoProductos.length()) {
                archivoProductos.seek(salto);
                productoInterno=new Producto();
                productoInterno.setCodigo(archivoProductos.readUTF());
                productoInterno.setNombreDeProducto(archivoProductos.readUTF());
                productoInterno.setPrecioDeProdcuto(archivoProductos.readDouble());
                productoInterno.setCantidad(archivoProductos.readInt());
                String bodega = archivoProductos.readUTF();
                productoInterno.setBodega(bodegaDao.read(bodega));
                if (codigo.equals(productoInterno.getCodigo())) {
                    return productoInterno;
                }
                salto += tamañoDeArchivo;
            }
        } catch (IOException e) {
            System.out.println("Error escritura y lectura [read ProductoDAO]");
        }
        return null;
    }
    
    /**
     * Metodo update.
     * 
     * El metodo actualizar bodega nos sirve en especial para renombrar siertos atributos ya estabelcido en 
     * la clase producto, mismos que el usuario podra leer ya con GUI para ellos es nesario controlar los saltos
     * en este caso iniciara en cero eh ira s aumentando dependiento el usu que se le de al metodo 
     * y donde sea invocado.
     * 
     * @param producto 
     */
    @Override
    public void update(Producto producto) {
        int salto = 0;
        try {
            while (salto < archivoProductos.length()) {
                archivoProductos.seek(salto);
                productoInterno=new Producto();
                productoInterno.setCodigo(archivoProductos.readUTF());
                if (producto.getCodigo().equals(productoInterno.getCodigo())) {
                    archivoProductos.seek(salto + 12);
                    archivoProductos.writeUTF(producto.getNombreDeProducto());
                    archivoProductos.writeDouble(producto.getPrecioDeProdcuto());
                    archivoProductos.writeInt(producto.getCantidad());
                    archivoProductos.writeUTF(producto.getBodega().getNombre());
                    break;
                }
                salto += tamañoDeArchivo;
            }
        } catch (IOException e) {
            System.out.println("Error escritura y lectura [update DAOTelefono]");
        }
    }

    /**
     * Metodo delete.
     * 
     * El metodo eliminar nos eliminara de una manera directa un producto ya creado con anterioridad ya que ademas de
     * eso esta controlado de que exista el producto dentro de los archivos  punto dat para poder ser ejecutado en metodo de 
     * caso contrario no podra  no servira para el cual fue planteado.
     * 
     * @param codigo 
     */
    @Override
    public void delete(String codigo) {
        int salto = 0;
        try {
            while (salto < archivoProductos.length()) {
                archivoProductos.seek(salto);
                String codigoAEliminar=archivoProductos.readUTF();
                if (codigo.equals(codigoAEliminar)) {
                    archivoProductos.seek(salto);
                    archivoProductos.writeUTF(eliminar10bytes);
                    archivoProductos.writeUTF(eliminar25bytes);
                    archivoProductos.writeDouble(0);
                    archivoProductos.writeInt(0);
                    archivoProductos.writeUTF(eliminar25bytes);
                    break;
                }
                salto += tamañoDeArchivo;
            }
        } catch (IOException e) {
            System.out.println("Error escritura y lectura [delete ProductoDAO]");
        }
    }

    /**
     * Metodo listar productos. 
     * 
     * El metodo a cuestion es muy necesario en esta clase ya que sin ellos el usuario no podra
     * observar todo lo que tiene a sus disposicion para poder hacer dichas modifcaciones o 
     * consultas  para ellos anbuscarenos un codigo que nos facilitara la consulta individual de los 
     * productos estableciendo los calores dentro de una tabla que esta actuando con el usuario.
     * 
     * @return List o null.
     */
    @Override
    public List<Producto> findAllProductos() {
        List<Producto> todosLosProductos = new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivoProductos.length()) {
                productoInterno=new Producto();
                archivoProductos.seek(salto);
                productoInterno.setCodigo(archivoProductos.readUTF());
                productoInterno.setNombreDeProducto(archivoProductos.readUTF());
                productoInterno.setPrecioDeProdcuto(archivoProductos.readDouble());
                productoInterno.setCantidad(archivoProductos.readInt());
                String bodega = archivoProductos.readUTF();
                productoInterno.setBodega(bodegaDao.read(bodega));
                if (!productoInterno.getCodigo().equals(eliminar10bytes)) {
                    todosLosProductos.add(productoInterno);
                }
                salto += tamañoDeArchivo;
            }
            
        } catch (IOException e) {
            System.out.println("Error escritura y lectura [findAllProductos ProdcutoDAO]");
        }
        return todosLosProductos;
    }

    /**
     * Metodo Listar Productos por Bodega.
     * 
     * El metodo listar esta englobando a todas las bodegas y se podra analizar el de una manera 
     * legible todos los datos especificados en alguno de los atributos para ellos se establecera y se 
     * emepzara a ver dentro del arhchivo desde la posisicon 0 eh ira leyendo todo los productos que encuentre para 
     * posteriormente  ser mostrados en la GUI 
     * 
     * @param bodega
     * @return List o null.
     */
    @Override
    public List<Producto> ListarProductosPorBodega(String bodega) {
       List<Producto> todosLosProductos = new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivoProductos.length()) {
                archivoProductos.seek(salto);
                productoInterno = new Producto();
                productoInterno.setCodigo(archivoProductos.readUTF());
                productoInterno.setNombreDeProducto(archivoProductos.readUTF());
                productoInterno.setPrecioDeProdcuto(archivoProductos.readDouble());
                productoInterno.setCantidad(archivoProductos.readInt());
                String bodega1 = archivoProductos.readUTF();
                if (bodega1.equals(bodega)) {
                    productoInterno.setBodega(bodegaDao.read(bodega1));  
                    todosLosProductos.add(productoInterno);
                }
                salto += tamañoDeArchivo;
            }
            return todosLosProductos;
        } catch (IOException e) {
            System.out.println("Error escritura y lectura [findAllProductos ProdcutoDAO]");
        }
        return null; 

    }

}
