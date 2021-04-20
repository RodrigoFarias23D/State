package com.ufcg.psoft.state.model;

import java.util.Set;

import com.ufcg.psoft.state.states.NaoHabilitada;

public class Pessoa {
	private String nome;
	private long cpf;
	private int idade;
	private String endereco;
	private long numCartaoSus;
	private String email;
	private String telefone;
	private Profissao profissao;
	private Set<Comorbidade> comorbidades;
	
	private SituacaoCadastro situacaoCadastro;

	public Pessoa(String nome, long cpf, int idade, String endereco, long numCartaoSus, String email, String telefone, Profissao profissao, Set<Comorbidade> comorbidades) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.endereco = endereco;
		this.numCartaoSus = numCartaoSus;
		this.email = email;
		this.telefone = telefone;
		this.profissao = profissao;
		this.comorbidades = comorbidades;
		this.situacaoCadastro = new NaoHabilitada();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public long getNumCartaoSus() {
		return numCartaoSus;
	}

	public void setNumCartaoSus(long numCartaoSus) {
		this.numCartaoSus = numCartaoSus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	public long getCpf() {
		return cpf;
	}

	public Set<Comorbidade> getComorbidades() {
		return comorbidades;
	}
	
	/*public Comorbidade getComorbidadeByNome(String nome) {
		Iterator<Comorbidade> it = comorbidades.iterator();
		
        while(it.hasNext()){
        	Comorbidade comorbidade = (Comorbidade)it.next();
        	
        	if (comorbidade.getNome() == nome.toUpperCase()) {
        		return comorbidade;
        	}
        }
        
        return null;
	}*/
	
	public void registraComorbidade(Comorbidade comorbidade) {
		comorbidades.add(comorbidade);
	}
	
	public void removeComorbidade(Comorbidade comorbidade) {
		comorbidades.remove(comorbidade);
	}

	public SituacaoCadastro getSituacaoCadastro() {
		return situacaoCadastro;
	}

	public void setSituacaoCadastro(SituacaoCadastro situacaoCadastro) {
		this.situacaoCadastro = situacaoCadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cpf ^ (cpf >>> 32));
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
		Pessoa other = (Pessoa) obj;
		if (cpf != other.cpf)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome + ", CPF = " + cpf + " | Idade = " + idade + " | Endereço = " + endereco + " | Email = " + email + " | Telefone = " + telefone + " | Cartão do Sus = " + numCartaoSus + " | Profissão = " + profissao + " | Comorbidades = " + comorbidades + " | Situacao do Cadastro = " + situacaoCadastro.toString();
	}
}