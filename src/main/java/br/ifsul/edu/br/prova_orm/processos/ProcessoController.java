package br.ifsul.edu.br.prova_orm.processos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class ProcessoController {

    private static final Scanner input = new Scanner(System.in);

    private static ProcessoService processoService;

    @Autowired
    public ProcessoController(ProcessoService processoService) {
        ProcessoController.processoService = processoService;
    }

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.print("\n\"-------  MENU Processo -------\"");
            System.out.print("""
                    1. Inserir novo Processo
                    2. Atualizar Processo
                    3. Visualizar Processo
                    4. Excluir Processo
                    Opção (Zero p/sair): """);
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> visualizar();
                case 4 -> excluir();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }

    private static void inserir() {
        Processo processo = new Processo();
        System.out.println("\n++++++ Cadastro de novo Processo ++++++");
        System.out.print("Digite o número do Processo: ");
        processo.setNumeroProcesso(input.nextLine());
        System.out.println("Digite a data de abertura do Processo");
        processo.setAberturaProcesso(input.nextLine());
        System.out.println("Descreva o Processo");
        processo.setDescricaoProcesso(input.nextLine());
        System.out.println("Processo salvo com sucesso:" + processoService.insert(processo));
    }

    public static void atualizar() {
        System.out.println("\n++++++ Alterar um Processo ++++++");
        Processo processo;
        int opcao = 0;
        do {
            System.out.print("\nDigite o ID do Processo (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else {
                processo = processoService.getProcessoById(codigo);
                if (processo == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println("Número: " + processo.getNumeroProcesso());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Digite o novo número do processo: ");
                        processo.setNumeroProcesso(input.nextLine());
                    }
                    System.out.println("Descrição: " + processo.getDescricaoProcesso());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.print("Digite a nova descrição do processo: ");
                        processo.setDescricaoProcesso(input.nextLine());
                    }

                    if (processoService.update(processo) != null) {
                        System.out.println("Processo atualizado com sucesso. " + processoService.getProcessoById(processo.getId()));
                    } else {
                        System.out.println("Não foi possível atualizar este processo.");
                    }

                    opcao = 1;
                }
            }
        } while (opcao != 0);
    }

    public static void visualizar() {
        System.out.println("\n++++++ Visualizar um Processo ++++++");
        System.out.print("\nDigite o código do Processo (Zero p/sair): ");
        long codigo = input.nextLong();
        input.nextLine();
        if (codigo == 0) {
            return;
        }

        Processo processo = processoService.getProcessoById(codigo);
        if (processo == null) {
            System.out.println("Código inválido.");
        } else {
            System.out.println("Número: " + processo.getNumeroProcesso());
            System.out.println("Descrição: " + processo.getDescricaoProcesso());
            System.out.println("Abertura: " + processo.getAberturaProcesso());
            System.out.println("Conclusão: " + processo.getConclusaoProcesso());
        }
    }


    public static void excluir() {
        System.out.println("\n++++++ Deletar um Processo ++++++");
        System.out.print("\nDigite o ID do Processo (Zero p/sair): ");
        long codigo = input.nextLong();
        input.nextLine();
        if (codigo == 0) {
            return;
        }

        Processo processo = processoService.getProcessoById(codigo);
        if (processo == null) {
            System.out.println("Código inválido.");
        } else {
            processoService.delete(codigo);
            System.out.println("Processo deletado com sucesso.");
        }
    }
}





//fim classex
