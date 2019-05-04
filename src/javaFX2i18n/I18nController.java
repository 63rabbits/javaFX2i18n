package javaFX2i18n;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class I18nController {

	@FXML
	private AnchorPane ancp;
	@FXML
	private Label defaultLocale;
	@FXML
	private Label jp;
	@FXML
	private Label en;

	@FXML
	void initialize() {
		assert ancp != null : "fx:id=\"ancp\" was not injected: check your FXML file 'I18n.fxml'.";
		assert defaultLocale != null : "fx:id=\"defaultLocale\" was not injected: check your FXML file 'I18n.fxml'.";
		assert en != null : "fx:id=\"en\" was not injected: check your FXML file 'I18n.fxml'.";
		assert jp != null : "fx:id=\"jp\" was not injected: check your FXML file 'I18n.fxml'.";

		Locale dlocale = Locale.getDefault();
		StringBuffer sLocale = new StringBuffer();
		sLocale.append("  << Default Locale >>\n");
		sLocale.append("Locale           = " + dlocale.toString() + "\n");
		sLocale.append("Language         = " + dlocale.getLanguage() + "\n");
		sLocale.append("Country          = " + dlocale.getCountry() + "\n");
		sLocale.append("Display Language = " + dlocale.getDisplayLanguage() + "\n");
		sLocale.append("Display Country  = " + dlocale.getDisplayCountry() + "\n");
		defaultLocale.setText(sLocale.toString());
	}

	@FXML
	void jpOnMouseClicked(MouseEvent event) throws IOException {
		changeLanguage(new Locale("jp", "JP"));
	}

	@FXML
	void enOnMouseClicked(MouseEvent event) throws IOException {
		changeLanguage(new Locale("en", "US"));
	}

	public void changeLanguage(Locale locale) throws IOException {
		ResourceBundle rb = ResourceBundle.getBundle(
				this.getClass().getPackage().getName() + I18nConstants.BUNDLE_NAME, locale);
		((Stage) ancp.getScene().getWindow()).setTitle(rb.getString(I18nConstants.APPLICATION_TITLE));

		Pane pane = FXMLLoader.load(this.getClass().getResource("I18n.fxml"), rb);
		// replace the content
		Pane root = (Pane) ancp.getScene().getRoot();
		root.getChildren().clear();
		root.getChildren().add(pane);
	}
}
