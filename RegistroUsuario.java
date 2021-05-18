/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro;
import java.util.Objects;

/**
 *
 * @author McCarthy
 */
public class RegistroUsuario {
    public String NombreCompleto;
    public String Direccion;
//    private int Telefono;
//    private int Edad;
    
    
    public RegistroUsuario() {
        this( "", "");
    }
    public RegistroUsuario(String nombreCompleto, String direccion) {
        super(); // manda a llamar al constructor de object
        this.NombreCompleto = nombreCompleto;
        this.Direccion = direccion;
//        this.Telefono = telefono;
//        this.Edad = edad;
    }
    public RegistroUsuario(RegistroUsuario usuario) {
        super();
        this.NombreCompleto = usuario.NombreCompleto;
        this.Direccion = usuario.Direccion;
//        this(  );
//        this( usuario.Telefono);
//        this( usuario.Edad);
        
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = (79 * hash + Objects.hashCode(this.NombreCompleto)) + 
                (79 * hash + Objects.hashCode(this.Direccion));
        return hash;
    }
    
    @Override
    public boolean equals(Object objeto) {
        if(objeto==null) {
            return false;
            }
        if(!(objeto instanceof RegistroUsuario)) {
            return false;
            }
        RegistroUsuario humanoTemporal = (RegistroUsuario)objeto;
        return NombreCompleto.equals(humanoTemporal.NombreCompleto) && 
                Direccion.equals(humanoTemporal.Direccion);
    }
    
    
    
    @Override
    public String toString() {
        return "NombreCompleto: " + this.NombreCompleto + "\n" + 
                "Direccion:  " + this.Direccion + "\n";
    }

    // Estos dos metodos no son comportamiento
    public void setRegistroUsuario(String nombreCompleto, String direccion) {
        this.NombreCompleto = nombreCompleto;
        this.Direccion = direccion;
    }
    public String getRegistroUsuario() {
        return this.NombreCompleto + this.Direccion;
    }
    
    
    public void Registrando() {
        System.out.println( "Registrado ..." );
    }

}
