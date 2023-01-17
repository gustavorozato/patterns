package patterns.observer.example.editor;

import patterns.observer.example.publisher.EventManager;

import java.io.File;

public class Editor {
    public EventManager events;

    public Editor() {
        this.events = new EventManager("error");
    }

    public void handleError() {
        events.notify("error");
    }
}