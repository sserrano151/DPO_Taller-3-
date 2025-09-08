package uniandes.dpoo.aerolinea.modelo;
import java.util.Collection;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Vuelo {
	private String fecha;
    private Ruta ruta;
    private Avion avion;
    private final List<Tiquete> tiquetes = new ArrayList<>();
    public Vuelo(String fecha, Ruta ruta, Avion avion) {
		super();
		this.fecha = fecha;
		this.ruta = ruta;
		this.avion = avion;
	}
	public String getFecha() {
		return fecha;
	}
	
	public Ruta getRuta() {
		return ruta;
	}
	
	public Avion getAvion() {
		return avion;
	}
	
	public Collection<Tiquete> getTiquetes() {
        return Collections.unmodifiableList(tiquetes);
    }
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
		int vendidos = 0;
        for (int i = 0; i < cantidad; i++) {
            int tarifa = (int) calculadora.calcularTarifa(this, cliente);
            Tiquete t = GeneradorTiquetes.generarTiquete(this, cliente, tarifa);

            GeneradorTiquetes.registrarTiquete(t);
            cliente.agregarTiquete(t);
            tiquetes.add(t);
            
            vendidos++;
        }
        return vendidos;
	}
	public boolean equals(Object obj) {
		if (obj instanceof Vuelo) {
			Vuelo otro = (Vuelo) obj;
            return this.getRuta().equals(otro.getRuta()) && this.getFecha().equals(otro.getFecha());
		}
		return false;
	}

}
