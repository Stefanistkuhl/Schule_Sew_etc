public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        PaymentProcessor process = new PaymentProcessor();
        PayPalPayment paypal = new PayPalPayment();
        CreditCardPayment card = new CreditCardPayment();
        BankTransferPayment bank = new BankTransferPayment();
        process.process(paypal, 30);
        process.process(card, 40);
        process.process(bank, 60);
    }
}
