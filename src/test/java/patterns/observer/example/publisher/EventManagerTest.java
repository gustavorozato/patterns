package patterns.observer.example.publisher;

import org.junit.jupiter.api.Test;
import patterns.observer.example.listeners.EventListener;
import patterns.observer.example.listeners.LogSaveListener;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class EventManagerTest {

    @Test
    void subscribe() {
        EventManager eventManager = new EventManager("error");
        eventManager.subscribe("error", new LogSaveListener("test.txt"));
        List listeners = eventManager.listeners.get("error");
        assertEquals(listeners.size(), 1);
        assertTrue(listeners.get(0) instanceof EventListener);
    }

    @Test
    void unsubscribe() {
    }
}