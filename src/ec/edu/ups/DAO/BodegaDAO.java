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
     * String nombre -> 25 bytes String direccion -> 50 bytes
     *
     * total registro = 79
     */
    private RandomAccessFile archivo;
    private int tamañoRegistro;

    public BodegaDAO() {
        tamañoRegistro = 79;
        try {
            archivo = new RandomAccessFile("datos/bodega.dat", "rw");
        } catch (IOException e) {
            System.out.println("Error de lectura y escritura (BodegaDAO Bodega DAO)");
            e.printStackTrace();
        }
    }

    @Override
    public void create(Bodega bodega) {
        try {
            archivo.seek(archivo.length());
            archivo.writeUTF(bodega.getDireccion());
            archivo.writeUTF(bodega.getNombre());

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
                String bodegaArchivo = archivo.readUTF();
                if (bodegaArchivo.equals(bodegaArchivo)) {
                    Bodega bodega = new Bodega(nombre, bodegaArchivo);
                    return bodega;
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
        try {
            int salto = 0;

            while (salto < archivo.length()) {
                archivo.seek(salto);
                String nombreArchivo = archivo.readUTF();

                if (nombreArchivo.equals(bodega.getNombre())) {
                    archivo.writeUTF(bodega.getDireccion());
                    archivo.writeUTF(bodega.getNombre());
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
                    archivo.writeUTF(String.format("%-" + 25 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 50 + "s", cadena));
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
        int registro = 128;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                Bodega bodega = new Bodega(archivo.readUTF(), archivo.readUTF());

                bodegaLista.add(bodega);
                salto += registro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (List : BodegaDAO)");
            ex.printStackTrace();
        }
        return bodegaLista;
    }

}
