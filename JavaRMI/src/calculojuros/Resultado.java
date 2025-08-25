import java.io.Serializable;
import java.util.List;

public class Resultado implements Serializable {
    private double valorTotal;
    private List<Double> jurosMensais;

    public Resultado(double valorTotal, List<Double> jurosMensais) {
        this.valorTotal = valorTotal;
        this.jurosMensais = jurosMensais;
    }

    public double getValorTotal() { return valorTotal; }
    public List<Double> getJurosMensais() { return jurosMensais; }
}

