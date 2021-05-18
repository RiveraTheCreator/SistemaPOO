/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    /*
    El tipo de usuario se verá reflejado por el cliente con el mismo ID solo
    lo que lo diferencia de un cliente normal son sus productos, la cantidad que compra
    */
package TipoUsuario;

import java.util.Objects;

/**
 *
 * @author McCarthy
 */
public class ClienteFrecuente extends Cliente{
    private int CantidadCompra;
    
    public ClienteFrecuente() {
        this( "", "", "", 0);
    }
    public ClienteFrecuente(String nombreCompleto, String direccion, String idCliente,
            int cantidadCompra) {
        super(); // manda a llamar al constructor de object
        this.CantidadCompra = cantidadCompra;
    }
    public ClienteFrecuente(ClienteFrecuente usuario) {
        super(usuario);
        this.CantidadCompra = usuario.CantidadCompra;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.CantidadCompra);
        return hash;
    }
    
    @Override
    public boolean equals(Object objeto) {
        if(objeto==null) {
            return false;
            }
        if(!(objeto instanceof ClienteFrecuente)) {
            return false;
            }
        ClienteFrecuente Temporal = (ClienteFrecuente)objeto;
        return super.equals(objeto) && CantidadCompra==Temporal.CantidadCompra;
    }
    
    
    
    @Override
    public String toString() {
        return super.toString() + "Cantidad de Compra:   " + this.CantidadCompra + "\n";
    }
    public void setClienteFrecuente(String nombreCompleto, String direccion, 
            String idCliente, int cantidadCompra) {
        // llama el metodo heredado del padre (herencia)
        setCliente(nombreCompleto, direccion, idCliente); 
        this.CantidadCompra = cantidadCompra;
    }
    public String getClienteFrecuente() {
        return getCliente() + "\n" + this.CantidadCompra;
    }
}
