import org.acme.tamboui.HelloDsl;
import org.acme.tamboui.TestLists;


public class TambouiApp {
    public static void main(String[] args) {
        try {
            //HelloDsl.runApp();
            TestLists.runApp();
        } catch (Exception e) {
            System.err.println("Application failed to start:");
            e.printStackTrace();
        }
    }
}