package POO;

import java.util.HashMap;
import java.util.Scanner;

public class TesteNumero {
    public static void main(String[] args) {
        Numero n = new Numero();
        boolean continuar = true;

        Scanner scan = new Scanner(System.in);
        while (continuar) {
            double x = 0;
            double y = 0;
            int operacao = 0;

            System.out.println("Digite a operação que deseja realizar: "
                    + "\n 1 Para soma"
                    + "\n 2 Para subtração"
                    + "\n 3 Para multiplicação"
                    + "\n 4 Para divisão"
                    + "\n 0 Para finalizar");

            operacao = scan.nextInt();

            if (operacao == 0) {
                continuar = false;
                break;
            }

            System.out.println("Informe o valor do primeiro número:");
            x = scan.nextDouble();

            System.out.println("Informe o valor do segundo número:");
            y = scan.nextDouble();

            switch (operacao) {
                case 1:
                    imprimeCalculadora(operacao, n.soma(x, y), x, y);
                    break;
                case 2:
                    imprimeCalculadora(operacao, n.subtracao(x, y), x, y);
                    break;
                case 3:
                    imprimeCalculadora(operacao, n.multiplicacao(x, y), x, y);
                    break;
                case 4:
                    double resultado = n.divisao(x, y);
                    if (Double.isNaN(resultado)) {
                        System.out.println("Divisão por zero não é permitida\n");
                    } else {
                        imprimeCalculadora(operacao, resultado, x, y);
                    }
                    break;
                default:
                    System.out.println("Operação inválida\n");
                    break;
            }
        }
        scan.close();
    }

    static void imprimeCalculadora(int operacao, double resultado, double x, double y) {
        HashMap<Integer, String> mapOperacao = new HashMap<>();
        mapOperacao.put(1, " somado");
        mapOperacao.put(2, " subtraído");
        mapOperacao.put(3, " multiplicado");
        mapOperacao.put(4, " dividido");

        System.out.println("O resultado de " + x + mapOperacao.get(operacao) + " por " + y + " é igual a " + resultado + "\n");
    }
}
