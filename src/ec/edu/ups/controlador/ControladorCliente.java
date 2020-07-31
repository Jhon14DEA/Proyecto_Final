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
     * Recibe un atributo tipo string para enviar al cliienteDao y luego compara
     * la informacion retornada desde el dao, si es diferente de null, retorna al
     * cliente y si es igual a null, retorna null.
     * @param cedula.
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
    
    /**
     * Metodo actualizarCliente.
     * 
     * Este metodo realiza como inetermediario entre la vista y dao, tecibe como
     * paametro un cliente y este el envia al Dao para que sea modificado en el 
     * archivo.
     * @param cliente.
     * @return Boolean:cent
     */
    public boolean actualizarCliente(Cliente cliente){
        
        boolean cent = clienteDao.update(cliente);
        return cent;
        
    }
    
    /**
     * Metodo eliminarCliente.
     * 
     * Recibe como parametro un String y le envi al dao para buscar el cliente y
     * el cliente retornado se vuelve a enviar al dao para que se elimine del 
     * archivo.
     * @param cedula.
     * @return tipo de dato boolean
     */
    public boolean eliminarCliente(String cedula){
        
        cliente = clienteDao.read(cedula);
        if(cliente!=null){
            clienteDao.delete(cliente);
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Metodo listarClientes.
     * 
     * Recibe desde el dao informacion que es guardada en una variable tipo
     * Lista y esta misma es retornada a la vista para ser listada.
     * @return List:lista
     */
    public List<Cliente> listarClientes(){
        
        List<Cliente> lista = clienteDao.findAllClientes();
        return lista;
        
    }
    
    
    
}
