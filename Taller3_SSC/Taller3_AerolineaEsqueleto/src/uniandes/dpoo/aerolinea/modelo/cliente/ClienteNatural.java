package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente {
	public static final String NATURAL = "Natural";

    private final String nombre;

    public ClienteNatural(String identificador, String nombre) {
    	super(identificador);
        this.nombre = nombre;
    }
    public ClienteNatural(String nombre) {
    	this(nombre, nombre);
    }
    @Override
    public String getIdentificador() {
        return nombre;
    }
    
    @Override
    public String getTipoCliente() {
    	return NATURAL;
    }
    
	}
	
	

