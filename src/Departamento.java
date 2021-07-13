//Departamento
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder;
public class Departamento {

    private String tipo;
    private int numero;
    private double presupuesto;
    private Personal empleado;
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
        tipo = dep.getTipo();
        numero = dep.getNumero();
        presupuesto = dep.getPresupuesto();
    }

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
            empleado = new Personal(c);
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
            ClearConsole();
            System.out.println("1) Ventas");
            System.out.println("2) Usuario");
            System.out.println("3) SALIR");
            opc = Integer.parseInt(leer());
            switch(opc){
                case 1:
                    empleado.realizarVenta();
                    break;
                case 2: 
                    empleado.mostrarUsuario();
                    break;
            }
        }while(opc != 3);
    }
    public void menuEncargado(){
        int opc= 0;
        do{
            ClearConsole();
            System.out.println("\t1) Registrar Compra  provedor");
            System.out.println("\t2) Aumentar presupuesto de la tienda");
            System.out.println("\t3) Mostrar las ventas del dia");
            System.out.println("\t4) Configuaracion de Usuario");
            System.out.println("\t5) SALIR");
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
    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }


    public static Usuario iniciarSesion(){
        Usuario[] cuentasPersonal = {


                new Usuario("Juan Daniel Hernanadez", 1234, "simur",
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
        return empleado;
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
/** @autor RiveraIsaac
 * */