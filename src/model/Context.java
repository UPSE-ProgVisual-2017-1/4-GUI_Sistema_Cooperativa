package model;

public class Context {

	private final static Context instance = new Context();
	
	public static Context getInstance()
	{
		return instance;
	}
		
	private Cooperativa cooperativa;
	
	public void setCooperativa(Cooperativa cooperativa)
	{
		this.cooperativa = cooperativa;
	}
	
	public Cooperativa getCooperativa()
	{
		return this.cooperativa;
	}
}
