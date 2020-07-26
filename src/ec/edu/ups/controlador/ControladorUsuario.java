package ec.edu.ups.controlador;

import ec.edu.ups.DAO.UsuarioDAO;
import ec.edu.ups.IDAO.IUsuario;
import ec.edu.ups.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public class ControladorUsuario {

    private Usuario usuario;
    private IUsuario usuarioDAO;

    public ControladorUsuario() {
    }

    public ControladorUsuario(UsuarioDAO usuarioDAO) {

        this.usuarioDAO = usuarioDAO;
    }

    public void registrarUsuario(String cedula, String nombre, String apellido, String correo, String contrasena) {

        usuario = new Usuario(cedula, nombre, apellido, correo, contrasena);
        usuarioDAO.create(usuario);

    }

    public Usuario buscarUsuario(String cedula) {

        usuario = usuarioDAO.read(cedula);

        return usuario;

    }

    public Usuario devolverUsuario() {

        return usuario;

    }

    public boolean validarUsuario(String correo, String contrasena) {

        usuario = usuarioDAO.login(correo, contrasena);
        if (usuario != null) {

            return true;

        } else {

            return false;

        }

    }

    public boolean actualizarUsuario(Usuario usuario) {
        boolean cent = usuarioDAO.update(usuario);
        return cent;

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

        List<Usuario> lista = new ArrayList<Usuario>();
        lista = usuarioDAO.findAll();
        return lista;
        
        

    }

}
