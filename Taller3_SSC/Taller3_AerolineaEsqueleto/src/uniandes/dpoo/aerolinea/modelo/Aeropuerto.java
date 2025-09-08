package uniandes.dpoo.aerolinea.modelo;

import java.util.HashSet;
import java.util.Set;



/**
 * Esta clase encapsula la información sobre los aeropuertos e implementa algunas operaciones relacionadas con la ubicación geográfica de los aeropuertos.
 * 
 * No puede haber dos aeropuertos con el mismo código.
 */
public class Aeropuerto
{
	 private String nombre;
	    private String codigo;
	    private String nombreCiudad;
	    private double latitud;
	    private double longitud;
	    private static Set<String> codigosUtilizados = new HashSet<String>();
	    private static int RADIO_TERRESTRE = 6371;
	    
	    
	    
    public Aeropuerto(String nombre, String codigo, String nombreCiudad, double latitud, double longitud) {
			super();
			this.nombre = nombre;
			this.codigo = codigo;
			this.nombreCiudad = nombreCiudad;
			this.latitud = latitud;
			this.longitud = longitud;
			
		}



	public String getNombre() {
		return nombre;
	}



	public String getCodigo() {
		return codigo;
	}



	public String getNombreCiudad() {
		return nombreCiudad;
	}



	public double getLatitud() {
		return latitud;
	}



	public double getLongitud() {
		return longitud;
	}



	public static Set<String> getCodigosUtilizados() {
		return codigosUtilizados;
	}



	public static int getRADIO_TERRESTRE() {
		return RADIO_TERRESTRE;
	}



	public static int calcularDistancia( Aeropuerto aeropuerto1, Aeropuerto aeropuerto2 )
    {
        // Convertir los ángulos a radianes para facilitar las operaciones trigonométricas
        double latAeropuerto1 = Math.toRadians( aeropuerto1.getLatitud( ) );
        double lonAeropuerto1 = Math.toRadians( aeropuerto1.getLongitud( ) );
        double latAeropuerto2 = Math.toRadians( aeropuerto2.getLatitud( ) );
        double lonAeropuerto2 = Math.toRadians( aeropuerto2.getLongitud( ) );

        // Calcular la distancia debido a la diferencia de latitud y de longitud
        double deltaX = ( lonAeropuerto2 - lonAeropuerto1 ) * Math.cos( ( latAeropuerto1 + latAeropuerto2 ) / 2 );
        double deltaY = ( latAeropuerto2 - latAeropuerto1 );

        // Calcular la distancia real en kilómetros
        double distancia = Math.sqrt( deltaX * deltaX + deltaY * deltaY ) * RADIO_TERRESTRE;

        return ( int )Math.round( distancia );
    }

}
