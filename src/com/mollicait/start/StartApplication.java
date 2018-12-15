package com.mollicait.start;

import java.util.List;

import com.mollicait.controller.PacienteController;
import com.mollicait.model.Paciente;

public class StartApplication {
	public static void main(String[] args) {		
		execute();
	}
	
	public static void execute(){
		PacienteController pController = new PacienteController();
		List<Paciente> pacientes = pController.cadastrarPacientes();
		pController.quantidadePacientes(pacientes);	
		pController.mediaIdadeHomens(pacientes);
		pController.quantidadeMulheresAlturaPeso(pacientes);
		pController.quantidadePessoasEntreIdades(pacientes);
		pController.nomePacienteMaisVelho(pacientes);
		pController.nomeMulherMaisBaixa(pacientes);
		pController.calculaIMC(pacientes);		
			
	}
}
