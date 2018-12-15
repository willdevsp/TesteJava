package com.mollicait.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mollicait.model.Paciente;
import com.mollicait.model.Sexo;

public class PacienteFluentInterface {
	List<Paciente> pacientes;
	public PacienteFluentInterface() {
		pacientes = new ArrayList<Paciente>();
	}
	
	public PacienteFluentInterface cadastrarPacientes() {
		String entrada = "";
		pacientes = new ArrayList<Paciente>();
		System.out.println("====== Cadastro de pacientes ======\n\n");
		while (!entrada.equals("fim")) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Paciente paciente = new Paciente();

			try {
				System.out.print("***Digite fim no nome para sair***\n" + "\nDigite o nome do Paciente: ");
				String nome = br.readLine();
				entrada = nome;
				if (nome.equalsIgnoreCase("fim"))
					break;
				System.out.print("Digite M para Sexo Masculino ou F para Sexo Feminino: ");
				String sexo = br.readLine();
				System.out.print("Digite a idade do paciente: ");
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
				System.out.println(String.format("Paciente %s cadastrado com sucesso", paciente.getNome()));

			} catch (IOException e) {
				e.printStackTrace();
			}
			pacientes.add(paciente);

		}

		separador();

		return this;
	}

	public PacienteFluentInterface exibirQuantidadePacientes() {
		System.out.println(String.format("%s Paciente(s) cadastrados ", pacientes.size()));
		separador();
		return this;
	}

	public PacienteFluentInterface calcularMediaIdadeHomens() {
		double mediaIdade = 0;
		Supplier<Stream<Paciente>> homens = () -> pacientes.stream().filter(p -> p.getSexo()== Sexo.M);
		long qttHomens = homens.get().count();
		if(qttHomens == 0) {
			System.out.println("Não existem pacientes homens cadastrados");
		}else {
			mediaIdade = homens.get().mapToDouble(Paciente::getIdade).average().getAsDouble();
			System.out.println(String.format("Média de idade dos pacientes homens %S anos", mediaIdade));
		}
		
		separador();
		return this;
	}

	public PacienteFluentInterface calcularQuantidadeMulheresAlturaPeso() {

		List<Paciente> pacientesFilter = new ArrayList<Paciente>();
		if (pacientes.isEmpty()) {
			System.out.println("Não existem pacientes mulheres");
		} else {
			pacientesFilter = pacientes.stream()
					.filter(m->m.getSexo() == Sexo.F)
					.filter(m-> m.getAltura() >= 1.60)
					.filter(m -> m.getAltura()<=1.70)
					.filter(m -> m.getPeso()>70)
					.collect(Collectors.toList());
			System.out.println(String.format("%s mulher(es) com Altura entre 1.60cm e 1.70cm com peso maior que 70 quilos",
					pacientesFilter.size()));
		}

		separador();
		return this;
	}

	public PacienteFluentInterface calcularQuantidadePessoasEntreIdades() {

		List<Paciente> pacientesFilter = new ArrayList<Paciente>();
		if (pacientes.isEmpty()) {
			System.out.println("Não existem pacientes cadastrado");
		} else {
			pacientesFilter = pacientes.stream()
					.filter(p -> p.getIdade() >= 18)
					.filter(p ->p.getIdade()>=25)
					.collect(Collectors.toList());
			System.out.println(String.format("%s pacientes entre 18 e 25 anos", pacientesFilter.size()));
		}		

		
		separador();
		return this;
	}

	public PacienteFluentInterface exibirNomePacienteMaisVelho() {
		Paciente pacienteComparator = new Paciente();
		if (pacientes.isEmpty()) {
			System.out.println("Não existem pacientes cadastrado");
		} else {
			Comparator<Paciente> comparator = Comparator.comparing(Paciente::getIdade);
			pacienteComparator = pacientes.stream().max(comparator).get();
			System.out.println(String.format("%s é o paciente mais velho(a)",pacienteComparator.getNome()));
		}
		
		separador();
		return this;
	}

	public PacienteFluentInterface exibirNomeMulherMaisBaixa() {		
			Comparator<Paciente> comparator = Comparator.comparing(Paciente::getAltura);
			Supplier<Stream<Paciente>> mulheresPaciente = () -> pacientes.stream().filter(p -> p.getSexo()== Sexo.F);			
			if(mulheresPaciente.get().count() != 0) {
				Paciente mulherMaisBaixa = new Paciente();
				mulherMaisBaixa = mulheresPaciente.get().collect(Collectors.toList()).stream().min(comparator).get();
				System.out.println(String.format("%s é a paciente mais baixa ", mulherMaisBaixa.getNome()));
				separador();
			}
		return this;
	}

	public PacienteFluentInterface calcularImcDePacientes() {
		if (pacientes.isEmpty()) {
			System.out.println("Não existem pacientes cadastrado");
		} else {
			for (Paciente paciente : pacientes) {
				double altura = paciente.getAltura();
				double peso = paciente.getPeso();
				double imc = peso / (altura * altura);
				String msg = null;
				if (imc < 18) {
					msg = "abaixo do peso";
				} else if ((imc >= 18) && (imc <= 25)) {
					msg = "peso normal";
				} else {
					msg = "Obeso";
				}
				System.out.println(String.format("A Media de peso de %s é %.2f sua situação é  %s \n", paciente.getNome(),
						imc, msg));

			}
			double mediaIMC = pacientes.stream().mapToDouble(a ->a.getPeso()/(a.getAltura()*a.getAltura())).average().getAsDouble();
			System.out.println(String.format("%.2f é media do IMC (indice de massa corporal) de todos os pacientes",mediaIMC));
		}
		
		separador();
		return this;
	}

	public void separador() {
		System.out.println("\n============================================================"
				+ "============================================================\n");
	}

}
