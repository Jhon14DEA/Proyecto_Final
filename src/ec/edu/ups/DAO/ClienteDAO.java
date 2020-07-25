/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.DAO;

import ec.edu.ups.IDAO.ICliente;
import ec.edu.ups.modelo.Cliente;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sebastian Uyaguri
 * @author Denys Dutan
 * @author John Fárez
 * @Santiago Cabrera
 */
public class ClienteDAO implements ICliente {

    private RandomAccessFile archivo;
    private int tamañoRegistro;

    /**
     * Estructura del archivo.
     *
     * private String cedula = 10 bytes private String nombre = 25 bytes private
     * String apellido = 25 bytes private String nombreDelLocal 25 bytes private
     * String telefono = 25 bytes private String direccion = 50 bytes
     *
     * Total bytes registro = 172 bytes
     */
    public ClienteDAO() {
        tamañoRegistro = 172;
        try {
            archivo = new RandomAccessFile("datos/cliente.dat", "rw");
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura");
            ex.printStackTrace();
        }
    }

    @Override
    public void create(Cliente cliente) {
        try {
            archivo.seek(archivo.length());
            archivo.writeUTF(cliente.getNombreDelLocal());
            archivo.writeUTF(cliente.getTelefono());
            archivo.writeUTF(cliente.getDireccion());
            archivo.writeUTF(cliente.getCedula());
            archivo.writeUTF(cliente.getNombre());
            archivo.writeUTF(cliente.getApellido());

        } catch (IOException ex) {

            System.out.println("Error lectrura escritura (ClienteDAO:Create)");
            ex.printStackTrace();

        }
    }

    @Override
    public Cliente read(String nombreDelLocal) {
        try {
            int salto = 0;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String nombreDelLocalArchivo = archivo.readUTF();
                if (nombreDelLocal.equals(nombreDelLocalArchivo)) {
                    Cliente cliente = new Cliente(nombreDelLocal, archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim());
                    return cliente;
                }
                salto += tamañoRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (ClienteDao:Read)");
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(Cliente cliente) {
        int salto = 0;
        try {

            while (salto < archivo.length()) {
                archivo.seek(salto);
                String nombreDelLocalArchivo = archivo.readUTF();
                if (nombreDelLocalArchivo.equals(cliente.getNombreDelLocal())) {
                    archivo.seek(salto);
                    archivo.writeUTF(cliente.getNombreDelLocal());
                    archivo.writeUTF(cliente.getTelefono());
                    archivo.writeUTF(cliente.getDireccion());
                    archivo.writeUTF(cliente.getCedula());
                    archivo.writeUTF(cliente.getNombre());
                    archivo.writeUTF(cliente.getApellido());
                }
                salto += tamañoRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (ClienteDao:Update)");
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(String codigo) {
        String cadena = "";
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String nombreDelLocalArchivo = archivo.readUTF();
                if (nombreDelLocalArchivo.equals(codigo)) {
                    archivo.seek(salto);
                    archivo.writeUTF(String.format("%-" + 10 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 25 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 25 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 25 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 25 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 50 + "s", cadena));
                }
                salto += tamañoRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (ClienteDao:Delite)");
            ex.printStackTrace();

        }
    }

    @Override
    public List<Cliente> findAllClientes() {
        List<Cliente> clienteLista = new ArrayList<>();
        int salto = 0;
        int registro = 128;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);

                Cliente cliente = new Cliente(archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim());

                clienteLista.add(cliente);

                salto += registro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (ClienteDao:FindAll)");
            ex.printStackTrace();
        }
        return clienteLista;
    }

}
