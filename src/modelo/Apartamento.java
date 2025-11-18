package modelo;

public class Apartamento extends Financiamento{
    private final double taxaJurosMensal;
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.taxaJurosMensal = taxaJurosAnual/12;
    }

    @Override
    public double parcelaMensal() {
        int prazoFinanciamentoMeses = getPrazoFinanciamento()*12;
        return ((getValorImovel()*Math.pow((1+taxaJurosMensal),prazoFinanciamentoMeses))/(Math.pow((1+taxaJurosMensal),prazoFinanciamentoMeses) - 1))*taxaJurosMensal;
    }
}
