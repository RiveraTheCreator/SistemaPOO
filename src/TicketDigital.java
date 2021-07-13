
//package Proyecto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class TicketDigital extends Object implements Serializable{
    
    static final long serialVersionUID = 1L;
    private int hora,minutos,segundos;
    private int dia,mes,anio;
    private int [] productos;
    private double []precio;
    private int numeroDeVenta;
    private double IvaAplicado;
    private double precioFinal;
    private double montoCliente;
    private double cambio;
    private int numero;
    
    public TicketDigital(int[] productos, double[] precio, int numeroDeVenta, double IvaAplicado, double precioFinal, double montoCliente, double cambio, int numero){
        Calendar calendario = Calendar.getInstance();
        this.hora = calendario.get(Calendar.HOUR_OF_DAY);
        this.minutos = calendario.get(Calendar.MINUTE);
        this.segundos = calendario.get(Calendar.SECOND);
        this.dia = calendario.get(Calendar.DATE);
        this.mes = calendario.get(Calendar.MONTH);
        this.anio = calendario.get(Calendar.YEAR);
        this.productos = productos;
        this.precio = precio;
        this.numeroDeVenta = numeroDeVenta;
        this.IvaAplicado = IvaAplicado;
        this.precioFinal = precioFinal;
        this.montoCliente = montoCliente;
        this.cambio = cambio;
        this.numero = numero;
    }
    
    public TicketDigital(TicketDigital unTicket){
        hora = unTicket.hora;
        minutos = unTicket.minutos;
        segundos = unTicket.segundos;
        dia = unTicket.dia;
        mes = unTicket.mes;
        anio = unTicket.anio;
        productos = unTicket.productos;
        precio = unTicket.precio;
        numeroDeVenta = unTicket.numeroDeVenta;
        IvaAplicado = unTicket.IvaAplicado;
        precioFinal = unTicket.precioFinal;
        montoCliente = unTicket.montoCliente;
        cambio = unTicket.cambio;
    }
    
    public int [] getFecha(){
       int [] fecha = {
         hora,
         minutos,
         segundos,
         dia,
         mes,
         anio
       };
       return fecha;
    }
    public int getNumeroDeVenta(){
        return numeroDeVenta;
    }
    
    public double getIvaAplicado(){
        return IvaAplicado;
    }
    public double getPrecioFinal(){
        return precioFinal;
    }
    public double getMontoCliente(){
        return montoCliente;
    }
    public double getCambio(){
        return cambio;
    }
    public String productos(){
        String regreso ="";
        for(int i=0;i<numero;i++){
            
            regreso = regreso + productos[i] + "  $" + precio[i] + "\n";
        }
        return regreso;
    }
    
    @Override
    public String toString(){
        return  "\n--------------------\n" +
                "Hora:  " + hora + ":" + minutos + ":" + segundos + "\n" + 
                "Fecha de la compra:  " + dia + "/" + mes + "/" + anio + "\n" +
                "Productos:\n" + productos() + "\n" + 
                "Numero de venta:  " + numeroDeVenta + "\n" + 
                "Iva aplicado:  " + IvaAplicado + "\n" + 
                "Precio final:  " + precioFinal + "\n" + 
                "Monto del cliente:  " + montoCliente + "\n" + 
                "Cambio:  " + cambio + "\n" + 
		        "Gracias por su compra :)" +
                "\n--------------------\n";
    }
}
