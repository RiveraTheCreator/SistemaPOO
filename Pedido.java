import java.util.*;
public class Pedido{
	private int idDeVenta = 0; 
	private String fechaDeEntrega = "";
	private boolean estatus = false;
	Random aleatorio = new Random(System.currentTimeMillis());
	public Pedido(){
		this.idDeVenta = this.generarID();
		this.fechaDeEntrega = this.asignarEntrega();
	}

	public void procesarPedido(){
		new CompraYVenta();
	}

	public int generarID(){
		int idAletorio = aleatorio.nextInt(150);
		aleatorio.setSeed(System.currentTimeMillis());
		return idAletorio;
	}
	public void registrarDatos(int id, String fecha,double bonificacion){
		new CompraYVenta(id,fecha);
	}

	public String asignarEntrega(){	
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
       	cal.add(Calendar.MONTH, 1);
       	return dateFormat.toString(format(cal.getTime()));
	}
}

/**
 * @author RiveraIsaac
 * */