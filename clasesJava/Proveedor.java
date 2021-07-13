/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Proyecto;

public class Proveedor extends Domicilio{
    private String nombre;
//    private Telefono telefono;
    private Domicilio direccion;
    
    public Proveedor(){
        this("","","","","","","","");
    }
    
    public Proveedor(String nombre, String telefono, String email,
                     String calleYnum, String colonia, String ciudad,
                     String pais, String CP){
   
        //this.telefono = new Telefono(telefono,email);
        this.direccion = new Domicilio(calleYnum, colonia, ciudad, pais, CP);
        this.nombre = nombre;
    }
    
    public Proveedor(Proveedor unProveedor){
        nombre = unProveedor.nombre;
    //    telefono = unProveedor.telefono;
        direccion = unProveedor.direccion;
    }
    
    
    @Override
    public void destruir(){
        if(nombre!= null){
            //if(telefono != null){
                if(direccion != null){
                    nombre = null;
                    //telefono = null;
                    direccion = null;
                    System.gc();
                }
            }
        }
    //}
    
    public void proveer(){
        System.out.println("Se esta abasteciendo la Tienda...");
    }
    
    
    
    @Override 
    public String toString(){
        return "Nombre: " + nombre + "\n" +
               "Direccion:\n" + direccion + "\n";
    }
}
