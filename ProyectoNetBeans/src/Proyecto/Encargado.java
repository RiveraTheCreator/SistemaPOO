package Proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
public class Encargado {
    private static Usuario cuenta;
    private static double cambio;

    public Encargado(Usuario user){
        this.cuenta = user;
    }
    
    public void destruir(){
        if(cuenta!=null){
            cuenta=null;
            System.gc();
        }
    }
    
    public void realizarCompra(double presupuesto){
        Compra compra = new Compra(presupuesto);
        int opc =0;
        cambio = 0;
        
        do{
            System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
            System.out.println("°                             °");
            System.out.println("°   1) Registrar compra       °");
            System.out.println("°   2) Regresar               °");
            System.out.println("°                             °");
            System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
            opc = Integer.parseInt(leer());
            switch(opc){
                case 1: 
                    cambio=compra.registrarCompra();
                    break;
                case 2:
                    break;
            }  
        }while(opc != 2);
    }
    public double actualizarPresupuesto(){
        return cambio;
    }

    public double actualizarPresupuestoPorProveedor(){
        Tesorero unProR = new Tesorero();
        return unProR.surtirDeRecursos();
    }
    public void mostrarUsuario(){
        int opc = 0;
        do{
            System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
            System.out.println("°                             °");
            System.out.println("°   1) Editar Infomracion     °");
            System.out.println("°   2) Mostrar informacion    °");
            System.out.println("°   3) salir                  °");
            System.out.println("°                             °");
            System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
            opc = Integer.parseInt(leer());
            switch(opc){
                case 1:
                    editarInfo();
                    break;
                case 2:
                    System.out.println(cuenta);
                    break;
            }
            
        }while(opc!=3);
    }
    
    public static void editarInfo() {
        int opc = 0;
        String cambio =" ";
        do {
            System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
            System.out.println("°                             °");
            System.out.println("°   Que quieres editar?       °");
            System.out.println("°   1) Nombre completo        °");
            System.out.println("°   2) Contraseña             °");
            System.out.println("°   3) Direccion              °");
            System.out.println("°   4) Telefono               °");
            System.out.println("°   5) Fecha de contratacion  °");
            System.out.println("°   6) Edad                   °");
            System.out.println("°   7) Departamento           °");
            System.out.println("°   8) Regresar               °");
            System.out.println("°                             °");
            System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
            opc= Integer.parseInt(leer());
           
            switch(opc){
                case 1:
                    System.out.println("Dame el nuevo valor...");
                    cambio = leer();
                    cuenta.setName(cambio);
                    break;
                case 2:
                    System.out.println("Dame el nuevo valor...");
                    cambio = leer();
                    cuenta.setPassword(cambio);
                    break;
                case 3:
                    cambiarDomicilio();
                    break;
                case 4:
                    cambiarTelefono();
                    break;
                case 5:
                    System.out.println("Dame el nuevo valor...");
                    cambio = leer();
                    cuenta.setFechaContratacion(cambio);
                    break;
                case 6:
                    System.out.println("Dame el nuevo valor...");
                    cambio = leer();
                    cuenta.setEdad(Integer.parseInt(cambio));
                    break;
                case 7:
                    System.out.println("Dame el nuevo valor...");
                    cambio = leer();
                    cuenta.setDepartamento(Integer.parseInt(cambio));
                    break;
            }
        }while(opc !=8);
    }
    
    public static void cambiarDomicilio(){
        String calle,colonia,ciudad,pais,cp;
        System.out.println("Calle y Numero?");
        calle = leer();
        System.out.println("Colonia?");
        colonia= leer();
        System.out.println("Ciudad?");
        ciudad = leer();
        System.out.println("Pais?");
        pais = leer();
        System.out.println("Codigo postal?");
        cp = leer();
        cuenta.setDomicilio(calle,colonia,ciudad,pais,cp);
    }
    
    public static void cambiarTelefono(){
        String telefono,correo;
        System.out.println("Telefono?");
        telefono = leer();
        System.out.println("Correo?");
        correo = leer();
        cuenta.setTelefono(telefono, correo);
    }
    public void mostrarVentasDelDia(){
        String path = "\\Users\\McCarthy\\Documents\\POO\\Editar Proy\\Proyecto\\src\\Proyecto";
        String archivoN = path + "ventas.obj";
        FlujoLinkedListInputStream flujoEntrada = new FlujoLinkedListInputStream(archivoN);
        List<Object> ventasRegistradas = flujoEntrada.leerObjetos();
        for (Object venta : ventasRegistradas) {
                System.out.println(venta);
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
}