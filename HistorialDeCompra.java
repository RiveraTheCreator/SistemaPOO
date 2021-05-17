import java.util.*;
public class HistorialDeCompras{
 private Date fecha = new Date(); 
 public HistorialDeCompras(LinkedList listaProductos ){
 	this.fecha = this.asignarFecha;
 }
	public Date asignarFecha(){	
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
       	return dateFormat.format(cal.getTime());
	}

	public void desplegarArticulos(){
		
	}
}
/**
 * @author RiveraIsaac
 * */