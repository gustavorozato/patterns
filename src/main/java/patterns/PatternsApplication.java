package patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import patterns.observer.example.editor.Editor;
import patterns.observer.example.listeners.EmailNotificationListener;
import patterns.observer.example.listeners.LogSaveListener;

// The purpose of the observers is to simulate an error in an editor.
// This error will trigger a save to a log file as well as sending an email to an admin.
// args[0] should be the log file path and args[1] should be the recipient email,
// args[2] should be the type of the incoming event from our editor, in this case
// we should use "error" for the purpose of this test implementation
@SpringBootApplication
public class PatternsApplication {

	private static final String ERROR_EVENT_TYPE = "error";

	public static void main(String[] args) {
		if (args.length < 3) throw new IllegalArgumentException("Please provide log file name, email and event type.");

		String logFileName = args[0];
		String email = args[1];
		String eventFromEditor = args[2];

		Editor editor = new Editor();
		editor.events.subscribe(ERROR_EVENT_TYPE, new LogSaveListener(logFileName));
		editor.events.subscribe(ERROR_EVENT_TYPE, new EmailNotificationListener(email));

		try {
			if (eventFromEditor.equals(ERROR_EVENT_TYPE)) editor.handleError();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SpringApplication.run(PatternsApplication.class, args);
	}
}
