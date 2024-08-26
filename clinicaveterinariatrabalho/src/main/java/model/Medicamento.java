package model;

public class Medicamento {

	private int id;
	private float concentracao;
	private Consulta consulta;
	
	// Construtor
    public Medicamento(Float concentracao, Consulta consulta) {
    	super();
        this.concentracao = concentracao;
        this.consulta = consulta;
    }
    
    public Medicamento() {
		 
	 }
	
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public float getConcentracao() {
		return concentracao;
	}

	public void setConcentracao(float concentracao) {
		this.concentracao = concentracao;
	}
	
	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
}
