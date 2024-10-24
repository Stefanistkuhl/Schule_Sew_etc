public class BankTransferPayment implements IPaymentMethod {
    @Override
    public void processPayment(double amount) {

        System.out.println("thing"+ amount);
    }
}
