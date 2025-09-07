package uniandes.dpoo.aerolinea.tiquetes;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
	private String codigo;
    private int tarifa;
    private boolean usado;
    private Vuelo vuelo;
    private Cliente cliente;
	public Tiquete(String codigo, int tarifa, boolean usado, Vuelo vuelo, Cliente cliente) {
		super();
		this.codigo = codigo;
		this.vuelo = vuelo;
		this.cliente = cliente;
		this.tarifa = tarifa;
		this.cliente = cliente;
	}
	public String getCodigo() {
		return codigo;
	}
	
	public int getTarifa() {
		return tarifa;
	}
	
	
	public boolean isUsado() {
		return usado;
	}
	
	public Vuelo getVuelo() {
		return vuelo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setUsado(boolean usado) { this.usado = usado; 
	}
	
	}
    

