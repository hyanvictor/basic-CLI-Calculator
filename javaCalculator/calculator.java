import java.util.InputMismatchException;
import java.text.DecimalFormat;
import java.util.Scanner; // Importa a classe Scanner para seu usado no projeto.

public class Calculator {
    public static void main(String[] args) {
        // 1. Instancia o scanner.
        Scanner scanner = new Scanner(System.in);

        // 2. Variáveis do projeto
        double num1, num2, result = 0;
        char operation;
        int option = 0;
        boolean hasError = false;
        boolean hasMenu = true;

        DecimalFormat resultsFormat = new DecimalFormat("0.##########");

        // 3. Entrada de dados do usuário.
        // 3.1 While (true): cria um loop infinito.
        while (option != 2) {
            if (hasMenu) {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Iniciar");
                System.out.println("2. Sair");
                System.out.println("Escolha uma opção: ");

                option = scanner.nextInt();
            }

            // 4. case das opçoes para o usuário escolher
            switch (option) {
                case 1:
                    System.out.println("\n--- Seja bem vindo! ---");
                    break;
                case 2:
                    System.out.println("\n--- Saindo do programa... ---");
                    break;
                default:
                    System.out.println("\n--- Opção inválida! ---");
                    break;
            }

            /*
             * 4.1 Lógica que finaliza o loop (do while) ao escolher a opção 2 (case 2) OU
             * escolher qualquer opção que não seja 1.
             */
            if (option == 2) {
                break;
            }

            if (option != 1) {
                System.out.println("Erro: Opção inválida!");
                continue;
            }

            // 5. Inputs do usuário
            if (option == 1) {
                try {
                    System.out.println("Digite um número: ");
                    num1 = scanner.nextDouble();

                    System.out.println("Escolha uma operaçãp: +, -, *, ou /");
                    operation = scanner.next().charAt(0);

                    System.out.println("Digite outro número: ");
                    num2 = scanner.nextDouble();

                    // 6. Lógica e funcionamento da calculadora.
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
                            result = num1 / num2;
                            break;
                        default:
                            throw new IllegalArgumentException("Operação inválida!");
                    }

                    System.out.println("O resultado é: " + resultsFormat.format(result));
                    System.out.println("Operação finalizada!");
                    System.out.println("Deseja: [1] Nova conta | [2] Voltar ao menu");
                    int decision = scanner.nextInt();

                    if (decision == 1) {
                        hasMenu = false;
                    } else if (decision == 2) {
                        hasMenu = true;
                    } else {
                        System.out.println("\n--- Opção inválida! ---");
                        continue;
                    }

                } catch (ArithmeticException e) {
                    hasError = true;
                    System.out.println("Erro: Não é possível dividir por 0!");
                } catch (InputMismatchException e) {
                    hasError = true;
                    System.out.println("Erro: Digite um número válido!");
                } catch (IllegalArgumentException e) {
                    hasError = true;
                    System.out.println("Erro: " + e.getMessage());
                }

                if (hasError) {
                    hasMenu = true;
                }
            }
        }
        scanner.close();
    }
}
