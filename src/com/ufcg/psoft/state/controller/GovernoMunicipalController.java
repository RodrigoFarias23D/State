package com.ufcg.psoft.state.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.ufcg.psoft.state.model.Comorbidade;
import com.ufcg.psoft.state.model.GovernoMunicipal;
import com.ufcg.psoft.state.model.Pessoa;
import com.ufcg.psoft.state.model.Profissao;
import com.ufcg.psoft.state.states.HabilitadaPrimeiraDose;

public class GovernoMunicipalController {
	Scanner scanner = new Scanner(System.in);
	PessoaController pessoaController = new PessoaController();
	
	public GovernoMunicipal criaGoverno() {
		System.out.print("Nome do município: ");
		String nomeMunicipio = scanner.nextLine();
			
		System.out.print("Idade mínima hábil a se vacinar: ");
		int idadeHabil = scanner.nextInt();
			
		System.out.println("Profissões hábeis a se vacinar");
		System.out.println("- Digite uma a uma, pressionando Enter após cada");
		System.out.println("- Para encerrar a lista de profissões, digite f e pressione Enter");
		Set<Profissao> profissoes = getProfissoes();
			
		System.out.println("Comorbidades hábeis a se vacinar");
		System.out.println("- Digite uma a uma, pressionando Enter após cada");
		System.out.println("- Para encerrar a lista de comorbidades, digite f e pressione Enter");
		Set<Comorbidade> comorbidades = getComorbidades();
		
		System.out.println("-----------");
			
		return new GovernoMunicipal(nomeMunicipio, idadeHabil, profissoes, comorbidades);
	}
	
	private Set<Profissao> getProfissoes() {
		Set<Profissao> profissoes = new HashSet<Profissao>();
			
		String in = scanner.nextLine();
			
		while (!in.toLowerCase().equals("f")) {
			profissoes.add(new Profissao(in));
			in = scanner.nextLine();
		}
			
		return profissoes;
	}
	
	private Set<Comorbidade> getComorbidades() {
		Set<Comorbidade> comorbidades = new HashSet<Comorbidade>();
		String in = "";
			
		in = scanner.nextLine();
			
		while (!in.toLowerCase().equals("f")) {
			comorbidades.add(new Comorbidade(in));
			in = scanner.nextLine();
		}
			
		return comorbidades;
	}
	
	
	public void imprimeHabitantes(GovernoMunicipal gov) {
		gov.imprimeHabitantes(gov);
	}
	
	public void registraPessoa(GovernoMunicipal gov) {
		Pessoa pessoa = pessoaController.criaPessoa();
		
		gov.registraPessoa(pessoa);
		
		if (hasIdadeHabil(gov, pessoa.getIdade()) || hasProfissaoHabil(gov, pessoa.getProfissao()) || hasComorbidadeHabil(gov, pessoa.getComorbidades())) {
			pessoa.setSituacaoCadastro(new HabilitadaPrimeiraDose());
		}
	}
	
	public void confirmaSituacaoVacina(GovernoMunicipal gov, long cpf) {
		Pessoa pessoa = gov.getPessoaByCpf(cpf);
		
		pessoaController.confirmaSituacaoVacina(pessoa);
	}
	
	public void alteraCadastroPessoa(GovernoMunicipal gov, long cpf) {
		Pessoa pessoa = gov.getPessoaByCpf(cpf);
		
		if (pessoa == null) {
			System.out.println("O CPF digitado não está no sistema ou não pertence a este governo!");
		} else {
			pessoaController.alteraCadastroPessoa(pessoa);
		}
	}
	
	public boolean existsPessoa(GovernoMunicipal gov, long cpf) {
		if (gov.getPessoaByCpf(cpf) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public void removePessoa(GovernoMunicipal gov, long cpf) {
		Pessoa pessoa = gov.getPessoaByCpf(cpf);
		
		if (pessoa == null) {
			System.out.println("O CPF digitado não está no sistema ou não pertence a este governo!");
		} else {
			gov.removePessoa(pessoa);
		}
	}
	
	public boolean hasIdadeHabil(GovernoMunicipal gov, int idade) {
		return idade >=  gov.getIdadeHabil();
	}
	
	public boolean hasProfissaoHabil(GovernoMunicipal gov, Profissao profissao) {
		return gov.getProfissoesHabeis().contains(profissao);
	}
	
	public boolean hasComorbidadeHabil(GovernoMunicipal gov, Set<Comorbidade> comorbidades) {
		Iterator<Comorbidade> it = comorbidades.iterator();
		
        while(it.hasNext()){
        	Comorbidade comorbidade = (Comorbidade)it.next();
        	
        	if (gov.getComorbidadesHabeis().contains(comorbidade)) {
        		return true;
        	}
        }
        
        return false;
	}

	public void vacina(GovernoMunicipal gov, long cpf) {
		Pessoa pessoa = gov.getPessoaByCpf(cpf);
		
		if (pessoa == null) {
			System.out.println("O CPF digitado não está no sistema ou não pertence a este governo!");
		} else {
			pessoaController.vacina(pessoa);
		}
	}
}