package patterns.observer.example.listeners;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogSaveListener implements EventListener {
    private final File log;

    public LogSaveListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType) {
        try(BufferedWriter out = new BufferedWriter(new FileWriter(log.getName(), true))) {
            out.write("Some error happened in the editor at ".concat(formattedNow()));
            out.newLine();
        } catch (IOException e) {
            // LOG ERROR
        }
    }

    private String formattedNow() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}