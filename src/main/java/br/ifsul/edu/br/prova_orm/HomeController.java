package br.ifsul.edu.br.prova_orm;



import br.ifsul.edu.br.prova_orm.processos.Processo;
import br.ifsul.edu.br.prova_orm.processos.ProcessoController;

import java.util.Scanner;

public class HomeController {
	
	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		int opcao;
		do {
			System.out.print("\n-------  Home -------");
			System.out.print(
				"""

					1. Inserir um Processo
					2. Atualizar Processo
					3. Ver  Processo
					4. Excluir Processo
					Opção (Zero p/sair):\s""");
			opcao = input.nextInt();
			input.nextLine();
			switch (opcao) {
				case 1 -> ProcessoController.main(args);
				case 2 -> ProcessoController.atualizar();
				case 3 -> ProcessoController.visualizar();
				case 4 -> ProcessoController.excluir(); //ItemController.main(null);
				default -> {
					if (opcao != 0) System.out.println("Opção inválida.");
				}
			}
		} while(opcao != 0) ;
		System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!");
		input.close(); //libera o recurso
	}

}//fim classe
