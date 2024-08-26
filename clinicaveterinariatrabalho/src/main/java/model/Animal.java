package model;

public class Animal {
	private int id;
	private String nome;
	private String especie;
	private String raca;
	private float peso;
	private int idade;
	private String genero;
	private Tutor tutor;
	
	 public Animal(String nome, String especie, String raca, float peso, int idade, String genero, Tutor tutor) {
	    	super();
	        this.nome = nome;
	        this.especie = especie;
	        this.raca = raca;
	        this.peso = peso;
	        this.idade = idade;
	        this.genero = genero;
	        this.tutor = tutor;
	    }
	
	 public Animal() {
		 
	}

	public Animal(int animalId) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String string) {
		this.genero = string;
	}
	
	 public Tutor getTutor() {
			return tutor;
		}

		public void setTutor(Tutor tutor) {
			this.tutor = tutor;
		}
	
	
}
