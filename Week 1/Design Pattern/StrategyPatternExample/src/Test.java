public class Test {
    public static void main(String[] args) {

        PaymentContext CreditCard = new PaymentContext();
        PaymentContext PayPal = new PaymentContext();

        System.out.println("Credit Card Payment");
        CreditCard.setPayment(new CreditCardPayment());
        CreditCard.makePayment();
        System.out.println();

        System.out.println("PayPal Payment");
        PayPal.setPayment(new PayPalPayment());
        PayPal.makePayment();




    }
}