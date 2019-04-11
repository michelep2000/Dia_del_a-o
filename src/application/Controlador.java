package application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class Controlador {
	private Date primavera;
	private Date verano;
	private Date otono;
	private Date invierno;
	private int changeEstacion;
	@FXML
	private Button show_status;

	@FXML
	public void initialize() {
		// TODO (don't really need to do anything here).
	}

	public Controlador() {
		changeEstacion = 0;
	}

	// When user click on myButton this method will be called.
	public void showDateTime(ActionEvent event) {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
		showDateStatus(now, 0, "");
	}

	private void showDateStatus(Date now, int changeEstacion, String diasDif) {
		SimpleDateFormat dates = new SimpleDateFormat("yyyy-MM-dd-HH:mm");

		if (diasDif.length() > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Date Status");
			alert.setHeaderText("Current date:\n" + now);
			alert.setContentText(diasDif);
			alert.showAndWait();
			if(changeEstacion==3)
				System.exit(0);
		}
		try {

			for (int i = this.changeEstacion; i < 4; i++) {
				if (i == 0) {
					primavera = dates.parse("2019-03-20-11:02");
					calcDateStatus(now, primavera);
				} else if (i == 1) {
					verano = dates.parse("2019-06-21-05:04");
					calcDateStatus(now, verano);
				} else if (i == 2) {
					otono = dates.parse("2019-09-22-20:44");
					calcDateStatus(now, otono);
				} else if (i == 3) {
					invierno = dates.parse("2019-12-21-17:11");
					calcDateStatus(now, invierno);
				}
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	private void calcDateStatus(Date now, Date estacion) {
		int diasDif = 0;
		String res = "";
		if (changeEstacion == 0) {
			diasDif = (int) ((estacion.getTime() - now.getTime()) / 86400000);
			if (diasDif < 0)
				res = "Estamos en primavera";
			else
				res = "Faltan " + diasDif + " para primavera";
		} else if (changeEstacion == 1) {
			diasDif = (int) ((estacion.getTime() - now.getTime()) / 86400000);
			if (diasDif < 0)
				res = "Estamos en verano";
			else
				res = "Faltan " + diasDif + " para verano";
		} else if (changeEstacion == 2) {
			diasDif = (int) ((estacion.getTime() - now.getTime()) / 86400000);
			if (diasDif < 0)
				res = "Estamos en otoño";
			else
				res = "Faltan " + diasDif + " para otoño";
		} else if (changeEstacion == 3) {
			diasDif = (int) ((estacion.getTime() - now.getTime()) / 86400000);
			if (diasDif < 0)
				res = "Estamos en invierno";
			else
				res = "Faltan " + diasDif + " para invierno";
		}
		showDateStatus(now, changeEstacion++, res);

	}
}