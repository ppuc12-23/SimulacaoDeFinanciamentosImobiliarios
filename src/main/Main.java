package main;
import java.util.ArrayList;
import modelo.Financiamento;
import util.InterfaceUsuario;

public class Main {
    public static void main(String[] args) {
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        Financiamento fin1 = new Financiamento(100000, 20, 10);
        financiamentos.add(fin1);
        Financiamento fin2 = new Financiamento(300000, 50, 20);
        financiamentos.add(fin2);
        Financiamento fin3 = new Financiamento(400000, 40, 10);
        financiamentos.add(fin3);
        Financiamento fin4 = new Financiamento(500000, 50, 10);
        financiamentos.add(fin4);

        double totalValorReal = 0;
        double totalValorFinanciamento = 0;
        for (Financiamento financiamento : financiamentos) {
            double valorReal = financiamento.getValorImovel();
            double valorFinanciamento = financiamento.totalPagamento();
            if (Double.isNaN(valorFinanciamento)) {
                System.out.println("Não é possível efetuar os financiamentos!");
                break;
            }

            totalValorReal += valorReal;
            totalValorFinanciamento += valorFinanciamento;
        }

        System.out.printf("Total de todos os imóveis: R$ %.2f. Total de todos os financiamentos: R$ %.2f.\n", totalValorReal, totalValorFinanciamento);


        /*
        //TESTE:
        double valorDoImovel = InterfaceUsuario.dadoValorImovel();
        int prazoDeFinanciamentoEmAnos = InterfaceUsuario.dadoPrazoFinanciamento();
        double taxaDeJurosAnual = InterfaceUsuario.dadoTaxaJurosAnual();

        Financiamento financiamento = new Financiamento(valorDoImovel, prazoDeFinanciamentoEmAnos, taxaDeJurosAnual);

        double parcela = financiamento.parcelaMensal();
        double total = financiamento.totalPagamento();

        System.out.printf("Valor: %.2f,Prazo: %d,Taxa: %.2f, Parcela: %.2f, total: %.2f", valorDoImovel, prazoDeFinanciamentoEmAnos, taxaDeJurosAnual, parcela, total);
        */
    }
}