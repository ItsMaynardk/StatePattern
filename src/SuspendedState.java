public class SuspendedState implements AccountState {

    private final Account account;

    public SuspendedState(Account account) {
        this.account = account;
    }

    @Override
    public void deposit(double amount) {
        System.out.println("You cannot deposit on a suspended account!");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("You cannot withdraw on a suspended account!");
    }

    @Override
    public void activate() {
        account.changeState(new ActiveState(account));
        System.out.println("Account is activated!");
    }

    @Override
    public void suspend() {
        System.out.println("Account is already suspended!");
    }

    @Override
    public void close() {
        account.changeState(new ClosedState(account));
        System.out.println("Account is closed!");
    }
}
