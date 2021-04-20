package com.ufcg.psoft.state.states;

import com.ufcg.psoft.state.model.Pessoa;
import com.ufcg.psoft.state.model.SituacaoCadastro;

public class NaoHabilitada extends SituacaoCadastro {
	@Override
	public void executa(Pessoa pessoa) {
		System.out.println("Pessoa não habilitada a receber a vacina!");
	}
	
	@Override
	public String toString() {
		return "Não habilitada a receber a vacina!";
	}
}