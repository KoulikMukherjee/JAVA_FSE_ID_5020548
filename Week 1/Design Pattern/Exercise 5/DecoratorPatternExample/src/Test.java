public class Test {
    public static void main(String[] args) {

        Notifier emailNotifier = new EmailNotifier();

        Notifier SMSAndEmailNotifier = new SMSNotifierDecorator(new EmailNotifier());

        Notifier SlackAndEmialNotifier = new SlackNotifierDecorator(new EmailNotifier());

        Notifier SMSAndSlackAndEmailNotifier = new SMSNotifierDecorator(new SlackNotifierDecorator(new EmailNotifier()));

        System.out.println("Email Notifier: ");
        emailNotifier.send();
        System.out.print("\n");

        System.out.println("SMS and Email Notifier: ");
        SMSAndEmailNotifier.send();
        System.out.print("\n");

        System.out.println("Slack and Email Notifier: ");
        SlackAndEmialNotifier.send();
        System.out.print("\n");

        System.out.println("SMS, Slack and Email Notifier: ");
        SMSAndSlackAndEmailNotifier.send();

    }
}