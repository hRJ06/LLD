package DIP;

public class Main {
    public static void main(String[] args) {
        NotificationService smsService = new NotificationService(new SMSService());
        smsService.notify("OTP - 1234");

        NotificationService emailService = new NotificationService(new EmailService());
        emailService.notify("OTP - 1234");
    }
}
