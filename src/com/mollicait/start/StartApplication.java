package com.mollicait.start;

import com.mollicait.controller.PacienteFluentInterface;

public class StartApplication {
	public static void main(String[] args) {
		new PacienteFluentInterface()
		.cadastrarPacientes()
		.quantidadePacientes()
		.mediaIdadeHomens()
		.quantidadeMulheresAlturaPeso()
		.quantidadePessoasEntreIdades()
		.nomePacienteMaisVelho()
		.nomeMulherMaisBaixa()
		.calculaIMC();
	}

}
