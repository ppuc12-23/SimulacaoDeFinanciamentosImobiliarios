package modelo;

public class Casa extends Financiamento{
    private final int taxaAdicional;
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.taxaAdicional = 80;
    }

    @Override
    public double parcelaMensal() {
        return (this.getValorImovel()/(getPrazoFinanciamento() *12))*(1+(getTaxaJurosAnual() /12)) + taxaAdicional;
    }

}
