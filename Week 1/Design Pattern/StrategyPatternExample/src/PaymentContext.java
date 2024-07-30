public class PaymentContext {
    PaymentStrategy paymentStrategy;
    public void setPayment(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(){
        paymentStrategy.pay();
    }
}
