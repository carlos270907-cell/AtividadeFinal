package SistemaDeNotas;

import java.util.Scanner;

public class Atividade11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] notas = new double[10];
        int quantidade = 0;
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar notas");
            System.out.println("2 - Listar notas");
            System.out.println("3 - Calcular média");
            System.out.println("4 - Maior e menor nota");
            System.out.println("5 - Consultar nota por número");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Quantos alunos deseja cadastrar (1 a 10)? ");
                    int qtd = sc.nextInt();

                    if (qtd < 1 || qtd > 10) {
                        System.out.println("Quantidade inválida! Digite um valor entre 1 e 10.");
                        break;
                    }

                    quantidade = qtd;
                    for (int i = 0; i < quantidade; i++) {
                        double nota;
                        do {
                            System.out.print("Nota do aluno " + (i + 1) + " (0 a 10): ");
                            nota = sc.nextDouble();
                            if (nota < 0 || nota > 10) {
                                System.out.println("Nota inválida! Digite um valor entre 0 e 10.");
                            }
                        } while (nota < 0 || nota > 10);
                        notas[i] = nota;
                    }
                    System.out.println("Notas cadastradas com sucesso!");
                    break;

                case 2:
                    if (quantidade == 0) {
                        System.out.println("Nenhuma nota cadastrada ainda.");
                        break;
                    }
                    System.out.println("--- Notas cadastradas ---");
                    for (int i = 0; i < quantidade; i++) {
                        System.out.println("Aluno " + (i + 1) + ": " + notas[i]);
                    }
                    break;

                case 3:
                    if (quantidade == 0) {
                        System.out.println("Nenhuma nota cadastrada ainda.");
                        break;
                    }
                    double soma = 0;
                    for (int i = 0; i < quantidade; i++) {
                        soma += notas[i];
                    }
                    double media = soma / quantidade;
                    System.out.printf("Média da turma: %.2f%n", media);
                    break;

                case 4:
                    if (quantidade == 0) {
                        System.out.println("Nenhuma nota cadastrada ainda.");
                        break;
                    }
                    double maior = notas[0];
                    double menor = notas[0];
                    for (int i = 0; i < quantidade; i++) {
                        if (notas[i] > maior) {
                            maior = notas[i];
                        }
                        if (notas[i] < menor) {
                            menor = notas[i];
                        }
                    }
                    System.out.println("Maior nota: " + maior);
                    System.out.println("Menor nota: " + menor);
                    break;

                case 5:
                    if (quantidade == 0) {
                        System.out.println("Nenhuma nota cadastrada ainda.");
                        break;
                    }
                    System.out.print("Digite o número do aluno (1 a " + quantidade + "): ");
                    int numero = sc.nextInt();

                    if (numero < 1 || numero > quantidade) {
                        System.out.println("Número de aluno inválido!");
                    } else {
                        System.out.println("Nota do aluno " + numero + ": " + notas[numero - 1]);
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        sc.close();
    }
}