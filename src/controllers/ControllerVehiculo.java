package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
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
	
	public void initialize()
	{
		ObservableList<EstadoVehiculo> itemsEstadoVehiculo = FXCollections.observableArrayList(EstadoVehiculo.values());
		cmbEstado.setItems(itemsEstadoVehiculo);
		
		ObservableList<MarcaVehiculo> itemsMarcaVehiculo = FXCollections.observableArrayList(MarcaVehiculo.values());
		cmbMarca.setItems(itemsMarcaVehiculo);
		
		vehiculoPojo = new Vehiculo();
		txtID.setEditable(false);
		
	}
	
	public void limpiar()
	{
		txtID.setText("");
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
	}
	
}
