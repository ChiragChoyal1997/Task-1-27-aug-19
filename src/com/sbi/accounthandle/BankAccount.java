package com.sbi.accounthandle;

/**
 *
 * @author Chirag
 */
public class BankAccount {
    long ano; //account number
    String name; //account holder name
    long balance; //balance of account
    String actype; //account type
    static long totaldeposit; 
    static long totalwithdrawl;
    
    //Method to open customer account with given details
    public void openAccount(long acno,String cname, int cbalance,String cactype ){
        ano = acno;
        name = cname;
        balance = cbalance;
        actype = cactype;
        totaldeposit = totaldeposit+cbalance;
    }
    
    //Method to dispaly details of an account
    public void displayAccountDetail()
    {
        System.out.println("Account No :- "+ano);
        System.out.println("Account Holder Name :- "+name);
        System.out.println("Total Balance :- "+balance);
        System.out.println("Account Type :- "+actype);
    }
    
    //Method to withdraw money from account
    public void withdraw(int num){
        
        if(balance>num){
        balance = balance-num;
        totalwithdrawl = totalwithdrawl+num;
            System.out.println("Withdrawl successfull");    
        }
        else{
            System.out.println("Do not have enough balance");
        }
    }
    
    //Method to deposit money into the account
    public void deposit(int num){
        try
        {
        balance = balance + num;
        totaldeposit = totaldeposit+num;
        System.out.println("Successfully deposited");
        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }         
    }
    
    //Method to display total_withdrawl and total_deposit from or by all account
    public static void totalDepositAndWithdrawl(){
        System.out.println("Total Money Deposited :- "+totaldeposit);
        System.out.println("Total Money Withdrawl :- "+totalwithdrawl);
    }
    
    //Method to find Average Balance per account in the bank.
    public static void avgBalance(BankAccount...b){
        long sum = 0;
        for(BankAccount n:b){
            sum = sum + n.balance;
        }
        System.out.println("Average Balance :- "+(sum/b.length));
    }
    
    //Constructor to initialize the account for customer.
    public BankAccount(long accountno, String customername, long initialbalance, String accounttype)
    {
        ano = accountno;
        name = customername;
        balance = initialbalance;
        actype = accounttype;
        totaldeposit = totaldeposit + initialbalance;
    }
    
    public BankAccount(){
        
    }
    
    public static void main(String args[])
    {
        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount();
        BankAccount b3 = new BankAccount();
        BankAccount b4 = new BankAccount(80856768,"Chirag Choyal", 20000, "Current Account");
        
        b1.openAccount(963018930, "Vikas Shinde", 10000, "Saving Account");
        b2.openAccount(789456123, "Amrendra Bagga", 5000, "Current Account");
        b3.openAccount(123456789, "Anuj Jhawar", 4000, "Saving Account");
        
        System.out.println("---------------------------------------------------------------------");
        b1.displayAccountDetail();
        System.out.println("---------------------------------------------------------------------");
        b2.withdraw(2500);
        System.out.println("---------------------------------------------------------------------");
        b3.deposit(10000);
        System.out.println("---------------------------------------------------------------------");
        BankAccount.totalDepositAndWithdrawl();
        System.out.println("---------------------------------------------------------------------");
        BankAccount.avgBalance(b1,b2,b3,b4);
        System.out.println("---------------------------------------------------------------------");
    }
}
