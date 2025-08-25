package org.example.generics.creategenericinstance;

public class Main {

    public static void main(String [] args){
        Main main = new Main();
        main.useReflectin();
        //main.useSupplier();
        //main.useFactoryNotificationSender();
    }

    private void useReflectin(){
        SenderServiceReflection<EmailSender> service = new SenderServiceReflection<>(EmailSender.class);

        Sender emailSender = service.createInstance();
        String result = emailSender.send();
        System.out.println(result);
    }

    private void useSupplier(){
        SenderServiceSupplier<EmailSender> service = new SenderServiceSupplier<>(EmailSender::new);

        Sender emailSender = service.createInstance();
        String result = emailSender.send();
        System.out.println(result);
    }

    private void useFactoryNotificationSender(){
        SenderServiceFactory<NotificationSender<String>> service = new SenderServiceFactory<>(
                () -> new NotificationSender<>("Hello from Baeldung"));

        NotificationSender<String> notificationSender = service.createInstance();
        String result = notificationSender.send();
        System.out.println(result);
    }

}
