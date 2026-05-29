package org.acme.tamboui;

import java.util.ArrayList;
import java.util.List;
import static dev.tamboui.toolkit.Toolkit.*;
import dev.tamboui.toolkit.app.ToolkitApp;
import dev.tamboui.toolkit.elements.ListElement;
import dev.tamboui.toolkit.event.EventResult;
import dev.tamboui.tui.event.KeyEvent;
import dev.tamboui.style.Color;
import dev.tamboui.toolkit.element.*;

public class TodoApp extends ToolkitApp {

    private final List<String> items = new ArrayList<>(List.of(
        "Learn TamboUI",
        "Build something cool"
    ));
    private final ListElement<?> todoList = list()
        .highlightColor(Color.CYAN)
        .autoScroll();

    @Override
    protected Element render() {
        return panel("Todo",
            items.isEmpty()
                ? text("Empty - press 'a' to add").dim()
                : todoList.items(items.toArray(new String[0])),
            spacer(),
            text("[a]dd [d]elete [q]uit").dim()
        )
        .rounded()
        .id("main")
        .focusable()
        .onKeyEvent(this::handleKey);
    }

    private EventResult handleKey(KeyEvent event) {
        if (event.isChar('a')) {
            items.add("New item");
            return EventResult.HANDLED;
        }
        if (event.isChar('d') && !items.isEmpty()) {
            items.remove(todoList.selected());
            return EventResult.HANDLED;
        }
        if (event.isDown()) {
            todoList.selectNext(items.size());
            return EventResult.HANDLED;
        }
        if (event.isUp()) {
            todoList.selectPrevious();
            return EventResult.HANDLED;
        }
        return EventResult.UNHANDLED;
    }

    public static void runApp() throws Exception {
        new TodoApp().run();
    }
}

