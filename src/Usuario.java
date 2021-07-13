import java.io.Serializable;
public class Usuario implements Serializable{
	static final long serialVersionUID = 1L;
	private String nombreCompleto;
	private int numeroID;
	private String password;
	private Domicilio domicilio;
	private Telefono telefono;
	private String fechaContratacion;
	private int edad;
	private int departamento;
	private double sueldo;
	private String es;
	public Usuario(String n, int nu, String c, String ca,
				   String co, String ci, String pa,
				   String cp, String tel, String cor,
				   String fc, int e, int de, double s, String es){

		nombreCompleto = n;
		numeroID = nu;
		password = c;
		domicilio = new Domicilio(ca,co,ci,pa,cp);
		telefono = new Telefono(tel, cor);
		fechaContratacion = fc;
		edad = e ;
		departamento = de ;
		sueldo = s;
		this.es = es;
	}
	public Usuario(Usuario u){
		nombreCompleto = u.nombreCompleto;
		numeroID = u.numeroID;
		password = u.password;
		domicilio = u.domicilio;
		telefono = u.telefono;
		fechaContratacion = u.fechaContratacion;
		edad = u.edad;
		departamento = u.departamento;
		sueldo = u.sueldo;
		es = u.es;
	}
	public void destruir(){
		if(nombreCompleto!=null && numeroID!=0 
			&& password!=null && domicilio!=null 
			&& telefono!=null && fechaContratacion!=null 
			&& edad!=0 && departamento!=0 && sueldo!=0 ){
        	nombreCompleto = null;
        	numeroID = 0;
        	password = null;
        	domicilio = null;
        	telefono = null;
        	fechaContratacion = null;
        	edad = 0;
        	departamento = 0;
        	sueldo = 0;
        	System.gc();
		}	
	}
	public int getNumeroID(){
		return numeroID;
	}
	public String getPassword(){
		return password;
	}
	public String getEs(){
		return es;
	}
	public String getNombre(){
		return nombreCompleto;
	}

	public void setName(String nombreCompleto){
		this.nombreCompleto = nombreCompleto;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setDomicilio(String calle,String colonia,
							String ciudad, String pais, String cp){
		domicilio.setCalleYNumero(calle);
		domicilio.setColonia(colonia);
		domicilio.setCiudad(ciudad);
		domicilio.setPais(pais);
		domicilio.setCp(cp);
	}
	public void setTelefono(String tel, String correo){
		telefono.setTelefono(tel);
		telefono.setCorreo(correo);
	}
	public void setFechaContratacion(String fecha){
		this.fechaContratacion = fecha;
	}
	public void setEdad(int edad){
		this.edad = edad;
	}
	public void setDepartamento(int dep){
		this.departamento = dep;
	}
	
	@Override
	public String toString(){
		return "Nombre Completo: " + nombreCompleto + "\n" +
		"NumeroID: " + numeroID + "\n" + 
		"Domicilio: " + domicilio + "\n" + 
		"Contactos: " + telefono + "\n" + 
		"fecha de contratacion: " + fechaContratacion + "\n" +
		"Edad: " + edad + "\n" + 
		"Departamento" + departamento + "\n" + 
		"Sueldo: " + sueldo + "\n";
	}
}	