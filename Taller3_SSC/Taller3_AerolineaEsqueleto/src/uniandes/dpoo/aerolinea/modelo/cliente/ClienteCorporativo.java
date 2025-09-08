package uniandes.dpoo.aerolinea.modelo.cliente;

import org.json.JSONObject;

/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son empresas
 */
public class ClienteCorporativo extends Cliente
{
	public static String CORPORATIVO = "Corporativo";
    public int GRANDE = 1;
    public int MEDIANA = 2;
    public int PEQUENA = 3;
    private final String nombreEmpresa;
    private final int tamanoEmpresa;
    
    
    
    
    
    
    
    
    
    public ClienteCorporativo(String nombreEmpresa, int tamanoEmpresa) {
    	super(nombreEmpresa);
    	this.nombreEmpresa = nombreEmpresa;
        this.tamanoEmpresa = tamanoEmpresa;
    }
		
		
	

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public int getTamanoEmpresa() {
		return tamanoEmpresa;
	}

	public static ClienteCorporativo cargarDesdeJSON( JSONObject cliente )
    {
        String nombreEmpresa = cliente.getString( "nombreEmpresa");
        int tam = cliente.getInt( "tamanoEmpresa" );
        return new ClienteCorporativo( nombreEmpresa, tam );
    }

    
    public JSONObject salvarEnJSON( )
    {
        JSONObject jobject = new JSONObject( );
        jobject.put( "nombreEmpresa", this.nombreEmpresa );
        jobject.put( "tamanoEmpresa", this.tamanoEmpresa );
        jobject.put( "tipo", CORPORATIVO );
        return jobject;
    }
    @Override
    public String getTipoCliente() {
    	return CORPORATIVO;
    }
    @Override
    public String toString() {
    	return "ClienteCorporativo{nombreEmpresa='" + nombreEmpresa +
                "', tamanoEmpresa=" + tamanoEmpresa +
                ", tiquetes=" + getTiquetes().size() + "}";
    }
}
