package com.mollicait.controller;
import java.util.List;

import com.mollicait.model.Paciente;
public interface PacienteInterface {
	PacienteController cadastrarPacientes();
	PacienteController quantidadePacientes(List<Paciente> pacientes);	
	PacienteController mediaIdadeHomens(List<Paciente> pacientes);
	PacienteController quantidadeMulheresAlturaPeso(List<Paciente> pacientes);
	PacienteController quantidadePessoasEntreIdades(List<Paciente> pacientes);
	PacienteController nomePacienteMaisVelho(List<Paciente> pacientes);
	PacienteController nomeMulherMaisBaixa(List<Paciente> pacientes);
	PacienteController calculaIMC(List<Paciente> pacientes);		
		
}
