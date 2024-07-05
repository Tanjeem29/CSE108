public class Branch {
    private int id;
    private String name;
    private Account []  accounts;
    //private Account minBalanceAccount;
    private int accountCount;
    // add your code here
    // there can be at most 20 branches
    private static int totalBranchCount;
    public static Branch[] allBranches= new Branch[20];
    // you are not allowed to write any other constructor
    public Branch(int id, String name) {
        this.id = id;
        this.name = name;
        this.accounts = new Account[10];
        allBranches[totalBranchCount++] = this;
        // add your code here
    }
    public static int getTotalBranchCount()
    {
        return totalBranchCount;
    }
    public int getId(){
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getAccountCount()
    {
        return accountCount;
    }
    public Account getAccount(int i)
    {
        return accounts[i];
    }
    public void addAccount(Account a) {
        accounts[accountCount++] = a;
        //allBranches[getId()-1] = this;
        //allAccounts[totalAccountCount++] = a;
        //allAccounts[totalAccountNumber++] = a;
    }

    public double getBranchBalance(){
        int i;
        double ans = 0;
        for(i = 0; i < accountCount; i++ )
        {
            ans += accounts[i].getBalance();
        }
        return ans;
    }

    public Account getMinBalanceAccount()
    {
        int i;
        Account ans = accounts[0];
        for(i = 1; i < accountCount; i++)
        {
            if(accounts[i].getBalance() < ans.getBalance())
            {
                ans = accounts[i];
            }
        }
        return ans;
    }
    public static  void transferBalance(Account a1, Account a2, double amount)
    {
        a1.setBalance(a1.getBalance()-amount);
        a1.setBalance(a1.getBalance()+amount);
    }
    static void printAllBranchesInfo()
    {
        for(int j = 0; j < getTotalBranchCount(); j++)
        {
            System.out.println("Branch Id: " + allBranches[j].getId() + ", Branch Name: " + allBranches[j].getName());
            for(int i = 0; i < allBranches[j].getAccountCount(); i++)
            {
                allBranches[j].getAccount(i).printAccInfo();
            }
        }
    }


    // add your code here
}
