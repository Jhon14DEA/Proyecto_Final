/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.DAO;

import ec.edu.ups.IDAO.IBodega;
import ec.edu.ups.modelo.Bodega;
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
public class BodegaDAO implements IBodega {

    /**
     * Dimensiones del archivo
     *
     * String nombre -> 25 bytes + 2 
     * String direccion -> 50 bytes + 2 String
     * cuidad ->25 bytes + 2
     *
     * total registro = 106
     */
    private RandomAccessFile archivo;
    private int tamañoRegistro;
    private Bodega bodegaInterna;
    String eliminar50bytes;
    String eliminar25bytes;
    
    public BodegaDAO() {
        
        try {
            archivo = new RandomAccessFile("datos/bodega.dat", "rw");
            tamañoRegistro = 106;
            bodegaInterna = new Bodega();
            eliminar50bytes="                                                  ";
            eliminar25bytes="                         ";
        } catch (IOException e) {
            System.out.println("Error de lectura y escritura (BodegaDAO Bodega DAO)");
            e.printStackTrace();
        }
    }
    
    @Override
    public void create(Bodega bodega) {
        try {
            archivo.seek(archivo.length());
            archivo.writeUTF(bodega.getNombre());
            archivo.writeUTF(bodega.getDireccion());
            archivo.writeUTF(bodega.getCuidad());
            
        } catch (IOException e) {
            System.out.println("Error de  lectura y escritura(create: BodegaDAO)");
            e.printStackTrace();
            
        }
    }
    
    @Override
    public Bodega read(String nombre) {
        try {
            int salto = 0;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                bodegaInterna.setNombre(archivo.readUTF());
                bodegaInterna.setDireccion(archivo.readUTF());
                bodegaInterna.setCuidad(archivo.readUTF());
                if (bodegaInterna.getNombre().equals(nombre)) {
                    return bodegaInterna;
                }
                salto += tamañoRegistro;
                
            }
        } catch (IOException e) {
            System.out.println("Error de lectura (read: BodegaDAO)");
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void update(Bodega bodega) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                bodegaInterna.setNombre(archivo.readUTF());
                if (bodega.getNombre().equals(bodegaInterna.getNombre())) {
                    archivo.seek(salto + 27);
                    archivo.writeUTF(bodega.getDireccion());
                    archivo.writeUTF(bodega.getCuidad());
                    break;
                    
                }
                salto += tamañoRegistro;
                
            }
            
        } catch (IOException e) {
            System.out.println("Error de lectura (update: BodegaDAO)");
            e.printStackTrace();
            
        }
    }
    
    @Override
    public void delete(String nombre) {
        String cadena = "";
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String nombreArchivo = archivo.readUTF();
                if (nombreArchivo.equals(nombre)) {
                    archivo.seek(salto);
                    archivo.writeUTF(eliminar25bytes);
                    archivo.writeUTF(eliminar50bytes);
                    archivo.writeUTF(eliminar25bytes);
                    break;
                }
                salto += tamañoRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (Delte :Bodega DAO)");
            ex.printStackTrace();
            
        }
        
    }
    
    @Override
    public List<Bodega> findAllBodegas() {
        List<Bodega> bodegaLista = new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                bodegaInterna= new Bodega();
                bodegaInterna.setNombre(archivo.readUTF());
                bodegaInterna.setDireccion(archivo.readUTF());
                bodegaInterna.setCuidad(archivo.readUTF());
                if(!bodegaInterna.getNombre().equals(eliminar25bytes)){
                  bodegaLista.add(bodegaInterna);  
                }
                
                salto += tamañoRegistro;
            }
            return bodegaLista;
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (List : BodegaDAO)");
            ex.printStackTrace();
        }
        return null;
    }
    
}
