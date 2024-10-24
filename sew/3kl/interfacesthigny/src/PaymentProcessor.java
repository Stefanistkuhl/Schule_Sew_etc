public class PaymentProcessor {
    public void process(IPaymentMethod paymentMethod, double amount) {
        paymentMethod.processPayment(amount);
    }
}
