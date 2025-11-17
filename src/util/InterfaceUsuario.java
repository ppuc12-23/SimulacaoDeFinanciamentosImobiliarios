package util;

import java.util.Scanner;

public class InterfaceUsuario {

    public static double dadoValorImovel() {
        double x;
        Scanner scanner = new Scanner(System.in);
        do{
            try{
                System.out.print("Digite o valor do imóvel: ");
                x = scanner.nextDouble();
                if (x<=0){
                    System.out.println("O valor precisa ser positivo");
                }
            } catch(java.util.InputMismatchException erro){
                System.out.println("Valor inválido!");
                scanner.next();
                x = -1;
            }
        } while (x <=0);
        return x;
    }

    public static int dadoPrazoFinanciamento() {
        int x;
        Scanner scanner = new Scanner(System.in);

        do{
            try{
                System.out.print("Digite o prazo de financiamento: ");
                x = scanner.nextInt();
                if (x<=0){
                    System.out.println("O valor precisa ser positivo");
                }else if(x > 60){
                    System.out.println("Prazo muito longo. Diminua o tempo de financiamento.");
                    x = -1;
                }
            } catch(java.util.InputMismatchException erro){
                System.out.println("Valor inválido!");
                scanner.next();
                x = -1;
            }
        } while (x <=0);
        return x;
    }

    public static double dadoTaxaJurosAnual() {
        double x;
        Scanner scanner = new Scanner(System.in);
        do{
            try{
                System.out.print("Digite a taxa de juros anual: ");
                x = scanner.nextDouble();
                if (x<=0){
                    System.out.println("O valor precisa ser positivo");
                }else if(x>40){
                    System.out.println("Taxa de juros muito alta!");
                    x = -1;
                }
            } catch(java.util.InputMismatchException erro){
                System.out.println("Valor inválido. Digite um numero: ");
                scanner.next();
                x = -1;
            }
        } while (x <=0);
        return x;
    }
}
