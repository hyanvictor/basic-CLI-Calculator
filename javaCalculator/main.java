package javaCalculator;

import java.util.Scanner; // Importa a classe Scanner para seu usado no projeto.

public class main {
    public static void main(String[] args) {
        // 1. Instancia o scanner.
        Scanner scanner = new Scanner(System.in);

        // 2. Variáveis do projeto
        double num1, num2, result = 0;
        char operation;
        int option;

        // 3. Entrada de dados do usuário.
        // 3.1 While (true): cria um loop infinito.
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Iniciar");
            System.out.println("2. Sair");
            System.out.println("Escolha uma opção: ");

            option = scanner.nextInt();

            // 4. case das opçoes para o usuário escolher
            switch (option) {
                case 1:
                    System.out.println("Seja bem vindo!");
                    break;
                case 2:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            // 4.1 Lógica que finaliza o loop (do while) ao escolher a opção 2 (case 2).
            if (option == 2) {
                break;
            }

            System.out.println("Digite um número: ");
            num1 = scanner.nextDouble();

            System.out.println("Escolha uma operaçãp: +, -, *, ou /");
            operation = scanner.next().charAt(0);

            System.out.println("Digite outro número: ");
            num2 = scanner.nextDouble();

            // 4. Lógica e funcionamento da calculadora.
            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Erro: divisão por zero!");
                    }
                    break;
                default:
                    System.out.println("Operação inválida! escolha uma operação válida para prosseguir...");
            }
            System.out.println("O resultado é: " + result);
        }
        scanner.close();
    }
}
