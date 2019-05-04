package javaFX2i18n;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class I18n extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		Locale locale = Locale.getDefault();
		//		Locale locale = new Locale("ja", "JP");
		//		Locale locale = new Locale("en", "US");
		ResourceBundle rb = ResourceBundle.getBundle(
				this.getClass().getPackage().getName() + I18nConstants.BUNDLE_NAME, locale);
		Parent root = FXMLLoader.load(this.getClass().getResource("I18n.fxml"), rb);
		Scene scene = new Scene(root);

		stage.setTitle(rb.getString(I18nConstants.APPLICATION_TITLE));

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
