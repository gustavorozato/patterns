package patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import patterns.observer.example.editor.Editor;
import patterns.observer.example.listeners.EmailNotificationListener;
import patterns.observer.example.listeners.LogOpenListener;

@SpringBootApplication
public class PatternsApplication {

	public static void main(String[] args) {
		Editor editor = new Editor();
		editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
		editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

		try {
			editor.openFile("test.txt");
			editor.saveFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SpringApplication.run(PatternsApplication.class, args);
	}

}
