/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Objects;

/**
 * Clase Cliente.
 * 
 * Esta clase es la que contiene la representacion de los datos que necesita 
 * el sistema para su funcionamiento, hereda los metodos y atributos de la
 * clase perssona.
 * 
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class Cliente extends Persona {

    //Atributos de la clase
    private String nombreDelLocal;
    private String telefono;
    private String direccion;

    /**
     * Metodo Cliente.
     * 
     * Metodo constructor vacio.
     */
    public Cliente() {
    }

    /**
     * Metodo Cliente.
     * 
     * Metodo constructor que recibe y guarda la informacion a los atributos propios
     * de esta clase.
     * 
     * @param nombreDelLocal String 
     * @param telefono String
     * @param direccion String
     */
    public Cliente(String nombreDelLocal, String telefono, String direccion) {
        this.setNombreDelLocal(nombreDelLocal);
        this.setTelefono(telefono);
        this.setDireccion(direccion);
    }

    /**
     * Metodo Cliente.
     * 
     * Metodo constructor que recibe y guarda la informacion a los atributos propios
     * y tambien a los atributos heredados de la clase Padre.
     * 
     * @param nombreDelLocal String
     * @param telefono String
     * @param direccion String
     * @param cedula String
     * @param nombre String
     * @param apellido String
     */
    public Cliente(String nombreDelLocal, String telefono, String direccion, String cedula, String nombre, String apellido) {
        super(cedula, nombre, apellido);
        this.setNombreDelLocal(nombreDelLocal);
        this.setTelefono(telefono);
        this.setDireccion(direccion);
    }

    //Metodos Setter y Getter
    public String getNombreDelLocal() {
        return nombreDelLocal;
    }

    public void setNombreDelLocal(String nombreDelLocal) {
        this.nombreDelLocal = validarEspacios(nombreDelLocal, 25);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = validarEspacios(telefono, 25);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = validarEspacios(direccion, 50);
    }

    /**
     * Metodo ValidarEspacios.
     * 
     * Metodo en el cual se llena con espacios o  se recorta a una cierta cantidad
     * de caracteres con el fin de guardar la informacion con el tamaño exacto para 
     * ser guardados correctamente en el archivo binario y completar el numero de 
     * bytes asignados.
     * 
     * @param cadena String
     * @param numero Integer
     * @return cadena 
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
        hash = 89 * hash + Objects.hashCode(this.nombreDelLocal);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.nombreDelLocal, other.nombreDelLocal)) {
            return false;
        }
        return true;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Cliente{" + "nombreDelLocal=" + nombreDelLocal + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }

}
