import org.acme.tamboui.HelloDsl;


public class TambouiApp {
    public static void main(String[] args) {
        try {
            HelloDsl.runApp();
        } catch (Exception e) {
            System.err.println("Application failed to start:");
            e.printStackTrace();
        }
    }
}