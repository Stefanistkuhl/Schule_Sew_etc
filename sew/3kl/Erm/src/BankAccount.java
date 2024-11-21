public class BankAccount {
    String accountHolderName;
    double balance;

    public void deposit(double amount){
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        if (amount > this.balance) {
            throw new InsufficientFundsException("zu wenig geld");
        }
    }

    public void transfer(BankAccount toAccount, double amount) throws InvalidAccountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        if (toAccount == null) {
            throw new InvalidAccountException("account nicht gefunden");
        }
        if (amount>this.balance){
            throw new InsufficientFundsException("zu wenig geld");
        }
    }

    public void printAccountDetails() {
        System.out.println("name: " + this.accountHolderName + "\n balance: " + this.balance);
    }

    public BankAccount(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
}
