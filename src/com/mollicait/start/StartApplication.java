package com.mollicait.start;

import java.util.List;

import com.mollicait.controller.PacientesController;
import com.mollicait.model.Paciente;

public class StartApplication {
	public static void main(String[] args) {
		
		execute();
	}
	
	public static void execute(){
		PacientesController pacientesController = new PacientesController();
			List<Paciente> p = pacientesController.cadastrarPacientes();
			pacientesController.quantidadePacientes(p);	
			pacientesController.mediaIdadeHomens(p);
			
	}
}
