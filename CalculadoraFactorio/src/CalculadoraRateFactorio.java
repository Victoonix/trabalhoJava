import java.util.Scanner;

public class CalculadoraRateFactorio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Insira quantos itens por minuto deseja: ");
        double apm = sc.nextDouble(); // APM é encurtado de amount per minute, só para não confundir com IPM, ingredients per minute.

        System.out.print("Insira o tempo de fabricaçao (segundos): ");
        int tempoFabricacao = sc.nextInt();

        System.out.print("Insira a quantidade de itens produzidos por fabricaçao: ");
        int quantidadeProduzida = sc.nextInt();

        System.out.print("Insira o multiplicador da velocidade da máquina: ");
        double velocidadeMaquina = sc.nextDouble();

        System.out.print("Insira a quantidade de algum ingrediente necessária por fabricaçao (ou 0 se nao tiver): ");
        int quantidadeIngrediente = sc.nextInt();

        System.out.print("Insira a velocidade da esteira (itens por minuto): ");
        double velocidadeEsteira = sc.nextDouble();

        System.out.println("\nPara alcançar " + apm + " itens por minuto, você precisará de: ");

        double maquinasNecessarias = apm / (((velocidadeMaquina * quantidadeProduzida) / tempoFabricacao) * 60);
        System.out.println("\nMáquinas necessárias: " + ceil1decimal(maquinasNecessarias));

        double outputEsteiras = ceil1decimal(apm / velocidadeEsteira); // Quantas esteiras vão precisar pra carregar os itens na saída
        System.out.println("Esteiras para a saída: " + outputEsteiras);

        if (quantidadeIngrediente > 0) {
            double ipm = apm / quantidadeProduzida * quantidadeIngrediente;
            double inputEsteiras = ceil1decimal(ipm / velocidadeEsteira); // Quantas esteiras vão precisar pra carregar os ingredientes na entrada

            System.out.println("Ingredientes por minuto: " + ipm);
            System.out.println("Esteiras para a entrada: " + inputEsteiras);
        }

        sc.close();
    }

    private static double ceil1decimal(double numero) { // função pra arredondar pra cima com uma casa decimal
        return Math.ceil(numero * 10.0) / 10.0;
    }
}

