package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonasData {
	
	//Atriutos
	
	private ObservableList<PersonaDANE> personas;
	
	public PersonasData() {
		
		personas = FXCollections.observableArrayList();
		
	}
	
	public void addPersona(PersonaDANE persona) {
		
		personas.add(persona);
	}
	
	public void printData() {
		
		for(PersonaDANE persona : personas ) {
			
			System.out.println(persona.toString());
		}
	}

	public ObservableList<PersonaDANE> getData() {
		return personas;
	}

}
