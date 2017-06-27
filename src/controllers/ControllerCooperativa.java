package controllers;

import java.io.File;
import java.io.IOException;
import java.net.URI;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import model.Context;
import model.Cooperativa;
import model.EstadoVehiculo;
import model.MarcaVehiculo;
import model.Vehiculo;

public class ControllerCooperativa {

	@FXML TextField txtNombre;
	@FXML ListView<Vehiculo> lstVehiculos;
	@FXML ImageView imgCooperativa;
	@FXML MediaView mediaCooperativa;
	
	Context context = Context.getInstance();
	
	private Cooperativa cooperativa;
	
	public void initialize()
	{
		cargarImagen();
		cargarMedia();
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
	
	
	private void cargarMedia() {
		try{

			//Path to Online Video Resource
			String pathName = "http://clips.vorwaerts-gmbh.de/VfE_html5.mp4";
			URI u = URI.create(pathName);

			//Path to File
			//String pathName = "H:\\Downloads\\SwarmThousandRobots.mp4";
			//URI u = new File(pathName).toURI();

			Media media = new Media(u.toString());
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			mediaPlayer.setAutoPlay(true);
			mediaCooperativa.setMediaPlayer(mediaPlayer);
			mediaPlayer.play();
		}catch (Exception e) {
			System.err.println("Error en el media view" + e);
			e.printStackTrace();
		}
	}


	private void cargarImagen() {
		Image image = new Image("/jeepney.jpg");
		imgCooperativa.setImage(image);
		imgCooperativa.setFitHeight(150);
		imgCooperativa.setPreserveRatio(true);
		
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
			context.setVehiculoSeleccionado(null);
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
	
	public void modificarVehiculo()
	{
		try {
			context.setVehiculoSeleccionado(lstVehiculos.getSelectionModel().getSelectedItem());
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
	
	
}
