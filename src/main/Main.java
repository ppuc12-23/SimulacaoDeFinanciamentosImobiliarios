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

        double valorImovel = InterfaceUsuario.dadoValorImovel();
        int prazoFinanciamento = InterfaceUsuario.dadoPrazoFinanciamento();
        double taxaJurosAnual = InterfaceUsuario.dadoTaxaJurosAnual();

        Financiamento fin1 = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual);
        financiamentos.add(fin1);
        Financiamento fin2 = new Casa(200000, 15, 0.1);
        financiamentos.add(fin2);
        Financiamento fin3 = new Apartamento(300000, 15, 0.2);
        financiamentos.add(fin3);
        Financiamento fin4 = new Apartamento(400000, 25, 0.09);
        financiamentos.add(fin4);
        Financiamento fin5 = new Terreno(100000, 10, 0.02);
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