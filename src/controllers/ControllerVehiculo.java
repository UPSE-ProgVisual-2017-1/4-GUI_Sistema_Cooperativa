package controllers;

import java.io.IOException;
import java.util.List;

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
import javafx.scene.control.SpinnerValueFactory;
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
	
	private boolean modificando = false;
	
	public void initialize()
	{
		ObservableList<EstadoVehiculo> itemsEstadoVehiculo = FXCollections.observableArrayList(EstadoVehiculo.values());
		cmbEstado.setItems(itemsEstadoVehiculo);
		
		ObservableList<MarcaVehiculo> itemsMarcaVehiculo = FXCollections.observableArrayList(MarcaVehiculo.values());
		cmbMarca.setItems(itemsMarcaVehiculo);
		
		if(context.getVehiculoSeleccionado()!=null)
		{
			vehiculoPojo = context.getVehiculoSeleccionado();
			cargar(vehiculoPojo);
			modificando = true;
		}else{
			vehiculoPojo = new Vehiculo();
		}
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
		cmbMarca.setValue(v.getMarca());
		txtMatricula.setText(v.getMatricula());
		txtKilometraje.setText(Integer.toString(v.getKmRecorrido()));
		cmbEstado.setValue(v.getEstado());
		chkOcupado.setSelected(v.isOcupado());
		spnCapacidad.getValueFactory().setValue(v.getCapacidadPasajeros());
	}
	
	private void guardarModificado()
	{
		cargarDatosPantalla();
		
		if(cooperativa != null)
		{
			List<Vehiculo> listaVehiculo = cooperativa.getVehiculosRegistrados();
			
			for(Vehiculo v: listaVehiculo)
			{
				if(v.getId() == vehiculoPojo.getId())
				{
					v = vehiculoPojo;
					break;
				}
			}
			
			System.out.println(cooperativa);
			llamarGUICooperativa();
		}else{
			System.err.println("Error, todo vehiculo debe estar en una cooperativa pero cooperativa es null");
		}
	}
	
	public void guardar()
	{
		if(modificando)
		{
			guardarModificado();
		}else
		{
			vehiculoPojo = new Vehiculo();
			cargarDatosPantalla();
			
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
		
	}

	private void cargarDatosPantalla() {
		vehiculoPojo.setAnioFabricacion(Integer.parseInt(txtAnioFabricacion.getText()));
		vehiculoPojo.setCapacidadPasajeros(spnCapacidad.getValue());
		vehiculoPojo.setEstado(cmbEstado.getValue());
		vehiculoPojo.setKmRecorrido(Integer.parseInt(txtKilometraje.getText()));
		vehiculoPojo.setMarca(cmbMarca.getValue());
		vehiculoPojo.setMatricula(txtMatricula.getText());
		vehiculoPojo.setOcupado(chkOcupado.isSelected());
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
