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
 *
 * @author JHON FAREZ
 */
public class UsuarioDAO implements IUsuario {

    private RandomAccessFile archivo;

    /**
     * String cedula  = 10 caracteres
     * String nombre = 25 caracteres
     * String apellido = 25 caracteres
     * String Correo = 50 caracteres 
     * String contrasena = 8 caracteres
     * 
     * int registro = 128 bytes
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

    @Override
    public Usuario read(String cedula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
