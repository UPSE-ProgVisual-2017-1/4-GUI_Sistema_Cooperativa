package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Context;
import model.Cooperativa;
import model.EstadoVehiculo;
import model.MarcaVehiculo;
import model.Vehiculo;

public class ControllerCooperativa {

	@FXML TextField txtNombre;
	@FXML ListView<Vehiculo> lstVehiculos;
	
	Context context = Context.getInstance();
	
	private Cooperativa cooperativa;
	
	public void initialize()
	{
		ObservableList<Vehiculo> listaObservableVehiculos;
		if(context.getCooperativa()!=null)
		{
			cooperativa = context.getCooperativa();
			listaObservableVehiculos = FXCollections.observableArrayList(cooperativa.getVehiculosRegistrados());
			lstVehiculos.setItems(listaObservableVehiculos);
			txtNombre.setText(cooperativa.getNombre());
			txtNombre.setEditable(false);
		}	
	}
	
	
	public void eliminarVehiculo()
	{
		Vehiculo vehiculoABorrar = lstVehiculos.getSelectionModel().getSelectedItem();
		lstVehiculos.getItems().remove(vehiculoABorrar);
		if(cooperativa!=null)
		{
			cooperativa.getVehiculosRegistrados().remove(vehiculoABorrar);
		}
	}
	
	public void crearVehiculoPorGUI()
	{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/ViewVehiculo.fxml"));
			Stage escenario = new Stage();
			Scene escena = new Scene(root);
			escenario.setScene(escena);
			escenario.show();
			Stage stageCooperativa = (Stage) txtNombre.getScene().getWindow();
			stageCooperativa.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void crearCooperativa()
	{
		String nombreCooperativa = txtNombre.getText();
		if(nombreCooperativa!=null 
				&& nombreCooperativa.trim()!="")
		{
			cooperativa = new Cooperativa(nombreCooperativa);
			context.setCooperativa(cooperativa);
		}
		
		System.out.println(cooperativa);
	}
	
	
}
