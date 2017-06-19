package model;

public class Context {

	private final static Context instance = new Context();
	
	public static Context getInstance()
	{
		return instance;
	}
		
	private Cooperativa cooperativa;
	private Vehiculo vehiculoSeleccionado;
	
	public void setCooperativa(Cooperativa cooperativa)
	{
		this.cooperativa = cooperativa;
	}
	
	public Cooperativa getCooperativa()
	{
		return this.cooperativa;
	}

	public Vehiculo getVehiculoSeleccionado() {
		return vehiculoSeleccionado;
	}

	public void setVehiculoSeleccionado(Vehiculo vehiculoSeleccionado) {
		this.vehiculoSeleccionado = vehiculoSeleccionado;
	}
	
	
}
