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
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class ProductoDAO implements IProducto {

    /**
     *
     * private String codigo | 10 caracteres + 2 bytes private String
     * nombreDeProducto | 25 caracteres + 2 bytes private double
     * precioDeProdcuto | 8 bytes private int cantidad | 4 bytes private Bodega
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

    @Override
    public Producto read(String codigo) {
        int salto = 0;
        try {
            while (salto < archivoProductos.length()) {
                archivoProductos.seek(salto);
                productoInterno.setCodigo(archivoProductos.readUTF());
                productoInterno.setNombreDeProducto(archivoProductos.readUTF());
                productoInterno.setPrecioDeProdcuto(archivoProductos.readDouble());
                productoInterno.setCantidad(archivoProductos.readInt());
                String bodega = archivoProductos.readUTF();
                productoInterno.setBodega(bodegaDao.read(bodega));
                if (codigo == productoInterno.getCodigo()) {
                    productoInterno.setBodega(bodegaInterna);
                    return productoInterno;
                }
                salto += tamañoDeArchivo;
            }
        } catch (IOException e) {
            System.out.println("Error escritura y lectura [read ProductoDAO]");
        }
        return null;
    }

    @Override
    public void update(Producto producto) {
        int salto = 0;
        try {
            while (salto < archivoProductos.length()) {
                archivoProductos.seek(salto);
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

    @Override
    public void delete(String codigo) {
        int salto = 0;
        try {
            while (salto < archivoProductos.length()) {
                archivoProductos.seek(salto);
                productoInterno.setCodigo(archivoProductos.readUTF());
                if (codigo.equals(productoInterno.getCodigo())) {
                    archivoProductos.seek(salto);
                    archivoProductos.writeUTF(eliminar10bytes);
                    archivoProductos.writeUTF(eliminar25bytes);
                    archivoProductos.writeDouble(0.00);
                    archivoProductos.write(0);
                    archivoProductos.writeUTF(eliminar25bytes);
                    break;
                }
                salto += tamañoDeArchivo;
            }
        } catch (IOException e) {
            System.out.println("Error escritura y lectura [delete ProductoDAO]");
        }
    }

    @Override
    public List<Producto> findAllProductos() {
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
                String bodega = archivoProductos.readUTF();
                if (!productoInterno.getCodigo().equals(eliminar10bytes)) {
                    productoInterno.setBodega(bodegaDao.read(bodega));
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
                productoInterno.setBodega(bodegaDao.read(bodega1));
                if (productoInterno.getBodega().getNombre().equals(bodega)) {
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
