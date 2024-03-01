public class Account {

    private String accountNumber;
    private double balance;
    private AccountState currentState;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.currentState = new ActiveState(this); // Initial state is active
    }

    // Delegate actions to the current state
    public void deposit(double amount) {
        currentState.deposit(amount);
    }

    public void withdraw(double amount) {
        currentState.withdraw(amount);
    }

    public void activate() {
        currentState.activate();
    }

    public void suspend() {
        currentState.suspend();
    }

    public void close() {
        currentState.close();
    }

    public double getBalance() {
        return balance;
    }

    public void addToBalance(double amount) {
        this.balance += amount;
    }

    public void subtractFromBalance(double amount) {
        this.balance -= amount;
    }

    public void changeState(AccountState newState) {
        this.currentState = newState;
    }
}