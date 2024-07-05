public class Account {
    private int number;
    private String customer;
    private double balance;
    // you are not allowed to add any more class variables here
    public static Account[] allAccounts = new Account[200];
    public static int totalAccountNumber;
    // you are not allowed to write any other constructor
    public Account(int number, String customer, double balance) {
        this.number = number;
        this.customer = customer;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double b)
    {
        balance = b;
    }


    public int getNumber(){
        return number;
    }

    public String getCustomer(){
        return customer;
    }

    public void printAccInfo()
    {
        System.out.println("Account Number: " + getNumber() + ", Customer Name: " + getCustomer() + ", Balance: " + getBalance());
    }
    // add your code here
}
