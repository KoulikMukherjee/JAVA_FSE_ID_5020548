public class XPaymentAdapter implements PaymentProcessor{
    private XPaymentGateway XPay;

    public XPaymentAdapter(XPaymentGateway XPay){
        this.XPay = XPay;
    }

    @Override
    public void processPayment(){
        XPay.processXPayment();
    }
    @Override
    public String paymentID(){
        return XPay.XPaymentID();
    }
}
