/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Objects;

/**
 *
 * @author Dutan2000
 */
public class Cliente extends Persona{
    
    private String nombreDelLocal;
    private String telefono;
    private String direccion;

    public Cliente() {
    }

    public Cliente(String nombreDelLocal, String telefono, String direccion) {
        this.nombreDelLocal = nombreDelLocal;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente(String nombreDelLocal, String telefono, String direccion, String cedula, String nombre, String apellido) {
        super(cedula, nombre, apellido);
        this.nombreDelLocal = nombreDelLocal;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombreDelLocal() {
        return nombreDelLocal;
    }

    public void setNombreDelLocal(String nombreDelLocal) {
        this.nombreDelLocal = nombreDelLocal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

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

    @Override
    public String toString() {
        return "Cliente{" + "nombreDelLocal=" + nombreDelLocal + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }
    
    
}
