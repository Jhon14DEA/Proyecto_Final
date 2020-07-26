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
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class ControladorCliente {
    
    private Cliente cliente;
    private ICliente clienteDao;

    public ControladorCliente() {
    }

    public ControladorCliente(Cliente cliente, ClienteDAO clienteDao) {
        this.cliente = cliente;
        this.clienteDao = clienteDao;
    }
    
    public void crearCliente(String nombreLocal, String telefono, String direccion, String cedula, String nombre, String apellido){
        
        cliente = new Cliente(nombreLocal, telefono, direccion, cedula, nombre, apellido);
        
        clienteDao.create(cliente);
        
    }
    
    public Cliente buscarCliente(String nombreLocal){
        
        cliente = clienteDao.read(nombreLocal);
        
        if(cliente != null){
            return cliente;
        }else{
            return null;
        }
    }
    
    public void actualizarCliente(String nombreLocal){
        
        cliente = clienteDao.read(nombreLocal);
        
        if(cliente!=null){
            clienteDao.update(cliente);
        }
    }
    
    public void eliminarCliente(String nombreLocal){
        
        clienteDao.delete(nombreLocal);
        
    }
    
    public List<Cliente> listarClientes(){
        
        List<Cliente> lista = clienteDao.findAllClientes();
        return lista;
        
    }
    
    
    
}
