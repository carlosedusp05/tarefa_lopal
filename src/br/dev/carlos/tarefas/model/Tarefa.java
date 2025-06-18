package br.dev.carlos.tarefas.model;

import java.time.LocalDate;

import br.dev.carlos.tarefas.utils.Utils;

public class Tarefa {
	
	private String codigo;
	private String nome;
	private String descricao;
	private String dataInicio;
	private int prazo;
	private LocalDate dataPrevisaoDeEntrega;
	private LocalDate dataEntrega;
	private String status;
	private String responsavel;
	
	public Tarefa() {
		this.codigo = Utils.gerarUUUID8();
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void Codigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Tarefa (String nome) {
		//System.out.println("Criando uma tarefa: " + nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String string) {
		this.dataInicio = string;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public LocalDate getDataPrevisaoDeEntrega() {
		return dataPrevisaoDeEntrega;
	}

	public void setDataPrevisaoDeEntrega(LocalDate dataPrevisaoDeEntrega) {
		this.dataPrevisaoDeEntrega = dataPrevisaoDeEntrega;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String string) {
		this.status = string;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String string) {
		this.responsavel = string;
	}
	
	public String toString() {
		return codigo + "," + nome + "," + descricao + "," + dataInicio + "," + prazo + ","  + dataPrevisaoDeEntrega + "\n" + status + "," + responsavel; 
	}

}
