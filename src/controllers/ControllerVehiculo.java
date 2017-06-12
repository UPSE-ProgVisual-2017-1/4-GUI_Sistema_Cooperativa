package controllers;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Context;
import model.Cooperativa;
import model.EstadoVehiculo;
import model.MarcaVehiculo;
import model.Vehiculo;

public class ControllerVehiculo {

	@FXML TextField txtID;
	@FXML Button btnConsultaId;
	@FXML ComboBox<MarcaVehiculo> cmbMarca;
	@FXML TextField txtAnioFabricacion;
	@FXML TextField txtMatricula;
	@FXML TextField txtKilometraje;
	@FXML ComboBox<EstadoVehiculo> cmbEstado;
	@FXML CheckBox chkOcupado;
	@FXML Button btnGuardar;
	@FXML Button btnLimpiar;
	@FXML Button btnEliminar;
	@FXML Button btnCancelar;
	@FXML Spinner<Integer> spnCapacidad;
	
	
	private Vehiculo vehiculoPojo;
	
	Context context = Context.getInstance();
	private Cooperativa cooperativa;
	
	public void initialize()
	{
		ObservableList<EstadoVehiculo> itemsEstadoVehiculo = FXCollections.observableArrayList(EstadoVehiculo.values());
		cmbEstado.setItems(itemsEstadoVehiculo);
		
		ObservableList<MarcaVehiculo> itemsMarcaVehiculo = FXCollections.observableArrayList(MarcaVehiculo.values());
		cmbMarca.setItems(itemsMarcaVehiculo);
		
		vehiculoPojo = new Vehiculo();
		txtID.setEditable(false);
		
		cooperativa = context.getCooperativa();
		
	}
	
	public void limpiar()
	{
		txtID.setText("");
	}
	
	public void cargar(Vehiculo v)
	{
		txtAnioFabricacion.setText(Integer.toString(v.getAnioFabricacion()));
		txtID.setText(v.getId());
		
	}
	
	public void guardar()
	{
		vehiculoPojo = new Vehiculo();
		vehiculoPojo.setAnioFabricacion(Integer.parseInt(txtAnioFabricacion.getText()));
		vehiculoPojo.setCapacidadPasajeros(spnCapacidad.getValue());
		vehiculoPojo.setEstado(cmbEstado.getValue());
		vehiculoPojo.setKmRecorrido(Integer.parseInt(txtKilometraje.getText()));
		vehiculoPojo.setMarca(cmbMarca.getValue());
		vehiculoPojo.setMatricula(txtMatricula.getText());
		vehiculoPojo.setOcupado(chkOcupado.isSelected());
		
		System.out.println(vehiculoPojo.toString());
		
		txtID.setText(vehiculoPojo.getId());
		
		if(cooperativa != null)
		{
			cooperativa.getVehiculosRegistrados().add(vehiculoPojo);
			System.out.println(cooperativa);
			llamarGUICooperativa();
		}else{
			System.err.println("Error, todo vehiculo debe estar en una cooperativa pero cooperativa es null");
		}
		
	}
	
	public void llamarGUICooperativa()
	{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/ViewCooperativa.fxml"));
			Stage escenario = new Stage();
			Scene escena = new Scene(root);
			escenario.setScene(escena);
			escenario.show();
			Stage stageCooperativa = (Stage) txtMatricula.getScene().getWindow();
			stageCooperativa.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
