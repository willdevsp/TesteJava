package com.mollicait.start;

import java.util.List;

import com.mollicait.controller.PacienteController;
import com.mollicait.model.Paciente;

public class StartApplication {
	public static void main(String[] args) {		
		execute();
	}
	
	public static void execute(){
		PacienteController pacientesController = new PacienteController();
			List<Paciente> pacientes = pacientesController.cadastrarPacientes();	
			pacientesController.quantidadePacientes(pacientes);	
			pacientesController.mediaIdadeHomens(pacientes);
			pacientesController.quantidadeMulheresAlturaPeso(pacientes);
			pacientesController.quantidadePessoasEntreIdades(pacientes);
			pacientesController.nomePacienteMaisVelho(pacientes);
			pacientesController.nomeMulherMaisBaixa(pacientes);
			pacientesController.calculaIMC(pacientes);
			System.out.println("Fim . . .");
	}
}
