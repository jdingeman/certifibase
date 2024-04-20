package com.certifibase.application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application extends javafx.application.Application {

	private ConfigurableApplicationContext context;

	@Override
	public void init() throws Exception {
		context = SpringApplication.run(Application.class);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Certifibase");
		// Use getResource to get the URL of the FXML file served by Spring Boot
		String fxmlPath = getClass().getResource("/static/main.fxml").toExternalForm();
		// Load the FXML file directly from the URL
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/static/main.fxml")));
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		context.close();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
