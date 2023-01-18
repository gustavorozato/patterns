package patterns.observer.example.listeners;

import patterns.observer.example.services.EmailClient;

public class EmailNotificationListener implements EventListener {
    private final String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType) {
        EmailClient emailClient = new EmailClient();
        emailClient.sendEmail(email, "CONTENT");
    }
}