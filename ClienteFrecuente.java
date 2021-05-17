public class ClienteFrecuente extends Cliente{
	private int idCliente = 0;
	private double BONIFICACION = 0.1;
	public ClienteFrecuente(Cliente candidato){
		idCliente = candidato.getId();
	}
	public double getBonificacion(){
		return BONIFICACION;
	}
}
/**
 * @author RiveraIsaac
 * */