package modelo;

import util.AumentoMaiorDoQueJurosException;

public class Casa extends Financiamento{
    private double tamanhoAreaConstruida;
    private double tamanhoTerreno;
    private final int taxaAdicional;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double tamanhoAreaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.taxaAdicional = 80;
        if (tamanhoTerreno >= 20) {
            if (tamanhoAreaConstruida < 10) {
                System.out.println("Tamanho improvável.");
            } else {
                this.tamanhoAreaConstruida = tamanhoAreaConstruida;
                this.tamanhoTerreno = tamanhoTerreno;
            }
        }else {
            System.out.println("Tamanho improvável");
        }
    }

    private void verificarRegraJuros(double juros, double taxaAdicional) throws AumentoMaiorDoQueJurosException {
            if (taxaAdicional>juros){
                throw new AumentoMaiorDoQueJurosException("A taxa adicional está maior do que o juros da parcela. O valor mínimo de juros é o valor da taxa fixa!");
            }
    }

    @Override
    // precisa de uma lógica melhor
    public double parcelaMensal() {
        double juros = ((this.getValorImovel()/(getPrazoFinanciamento() *12))*(1+(getTaxaJurosAnual() /12))) - getValorImovel()/(getPrazoFinanciamento()*12);
        double taxaAdicional = this.taxaAdicional;
        System.out.println(juros);
        try{
            verificarRegraJuros(juros, taxaAdicional);
        } catch (AumentoMaiorDoQueJurosException e){
            juros = taxaAdicional;
            System.out.println(juros);
        }
        return (this.getValorImovel()/(getPrazoFinanciamento() *12)) + juros + taxaAdicional;
    }

    @Override
    public double totalPagamento() {
        return (parcelaMensal()* getPrazoFinanciamento() *12);
    }

    public double getTamanhoAreaConstruida() {
        return tamanhoAreaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }
}
