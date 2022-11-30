public class CheckAccountInfo extends Account {

    public CheckAccountInfo() {
        super();
    }

    public CheckAccountInfo(int accountNumber) {
        super(accountNumber);

    }

    //WITHDRAW  
    public void deposit(double amount) {

        if( amount > 0) {
            balance += amount;
            System.out.println("Amount deposited: " + amount);
            System.out.println("Current Balance is: " + balance);
            
        } else {
            System.out.println("This amount cannot be deposited.");
        }
    }

    // WITHDRAW 
    public void withdraw(double amount) {

        if(amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
            System.out.println("Current Balance is: " + balance);
        } else {
            System.out.println("This amount cannot be withdrawn.");
        }
    }
}