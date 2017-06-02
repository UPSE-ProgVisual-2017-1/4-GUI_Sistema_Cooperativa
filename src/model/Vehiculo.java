package model;

import java.util.UUID;

public class Vehiculo {

	private String id;
	private MarcaVehiculo marca;
	private String anioFabricacion;
	private String matricula;
	private int capacidadPasajeros;
	private int kmRecorrido;
	private EstadoVehiculo estado;
	private boolean ocupado;
	
	public Vehiculo(MarcaVehiculo marca, String anioFabricacion, String matricula, int capacidadPasajeros, int kmRecorrido,
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

	public String getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(String anioFabricacion) {
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

	
}
