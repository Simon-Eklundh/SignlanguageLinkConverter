package com.example.signlanguageconverter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.Charset;

public class HelloApplication extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));

		Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
		stage.setTitle("Hello!");
		stage.setScene(scene);
		stage.show();
	}
}