package com.mollicait.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.mollicait.model.Paciente;
import com.mollicait.model.Sexo;

public class PacienteController {

	public List<Paciente> cadastrarPacientes() {
		String entrada = "";
		List<Paciente> pacientes = new ArrayList<Paciente>();
		System.out.println("====== Cadastro de pacientes ======\n\n");
		while (!entrada.equals("fim")) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Paciente paciente = new Paciente();

			try {
				System.out.print("Digite fim no nome para sair" + "\nDigite o nome do Paciente: ");
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

		return pacientes;
	}

	public void quantidadePacientes(List<Paciente> pacientes) {
		System.out.println(String.format("%s Pacientes cadastrados ", pacientes.size()));
		separador();
	}

	public void mediaIdadeHomens(List<Paciente> pacientes) {

		double media = 0;
		if (pacientes.isEmpty()) {
			System.out.println("não existem pacientes homens");
		} else {
			double idade = 0;
			long qttHomem = 0;
			for (Paciente paciente : pacientes) {
				if (paciente.getSexo() == Sexo.M) {
					idade += paciente.getIdade();
					qttHomem++;
				}
			}
			media = idade / qttHomem;
		}

		System.out.println(String.format("Média de idade dos pacientes homens %S anos", media));
		separador();
	}

	public void quantidadeMulheresAlturaPeso(List<Paciente> pacientes) {

		long qttMulheres = 0;
		if (pacientes.isEmpty()) {
			System.out.println("Não existem pacientes mulheres");
		} else {
			for (Paciente paciente : pacientes) {
				if (paciente.getSexo() == Sexo.F) {
					if ((paciente.getAltura() <= 1.70) && (paciente.getAltura() >= 1.60) && paciente.getPeso() > 70) {
						qttMulheres++;
					}

				}
			}
		}
		System.out.println(String.format("%s mulher(es) com Altura entre 1.60cm e 1.70cm com pe so maior que 70 quilos",
				qttMulheres));
		separador();
	}

	public void quantidadePessoasEntreIdades(List<Paciente> pacientes) {

		long qttPaciente = 0;
		if (pacientes.isEmpty()) {
			System.out.println("Não existem pacientes cadastrado");
		} else {
			for (Paciente paciente : pacientes) {
				if (paciente.getIdade() >= 18 && paciente.getIdade() <= 25) {
					qttPaciente++;
				}
			}
		}

		System.out.println(String.format("%s pacientes entre 18 e 25 anos", qttPaciente));
		separador();
	}

	public void nomePacienteMaisVelho(List<Paciente> pacientes) {
		String nomePacienteMaisVelho = null;
		if (pacientes.isEmpty()) {
			System.out.println("Não existem pacientes cadastrado");
		} else {
			int pacienteMaisVelho = 0;
			for (Paciente paciente : pacientes) {
				if (paciente.getIdade() > pacienteMaisVelho) {
					pacienteMaisVelho = paciente.getIdade();
					nomePacienteMaisVelho = paciente.getNome();
				}

			}
		}
		System.out.println(String.format("%s é o paciente mais velho", nomePacienteMaisVelho));
		separador();
	}

	public void nomeMulherMaisBaixa(List<Paciente> pacientes) {
		String nomeMulherMaisBaixa = null;
		List<Paciente> mulheresPacientes = pacientes.stream().filter(m ->m.getSexo() == Sexo.F)
				.collect(Collectors.toList());
		if (mulheresPacientes.size()== 0) {
			System.out.println("Não existem mulheres pacientes cadastrado");
		} else {
			Collections.sort(mulheresPacientes);
			nomeMulherMaisBaixa = mulheresPacientes.stream()
					.findFirst().get().getNome();
			System.out.println(String.format("%s é a paciente mais baixa", nomeMulherMaisBaixa));

		}
		separador();
	}

	public void calculaIMC(List<Paciente> pacientes) {
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
				System.out.println(String.format("A Media de peso de %s é %.2f sua situação é  %s ", paciente.getNome(),
						imc, msg));

			}
		}
		separador();
	}

	public void separador() {
		System.out.println("\n============================================================"
				+ "============================================================\n");
	}

}
