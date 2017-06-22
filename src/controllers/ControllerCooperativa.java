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
		Media media = new Media("http://anime4.streamregarder.com/videoplayback?hash=466775c85213aa3ec85991d296a5ee1656834808db382cc61920963ed21a9da1d77dea57f02e1c470e936bfd7bf9bddc4f57c4e0cd2ac402ea59f59e9a3a6dbd831e12bcf69335968348d222e45d58b54220a35e6bf12a1724969431c5c31d807d682de55d9f8f00c36cbd768445acaf5065f3c8fd1f76dc5964d5f19e766bf05dcc0187e99a5ddf1faa532b3d51526e3189b7f963848f58abaaab23daac64cdab1b72a8ce3e4850d3326dbe2b853afea1686922b0381be2264b1bde4fd1cf2fffcb14bf407f9d61a4fe388b74d0dc1124f22b6d083859080e07f013f0be2b61746cedd786200785ac14eeb4ed2f5158a0bf3713e96f7471de799a793c47cf8a3508cca3a95258e4172d8e1ccfb45b0da963df24e8a051dabbb902106cc3d000866d1cd759081044f0742725742191a46b2bbe833bead85fcd27875a44bf35d8e9092295618b38a2dea245093ae49f65001218c77e82a6b09bec633c0c41dacac7a63ccad528d30545df8460cb0f372f2dc47d46847b11ccef91b9199a6c54b2247566e418fe93d0ad6ac75b6a54918652bc4230cfc0d1bf34bc1eaa1a49376fe71a0a&id=94d74898298ff17c&itag=18&source=webdrive&requiressl=yes&ttl=transient&mm=30&mn=sn-5uaezn6r&ms=nxu&mv=m&pl=20&ei=lhBMWYD6J5TMqwXCjJX4Bg&mime=video/mp4&lmt=1471728566159177&mt=1498157087&ipbits=0&expire=1498171606&cp=QVJOWkJfUFZOR1hNOmMxeFJwY0dWVkhz&sparams=ip,ipbits,expire,id,itag,source,requiressl,ttl,mm,mn,ms,mv,pl,ei,driveid,mime,lmt,cp&signature=60D20AA0CF0F22E1478FA8CEBB8C946B5973EA76.B164B99F0BE7CE329B11B695CEB413FA5C4FEC29");
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		mediaCooperativa.setMediaPlayer(mediaPlayer);
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
