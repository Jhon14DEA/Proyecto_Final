/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.DAO;

import ec.edu.ups.IDAO.IUsuario;
import ec.edu.ups.modelo.Usuario;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 *
 */
/**
 * Clase UsuarioDao
 *
 * Accedemos los datos del MVC,
 *
 *
 */
public class UsuarioDAO implements IUsuario {

    private RandomAccessFile archivo;

    /**
     * String cedula = 10 caracteres String nombre = 25 caracteres String
     * apellido = 25 caracteres String Correo = 50 caracteres String contrasena=
     * 8 caracteres
     *
     * int registro = 128 bytes
     *
     */
    /**
     * Metodo UsuarioDao.
     *
     * creamos un atributo llamado atributo y lo instanciamos con el metodo
     * RandomAccessFile este nos sirve para abrir una archivo como de lectura,
     * Se utiliza para lectura del archivo.
     *
     *
     */
    public UsuarioDAO() {

        try {
            archivo = new RandomAccessFile("datos/usuario.dat", "rw");
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura");
            ex.printStackTrace();
        }

    }

    /**
     * Metodo create
     *
     * Este metodo es el encargado de crear
     *
     * Le decimos que registre los datos del usuario y con el metodo seej que
     * coloque el puntero en la posicion del archivo y este empezara a leer o
     * escribir en dicha posicion y con el writeUTF le decimos que escriba texto
     * en el formato UTF - 8 precidiendo con la longitud del texto.
     *
     *
     * @param usuario
     */
    @Override
    public void create(Usuario usuario) {

        try {

            archivo.seek(archivo.length());
            archivo.writeUTF(usuario.getCedula());
            archivo.writeUTF(usuario.getNombre());
            archivo.writeUTF(usuario.getApellido());
            archivo.writeUTF(usuario.getCorreo());
            archivo.writeUTF(usuario.getContraseña());

        } catch (IOException ex) {

            System.out.println("Error de lectura y escritura");
            ex.printStackTrace();

        }

    }

    /**
     * Metodo read.
     *
     * Este metodo es el que se encarga de leer, como nuestro registro consta de
     * 128 bytes. le decimos que el salto va a ser de cero ya que nuesto cedula
     * seria el que esta primero. mientras nuestro salto sea menor a la longitud
     * de nuestro archivo nuestro puntero se va y le decimos con readUTF lee el
     * numero de bytes.
     *
     *
     * @param cedula
     * @return
     */
    @Override
    public Usuario read(String cedula) {

        int salto = 0;
        int registro = 128;
        try {
            while (salto < archivo.length()) {

                archivo.seek(salto);
                String cedulaArchivo = archivo.readUTF();

                if (cedula.equals(cedulaArchivo.trim())) {
                    Usuario usuario = new Usuario(cedulaArchivo, archivo.readUTF().trim(),
                            archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim());
                    return usuario;
                }

                salto += registro;

            }
            return null;
        } catch (IOException ex) {
            System.out.println("Error lectura escritura (UsuarioDao:Read)");
            ex.printStackTrace();
        }
        return null;

    }

    /**
     * Metodo update.
     *
     * Encargado de actualizar los datos del usuario,Si la cedula es igual a la
     * cedula del usuario le decimos que va a saltar 12 bytes debido a que no
     * podemos cambiar los datos de la cedula y le damos los nuevos datos al
     * usuario.
     *
     * @param usuario
     * @return
     */
    @Override
    public boolean update(Usuario usuario) {

        int salto = 0;
        int registro = 128;
        try {

            while (salto < archivo.length()) {
                archivo.seek(salto);
                String cedula = archivo.readUTF();
                if (cedula.equals(usuario.getCedula())) {
                    archivo.seek(salto + 12);
                    archivo.writeUTF(usuario.getNombre());
                    archivo.writeUTF(usuario.getApellido());
                    archivo.writeUTF(usuario.getCorreo());
                    archivo.writeUTF(usuario.getContraseña());
                    return true;
                }
                salto += registro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (UsuarioDao:Update)");
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * metodo delete.
     *
     * Encargado de eliminar un usuario, en este caso como estamos haciendo con
     * archivos binarios no le podemos eliminar lo que hariamos es
     * sobreescribirle de espacios.
     *
     * @param usuario
     */
    @Override
    public void delete(Usuario usuario) {

        String cadena = "";
        int salto = 0;
        int registro = 128;

        try {

            while (salto < archivo.length()) {
                archivo.seek(salto);
                String cedula = archivo.readUTF();
                if (cedula.equals(usuario.getCedula())) {

                    archivo.seek(salto);

                    archivo.writeUTF(String.format("%-" + 10 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 25 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 25 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 50 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 8 + "s", cadena));
                }

                salto += registro;

            }
        } catch (IOException ex) {

            System.out.println("Error de lectura y escritura");
            ex.printStackTrace();

        }
    }

    /**
     * Metodo listar Usuario.
     *
     * Con este metodo Listamos todos los usuarios que se hayan registrado y le
     * hacemos con el metodo readUTF leemos los bytes.
     *
     * @return
     */
    public List<Usuario> findAll() {

        List<Usuario> lista = new ArrayList<Usuario>();
        int salto = 0;
        int registro = 128;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String cedula = archivo.readUTF().trim();
                String nombre = archivo.readUTF().trim();
                String apellido = archivo.readUTF().trim();
                String correo = archivo.readUTF().trim();
                String contraseña = archivo.readUTF().trim();
                Usuario usuario = new Usuario(cedula, nombre, apellido, correo, contraseña);
                lista.add(usuario);

                salto += registro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (UsuarioDao:Update)");
            ex.printStackTrace();
        }
        return lista;

    }

    /**
     * Metodo login.
     *
     * Este metodo es el encargado del inicio de sesion del usuario.
     *
     *
     * @param correo
     * @param contraseña
     * @return
     */
    @Override
    public Usuario login(String correo, String contraseña) {

        int salto = 66;
        int registro = 128;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String correoArchivo = archivo.readUTF();
                String contraseñaArchivo = archivo.readUTF();

                if (correo.equals(correoArchivo.trim()) && contraseña.equals(contraseñaArchivo.trim())) {
                    salto = salto - 66;
                    archivo.seek(salto);
                    Usuario usuario = new Usuario(archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim(), correoArchivo, contraseñaArchivo);
                    return usuario;
                }
                salto += registro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (UsuarioDao:login)");
            ex.printStackTrace();
        }
        return null;

    }

}
