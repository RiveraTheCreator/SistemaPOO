/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    /*
    Una vez siendo el registro procede a realizar las compras ver primero el catalogo de 
    productos que desea o quiere comprar para una vez seleccionarlo y enviarlo al carrito
    */
package TipoUsuario;

import java.util.Objects;
import Registro.RegistroUsuario;
/**
 *
 * @author McCarthy
 */
public class Cliente extends RegistroUsuario {
    private String IDCliente;
    
    public Cliente() {
        this( "", "", "");
    }
    public Cliente(String nombreCompleto, String direccion, String idCliente) {
        super(nombreCompleto, direccion); // manda a llamar al constructor de object
        this.IDCliente = idCliente;
    }
    public Cliente(Cliente usuario) {
        super(usuario);
        this.IDCliente = usuario.IDCliente;        
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.IDCliente);
        return hash;
    }
    
    @Override
    public boolean equals(Object objeto) {
        if(objeto==null) {
            return false;
            }
        if(!(objeto instanceof Cliente)) {
            return false;
            }
        Cliente Temporal = (Cliente)objeto;
        return super.equals(objeto) && IDCliente.equals(Temporal.IDCliente);
    }
    
    
    
    
    @Override
    public String toString() {
        return super.toString() + "IDCliente: " + this.IDCliente + "\n";
    }
    public void setCliente(String nombreCompleto, String direccion, String idCliente ) {
        setRegistroUsuario(NombreCompleto, direccion); // llama el metodo heredado del padre (herencia)
        this.IDCliente = idCliente;
    }
    public String getCliente() {
        return getRegistroUsuario() + "\n" + this.IDCliente;
    }
    
    public void Seleccion(){
        Registrando();
        System.out.println("Seleccionando un producto para comprar..." + "\n");
    }

    private void setRegistroUsuario(String NombreCompleto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
