/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Objects;

/**
 * Metodo Producto
 * EL metodo  produto nos ayudara a inicializar los atributos dentro del constructor 
 * con todos los atributos de a clase resiviendo como parametros el codigo, nombreProducto,el precio 
 * y la cantidad,  ademas de rcibir guarda la informacion alos atributos propios de esta clase
 * 
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class Producto {

    private String codigo;
    private String nombreDeProducto;
    private double precioDeProdcuto;
    private int cantidad;
    private Bodega bodega;

    public Producto() {
    }

    public Producto(String codigo, String nombreDeProducto, double precioDeProdcuto, int cantidad) {
        this.codigo = codigo;
        this.nombreDeProducto = nombreDeProducto;
        this.precioDeProdcuto = precioDeProdcuto;
        this.cantidad = cantidad;
    }

    /**
     * Metodos  gettrs y setters.
     * 
     * Metodos sirven para establecer y nostrar informacion para poder ser invocados 
     * desde cualquier otra clase donde sea instanciado la clase Producto.
     * 
     * @return getters y setters.
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreDeProducto() {
        return nombreDeProducto;
    }

    public void setNombreDeProducto(String nombreDeProducto) {
        this.nombreDeProducto = nombreDeProducto;
    }

    public double getPrecioDeProdcuto() {
        return precioDeProdcuto;
    }

    public void setPrecioDeProdcuto(double precioDeProdcuto) {
        this.precioDeProdcuto = precioDeProdcuto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    /**
     * Metodo hashCode.
     * 
     * El metodo hash code nos sirve para  generar codigos dentro  de la clase para poder ser establecidos 
     * como codigos unicos.
     * 
     * @return hashcode.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    /**
     * Metodo equals.
     * 
     * Ese metodo se encargara de buscar dentro de la clase el codigo generado en caso de que 
     * exista una implementacion para poder ser buscada y comparada, en caso de comparar 
     * dentro de la clase nos  devolvera un true en el caso de econtrarla y false en caso de 
     * que no se encuentre el codigo establacido.
     * 
     * @param obj.
     * @return true o false.
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    /**
     * Metodo toString.
     * 
     * Nos imprimira los datos de la clase  de forma ordenada.
     * 
     * @return String.
     */
    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombreDeProducto=" + nombreDeProducto + ", precioDeProdcuto=" + precioDeProdcuto + '}';
    }

}
