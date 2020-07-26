package ec.edu.ups.controlador;

import ec.edu.ups.DAO.UsuarioDAO;
import ec.edu.ups.IDAO.IUsuario;
import ec.edu.ups.modelo.Usuario;
import java.util.List;

/**
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class ControladorUsuario {

    private Usuario usuario;
    private IUsuario usuarioDAO;

    public ControladorUsuario() {
    }

    public ControladorUsuario(Usuario usuario, UsuarioDAO usuarioDAO) {
        this.usuario = usuario;
        this.usuarioDAO = usuarioDAO;
    }

      public void registrarUsuario(String cedula, String nombre, String apellido, String correo, String contrasena) {

        usuario = new Usuario(cedula, nombre, apellido, correo, contrasena);
        usuarioDAO.create(usuario);

    }

    public Usuario buscarUsuario(String cedula) {

         usuario = usuarioDAO.read(cedula);
        
        if(usuario != null){
            return usuario;
        }else{
            return null;
        }   

    }

    public boolean validarUsuario(String correo, String contrasena) {

        usuario = usuarioDAO.login(correo, contrasena);
        if (usuario != null) {

            return true;

        } else {

            return false;

        }

    }

    public void actualizarUsuario(String cedula) {

        usuario = usuarioDAO.read(cedula);

        if (usuario != null) {
            usuarioDAO.update(usuario);
        }
    }

    public boolean eliminarUsuario(String cedula) {

        usuario = usuarioDAO.read(cedula);

        if (usuario != null) {
            usuarioDAO.delete(usuario);

            return true;

        } else {

            return false;
        }

    }

    public List<Usuario> listarUsuario() {

        List<Usuario> lista = usuarioDAO.findAll();
        return lista;

    }

}
