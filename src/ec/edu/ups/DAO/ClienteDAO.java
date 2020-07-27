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
 * Clase ClienteDAO.
 * 
 * Esta clase tiene el proposito de realizar el manejo de informacion en el archivo
 * binario, en el cual se sobrescribe los metodos de la clase interfaz ICliente.
 * 
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class ClienteDAO implements ICliente {

    //Metodos de la clase
    private RandomAccessFile archivo;
    private int tamañoRegistro;

    /**
     * Estructura del archivo.
     *
     * private String cedula = 10 bytes private 
     * String nombre = 25 bytes 
     * private String apellido = 25 bytes 
     * private String nombreDelLocal 25 bytes 
     * private String telefono = 25 bytes 
     * private String direccion = 50 bytes
     *
     * Total bytes registro = 172 bytes
     */
    
    /**
     * Metodo ClienteDAO.
     * 
     * Metodo constructor en el cual se instancia el RandomAccessFile para leer o 
     * escribir informacion en un archivo.
     * 
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

    /**
     * Metodo Create.
     * 
     * Metodo sobrescrio de la clase ICliente con el fin de escribir o ingresar
     * la informacion recibida como parametro en el archivo binario.
     * 
     * @param cliente Cliente
     */
    @Override
    public void create(Cliente cliente) {
        try {
            archivo.seek(archivo.length());
            archivo.writeUTF(cliente.getCedula());
            archivo.writeUTF(cliente.getNombre());
            archivo.writeUTF(cliente.getApellido());
            archivo.writeUTF(cliente.getNombreDelLocal());
            archivo.writeUTF(cliente.getTelefono());
            archivo.writeUTF(cliente.getDireccion());

        } catch (IOException ex) {

            System.out.println("Error lectrura escritura (ClienteDAO:Create)");
            ex.printStackTrace();

        }
    }
    
    /**
     * Metodo Read.
     * 
     * Metodo sobrescrito de la clase ICliente donde se busca y retorna la 
     * informacion que este ligada a la id, comparando los datos guardados en el 
     * archivo con el parametro recibido.
     * 
     * @param nombreDelLocal String
     * @return Cliente:cliente
     */
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

    /**
     * Metodo Update.
     * 
     * Metodo sobrescrito de la clase ICliente, recibe un parametro de tipo
     * cliente, donde comparamos el id del parametro con los id recuperados
     * del archivo para poder acualizar la informacion que este ligada al id
     * del cliente.
     * 
     * @param cliente Cliente
     */
    @Override
    public void update(Cliente cliente) {
        int salto = 0;
        try {

            while (salto < archivo.length()) {
                archivo.seek(salto);
                String cedulaArchivo = archivo.readUTF();
                if (cedulaArchivo.equals(cliente.getCedula())) {
                    archivo.seek(salto);
                    archivo.writeUTF(cliente.getCedula());
                    archivo.writeUTF(cliente.getNombre());
                    archivo.writeUTF(cliente.getApellido());
                    archivo.writeUTF(cliente.getNombreDelLocal());
                    archivo.writeUTF(cliente.getTelefono());
                    archivo.writeUTF(cliente.getDireccion());
                }
                salto += tamañoRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (ClienteDao:Update)");
            ex.printStackTrace();
        }
    }
    
    /**
     * Metodo Delete.
     * 
     * Metodo sobrescrito de la clase ICliente, busca la informacion que este 
     * ligada al id para despues remplazar con espacios vacios realizando una 
     * eliminacion logica.
     * 
     * @param codigo String
     */
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

    /**
     * Metodo findAllClientes.
     * 
     * Metodo sobrescrito de la clase ICLiente, recupera toda la informacion guardada
     * en el archivo para guardar en una lista para ser retornada.
     * @return List:clienteLista
     */
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
