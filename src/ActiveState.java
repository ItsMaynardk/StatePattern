public class ActiveState implements AccountState {

    private final Account account;

    public ActiveState(Account account) {
        this.account = account;
    }

    @Override
    public void deposit(double amount) {
        account.addToBalance(amount);
        System.out.println("Deposit of $" + amount + " successful. Current balance: $" + account.getBalance());
    }

    @Override
    public void withdraw(double amount) {
        if (account.getBalance() >= amount) {
            account.subtractFromBalance(amount);
            System.out.println("Withdrawal of $" + amount + " successful. Current balance: $" + account.getBalance());
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    @Override
    public void activate() {
        System.out.println("Account is already activated!");
    }

    @Override
    public void suspend() {
        account.changeState(new SuspendedState(account));
        System.out.println("Account is suspended!");
    }

    @Override
    public void close() {
        account.changeState(new ClosedState(account));
        System.out.println("Account is closed!");
    }
}