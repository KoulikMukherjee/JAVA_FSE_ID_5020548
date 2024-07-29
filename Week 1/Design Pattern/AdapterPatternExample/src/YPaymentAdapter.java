public class YPaymentAdapter implements PaymentProcessor{
    private YPaymentGateway YPay;

    public YPaymentAdapter(YPaymentGateway YPay){
        this.YPay = YPay;
    }

    @Override
    public void processPayment(){
        YPay.processYPayment();
    }
    @Override
    public String paymentID(){
        return YPay.YPaymentID();
    }
}
