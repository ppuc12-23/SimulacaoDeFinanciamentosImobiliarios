package modelo;

public abstract class Financiamento {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        if (valorImovel > 0){
            //this.valorImovel = valorImovel;
            if (prazoFinanciamento<0) {
                System.out.println("Não existe prazo negativo!");
            } else if (prazoFinanciamento > 60) {
                System.out.println("Prazo muito longo. Diminua o tempo de financiamento.");
            } else {
                //this.prazoFinanciamento = prazoFinanciamento;

                if (taxaJurosAnual < 0) {
                    System.out.println("O valor precisa ser positivo!");
                } else if (taxaJurosAnual > 0.4) {
                    System.out.println("Taxa de juros muito alta!");
                } else {
                    this.prazoFinanciamento = prazoFinanciamento;
                    this.valorImovel = valorImovel;
                    this.taxaJurosAnual = taxaJurosAnual;
                }
            }
        } else {
            System.out.println("Não é possível adicionar imovel com valor negativo");
        }
    }

    public abstract double parcelaMensal();

    public abstract double totalPagamento();

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void mostrarDadosFinanciamento() {
        System.out.printf("Valor do imóvel: %.2f. Valor total a ser pago: %.2f.", valorImovel, totalPagamento());
    }
}

