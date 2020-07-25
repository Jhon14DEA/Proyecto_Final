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
public class UsuarioDAO implements IUsuario {

    private RandomAccessFile archivo;

    /**
     * String cedula = 10 caracteres String nombre = 25 caracteres String
     * apellido = 25 caracteres String Correo = 50 caracteres String contrasena
     * = 8 caracteres
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

        int salto = 0;
        int registro = 128;
        try {
            while (salto < archivo.length()) {

                archivo.seek(salto);
                String cedulaArchivo = archivo.readUTF();

                if (cedula.equals(cedulaArchivo.trim())) {
                    Usuario usuario = new Usuario(cedulaArchivo, archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim());
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

    @Override
    public void delete(Usuario usuario) {

        int salto = 0;
        int registro = 128;

        try {

            while (salto < archivo.length()) {
                archivo.seek(salto);
                String cedula = archivo.readUTF();
                if (cedula.equals(usuario.getCedula())) {

                    archivo.seek(salto);

                    archivo.writeUTF(String.format("%-" + 10 + "s"));
                    archivo.writeUTF(String.format("%-" + 25 + "s"));
                    archivo.writeUTF(String.format("%-" + 25 + "s"));
                    archivo.writeUTF(String.format("%-" + 50 + "s"));
                    archivo.writeUTF(String.format("%-" + 8 + "s"));
                }

                salto += registro;

            }
        } catch (IOException ex) {

            System.out.println("Error de lectura y escritura");
            ex.printStackTrace();

        }
    }

    @Override
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
