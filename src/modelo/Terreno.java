package modelo;

public class Terreno extends Financiamento{
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    @Override
    public double parcelaMensal() {
        return (this.getValorImovel()/(getPrazoFinanciamento() *12))*(1+(getTaxaJurosAnual() /12))*1.02;
    }
}
