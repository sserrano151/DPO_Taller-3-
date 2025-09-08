package uniandes.dpoo.aerolinea.modelo.tarifas;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Ruta;
public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {
	protected static final int COSTO_POR_KM = 1000;
	
	
	@Override
	    protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		Ruta ruta = vuelo.getRuta();
        int kms = calcularDistanciaVuelo(ruta);
        long base = (long) kms * COSTO_POR_KM;
        return base > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) base;
	 }
	@Override
    protected double calcularPorcentajeDescuento(Cliente cliente) {
		return 0.0;
	}
}
