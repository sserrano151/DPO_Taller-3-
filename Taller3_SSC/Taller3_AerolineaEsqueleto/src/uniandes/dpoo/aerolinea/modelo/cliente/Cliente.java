package uniandes.dpoo.aerolinea.modelo.cliente;
import java.util.ArrayList;
import java.util.Collection;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Cliente {
	protected final String identificador;
    protected final Collection<Tiquete> tiquetes = new ArrayList<>();

}
