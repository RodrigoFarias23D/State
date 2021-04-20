import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ufcg.psoft.state.controller.GovernoMunicipalController;
import com.ufcg.psoft.state.model.GovernoMunicipal;

public class SistemaDeVacinacao {
	static Scanner scanner = new Scanner(System.in);
	static List<GovernoMunicipal> governos = new ArrayList<GovernoMunicipal>();
	static GovernoMunicipalController govController = new GovernoMunicipalController();
	
	public static void main(String[] args) {
		imprimeMenuPrincipal();
		int op = scanner.nextInt();
		scanner.nextLine();
		
		while (op != 10) {
			switch (op) {
				case 1: governos.add(govController.criaGoverno());
						break;
				case 2: listaGovernos();
						break;		
				case 3: {
					System.out.println("");
					System.out.print("Nome do município: ");
					String nome = scanner.nextLine();
					
					GovernoMunicipal govAux = getGovernoByNomeMunicipio(nome);
					
					if (govAux != null) {
						governos.remove(govAux);
					}
					
					break;
				}
				case 4: {
					System.out.println("");
					System.out.print("Nome do município: ");
					String nome = scanner.nextLine();
					
					GovernoMunicipal govAux = getGovernoByNomeMunicipio(nome);
					
					if (govAux != null) {
						govController.registraPessoa(govAux);
					}
					
					break;
				}
				case 5: {
					System.out.println("");
					System.out.print("Nome do município: ");
					String nome = scanner.nextLine();
					
					GovernoMunicipal govAux = getGovernoByNomeMunicipio(nome);
					
					if (govAux != null) {
						System.out.print("CPF da pessoa: ");
						long cpf = scanner.nextLong();
						scanner.nextLine();
						
						govController.alteraCadastroPessoa(govAux, cpf);
					}
					
					break;
				}
				case 6: {
					System.out.println("");
					System.out.print("Nome do município: ");
					String nome = scanner.nextLine();
					
					GovernoMunicipal govAux = getGovernoByNomeMunicipio(nome);
					
					if (govAux != null) {
						System.out.print("CPF da pessoa: ");
						long cpf = scanner.nextLong();
						scanner.nextLine();
						
						govController.vacina(govAux, cpf);
					}
					
					break;
				}
				case 7: {
					System.out.println("");
					System.out.print("Nome do município: ");
					String nome = scanner.nextLine();
					
					GovernoMunicipal govAux = getGovernoByNomeMunicipio(nome);
					
					if (govAux != null) {
						System.out.print("CPF da pessoa: ");
						long cpf = scanner.nextLong();
						scanner.nextLine();
						
						if (govController.existsPessoa(govAux, cpf)) {
							System.out.println(govAux.getPessoaByCpf(cpf).toString());
						} else {
							System.out.println("O CPF digitado não está no sistema ou não pertence a este governo!");
						}
					}
					
					break;
				}
				case 8: {
					System.out.println("");
					System.out.print("Nome do município: ");
					String nome = scanner.nextLine();
					
					GovernoMunicipal govAux = getGovernoByNomeMunicipio(nome);
					
					if (govAux != null) {
						govAux.imprimeHabitantes(govAux);
					}
					
					break;
				}
				case 9: {
					System.out.println("");
					System.out.print("Nome do município: ");
					String nome = scanner.nextLine();
					
					GovernoMunicipal govAux = getGovernoByNomeMunicipio(nome);
					
					if (govAux != null) {
						System.out.print("CPF da pessoa: ");
						long cpf = scanner.nextLong();
						scanner.nextLine();
						
						govController.removePessoa(govAux, cpf);
					}
					
					break;
				}
			}
			
			imprimeMenuPrincipal();
			op = scanner.nextInt();
			scanner.nextLine();
		}
		
		System.out.println();
		System.out.println("Programa encerrado!");
	}
	
	private static void listaGovernos() {
		String resp = "";
		
		for (GovernoMunicipal govAux: governos) {
			resp += govAux.toString() + "\n";
		}
		
		System.out.println(resp);
	}

	private static GovernoMunicipal getGovernoByNomeMunicipio(String nome) {
		GovernoMunicipal gov = new GovernoMunicipal(nome);
		
		for (GovernoMunicipal govAux : governos) {
			if (govAux.equals(gov)) {
				return govAux;
			}
		}
		
		System.out.println("Governo não encontrado para o Município de " + nome.toUpperCase());
		
		return null;
	}
	
	private static void imprimeMenuPrincipal() {
		System.out.println("***** Menu *****");
		System.out.println();
		System.out.println("(1) Cadastrar novo Governo");
		System.out.println("(2) Lista Governos");
		System.out.println("(3) Apagar um Governo");
		System.out.println("(4) Cadastrar nova Pessoa");
		System.out.println("(5) Atualizar dados de uma Pessoa");
		System.out.println("(6) Vacina Pessoa");
		System.out.println("(7) Exibe Pessoa");
		System.out.println("(8) Lista Pessoas");
		System.out.println("(9) Apagar uma Pessoa");
		System.out.println();
		System.out.println("(10) Fechar Programa");
		System.out.println();
		System.out.print("--> ");
	}
}