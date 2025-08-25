import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JurosService extends Remote {
    Resultado calcularJuros(double investimento, double taxa, int meses) throws RemoteException;
}
