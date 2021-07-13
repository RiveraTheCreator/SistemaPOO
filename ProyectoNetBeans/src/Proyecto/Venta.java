package Proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 *@author Victor Hugo de la Cruz del Angel
 */

public class Venta {
    private int numeroVenta;
    private static int [] productos;
    private static double [] precios;
    private static LinkedList<Object>tickets;
    
    
    public Venta(){        
        tickets = new LinkedList<>();
    }
    
    public Venta(int numeroVenta){
        this.numeroVenta = numeroVenta;
    }
    
    public static void determinarPrecios(int i){
        int j;
        precios = new double [i];
        try{
            for( j=0;j<i;j++ ){
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
            System.out.println("Error NullPointerException  :(");
        }
    }
    
    public static void ingresarProductos(int numero){
        int ban=0, i=0;
        productos = new int[numero];
        int producto;
       
        for(i=0;i<numero;i++){
            System.out.println("Ingrese el codigo del producto " + (i+1) +" :" );
            producto = Integer.parseInt(leer());
               try{
                    
                    productos[i] = producto;
               }catch(NullPointerException e){
                   System.out.println("ERROR:..." + e );
                  
               }catch(ArrayIndexOutOfBoundsException r){
                   System.out.println("ERROR:Revisar numero de productos" + r);
                   
               }
         
        }
    }
    
    public void imprimirCatalogo(){
        String [] auxiliarNombre = new String[5];
        int [] auxiliarPrecio = new int[5];
        
        auxiliarNombre[0] = "Iphone 8";
        auxiliarNombre[1] = "Iphone 9";
        auxiliarNombre[2] = "Iphone X";
        auxiliarNombre[3] = "Iphone 11";
        auxiliarNombre[4] = "Iphone 11 Pro Max";
        
        auxiliarPrecio[2] = 800;
        auxiliarPrecio[0] = 1500;
        auxiliarPrecio[1] = 200;
        auxiliarPrecio[3] = 700;
        auxiliarPrecio[4] = 500;
        
        for(int i=0; i<5; i++){
            System.out.println("Codigo del producto : " + i + 
                    "\t | Nombre del Producto : " + auxiliarNombre[i] + 
                    "\t | Precio : " + auxiliarPrecio[i]);
        }
        System.out.println();
    }
    
    public int disponibilidad(int numero){
        int i=0, contador = 0;
        String path = "\\Users\\McCarthy\\Documents\\POO\\Editar Proy\\Proyecto\\src\\Proyecto";
        String archivoP = path + "productos.obj";
        FlujoLinkedListInputStream flujoEntrada= new FlujoLinkedListInputStream(archivoP);
        //System.out.println("productos desde el flujo\n " + archivoP);
        List<Object> productosRegistrados = flujoEntrada.leerObjetos();
        try {
            for (Object producto : productosRegistrados) {
                if ((int) producto == productos[i]) {
              
                    contador++;
                    i++;
                }
                
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("productos no disponibles");
        }
        
        return contador;
    }
    
    public void registrarVenta(){
        int i;
        int numero;
        int cuenta;
        String opc;
        //imprimirCatalogo();
        do{
            imprimirCatalogo();
            System.out.flush();
            System.out.println("¿Cuantos productos desea registrar?\n");
            numero = Integer.parseInt(leer());
            if(numero == 0)
                System.out.println("\nIngrese un valor mayor a 0 para realizar una compra\n");
        }while(numero == 0);
        
        ingresarProductos(numero);
        cuenta = disponibilidad(numero);
        if (cuenta == numero) {
            //Aqui se determinan todos los elementos del Ticket para poder crearlo y se pregunta si todo está bien o se va a alterar algo
            determinarPrecios(numero);
            double precioFinal = generarPrecioFinal(numero);
            numeroVenta = generarNumeroDeVenta();
            System.out.println("El precio final es de: " + precioFinal);
            System.out.println(
                    "¿Desea realizar un cambio?(si/no), "
                            + "Ingresar todo de nuevo");
            opc = leer();
            if (opc.equals("si")) {
                productos = null;
                precios = null;
                ingresarProductos(numero);
                determinarPrecios(numero);
                precioFinal = generarPrecioFinal(numero);
            }
            double cambio;
            do{
            double montoCliente = generarMontoCliente();
           
                cambio = generarCambio(precioFinal, montoCliente);

                if(cambio >= 0){
                    TicketDigital ticket = new TicketDigital(
                        productos, precios, numeroVenta, 16, 
                        precioFinal, montoCliente, cambio, numero);
            
                    System.out.println(ticket);
                    tickets.add(ticket);
                }
                else{
                    System.out.println("\nDebe pagar con un monto mayor al precio final,"
                            + " para realizar la compra\n");
                }
            }while(cambio < 0);
        }
        else{
            System.out.println("no hay productos suficientes " + cuenta);
        }
    }
    
    public  void almacenarTicketDigital(){
        String path = "\\Users\\McCarthy\\Documents\\POO\\Editar Proy\\Proyecto\\src\\Proyecto";
        String archivoN = path + "Ventas.obj";
        FlujoLinkedListOutputStream flujoSalida= new FlujoLinkedListOutputStream(archivoN);
        System.out.println("Almacenando venta...\n ");
        flujoSalida.escribirObjetos(tickets);
    }
    
    
    public static int generarNumeroDeVenta() {
        int numeroAl;
        Stack< Integer> numVen = new Stack< Integer>();
        numeroAl = (int) Math.floor(Math.random() * 1000000 );
        while(numVen.contains(numeroAl)){
            numeroAl = (int) Math.floor(Math.random() * 1000000 );
        }
        numVen.push(numeroAl);
        return numeroAl;
    }
    
    
    public static double generarPrecioFinal(int numero){
        double precioFin = 0;
        int a = 0;
        try{
            for(a = 0; a<numero ;a++)
                precioFin = precioFin + precios[a];
        }catch(NullPointerException e){
            System.out.println("ERROR NullPointerException :(");
            precios = null;
        }
        return precioFin;
    }
    
    
    public static double generarMontoCliente(){
        double monto;
        System.out.println("Con cuanto dinero va a pagar?");
        monto = Double.parseDouble(leer());
        return monto;
    }

    public static double generarCambio(double precioFinal, double montoCliente){
        double cambio= montoCliente-precioFinal;
        if(cambio<0 ){ System.out.println("Monto insuficiente"); return cambio;}
        else{ 
            return cambio;
        }
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
    
//    private static void clearScreen() throws Exception{
//        if (SystemUtil.osName().contains("win")){
//            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//        }
//        else{
//            System.out.print(ANSI_CLS + ANSI_HOME);
//        }
//  }
}


