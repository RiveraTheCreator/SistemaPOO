
package Proyecto;

public class Tesorero extends Proveedor {
    private String tipoDeProducto;
    
    public Tesorero(){
        
    }
    public Tesorero(String nombre, String telefono, String correo, String CalleYNum, String colonia, String ciudad, String pais, String cp, String tipoP){
        super(nombre,telefono,correo,CalleYNum,colonia,ciudad,pais,cp);
        tipoDeProducto = tipoP;
    }
    public Tesorero(Tesorero unProR){
        super(unProR);
        tipoDeProducto = unProR.tipoDeProducto;
    }
    
    @Override
    public void destruir(){
        if(tipoDeProducto!= null){
            super.destruir();
            System.gc();
        }
    }
    
    public double surtirDeRecursos(){
        System.out.println("Mandando recurso economico");
        return 1000000.00;
    }
    
    
    @Override
    public String toString() {
        return super.toString() + "\n" + 
               "Tipo de producto: " + tipoDeProducto + "\n"; 
    }
}
