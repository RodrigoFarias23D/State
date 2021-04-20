package com.ufcg.psoft.state.states;

import java.util.Scanner;

import com.ufcg.psoft.state.model.Pessoa;
import com.ufcg.psoft.state.model.SituacaoCadastro;

public class PrimeiraDose extends SituacaoCadastro {
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void executa(Pessoa pessoa) {
		System.out.print("Quantos dias fazem da primeira dose: ");
		
		if (scanner.nextInt() >= 20) {
			System.out.println("Segunda dose aplicada!");
			pessoa.setSituacaoCadastro(new HabilitadaSegundaDose());
		} else {
			System.out.println("Ainda não hábil a tomar a segunda dose!");
		}
	}
	
	@Override
	public String toString() {
		return "Primeira dose aplicada!";
	}
}