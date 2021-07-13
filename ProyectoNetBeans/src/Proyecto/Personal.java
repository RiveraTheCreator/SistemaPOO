
package Proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Personal{
    
    private static Usuario usuario;
    public Personal( Usuario unUsuario){
        
        this.usuario = unUsuario;
    }
    
    public void destruir(){
        if(usuario != null){
            usuario = null;
            System.gc();
        }
    }
    //en este metodo, el empleado realiza las ventas
    public void realizarVenta(){
        Venta venta = new Venta();
        int opc =0;
        do{   
            System.out.println("\t1) Registrar venta");
            System.out.println("\t2) Regresar");
            
            opc = Integer.parseInt(leer());
            switch(opc){
                case 1: 
                    venta.registrarVenta();
                    break;
                case 2:
                    
                    break;
            }
            
        }while(opc != 2);
        venta.almacenarTicketDigital();
    }
    //en este metodo, se muestra la informacion del empleado
    public void mostrarUsuario(){
        int opc = 0;
        do{
            System.out.println("*************************************");
            System.out.println("*                                   *");
            System.out.println("*\t1) Editar Infomracion       *");
            System.out.println("*\t2) Ver informacion          *");
            System.out.println("*\t3) Regresar                 *");
            System.out.println("*                                   *");
            System.out.println("*************************************");
            opc = Integer.parseInt(leer());
            switch(opc){
                case 1:
                    editarInfo();
                    break;
                case 2: 
                    System.out.println(usuario);
                    break;
            }
            
        }while(opc!=3);
    }
    
    public static void editarInfo() {
        int opc = 0;
        String cambio =" ";
        do {
            System.out.println("**********************************");
            System.out.println("*                                *");
            System.out.println("* Que quieres editar?            *");
            System.out.println("* 1) Nombre completo             *");
            System.out.println("* 2) Contraseña                  *");  
            System.out.println("* 3) Domicilio                   *");
            System.out.println("* 4) Telefono                    *");
            System.out.println("* 5) Fecha de contratacion       *");
            System.out.println("* 6) Edad                        *");
            System.out.println("* 7) Departamento                *");
            System.out.println("* 8) Regresar                    *");
            System.out.println("*                                *");
            System.out.println("**********************************");
            opc= Integer.parseInt(leer());
            
            switch(opc){
                case 1: 
                    System.out.println("Dame el nuevo valor...");
                    cambio = leer();
                    usuario.setName(cambio);
                    break;
                case 2:
                    System.out.println("Dame el nuevo valor...");
                    cambio = leer();
                    usuario.setPassword(cambio);
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
                    usuario.setFechaContratacion(cambio);
                    break;
                case 6:
                    System.out.println("Dame el nuevo valor...");
                    cambio = leer();
                    usuario.setEdad(Integer.parseInt(cambio));
                    break;
                case 7:
                    System.out.println("Dame el nuevo valor...");
                    cambio = leer();
                    usuario.setDepartamento(Integer.parseInt(cambio));
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
        usuario.setDomicilio(calle,colonia,ciudad,pais,cp); //setDireccion(calle,colonia,ciudad,pais,cp);
    }
    
    public static void cambiarTelefono(){
        String telefono,correo;
        System.out.println("Telefono?");
        telefono = leer();
        System.out.println("Correo?");
        correo = leer();
        usuario.setTelefono(telefono, correo);
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
