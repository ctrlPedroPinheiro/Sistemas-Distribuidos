import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            JurosService service = (JurosService) Naming.lookup("rmi://localhost:1099/JurosService");
            Scanner sc = new Scanner(System.in);

            System.out.print("Digite o valor do investimento: ");
            double investimento = sc.nextDouble();

            System.out.print("Digite a taxa de juros (Decimal): ");
            double taxa = sc.nextDouble();

            System.out.print("Digite o número de meses: ");
            int meses = sc.nextInt();

            Resultado resultado = service.calcularJuros(investimento, taxa, meses);

            System.out.println("Valor total a receber: " + resultado.getValorTotal());
            System.out.println("Juros acumulados por mês:");
            for (int i = 0; i < resultado.getJurosMensais().size(); i++) {
                System.out.printf("Mês %d: %.2f%n", (i+1), resultado.getJurosMensais().get(i));
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
