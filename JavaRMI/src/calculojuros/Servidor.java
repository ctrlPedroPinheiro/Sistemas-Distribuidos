import java.rmi.Naming;

public class Servidor {
    public static void main(String[] args) {
        try {
            JurosService service = new JurosServiceImpl();
            Naming.rebind("rmi://localhost:1099/JurosService", service);
            System.out.println("Servidor pronto!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
