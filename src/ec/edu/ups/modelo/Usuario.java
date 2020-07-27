/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Objects;

/**
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
/**
 * Clase Usuario.
 *
 * Esta clase es la que tiene la representacion de los datos que necesita el
 * sistema para su funcionamiento.
 *
 */
public class Usuario extends Persona {

    //Atributos
    private String correo;
    private String contraseña;

    public Usuario() {
    }

    
    /**
     * Metodo Constructor.
     *
     * Inicializamos el objeto y contiene valores siempre validos.
     *
     * @param correo
     * @param contraseña
     * @param cedula
     * @param nombre
     * @param apellido
     */
    public Usuario(String cedula, String nombre, String apellido,String correo, String contraseña) {
        super(cedula, nombre, apellido);
        this.setCorreo(correo);
        this.setContraseña(contraseña);
    }

    
    /**
     * Metodo constructor.
     *
     * Inicializamos el objeto y contiene calores siempre validos.
     *
     * @param correo
     * @param contraseña
     */
    public Usuario(String correo, String contraseña) {
        this.setCorreo(correo);
        this.setContraseña(contraseña);
    }

    
    /**
     * Metodos getter y setter
     *
     * Su funcion es permitir el obtener el valor de una propiedad de la clase.
     *
     *
     * @return
     */
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {

        this.correo = validarEspacios(correo, 50);

    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {

        this.contraseña = validarEspacios(contraseña, 8);

    }

    /**
     * metodo Validar Espacios.
     * 
     * Este metodo nos permite decirle cuantos espacios le dejamos usar y si este 
     * le falta completar lo llenamos con espacios o si se ha pasado lo cortamos.
     * 
     * 
     * @param cadena
     * @param numero
     * @return 
     */
    
    public String validarEspacios(String cadena, int numero) {
        if (cadena.length() == numero) {
            return cadena;
        } else {
            if (cadena.length() > numero) {
                cadena = cadena.substring(0, numero);
                return cadena;
            } else {
                for (int i = cadena.length(); i < numero; i++) {
                    cadena += " ";
                }
                return cadena;
            }
        }
    }

    /**
     * Metodo HashCode y equals.
     * 
     * Si dos objetos son iguales deben tener el mismo valor hash.
     * 
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.correo);
        hash = 47 * hash + Objects.hashCode(this.contraseña);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.contraseña, other.contraseña)) {
            return false;
        }
        return true;
    }
    
    
    //metodo toString.

    @Override
    public String toString() {
        return "Usuario{" + "correo=" + correo + ", contrase\u00f1a=" + contraseña + '}';
    }

}
