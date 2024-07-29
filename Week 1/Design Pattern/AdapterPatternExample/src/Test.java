public class Test {
    public static void main(String[] args) {

        XPaymentGateway XPayment = new XPaymentGateway();
        YPaymentGateway  YPayment = new YPaymentGateway();

        XPaymentAdapter XPay = new XPaymentAdapter(XPayment);
        YPaymentAdapter YPay = new YPaymentAdapter(YPayment);

        XPay.processPayment();
        System.out.println("Payment ID: " + XPay.paymentID());


        YPay.processPayment();
        System.out.println("Payment ID: " + YPay.paymentID());
    }
}