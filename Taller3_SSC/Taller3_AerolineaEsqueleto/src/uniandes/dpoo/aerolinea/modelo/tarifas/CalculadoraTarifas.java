package uniandes.dpoo.aerolinea.modelo.tarifas;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;


public abstract class CalculadoraTarifas {
	 public double IMPUESTO = 0.28;

	    public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
	    	int costoBase = calcularCostoBase(vuelo, cliente);
	        int descuento = (int) Math.round(costoBase * calcularPorcentajeDescuento(cliente));
	        int impuestos = calcularValorImpuestos(costoBase);
	        return costoBase + impuestos - descuento;
	}
	    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);

	    protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	    
	    protected int calcularDistanciaVuelo(Ruta ruta) {
	    	int r = 0;
	        if (ruta != null)
	            r = Aeropuerto.calcularDistancia(ruta.getOrigen(), ruta.getDestino());
	        else
	            throw new NullPointerException("El origen o destino de la ruta no son válidos.");
	        return r;
	    }
	    protected int calcularValorImpuestos(int costoBase){
	    	return (int) (costoBase * IMPUESTO);
	    }
}

