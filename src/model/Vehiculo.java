package model;

import java.util.UUID;

public class Vehiculo {

	private String id;
	private MarcaVehiculo marca;
	private int anioFabricacion;
	private String matricula;
	private int capacidadPasajeros;
	private int kmRecorrido;
	private EstadoVehiculo estado;
	private boolean ocupado;
	
	public Vehiculo()
	{
		this.id = UUID.randomUUID().toString();
	}
	
	public Vehiculo(MarcaVehiculo marca, int anioFabricacion, String matricula, int capacidadPasajeros, int kmRecorrido,
			EstadoVehiculo estado, boolean ocupado) {
		super();
		
		this.id = UUID.randomUUID().toString();
		this.marca = marca;
		this.anioFabricacion = anioFabricacion;
		this.matricula = matricula;
		this.capacidadPasajeros = capacidadPasajeros;
		this.kmRecorrido = kmRecorrido;
		this.estado = estado;
		this.ocupado = ocupado;
	}

	public MarcaVehiculo getMarca() {
		return marca;
	}

	public void setMarca(MarcaVehiculo marca) {
		this.marca = marca;
	}

	public int getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(int anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getCapacidadPasajeros() {
		return capacidadPasajeros;
	}

	public void setCapacidadPasajeros(int capacidadPasajeros) {
		this.capacidadPasajeros = capacidadPasajeros;
	}

	public int getKmRecorrido() {
		return kmRecorrido;
	}

	public void setKmRecorrido(int kmRecorrido) {
		this.kmRecorrido = kmRecorrido;
	}

	public EstadoVehiculo getEstado() {
		return estado;
	}

	public void setEstado(EstadoVehiculo estado) {
		this.estado = estado;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", marca=" + marca + ", anioFabricacion=" + anioFabricacion + ", matricula="
				+ matricula + ", capacidadPasajeros=" + capacidadPasajeros + ", kmRecorrido=" + kmRecorrido
				+ ", estado=" + estado + ", ocupado=" + ocupado + "]";
	}

	/*
	@Override
	public String toString() {
		return  matricula + ": " + marca + "-" + anioFabricacion;
	}*/
	
}
