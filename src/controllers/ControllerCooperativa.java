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
import model.EstadoVehiculo;
import model.MarcaVehiculo;
import model.Vehiculo;

public class ControllerCooperativa {

	@FXML TextField txtNombre;
	@FXML ListView<Vehiculo> lstVehiculos;
	
	public void initialize()
	{
	 
		ObservableList<Vehiculo> listaObservableVehiculos = FXCollections.observableArrayList(crearListaVehiculo());
		lstVehiculos.setItems(listaObservableVehiculos);
	}
	
	private List<Vehiculo> crearListaVehiculo()
	{
		List<Vehiculo> listaFalsa = new ArrayList<Vehiculo>();
		
		Vehiculo v1 = new Vehiculo(MarcaVehiculo.CHEVROLET, 2015, "YTA-1234", 36, 10000, EstadoVehiculo.ACTIVO, false);
		Vehiculo v2 = new Vehiculo(MarcaVehiculo.HINO, 2017, "YTA-4567", 40, 100000, EstadoVehiculo.ACTIVO, false);
		
		listaFalsa.add(v1);
		listaFalsa.add(v2);
		return listaFalsa;
	}
	
	public void eliminarVehiculo()
	{
		Vehiculo vehiculoABorrar = lstVehiculos.getSelectionModel().getSelectedItem();
		lstVehiculos.getItems().remove(vehiculoABorrar);
	}
	
	public void crearVehiculoPorGUI()
	{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/ViewVehiculo.fxml"));
			Stage escenario = new Stage();
			Scene escena = new Scene(root);
			escenario.setScene(escena);
			escenario.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
