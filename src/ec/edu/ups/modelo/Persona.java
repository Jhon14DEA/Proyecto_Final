/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Objects;

/**
 * Clase Persona.
 * 
 * Esta clase es la que contiene la representacion de los datos que necesita 
 * el sistema para su funcionamiento, es la clase padre de las clases: Cliente,
 * Usuario.
 * 
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class Persona {

    //Atributos de la clase
    private String cedula;
    private String nombre;
    private String apellido;

    /**
     * Metod Persona.
     * 
     * Metodo constructor vacio.
     * 
     */
    public Persona() {
    }

    /**
     * Metodo Persona.
     * 
     * Metodo constructor que recibe y guarda la informacion a los atributos propios
     * de esta clase.
     * 
     * @param cedula String
     * @param nombre String
     * @param apellido String
     */
    public Persona(String cedula, String nombre, String apellido) {
        this.setCedula(cedula);
        this.setNombre(nombre);
        this.setApellido(apellido);
    }

    //Metodos Getter y Setter
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = validarEspacios(cedula, 10);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = validarEspacios(nombre, 25);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = validarEspacios(apellido, 25);
    }

    /**
     * Metodo validarEspacios.
     * 
     * Metodo en el cual se llena con espacios o  se recorta a una cierta cantidad
     * de caracteres con el fin de guardar la informacion con el tamaño exacto para 
     * ser guardados correctamente en el archivo binario y completar el numero de 
     * bytes asignados.
     * 
     * @param cadena String
     * @param numero String
     * @return String: cadena
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

    //Metodos equals y hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.cedula);
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
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Persona{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }

}
