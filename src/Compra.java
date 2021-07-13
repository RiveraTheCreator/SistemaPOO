

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Compra {
    private static int [] productos;
    private double presupuesto;
    public Compra(double presupuesto){
        this.presupuesto = presupuesto;
    }
    
    public static void ingresarProductos(int numero){
        int ban=0, i=0;
        productos = new int[numero];
        int producto;
        for(i=0;i<numero;i++){
            System.out.println("Ingrese el codigo del producto:");
            producto = Integer.parseInt(leer());
               try{
                    productos[i] = producto;
               }catch(NullPointerException e){
                   System.out.println("ERROR NULLPOINTER EXCEPTION");
                   System.out.println(i);
                   System.out.println(productos);
               }catch(ArrayIndexOutOfBoundsException r){
                   System.out.println("ERROR ARRA");
                   System.out.println(i);
                   System.out.println(productos);
               }
         
        }
    }
    
    
    public double registrarCompra(){
        int i,numero;
        double cambio =0;
        double precioTotal;
        //preguntamos cuantos productos va a comprar el cliente
        System.out.println("Cuantos productos son para surtir?");
        numero = Integer.parseInt(leer());
        //Aqui se ingresan los productos, se envia el numero de productos 
        ingresarProductos(numero);
        ProveedorDeBienes unProB = new ProveedorDeBienes(
                "Daniel Campos", "55-5132-5400", "danielc@gmail.com",
                "San Antonio Abad", "Cuauhtémoc", "CDMX", "Mexico",
                "09570","Bienes",productos);
        //se determina el precio total de los productos y se verifica que alcance el presupuesto
        unProB.determinarPrecio();
        precioTotal=unProB.precioTotal();
        System.out.println("El precio total es de: " + precioTotal);
        if(presupuesto<precioTotal){
            System.out.println("El presupuesto no alcanza... es de " + presupuesto);
            
        }
        else{ 
            System.out.println("productos almaccenados...");
            cambio=nuevoPresupuesto(precioTotal);
            unProB.almacenarProductos();
        }
        return cambio;
    }
    public double nuevoPresupuesto(double precioTotal){
        return presupuesto-precioTotal;
    }


    public static String leer(){
        String s="";
	BufferedReader sd = new BufferedReader(new InputStreamReader(System.in));
            try{
        	s =sd.readLine();
            }
	catch(IOException e){
        	System.out.println("ERROR: Se introdujo el dato");
       		System.out.println(e);
    	}
    	return s;
		
    }
}
