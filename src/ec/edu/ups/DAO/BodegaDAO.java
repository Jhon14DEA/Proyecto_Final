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
 *
 * @author JHON FAREZ
 */
public class BodegaDAO  implements IBodega{

    
    /**
     * Dimensiones del archivo 
     * 
     * String nombre -> 25 bytes
     * String direccion -> 50 bytes
     * 
     * total registro = 90
     */
    
    private RandomAccessFile archivo;
    private int tamañoRegistro;
    
    public BodegaDAO(){
     tamañoRegistro = 90;
        try {
            archivo = new RandomAccessFile("datos/bodega.dat", "rw");
        } catch (IOException e) {
            System.out.println("Error de lectura y escritura (BodegaDAO Bodega DAO)");
            e.printStackTrace();
        }
    }
    @Override
    public void create(Bodega bodega) {
       
    }
    

    @Override
    public Bodega read(String nombre) {
       
    }

    @Override
    public void update(Bodega bodega) {
     
    }

    @Override
    public void delete(String nombre) {
      
    }

    @Override
    public List<Bodega> findAllBodegas() {
       
    }

    
    
}
