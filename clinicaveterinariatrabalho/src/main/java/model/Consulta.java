package model;

public class Consulta {
	private int id;
	private String tipo;
	private float valor;
	private float valorDesconto;
	private Agendamento agendamento;
	
	 public Consulta(String tipo, Float valor, Float valorDesconto, Agendamento agendamento) {
	    	super();
	        this.tipo = tipo;
	        this.valor = valor;
	        this.valorDesconto = valorDesconto;
	        this.agendamento = agendamento;
	    }
	 public Consulta() {
		 
	 }
	 
	 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	 
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public float getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(float valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	

	 public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
	
}
