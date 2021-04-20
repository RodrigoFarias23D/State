package com.ufcg.psoft.state.states;

import com.ufcg.psoft.state.model.Pessoa;
import com.ufcg.psoft.state.model.SituacaoCadastro;

public class HabilitadaPrimeiraDose extends SituacaoCadastro {
	@Override
	public void executa(Pessoa pessoa) {
		System.out.println("Primeira dose aplicada!");
		pessoa.setSituacaoCadastro(new PrimeiraDose());
	}
	
	@Override
	public String toString() {
		return "Habilitada a receber a primeira dose!";
	}
}