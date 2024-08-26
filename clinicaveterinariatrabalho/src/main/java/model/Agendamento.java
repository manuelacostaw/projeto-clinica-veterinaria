package model;


import java.time.LocalDate;
import java.time.LocalTime;


public class Agendamento {
	private int id;
	private LocalDate data;
	private LocalTime hora;
	private Animal animal;
	
	 public Agendamento(LocalDate data, LocalTime hora, Animal animal) {
	    	super();
	        this.data = data;
	        this.hora = hora;
	        this.animal = animal;
	    }
	 
	 public Agendamento(LocalDate data, LocalTime hora) {
	        this.data = data;
	        this.hora = hora;
	    }
	 
	public Agendamento() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate date) {
		this.data = date;
	}
	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
		

	//precisa mesmo
	public void add(Agendamento agendamento) {
		// TODO Auto-generated method stub
		
	}
	
}
