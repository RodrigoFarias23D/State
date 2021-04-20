package com.ufcg.psoft.state.states;

import com.ufcg.psoft.state.model.Pessoa;
import com.ufcg.psoft.state.model.SituacaoCadastro;

public class NaoHabilitada extends SituacaoCadastro {
	@Override
	public void executa(Pessoa pessoa) {
		System.out.println("Pessoa n�o habilitada a receber a vacina!");
	}
	
	@Override
	public String toString() {
		return "N�o habilitada a receber a vacina!";
	}
}