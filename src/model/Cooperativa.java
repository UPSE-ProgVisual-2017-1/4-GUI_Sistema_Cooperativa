package model;

import java.util.ArrayList;
import java.util.List;

public class Cooperativa {

	private String nombre;
	private List<Vehiculo> vehiculosRegistrados;
	
	public Cooperativa(String nombre)
	{
		this.nombre = nombre;
		vehiculosRegistrados = new ArrayList<Vehiculo>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Vehiculo> getVehiculosRegistrados() {
		return vehiculosRegistrados;
	}

	public void setVehiculosRegistrados(List<Vehiculo> vehiculosRegistrados) {
		this.vehiculosRegistrados = vehiculosRegistrados;
	}
	
	public void ingresarNuevoVehiculo(Vehiculo v)
	{
		vehiculosRegistrados.add(v);
	}

	@Override
	public String toString() {
		return "Cooperativa [nombre=" + nombre + ", vehiculosRegistrados=" + vehiculosRegistrados + "]";
	}
	
	
}
