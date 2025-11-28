package modelo;

public class Apartamento extends Financiamento{
    private final double taxaJurosMensal;
    private int vagasGaragem;
    private int andar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int andar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        if (vagasGaragem >= 0) {
            if (andar < 0) {
                System.out.println("Número de andar improvável.");
            } else {
                this.vagasGaragem = vagasGaragem;
                this.andar = andar;
            }
        }else {
            System.out.println("Número de vagas impossível.");
        }
        this.taxaJurosMensal = taxaJurosAnual/12;
    }

    @Override
    public double parcelaMensal() {
        int prazoFinanciamentoMeses = getPrazoFinanciamento()*12;
        //não entendi a fórmula do material, apliquei a fórmula que achei em outro site
        return ((getValorImovel()*Math.pow((1+taxaJurosMensal),prazoFinanciamentoMeses))/(Math.pow((1+taxaJurosMensal),prazoFinanciamentoMeses) - 1))*taxaJurosMensal;
    }

    @Override
    public double totalPagamento() {
        return (parcelaMensal()* getPrazoFinanciamento() *12);
    }

    public double getVagasGaragem() {
        return vagasGaragem;
    }
}
