/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.io.Serializable;
/**
 *
 *@author Victor Hugo de la Cruz del Angel
 */

public class Telefono implements Serializable {
    static final long serialVersionUID = 1L;
    private String telefono;
    private String email;
    
    public Telefono(){
        this("00+0000000000", "");
    }
    public Telefono(String telefono, String email){
        this.telefono = telefono;
        this.email = email;
    }
    public Telefono(Telefono otroTelefono){
        this(otroTelefono.telefono, otroTelefono.email);
    }
    public void destruir(){
        if(telefono != null && email != null){
            telefono = null;
            email = null;
            System.gc();
        }
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public String getCorreo(){
        return email;
    }
    
    public void setCorreo(String correo){
        this.email = correo;
    }
    
    @Override
    public String toString(){
        return "Telefono:  " + telefono + "\n"+
                "Correo:  " + email + "\n";
    }
}
