import org.acme.tamboui.HelloDsl;
import org.acme.tamboui.TestLists;
import org.acme.tamboui.TodoApp;
import dev.tamboui.backend.jline3.JLineBackend;
import dev.tamboui.style.Color;
import dev.tamboui.style.Style;
import dev.tamboui.terminal.Terminal;
import dev.tamboui.widgets.paragraph.*;


public class TambouiApp {
    public static void main(String[] args) {
        try {
           // HelloDsl.runApp();
           // TestLists.runApp();
           TodoApp.runApp();
/*         try (var backend = new JLineBackend()) {
            backend.enableRawMode();
            backend.enterAlternateScreen();
            backend.hideCursor();
            var terminal = new Terminal<>(backend);
            terminal.draw(frame -> {
                var widget = Paragraph.builder()
                    .text("Press 'q' to quit")
                    .style(Style.EMPTY.fg(Color.CYAN))
                    .build();               
                frame.renderWidget(widget, frame.area());
            });
        } */
        } 
        catch (Exception e) {
            System.err.println("Application failed to start:");
            e.printStackTrace();
        }
    }
}