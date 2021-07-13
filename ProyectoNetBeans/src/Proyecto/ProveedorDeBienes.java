
package Proyecto;

import java.util.LinkedList;
    
/**
 *
 * Victor Hugo de la Cruz del Angel
 */
public class ProveedorDeBienes extends  Proveedor{
    private String tipoDeProducto;
    private static int[] productos;
    private static double [] precios;
    
    public ProveedorDeBienes(){
        
    }
    public ProveedorDeBienes(String nombre, String telefono, String correo, 
           String calleYnum, String colonia, String ciudad, String pais,
           String cp, String tipoProducto, int[] productos){
        super(nombre,telefono,correo,calleYnum,colonia,ciudad,pais,cp);
        this.tipoDeProducto = tipoProducto;
        ProveedorDeBienes.productos = productos;
    }
    public ProveedorDeBienes(ProveedorDeBienes unProveedorBienes){
        super(unProveedorBienes);
        tipoDeProducto = unProveedorBienes.tipoDeProducto;
        ProveedorDeBienes.productos = unProveedorBienes.productos;
    }
    
    @Override
    public void destruir(){
        if(tipoDeProducto!= null){
            tipoDeProducto = null;
            System.gc();
        }
    }
    
    public void determinarPrecio(){
        int numero = productos.length;
        int j;
        precios = new double [numero];
        try{
            for( j=0;j<numero;j++ ){
                if(productos[j] ==0){precios[j] = 1500;}
                else if(productos[j] ==1){precios[j] = 200;}
                else if(productos[j] ==2){precios[j] = 800;}
                else if(productos[j] ==3){precios[j] = 700;}
                else if(productos[j] ==4){precios[j] = 500;}
                else if(productos[j] ==5){precios[j] = 900;}
                else if(productos[j] ==6){precios[j] = 1700;}
                else if(productos[j] ==7){precios[j] = 1350;}
                else if(productos[j] ==8){precios[j] = 5000;}
                else if(productos[j] ==9){precios[j] = 15000;}
            }
        }catch(NullPointerException e){
            System.out.println("ERROR");
        }
        
        
    }
    
    public double precioTotal(){
        int numero= precios.length;
        double precioFin = 0;
        int a = 0;
        try{
            for(a = 0; a<numero ;a++)
                precioFin = precioFin + precios[a];
        }catch(NullPointerException e){
            System.out.println("ERROR :(");
            precios = null;
        }
        return precioFin;
    }
    
    public void almacenarProductos(){
        String path = "\\Users\\McCarthy\\Documents\\POO\\Editar Proy\\Proyecto\\src\\Proyecto";
        String archivoP = path + "productos.obj";
        FlujoLinkedListOutputStream flujoSalida= new FlujoLinkedListOutputStream(archivoP);
        System.out.println("Almacenando productos...\n ");
        LinkedList<Object> producto = new LinkedList<>();
         for (int unosProductos : productos) {
             producto.add(unosProductos);
        }
        flujoSalida.escribirObjetos(producto);
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n" + 
               "Tipo de producto: " + tipoDeProducto + "\n"; 
    }
   
}
