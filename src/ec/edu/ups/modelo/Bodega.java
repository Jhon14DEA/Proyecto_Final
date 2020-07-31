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
public class Bodega {

    /**
     * Declaraciones que tiene  la clase bodega 
     * en este caso seran de accesibilidad privada los 2 atributos 
     */
    private String nombre;
    private String direccion;
    private String cuidad;
     
/**
 * Codificacion del constructor vacio
 */
    public Bodega() {
    }
/**
 * Declaracion de el constructor  Bodega que  es un
 * elemento de la clase Bodega cuyo identificador coincide con el de la clase bodega
 * y que tiene por objetivo obligar a y controlar cómo se inicializa una instancia de
 * una determinada clase, ya que el lenguaje Java no permite que las variables miembro 
 * de una nueva instancia queden sin inicializar.
 * @param nombre.
 * @param direccion.
 * @param cuidad. 
 */
    public Bodega(String nombre, String direccion, String cuidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuidad = cuidad;
    }
    
    /**
     *  A continuacion se crearan  los metodos get y set de la clase bodega 
     * Los métodos getter y setter se utilizan para definir una propiedad, 
     * a estos se accede como propiedades situadas fuera de la clase, aunque
     * las defina dentro de la clase como métodos.
     * @return nombre.
     */
 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * SIGNIFICADOS DE  GET Y SET
     * 
     * Setters: Del Inglés Set, que significa establecer, pues nos sirve para 
     * asignar un valor inicial a un atributo, pero de forma explícita,  y solo 
     * nos permite dar acceso público a ciertos atributos que deseemos el usuario 
     * pueda modificar. Es decir permiten cambiar el valor de los atributos.
      *
      *Getters: Del Inglés Get, que significa obtener, pues nos sirve para obtener
      * (recuperar o acceder) el valor ya asignado a un atributo y utilizarlo para 
      * cierto método. Por lo que devuelven el valor de los atributos
     * @return direccion.
     */
   

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCuidad() {
        return cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }

    /**
     * Este metodo sobreescrito dentro de la clase telefonos se encarga de de  crear
     * un codigo unico de una bodega
     * @return hashcode
     */
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    /**
     * El metodo  equal busca dentro de la clase si existe el nombre de la bodega 
     * si consige su finalidad  tendremos como reultado un retorno de true y de no encontrarlo 
     * nos devolvera un false
     * @param obj.
     * @return obj
     */
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
        final Bodega other = (Bodega) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
/**
 * El metodo  to String nos sirve para imprimir los datos de la clase bodega 
 * pero en  en orden
 * @return String
 */
    @Override
    public String toString() {
        return "Bodega{" + "nombre=" + nombre + ", direccion=" + direccion + '}';
    }

}
