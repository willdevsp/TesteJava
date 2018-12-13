package com.mollicait.controller;

import java.util.ArrayList;
import java.util.List;

import com.mollicait.model.Paciente;

public class PacientesController {

	public List<Paciente> cadastrarPacientes(){
		String entrada = "";
		List<Paciente> pacientes = new ArrayList<Paciente>();
		do {
			Paciente paciente = new Paciente();
			paciente.setNome("William");
			paciente.setSexo("Masculino");
			paciente.setAltura(1.72);
			paciente.setPeso(106.1);
			pacientes.add(paciente);
			System.out.println(paciente.getNome());
			System.out.println(pacientes);
			entrada = "fim";
			break;
		}while(entrada.equals("fim"));
		
		
		return pacientes;
	}

}
