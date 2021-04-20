package com.ufcg.psoft.state.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GovernoMunicipal {
	private String nomeMunicipio;
	private Set<Pessoa> habitantes;
	private int idadeHabil;
	private Set<Profissao> profissoesHabeis;
	private Set<Comorbidade> comorbidadesHabeis;
	
	public GovernoMunicipal(String nomeMunicipio) {
		super();
		this.nomeMunicipio = nomeMunicipio.toUpperCase();
		this.habitantes = null;
		this.idadeHabil = 0;
		this.profissoesHabeis = null;
		this.comorbidadesHabeis = null;
	}
	
	public GovernoMunicipal(String nomeMunicipio, int idadeHabil, Set<Profissao> profissoesHabeis, Set<Comorbidade> comorbidadesHabeis) {
		super();
		this.nomeMunicipio = nomeMunicipio.toUpperCase();
		this.habitantes = new HashSet<Pessoa>();
		this.idadeHabil = idadeHabil;
		this.profissoesHabeis = profissoesHabeis;
		this.comorbidadesHabeis = comorbidadesHabeis;
	}
	
	public String getNomeMunicipio() {
		return nomeMunicipio;
	}

	public Pessoa getPessoaByCpf(long cpf) {
		Iterator<Pessoa> it = habitantes.iterator();
		
        while(it.hasNext()){
        	Pessoa pessoa = (Pessoa)it.next();
        	
        	if (pessoa.getCpf() == cpf) {
        		return pessoa;
        	}
        }
        
        return null;
	}
	
	public void registraPessoa(Pessoa pessoa) {
		habitantes.add(pessoa);
	}
	
	public void removePessoa(Pessoa pessoa) {
		habitantes.remove(pessoa);
	}

	public Set<Pessoa> getHabitantes() {
		return habitantes;
	}
	
	public int getIdadeHabil() {
		return idadeHabil;
	}

	public void setIdadeHabil(int idadeHabil) {
		this.idadeHabil = idadeHabil;
	}

	public Set<Profissao> getProfissoesHabeis() {
		return profissoesHabeis;
	}

	public void registraProfissaoHabeis(Profissao profissao) {
		profissoesHabeis.add(profissao);
	}
	
	public void removeProfissaoHabil(Profissao profissao) {
		profissoesHabeis.remove(profissao);
	}

	public Set<Comorbidade> getComorbidadesHabeis() {
		return comorbidadesHabeis;
	}

	public void registraComorbidadeHabil(Comorbidade comorbidade) {
		comorbidadesHabeis.add(comorbidade);
	}
	
	public void removeComorbidadeHabil(Comorbidade comorbidade) {
		comorbidadesHabeis.remove(comorbidade);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeMunicipio == null) ? 0 : nomeMunicipio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GovernoMunicipal other = (GovernoMunicipal) obj;
		if (nomeMunicipio == null) {
			if (other.nomeMunicipio != null)
				return false;
		} else if (!nomeMunicipio.equals(other.nomeMunicipio))
			return false;
		return true;
	}
	
	public void imprimeHabitantes(GovernoMunicipal gov) {
		String result = "";
		
		Iterator<Pessoa> it = habitantes.iterator();
		
		while(it.hasNext()) {
			Pessoa p = (Pessoa)it.next();
			
			result += (p.toString() + "\n");
		}
				
		System.out.println(result);
	}

	@Override
	public String toString() {
		return "Governo Municipal de " + nomeMunicipio + "[Idade habil = " + idadeHabil + ", profissões hábeis = " + profissoesHabeis + ", comorbidades habeis = " + comorbidadesHabeis + "]";
	}
}