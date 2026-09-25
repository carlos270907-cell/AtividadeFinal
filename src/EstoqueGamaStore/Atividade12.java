package EstoqueGamaStore;

import java.util.Scanner;

public class Atividade12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] jogos = new String[5];
        int[] estoque = new int[5];
        int cadastrados = 0;
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== MENU - GAME STORE =====");
            System.out.println("1 - Cadastrar jogo");
            System.out.println("2 - Listar estoque");
            System.out.println("3 - Vender jogo");
            System.out.println("4 - Repor estoque");
            System.out.println("5 - Consultar jogo");
            System.out.println("6 - Ver total de unidades");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpa a quebra de linha antes de ler texto

            switch (opcao) {
                case 1:
                    if (cadastrados >= 5) {
                        System.out.println("Estoque cheio!");
                        break;
                    }
                    System.out.print("Nome do jogo: ");
                    String nome = sc.nextLine();

                    System.out.print("Quantidade inicial: ");
                    int qtdInicial = sc.nextInt();
                    sc.nextLine();

                    if (qtdInicial < 0) {
                        System.out.println("Quantidade inválida!");
                        break;
                    }

                    jogos[cadastrados] = nome;
                    estoque[cadastrados] = qtdInicial;
                    cadastrados++;
                    System.out.println("Jogo cadastrado com sucesso!");
                    break;

                case 2:
                    if (cadastrados == 0) {
                        System.out.println("Nenhum jogo cadastrado ainda.");
                        break;
                    }
                    System.out.println("--- Estoque ---");
                    for (int i = 0; i < cadastrados; i++) {
                        System.out.println((i + 1) + " - " + jogos[i] + ": " + estoque[i] + " unidades");
                    }
                    break;

                case 3:
                    if (cadastrados == 0) {
                        System.out.println("Nenhum jogo cadastrado ainda.");
                        break;
                    }
                    for (int i = 0; i < cadastrados; i++) {
                        System.out.println((i + 1) + " - " + jogos[i] + ": " + estoque[i] + " unidades");
                    }
                    System.out.print("Escolha o jogo: ");
                    int numVenda = sc.nextInt();

                    if (numVenda < 1 || numVenda > cadastrados) {
                        System.out.println("Escolha inválida!");
                        break;
                    }

                    System.out.print("Quantidade para vender: ");
                    int qtdVenda = sc.nextInt();

                    int indiceVenda = numVenda - 1;

                    if (qtdVenda <= 0) {
                        System.out.println("Escolha inválida!");
                    } else if (qtdVenda > estoque[indiceVenda]) {
                        System.out.println("Estoque insuficiente!");
                    } else {
                        estoque[indiceVenda] -= qtdVenda;
                        System.out.println("Venda realizada! " + jogos[indiceVenda] + " agora tem " + estoque[indiceVenda] + " unidades.");
                    }
                    break;

                case 4:
                    if (cadastrados == 0) {
                        System.out.println("Nenhum jogo cadastrado ainda.");
                        break;
                    }
                    for (int i = 0; i < cadastrados; i++) {
                        System.out.println((i + 1) + " - " + jogos[i] + ": " + estoque[i] + " unidades");
                    }
                    System.out.print("Escolha o jogo: ");
                    int numRepor = sc.nextInt();

                    if (numRepor < 1 || numRepor > cadastrados) {
                        System.out.println("Escolha inválida!");
                        break;
                    }

                    System.out.print("Quantidade que chegou: ");
                    int qtdRepor = sc.nextInt();

                    int indiceRepor = numRepor - 1;

                    if (qtdRepor <= 0) {
                        System.out.println("Escolha inválida!");
                    } else {
                        estoque[indiceRepor] += qtdRepor;
                        System.out.println("Estoque reposto! " + jogos[indiceRepor] + " agora tem " + estoque[indiceRepor] + " unidades.");
                    }
                    break;

                case 5:
                    if (cadastrados == 0) {
                        System.out.println("Nenhum jogo cadastrado ainda.");
                        break;
                    }
                    System.out.print("Digite o número do jogo: ");
                    int numConsulta = sc.nextInt();

                    if (numConsulta < 1 || numConsulta > cadastrados) {
                        System.out.println("Jogo não encontrado.");
                    } else {
                        int indiceConsulta = numConsulta - 1;
                        System.out.println(jogos[indiceConsulta] + ": " + estoque[indiceConsulta] + " unidades");
                    }
                    break;

                case 6:
                    int total = 0;
                    for (int i = 0; i < cadastrados; i++) {
                        total += estoque[i];
                    }
                    System.out.println("Total de unidades em estoque: " + total);
                    break;

                case 0:
                    System.out.println("Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        sc.close();
    }
}