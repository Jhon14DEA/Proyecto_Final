/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.DAO.ClienteDAO;
import ec.edu.ups.IDAO.ICliente;
import ec.edu.ups.modelo.Cliente;
import java.util.List;

/**
 * Clase ControladorCliente.
 * 
 * Esta clase realiza como intermediario entre la vista, el modelo y el dao
 * para manejar la informacion ingresada.
 * 
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class ControladorCliente {
    
    //Atributos de la clase
    private Cliente cliente;
    private ICliente clienteDao;

    /**
     * Metodo ControladorCliente.
     * 
     * Metodo constructor vacio.
     */
    public ControladorCliente() {
    }

    /**
     * MetodoControladorCliente.
     * 
     * Metodo constructor en el cual se recibe como paramerto el clienteDao.
     * 
     * @param clienteDao: ClienteDAO
     */
    public ControladorCliente(ClienteDAO clienteDao) {
        this.clienteDao = clienteDao;
    }
    
    /**
     * Metodo crearCLiente.
     * 
     * Este metodo recibe la informacion mediante parametros para crear un nuevo
     * objeto tipo cliente y enviar al dao para registrar en el archivo.
     * 
     * @param nombreLocal String
     * @param telefono String
     * @param direccion String
     * @param cedula String
     * @param nombre String
     * @param apellido String
     */
    public void crearCliente(String cedula, String nombre, String apellido, String nombreLocal, String telefono, String direccion){
        
        cliente = new Cliente(cedula, nombre, apellido, nombreLocal, telefono, direccion);
        
        clienteDao.create(cliente);
        
    }
    
    /**
     * Metodo buscarCliente.
     * 
     * Recibe un atributo tipo string para enviar al 
     * @param nombreLocal String
     * @return Cliente:cliente
     */
    public Cliente buscarCliente(String cedula){
        
        cliente = clienteDao.read(cedula);
        
        if(cliente != null){
            return cliente;
        }else{
            return null;
        }
    }
    
    public boolean actualizarCliente(Cliente cliente){
        
        boolean cent = clienteDao.update(cliente);
        return cent;
        
    }
    
    public boolean eliminarCliente(String nombreLocal){
        
        boolean cent = clienteDao.delete(nombreLocal);
        return cent;
        
    }
    
    public List<Cliente> listarClientes(){
        
        List<Cliente> lista = clienteDao.findAllClientes();
        return lista;
        
    }
    
    
    
}
