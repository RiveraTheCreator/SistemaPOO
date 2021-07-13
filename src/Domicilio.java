//Domicilio
import java.io.Serializable;
public class Domicilio implements Serializable{
	static final long serialVersionUID = 1L;
	private String calleYNumero;
	private String colonia;
	private String ciudad;
	private String pais;
	private String cp;
	public Domicilio(){
        this("","","","","");
    }
    public Domicilio(String calleYnumero, String colonia, String cuidad, String pais, String cp){
        this.calleYNumero = calleYnumero;
        this.colonia = colonia;
        this.ciudad = cuidad;
        this.pais = pais;
        this.cp = cp;
    }
	public void destruir(){
	if(calleYNumero != null && colonia!=null && ciudad !=null && pais != null && cp!=null){
		calleYNumero = null;
		colonia = null;
		ciudad = null;
		pais = null;
		cp = null;
		System.gc();
		}
	}
	public String getCalleYNumero(){
		return calleYNumero;
		}
	public String getColonia(){
		return colonia;
		}
	public String getCiudad(){
	 return ciudad; 
		}
	public String getPais(){
	 return pais; 
		}
	public String getCp(){
	 return cp; 
		}
	public String setCalleYNumero(String cn){
		calleYNumero = cn;
		return cn;
		}
	public String setCiudad(String city){
		ciudad = city;
		return ciudad;
	}
	public String setPais(String p){
		 pais = p;
		return  pais;
	}
	public String getCp(String ps){
	  cp = ps ;
	  return ps;
		}
	@Override
	public String toString(){
		return "Calle y numero: "+ calleYNumero + "\n"+
				"Colonia: " + colonia + "\n" +
				"Ciudad: " + ciudad + "\n" +
				"Pais: " + pais + "\n" +
				"Codigo Postal: " + cp + "\n" ;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
}
 