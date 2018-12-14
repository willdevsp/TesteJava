package com.mollicait.start;

import java.util.ArrayList;
import java.util.List;

import com.mollicait.controller.PacientesController;
import com.mollicait.model.Paciente;
import com.mollicait.model.Sexo;

public class StartApplication {
	public static void main(String[] args) {
		
		execute();
	}
	
	public static void execute(){
		PacientesController pacientesController = new PacientesController();
/*			List<Paciente> pacientes = pacientesController.cadastrarPacientes();
			pacientesController.quantidadePacientes(pacientes);	
			pacientesController.mediaIdadeHomens(pacientes);
			pacientesController.quantidadeMulheresAlturaPeso(pacientes);
			pacientesController.quantidadePessoasEntreIdades(pacientes);
			pacientesController.nomePacienteMaisVelho(pacientes);
*/
		
		List<Paciente> pacientes = new ArrayList<Paciente>();
		Paciente p1 = new Paciente();
		p1.setNome("nome5");
		p1.setAltura(1.67);
		p1.setIdade(20);
		p1.setPeso(90.0);
		p1.setSexo(Sexo.F);
		
		Paciente p2 = new Paciente();
		p2.setNome("fulano");
		p2.setAltura(1.7);
		p2.setIdade(40);
		p2.setPeso(102);
		p2.setSexo(Sexo.M);
		
		Paciente p3 = new Paciente();
		p3.setNome("Alegra");
		p3.setAltura(1.5);
		p3.setIdade(32);
		p3.setPeso(40.0);
		p3.setSexo(Sexo.F);
		Paciente p4 = new Paciente();
		p4.setNome("Master Chef");
		p4.setAltura(1.8);
		p4.setIdade(43);
		p4.setPeso(75.0);
		p4.setSexo(Sexo.M);
		
		Paciente p5 = new Paciente();
		p5.setNome("Miranda");
		p5.setAltura(1.55);
		p5.setIdade(19);
		p5.setPeso(58.0);
		p5.setSexo(Sexo.F);
		pacientes.add(p1);
		pacientes.add(p2);
		pacientes.add(p3);
		pacientes.add(p4);
		pacientes.add(p5);
		pacientesController.quantidadePacientes(pacientes);	
		pacientesController.mediaIdadeHomens(pacientes);
		pacientesController.quantidadeMulheresAlturaPeso(pacientes);
		pacientesController.quantidadePessoasEntreIdades(pacientes);
		pacientesController.nomePacienteMaisVelho(pacientes);
		pacientesController.calculaIMC(pacientes);
			
	}
}
