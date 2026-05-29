package org.acme.tamboui;

import dev.tamboui.widgets.list.*;
import dev.tamboui.widgets.block.*;
import dev.tamboui.style.Style;
import dev.tamboui.toolkit.event.*;
import dev.tamboui.tui.event.KeyEvent;
import dev.tamboui.toolkit.app.*;
import dev.tamboui.toolkit.element.Element;
import static dev.tamboui.toolkit.Toolkit.*;


public class TestLists extends ToolkitApp {

    private final ListState listState = new ListState();
    private String footerMessage = "Use ↑ ↓ keys to move. Press 'q' to exit.";
    private final ListWidget viewList;

    public TestLists() {
        this.listState.select(0); 
        viewList = ListWidget.builder()
            .items(
                ListItem.from("⚙️ System Configuration"),
                ListItem.from("📂 Search Files"),
                ListItem.from("🚀 Run Diagnostics")
            )
            .highlightSymbol("👉 ")
            .highlightStyle(Style.EMPTY.reversed()) 
            .block(Block.builder().title(" Main Menu").borders(Borders.ALL).build())
            .build();
    }

    @Override
    protected Element render() {

        return panel("Test Lists App",
            text("Control Panel").bold(),
            spacer(),
            
            widget((area, buffer) -> viewList.render(area, buffer, listState)),
            
            spacer(),
            text(footerMessage).dim()
        ).rounded()
         .focusable()
        .onKeyEvent(this::handleKeyPress);
    }


    public EventResult handleKeyPress(KeyEvent event) {
        footerMessage =  event.action().get() + " - " + listState.selected() ;
        if(event.isDown()){
            listState.selectNext(3);
            
            return EventResult.HANDLED;
        }
        if(event.isUp()){
            listState.selectPrevious();
            return EventResult.HANDLED;
        }
        if (event.string().equalsIgnoreCase("q")) {
            System.exit(0);
        }
        return EventResult.UNHANDLED;
    }


    public static void runApp() throws Exception {
        new TestLists().run();
    }
}
