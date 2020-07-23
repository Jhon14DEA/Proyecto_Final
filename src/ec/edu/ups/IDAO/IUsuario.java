/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.IDAO;

import ec.edu.ups.modelo.Usuario;
import java.util.List;

/**
 *
 * @author JHON FAREZ
 */
public interface IUsuario {
    
  //Metodos CRUD
    public void create(Usuario usuario);
    public Usuario read(String cedula);
    public void update(Usuario usuario);
    public void delete(Usuario usuario);   
    public List<Usuario> findAll();
    public Usuario login(String correo, String contraseña);
    
}
