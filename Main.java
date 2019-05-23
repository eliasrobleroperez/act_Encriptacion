package application;
	
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER_LEFT);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25,25,25,25));
			
			
			Scene scene = new Scene(grid,300,250);
			Label etiqueta = new Label("Palabra: ");
			grid.add(etiqueta, 0, 1);
			
			TextField palabra2 = new TextField();
			grid.add(palabra2, 1, 1);
			
			Button encriptar = new Button("ENCRIPTAR");
			grid.add(encriptar, 1, 2);
			
			Button desencriptar = new Button("DESENCRIPTAR");
			grid.add(desencriptar, 1, 3);
			
			
			encriptar.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					//TODO Auto-generated method stub
					
					byte[] palabra = palabra2.getText().getBytes();
					String palabraEncriptada = Base64.getEncoder().encodeToString(palabra);
					palabra2.setText(palabraEncriptada);
										
				}
			});
			
			desencriptar.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					//TODO Auto-generated method stub
					
					String palabra = palabra2.getText();
					Base64.Decoder palabra4 = Base64.getDecoder();
					byte[] resultado= palabra4.decode(palabra);
					String palabraDesencriptada = new String(resultado);
					palabra2.setText(palabraDesencriptada);
										
				}
			});
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
