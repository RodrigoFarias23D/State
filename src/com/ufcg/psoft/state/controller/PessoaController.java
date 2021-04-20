package com.ufcg.psoft.state.controller;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.ufcg.psoft.state.model.Comorbidade;
import com.ufcg.psoft.state.model.Pessoa;
import com.ufcg.psoft.state.model.Profissao;

public class PessoaController {
	Scanner scanner = new Scanner(System.in);
	
	public Pessoa criaPessoa() {
		System.out.print("Nome Completo: ");
		String nome = scanner.nextLine();
			
		System.out.print("CPF: ");
		long cpf = scanner.nextLong();
		scanner.nextLine();
		
		System.out.print("Idade: ");
		int idade = scanner.nextInt();
		scanner.nextLine();
			
		System.out.print("Endereco: ");
		String endereco = scanner.nextLine();
			
		System.out.print("Nº do Cartão do SUS: ");
		long numCartaoSus = scanner.nextLong();
		scanner.nextLine();
			
		System.out.print("Email: ");
		String email = scanner.nextLine();
			
		System.out.print("Telefone: ");
		String telefone = scanner.nextLine();
			
		System.out.print("Profissão: ");
		Profissao profissao = new Profissao(scanner.nextLine());
			
		System.out.println("Comorbidades");
		System.out.println("- Digite uma a uma, pressionando Enter após cada");
		System.out.println("- Para encerrar a lista de comorbidades, digite f e pressione Enter");
		Set<Comorbidade> comorbidades = getComorbidades();

		System.out.println("-----------");
			
		return new Pessoa(nome, cpf, idade, endereco, numCartaoSus, email, telefone, profissao, comorbidades);
	}
	
	private Set<Comorbidade> getComorbidades() {
		Set<Comorbidade> comorbidades = new HashSet<Comorbidade>();
			
		String in = scanner.nextLine();
			
		while (!in.toLowerCase().equals("f")) {
			comorbidades.add(new Comorbidade(in));
			in = scanner.nextLine();
		}
			
		return comorbidades;
	}
	
	public void alteraCadastroPessoa(Pessoa pessoa) {
		System.out.print("Nome Completo: ");
		String nome = scanner.nextLine();
		
		System.out.print("Idade: ");
		int idade = scanner.nextInt();
		scanner.nextLine();
			
		System.out.print("Endereco: ");
		String endereco = scanner.nextLine();
			
		System.out.print("Nº do Cartão do SUS: ");
		long numCartaoSus = scanner.nextLong();
		scanner.nextLine();
			
		System.out.print("Email: ");
		String email = scanner.nextLine();
			
		System.out.print("Telefone: ");
		String telefone = scanner.nextLine();
			
		System.out.print("Profissão: ");
		Profissao profissao = new Profissao(scanner.nextLine());
		
		pessoa.setNome(nome);
		pessoa.setIdade(idade);
		pessoa.setEndereco(endereco);
		pessoa.setNumCartaoSus(numCartaoSus);
		pessoa.setEmail(email);
		pessoa.setTelefone(telefone);
		pessoa.setProfissao(profissao);
		atualizarComorbidades(pessoa);
	}

	private void atualizarComorbidades(Pessoa pessoa) {
		System.out.println("Deseja atualizar as comobidades? (s / n)");
		String resp = scanner.nextLine();
		
		while (resp.toLowerCase().equals("s")) {
			System.out.println("Adicionar ou remover? (a / r)");
			
			resp = scanner.nextLine();
			
			if (resp.toLowerCase().equals("a") | resp.toLowerCase().equals("r")) {
				System.out.print("Comorbidade: ");
				String comorbidade = scanner.nextLine();
				
				if (resp.toLowerCase().equals("a")) {
					pessoa.registraComorbidade(new Comorbidade(comorbidade));
				} else {
					pessoa.removeComorbidade(new Comorbidade(comorbidade));
				}
			} else {
				System.out.println("Atualização de comorbidades cancelada!");
			}
			
			System.out.println("----- Atualizado! -----");
			System.out.println("Deseja continuar atualizando as comobidades? (s / n)");
			resp = scanner.nextLine();
		}
	}

	public void confirmaSituacaoVacina(Pessoa pessoa) {
		pessoa.getSituacaoCadastro().executa(pessoa);
	}

	public void vacina(Pessoa pessoa) {
		pessoa.getSituacaoCadastro().executa(pessoa);
	}
}