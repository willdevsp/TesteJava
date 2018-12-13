package com.mollicait.model;

public class Paciente {
	private String nome;
	private String sexo;
	private double peso;
	private double altura;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
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
		return "Paciente [nome=" + nome + ", sexo=" + sexo + ", peso=" + peso + ", altura=" + altura + "]";
	}
	
}
