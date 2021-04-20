package com.ufcg.psoft.state.states;

import com.ufcg.psoft.state.model.Pessoa;
import com.ufcg.psoft.state.model.SituacaoCadastro;

public class HabilitadaSegundaDose extends SituacaoCadastro {
	@Override
	public void executa(Pessoa pessoa) {
		System.out.println("Vacinação completa!");
		pessoa.setSituacaoCadastro(new VacinacaoCompleta());
	}
	
	@Override
	public String toString() {
		return "Segunda dose aplicada!";
	}
}