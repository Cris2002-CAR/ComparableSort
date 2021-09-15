package ui;

import java.util.Collections;
import java.util.Comparator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.PersonaDANE;
import model.PersonasData;

public class MainWindow extends Stage {

	private TableView<PersonaDANE> personasTBV;

	private Button nombreBTN;

	private Button apellidoBTN;

	private Button edadBTN;

	private PersonasData datos = new PersonasData();

	public MainWindow() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
			
			personasTBV =(TableView) loader.getNamespace().get("personasTBV");
			nombreBTN =(Button) loader.getNamespace().get("nombreBTN");
			apellidoBTN =(Button) loader.getNamespace().get("apellidoBTN");
			edadBTN =(Button) loader.getNamespace().get("edadBTN");

			datos.addPersona(new PersonaDANE("Andres", "Andrade", 20, 1, 1000000));
			datos.addPersona(new PersonaDANE("Carlos", "Zapata", 21, 1, 1000000));
			datos.addPersona(new PersonaDANE("Carlos", "Molta", 21, 4, 1000000));
			datos.addPersona(new PersonaDANE("Sebastian", "Garcia", 30, 2, 1000000));
			datos.addPersona(new PersonaDANE("Antonio", "Garcia", 26, 2, 1000000));
			datos.addPersona(new PersonaDANE("Cristian", "Echeverry", 19, 2, 1000000));
			datos.addPersona(new PersonaDANE("Cristian", "Montaño", 19, 4, 1000000));
			datos.addPersona(new PersonaDANE("Valentina", "Henao", 22, 1, 1000000));

			TableColumn<PersonaDANE, String> nombre = new TableColumn<>("Nombre");
			TableColumn<PersonaDANE, String> apellido = new TableColumn<>("Apellido");
			TableColumn<PersonaDANE, Integer> edad = new TableColumn<>("Edad");

			nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
			apellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
			edad.setCellValueFactory(new PropertyValueFactory<>("edad"));
			
			personasTBV.getColumns().addAll(nombre, edad, apellido);
			
			personasTBV.setItems(datos.getData());

			init();

			/*
			 * long tic = System.nanoTime(); Collections.sort(datos.getData()); long toc =
			 * System.nanoTime();
			 * 
			 * System.out.println(">>Tiempro transcurriodo: " + (toc - tic));
			 * 
			 * datos.printData();
			 * 
			 * System.out.println("__________________________________________________\n");
			 * // Comparaciones alternativas
			 * 
			 * Comparator<PersonaDANE> comparadorA = (o1, o2) -> {
			 * 
			 * int value = o1.getNombre().compareTo(o2.getNombre());
			 * 
			 * return value; };
			 * 
			 * Collections.sort(datos.getData(), comparadorA);
			 * 
			 * datos.printData();
			 * 
			 * System.out.println("______________________________________________________\n"
			 * );
			 * 
			 * Collections.sort(datos.getData(), (o1, o2) -> {
			 * 
			 * return o1.getApellido().compareTo(o2.getApellido()); });
			 * 
			 * datos.printData();
			 */

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void init() {

		nombreBTN.setOnAction(event -> {

			Collections.sort(datos.getData(), (o1, o2) -> {

				return o1.getNombre().compareTo(o2.getNombre());
			});

		});

		apellidoBTN.setOnAction(event -> {

			Collections.sort(datos.getData(), (o1, o2) -> {

				return o1.getApellido().compareTo(o2.getApellido());
			});

		});

		edadBTN.setOnAction(event -> {

			Collections.sort(datos.getData(), (o1, o2) -> {

				return o1.getEdad()-o2.getEdad();
			});

		});

	}
}
