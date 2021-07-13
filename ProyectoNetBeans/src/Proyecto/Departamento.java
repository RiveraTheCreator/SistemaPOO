package Proyecto;
//Departamento
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Departamento {

    private String tipo;
    private int numero;
    private double presupuesto;
    private Personal personal;
    private Encargado encargado;

    public Departamento() {
        this.tipo = null;
        this.numero = 0;
        this.presupuesto = 0;
    }

    public Departamento(String tipo, int numero, double presupuesto) {
        this.tipo = tipo;
        this.numero = numero;
        this.presupuesto = presupuesto;
      
    }

    public Departamento(Departamento dep) {
        tipo = dep.getTipo();  //tipo;
        numero = dep.getNumero();//numero;
        presupuesto = dep.getPresupuesto();//presupuesto;
    }
//gerente
    public void destruir() {
        if (tipo != null && numero != 0) {
            tipo = null;
            numero = 0;
            System.gc();
        }
    }
    public void realizarmovimientos(){
        Usuario c = iniciarSesion();
        if(c.getEs().equals("empleado")){
            personal = new Personal(c);
            System.out.println("Bienvenido " + c.getNombre());
            menuPersonal();
        }
        else if(c.getEs().equals("gerente")){
            encargado = new Encargado(c);
            System.out.println("Bienvenido " + c.getNombre());
            menuEncargado();
        }
    }
    public void menuPersonal(){
        int opc= 0;
        do{
            System.out.println("***************");
            System.out.println("*             *");
            System.out.println("* 1) Ventas   *");
            System.out.println("* 2) Usuario  *");
            System.out.println("* 3) SALIR    *");
            System.out.println("*             *");
            System.out.println("***************");
            opc = Integer.parseInt(leer());
            switch(opc){
                case 1:
                   personal.realizarVenta();
                    break;
                case 2: 
                    personal.mostrarUsuario();
                    break;
            }
        }while(opc != 3);
    }
    public void menuEncargado(){
        int opc= 0;
        do{
            System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
            System.out.println("°                                                °");
            System.out.println("°\t1) Registrar Compra  provedor            °");
            System.out.println("°\t2) Aumentar presupuesto de la tienda     °");
            System.out.println("°\t3) Mostrar las ventas del dia            °");
            System.out.println("°\t4) Configuaracion de Usuario             °");
            System.out.println("°\t5) SALIR                                 °");
            System.out.println("°                                                °");
            System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
            opc = Integer.parseInt(leer());
            switch(opc){
                case 1:
                    encargado.realizarCompra(presupuesto);
                    presupuesto = encargado.actualizarPresupuesto();
                    System.out.println(presupuesto);
                    break;
                case 2:
                    presupuesto =encargado.actualizarPresupuestoPorProveedor();
                    System.out.println(presupuesto);
                    break;
                case 3:
                    encargado.mostrarVentasDelDia();
                    
                    break;
                case 4:
                    encargado.mostrarUsuario();
                    break;
            } 
        }while(opc!=5);
    }

///cambiar datos de empleados
    public static Usuario iniciarSesion(){
        Usuario[] cuentasPersonal = {
//              *//  new Usuario("Isaac Alejandro Rivera", 0707, "paquito",
//                        "Del mar", "Tlahuac", "CDMX", "mexico",
//                        "01348", "5589251753", "isaac@gmail.com",
//                        "19-10-2000", 19, 1, 15000,"empleado"),

                new Usuario("Juan Daniel Hernanadez", 1234, "halo1429",
                        "Colinas de Plata", "El cruce", "Hidalgo", "Hidalgo",
                        "07945", "5548523159", "juand@gmail.com",
                        "19-11-2000", 19, 1, 15000,"empleado"),

                new Usuario("Victor de la Cruz", 2345, "hugo22", "22 de Febrero",
                        "Nicolas Romero", "Edo Mexico", "Mexico", "54435",
                        "5518253794", "victorh@gmail.com",
                        "19-12-2000", 19, 1, 15000,"empleado")
        };
        Usuario[] cuentasEncargados = {
                new Usuario("Saúl Torres", 3456, "sdelao", "Aquiles Serdan",
                        "iztapalapa", "CDMX", "Mexico", "69813",
                        "5524657435", "sdelao@gmail.com", "01-01-1990",
                        22, 1, 30000,"gerente")
        };

        Usuario si = null;
        int numeroEmp = 0;
        String password = "";
        System.out.println("\tInicio de sesion");
        System.out.println("Ingresa tu numero de empleado o gerente:");
        numeroEmp = Integer.parseInt(leer());
        System.out.println("Ingresa tu password:");
        password = leer();
            for (Usuario c : cuentasPersonal) {
                if (numeroEmp == c.getNumeroID() && password.equals(c.getPassword())) {
                    si = c;
                    System.out.println("eres un empleado comun");
                    break;
                }
            }
 
            for (Usuario c : cuentasEncargados) {
                if (numeroEmp == c.getNumeroID() && password.equals(c.getPassword())) {
                    si = c;
                    System.out.println("Eres un gerente");
                    break;
                }
            }
        return si;
    }

    public static String leer() {
        String s = "";
        BufferedReader sd = new BufferedReader(new InputStreamReader(System.in));
        try {
            s = sd.readLine();
        } catch (IOException e) {
            System.out.println("ERROR: Se introdujo el dato");
            System.out.println(e);
        }
        return s;


    }

    public String getTipo() {
        return tipo;
    }

    public int getNumero() {
        return numero;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public Personal getEmpleado() {
        return personal;
    }

    public Encargado getEncargado() {
        return encargado;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + "\n"
                + "Numero:\n" + numero + "\n";
    }
}
/** @author Isaac Rivera
*/