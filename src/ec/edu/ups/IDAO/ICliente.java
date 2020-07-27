/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.IDAO;

import ec.edu.ups.modelo.Cliente;
import java.util.List;

/**
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public interface ICliente {

    public void create(Cliente cliente);

    public Cliente read(String codigo);

    public boolean update(Cliente cliente);

    public boolean delete(String codigo);

    public List<Cliente> findAllClientes();
}
