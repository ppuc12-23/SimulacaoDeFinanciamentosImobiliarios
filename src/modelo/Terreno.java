package modelo;

public class Terreno extends Financiamento{
    private String zona;
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String zona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.zona = zona;
    }

    @Override
    public double parcelaMensal() {
        return (this.getValorImovel()/(getPrazoFinanciamento() *12))*(1+(getTaxaJurosAnual() /12))*1.02;
    }

    @Override
    public double totalPagamento() {
        return (parcelaMensal()* getPrazoFinanciamento() *12);
    }
}
