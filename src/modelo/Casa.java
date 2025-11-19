package modelo;

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

    @Override
    public double parcelaMensal() {
        return (this.getValorImovel()/(getPrazoFinanciamento() *12))*(1+(getTaxaJurosAnual() /12)) + taxaAdicional;
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
