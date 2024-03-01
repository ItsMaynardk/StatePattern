public interface AccountState {
    void deposit(double amount);
    void withdraw(double amount);
    void activate();
    void suspend();
    void close();
}
