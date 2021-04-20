package com.ufcg.psoft.state.states;

import com.ufcg.psoft.state.model.Pessoa;
import com.ufcg.psoft.state.model.SituacaoCadastro;

public class VacinacaoCompleta extends SituacaoCadastro {
	@Override
	public void executa(Pessoa pessoa) {
		System.out.println("Vacina��o completa!");
	}
	
	@Override
	public String toString() {
		return "Vacina��o completa!";
	}
}