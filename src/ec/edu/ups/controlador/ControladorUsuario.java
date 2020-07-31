package ec.edu.ups.controlador;

import ec.edu.ups.DAO.UsuarioDAO;
import ec.edu.ups.IDAO.IUsuario;
import ec.edu.ups.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Cabrera
 * @author Denys Dutan
 * @author John Fárez
 * @author Sebastian Uyaguari
 */

/**
 * Clase Controlador Usuario.
 * 
 * Esta clase realiza como intermediario entre la vista, el modelo y el dao
 * para manejar la informacion ingresada.
 * 
 */
public class ControladorUsuario {

    
    
    private Usuario usuario;
    private IUsuario usuarioDAO;

    /**
     * constructor ControladorUsuario
     * 
     * controlador vacio.
     * 
     */
    
    public ControladorUsuario() {
    }

    
    /**
     * Controlador Usuario.
     * 
     * Controlador en el cual le pasamos al UsuarioDAO como parametro.
     * 
     * 
     * @param usuarioDAO 
     */
    public ControladorUsuario(UsuarioDAO usuarioDAO) {

        this.usuarioDAO = usuarioDAO;
        
    }

    
    /**
     * Metodo Registrar usuario.
     * 
     * Pasamos como parametro los datos del usuario,y llamamos los metodos del usaurioDAO
     * y creamos al usuario.
     *
     * 
     * 
     * @param cedula
     * @param nombre
     * @param apellido
     * @param correo
     * @param contrasena 
     */
    public void registrarUsuario(String cedula, String nombre, String apellido, String correo, String contrasena) {

        usuario = new Usuario(cedula, nombre, apellido, correo, contrasena);
        usuarioDAO.create(usuario);

    }

    
    /**
     * Metodo buscar Usuario.
     * 
     * En este metodo mandamos a buscar por el numero de cedula y si lo encuentra 
     * nos retorna al usuario.
     * 
     * 
     * @param cedula
     * @return 
     */
    public Usuario buscarUsuario(String cedula) {

        usuario = usuarioDAO.read(cedula);

        return usuario;

    }
    
    /**
     * Metodo devolver Usuario.
     * 
     * Este metodo nos sirve para retornar al usuario en este caso le estamos usando
     * para los datos de l tabla de entrada en la interfaz.
     * 
     * 
     * @return 
     */

    public Usuario devolverUsuario() {

        return usuario;

    }

    
    /**
     *metodo validar Usuario.
     * 
     * Este metodo es el encargado de que cuando el usuario inicie sesion vea si 
     * que los datos que ingreso sean correctos.
     * 
     * 
     * @param correo
     * @param contrasena
     * @return 
     */
    public boolean validarUsuario(String correo, String contrasena) {

        usuario = usuarioDAO.login(correo, contrasena);
        if (usuario != null) {

            return true;

        } else {

            return false;

        }

    }

    
    /**
     * Metodo actualizar usuario.
     * 
     * Se encarga de actualizar los datos del usuario.
     * 
     * 
     * @param usuario
     * @return 
     */
    
    public boolean actualizarUsuario(Usuario usuario) {
        
        //este usuario le mandamos al dao
        boolean cent = usuarioDAO.update(usuario);
        return cent;

    }

    /**
     * Metodo eliminar Usuario.
     * 
     * Es el encargado de eliminar un usuario
     * 
     * Le pasamos como parametro la cedula, y mandamos a buscar si el usuario 
     * existe con el metodo delete lo eliminamos.
     * 
     * 
     * @param cedula
     * @return 
     */
    
    public boolean eliminarUsuario(String cedula) {

        usuario = usuarioDAO.read(cedula);

        if (usuario != null) {
            usuarioDAO.delete(usuario);

            return true;

        } else {

            return false;
        }

    }

    /**
     * metodo listar Usuario.
     * 
     * Este metodo es el encargado de listar todos los usuario creados, le instanciamos
     * un ArrayList y mandamos a llamamos al metodo del usuarioDAO findAll.
     * 
     * 
     * @return 
     */
    
    public List<Usuario> listarUsuario() {
        
        List<Usuario> lista = usuarioDAO.findAll();
        return lista;
        
        

    }

}
