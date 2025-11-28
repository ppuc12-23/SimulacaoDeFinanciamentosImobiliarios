package main;
import java.util.ArrayList;
import modelo.Financiamento;
import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;
import util.InterfaceUsuario;

public class Main {
    public static void main(String[] args) {
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        // input do usuário
        double valorImovel = InterfaceUsuario.dadoValorImovel();
        int prazoFinanciamento = InterfaceUsuario.dadoPrazoFinanciamento();
        double taxaJurosAnual = InterfaceUsuario.dadoTaxaJurosAnual();
        double tamanhoAreaConstruida = InterfaceUsuario.dadoTamanhoAreaConstruida();
        double tamanhoTerreno = InterfaceUsuario.dadoTamanhoTerreno();


        Financiamento fin1 = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, tamanhoAreaConstruida, tamanhoTerreno);
        financiamentos.add(fin1);

        Financiamento fin2 = new Casa(200000, 15, 0.1, 11, 21);
        // preciso tratar tamanhoAreaConstruida e tamanhoTerreno <0 - o financiamento tem que travar!!!
        financiamentos.add(fin2);
        Financiamento fin3 = new Apartamento(300000, 15, 0.2, 1, 2);
        // preciso tratar vagasGaragem e numeroAndar <0 - o financiamento tem que travar!!!
        financiamentos.add(fin3);
        Financiamento fin4 = new Apartamento(400000, 25, 0.09, 0, 1);
        financiamentos.add(fin4);
        Financiamento fin5 = new Terreno(100000, 10, 0.02, "Residencial");
        financiamentos.add(fin5);



        double totalValorReal = 0;
        double totalValorFinanciamento = 0;
        for (Financiamento financiamento : financiamentos) {
            double valorReal = financiamento.getValorImovel();
            double valorFinanciamento = financiamento.totalPagamento();
            System.out.println(financiamento.parcelaMensal()+" "+valorFinanciamento);
            if (Double.isNaN(valorFinanciamento)) {
                System.out.println("Não é possível efetuar os financiamentos!");
                totalValorReal = 0;
                totalValorFinanciamento = 0;
                break;
            }

            totalValorReal += valorReal;
            totalValorFinanciamento += valorFinanciamento;
        }
        System.out.printf("Total de todos os imóveis: R$ %.2f. Total de todos os financiamentos: R$ %.2f.\n", totalValorReal, totalValorFinanciamento);
    }
}