package uniandes.dpoo.aerolinea.modelo;

public class Avion {
	 private String nombre;
	 private int capacidad;
	 public Avion(String nombre, int capacidad) {
		super();
		if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre del avión no puede ser vacío.");
        if (capacidad <= 0)
            throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
		this.nombre = nombre;
		this.capacidad = capacidad;
	 }
	 public String getNombre() {
		 return nombre;
	 }
	 
	 public int getCapacidad() {
		 return capacidad;
	 }
	 
	 }
	 

