package com.mollicait.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mollicait.model.Paciente;
import com.mollicait.model.Sexo;

public class PacientesController {

	public List<Paciente> cadastrarPacientes() {
		String entrada = "";
		List<Paciente> pacientes = new ArrayList<Paciente>();
		System.out.println("====== Cadastro de pacientes ======\n\n");
		while (!entrada.equals("fim")) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Paciente paciente = new Paciente();

			try {
				System.out.print("Digite fim no nome para sair"
						+ "\nDigite o nome do Paciente: ");
				String nome = br.readLine();
				entrada=nome;
				if (nome.equalsIgnoreCase("fim"))
					break;
				System.out.print("Digite M para Sexo Masculino ou F para Sexo Feminino: ");
				String sexo = br.readLine();
				System.out.println("Digite a idade do paciente");
				String idade = br.readLine();
				System.out.print("Digite a altura do paciente: ");
				String altura = br.readLine();
				System.out.print("Digite o peso do paciente: ");
				String peso = br.readLine();

				paciente.setNome(nome);
				paciente.setSexo(Sexo.valueOf(sexo));
				paciente.setIdade(Integer.parseInt(idade));
				paciente.setAltura(Double.parseDouble(altura));
				paciente.setPeso(Double.parseDouble(peso));
				System.out.println("Paciente : "+paciente.getNome()+" Cadastrado com sucesso");

			} catch (IOException e) {
				e.printStackTrace();
			}
			pacientes.add(paciente);

		}

		separador();

		return pacientes;
	}
	
	public void quantidadePacientes(List<Paciente> pacientes){
		System.out.println("Quantidade de pacientes cadastrados: "+pacientes.size());		
		separador();
	}
	
	public void mediaIdadeHomens(List<Paciente> pacientes){		
		double media = 0;
		if(pacientes.isEmpty()){
			System.out.println("não existem pacientes homens");
		}else{
			double idade = 0;
			long qttHomem = 0;
			for(Paciente paciente: pacientes){				
				if(paciente.getSexo() == Sexo.M){
					 idade+= paciente.getIdade();
					 qttHomem++;
				}								
			}
			media = idade/qttHomem;
		}
		
		System.out.println("A Media de idade dos homens é de: "+media+" anos");
		separador();
	}
	
	public void quantidadeMulheresAlturaPeso(List<Paciente> pacientes){
		long qttMulheres = 0;
		if(pacientes.isEmpty()){
			System.out.println("NÃ£o existem pacientes mulheres");
		}else{
			for(Paciente paciente: pacientes){
				if(paciente.getSexo() == Sexo.F){
					if((paciente.getAltura()<=1.70) && (paciente.getAltura() >= 1.60) && paciente.getPeso()>70){
						qttMulheres++;					
					}
					
				}
			}
		}		
		System.out.println("A quantidade de mulheres com altura entre 1,60 e 1,70 e acima de 70 kilos é de: "+ qttMulheres);
		separador();
	}
	
	public void quantidadePessoasEntreIdades(List<Paciente> pacientes){
		long qttPaciente = 0;
		if(pacientes.isEmpty()){
			System.out.println("NÃ£o existem pacientes cadastrado");
		}else{ 
			for(Paciente paciente: pacientes){
				if(paciente.getIdade()>=18 && paciente.getIdade()<=25){
					qttPaciente++;
				}
			}
		}
		System.out.println("A quantidade de pacientes entre 18 e 25 anos Ã© de : "+qttPaciente);
		separador();
	}
	
	public void nomePacienteMaisVelho(List<Paciente> pacientes) {
		String nomePacienteMaisVelho = null;
		if(pacientes.isEmpty()) {
			System.out.println("Não existem pacientes cadastrado");
		}else {
			int pacienteMaisVelho = 0;
			for(Paciente paciente: pacientes) {				
				if(paciente.getIdade()>pacienteMaisVelho) {
					pacienteMaisVelho = paciente.getIdade();
					nomePacienteMaisVelho = paciente.getNome();
				}
				 
			}
		}
		System.out.println("O paciente mais velho se chama: " + nomePacienteMaisVelho);
		separador();
	}
	
	public void nomeMulherMaisBaixa(List<Paciente> pacientes) {
		String nomeMulherMaisBaixa = null;
		if(pacientes.isEmpty()) {
			System.out.println("Não existem pacientes cadastrado");
		}else {
			Collections.sort(pacientes);
			nomeMulherMaisBaixa=pacientes.stream().findFirst().get().getNome();
			
		}
		System.out.println(String.format("A paciente mais baixa se chama: %s", nomeMulherMaisBaixa));
		separador();
	}
	
	
	public void calculaIMC(List<Paciente> pacientes) {
		
		if(pacientes.isEmpty()) {
			System.out.println("Não existem pacientes cadastrado");
		}else {
			for(Paciente paciente: pacientes) {
				double altura = paciente.getAltura();
				double peso = paciente.getPeso();
				double imc = peso/(altura*altura);
				String msg = null;
				if(imc < 18) {
					msg = "abaixo do peso";
				}else if((imc>=18) && (imc <=25)) {
					msg = "peso normal";
				}else {
					msg = "Obeso";
				}
				System.out.println(String.format("A Media de peso de %s é %.2f sua situação é  %s ", paciente.getNome(), imc,msg));
				
			}
		}
		separador();
	}
	
	public void separador (){
		System.out.println("\n============================================================"
				+ "============================================================\n");
	}
	
}
