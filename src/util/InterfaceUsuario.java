package util;

import java.util.Scanner;

public class InterfaceUsuario {

    public static double dadoValorImovel() {
        // pesquisar se preciso aplicar scanner.close() nesse caso
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
                }else if(x>0.4){
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

    public static double dadoTamanhoAreaConstruida() {
        double x;
        Scanner scanner = new Scanner(System.in);
        do{
            try{
                System.out.print("Digite o tamanho da área construída no imóvel: ");
                x = scanner.nextDouble();
                if (x<=0){
                    System.out.println("O valor precisa ser positivo");
                } else if (0<x && x<10){
                    System.out.println("Tamanho improvável");
                }
            } catch(java.util.InputMismatchException erro){
                System.out.println("Valor inválido!");
                scanner.next();
                x = -1;
            }
        } while (x < 10);
        return x;
    }

    public static double dadoTamanhoTerreno() {
        double x;
        Scanner scanner = new Scanner(System.in);
        do{
            try{
                System.out.print("Digite o tamanho da área do terreno do imóvel: ");
                x = scanner.nextDouble();
                if (x<=0){
                    System.out.println("O valor precisa ser positivo");
                } else if (0<x && x<20){
                    System.out.println("Tamanho improvável");
                }
            } catch(java.util.InputMismatchException erro){
                System.out.println("Valor inválido!");
                scanner.next();
                x = -1;
            }
        } while (x < 20);
        return x;
    }

    public static int dadoVagasGaragem() {
        int x;
        Scanner scanner = new Scanner(System.in);
        do{
            try{
                System.out.print("Digite o número de vagas disponíveis na garagem: ");
                x = scanner.nextInt();
                if (x<0){
                    System.out.println("O valor é impossível");
                }
            } catch(java.util.InputMismatchException erro){
                System.out.println("Valor inválido!");
                scanner.next();
                x = -1;
            }
        } while (x < 0);
        return x;
    }

    public static int dadoAndar() {
        int x;
        Scanner scanner = new Scanner(System.in);
        do{
            try{
                System.out.print("Digite o número do andar do apartamento: ");
                x = scanner.nextInt();
                if (x<0){
                    System.out.println("O valor precisa ser positivo ou 0");
                }
            } catch(java.util.InputMismatchException erro){
                System.out.println("Valor inválido!");
                scanner.next();
                x = -1;
            }
        } while (x < 0);
        return x;
    }

    public static String dadoZona() {
        String x;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.print("Digite Se o apartamento está na zona residêncial(r) ou comercial(c): ");
            x = scanner.nextLine();
            if (!x.equals("c") && !x.equals("r")){
                System.out.println("Digite r para residêncial ou c para comercial");
            }

        } while (!x.equals("c") && !x.equals("r"));
        return x;
    }
}
