package com.mollicait.start;

import com.mollicait.controller.PacienteFluentInterface;

public class StartApplication {
	public static void main(String[] args) {
		new PacienteFluentInterface()
		.cadastrarPacientes()
		.exibirQuantidadePacientes()
		.calcularMediaIdadeHomens()
		.calcularQuantidadeMulheresAlturaPeso()
		.calcularQuantidadePessoasEntreIdades()
		.exibirNomePacienteMaisVelho()
		.exibirNomeMulherMaisBaixa()
		.calcularImcDePacientes();
	}

}
