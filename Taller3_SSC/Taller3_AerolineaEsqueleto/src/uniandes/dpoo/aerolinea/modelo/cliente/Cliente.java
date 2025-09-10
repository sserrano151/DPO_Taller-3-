package uniandes.dpoo.aerolinea.modelo.cliente;
import java.util.ArrayList;
import java.util.Collection;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import java.util.Objects;
import java.util.Collections;
import uniandes.dpoo.aerolinea.modelo.Vuelo;


public abstract class Cliente {
	protected final String identificador;
    protected final Collection<Tiquete> tiquetes = new ArrayList<>();
    
    public Cliente(String identificador) {
    	if (identificador == null || identificador.isBlank()) {
            throw new IllegalArgumentException("El identificador del cliente no puede ser vacío.");
    }
     this.identificador = identificador;
}
public String getIdentificador() {
	return identificador;
	
}
public Collection<Tiquete> getTiquetes(){
	 return Collections.unmodifiableCollection(tiquetes);
}
public void agregarTiquete(Tiquete tiquete) {
	if (tiquete != null) {
		tiquetes.add(tiquete);
	}
}
public int getSaldoPendiente() {
	int total = 0;
    for (Tiquete t : tiquetes) {
        if (!t.esUsado()) total += t.getTarifa();
}
    return total;
}
public void usarTiquetes(Vuelo vuelo) {
    for (Tiquete t : tiquetes) {
        if (!t.esUsado() && t.getVuelo().equals(vuelo)) {
            t.marcarComoUsado();
        }
    }   
            	}
            
    
public abstract String getTipoCliente();

@Override
public boolean equals(Object o) {
	if (this == o) 
		return true;
    if (!(o instanceof Cliente)) 
    	return false;
    Cliente cliente = (Cliente) o;
    return identificador.equals(cliente.identificador);
}
@Override
public int hashCode() {
	return Objects.hash(identificador);
}
@Override
public String toString() {
	return "Cliente{" + "id='" + identificador + '\'' + ", tiquetes=" + tiquetes.size() + '}';
}
}