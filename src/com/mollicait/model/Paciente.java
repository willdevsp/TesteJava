package com.mollicait.model;

public class Paciente {
	private String nome;
	private Sexo sexo;
	private int idade;
	private double peso;
	private double altura;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	@Override
	public String toString() {
		return "Paciente [nome=" + nome + ", sexo=" + sexo + ", idade=" + idade + ", peso=" + peso + ", altura="
				+ altura + "]";
	}
	
}
