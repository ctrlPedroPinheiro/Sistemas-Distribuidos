import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class JurosServiceImpl extends UnicastRemoteObject implements JurosService {

    protected JurosServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public Resultado calcularJuros(double investimento, double taxa, int meses) throws RemoteException {
        long inicio = System.currentTimeMillis();
        List<Double> jurosMensais = new ArrayList<>();
        double valorAtual = investimento;

        for (int i = 1; i <= meses; i++) {
            valorAtual *= (1 + taxa);
            jurosMensais.add(valorAtual - investimento);
        }

        long fim = System.currentTimeMillis();
        System.out.println("Tempo de processamento: " + (fim - inicio) + " ms");
        System.out.println("Requisição do cliente processada.");

        return new Resultado(valorAtual, jurosMensais);
    }
}
