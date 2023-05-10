package idh.java;

public class Bank {
    Account[] accounts = new Account[5];

    public class Account {
        // the balance of the account
        int balance;
        
        // the id of the account
        int id;
    
        public Account(int id, int status) {
            this.id = id;
            this.balance = status;
        }
        
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public int getBalance() {
            return balance;
        }
    
        public void setBalance(int status) {
            this.balance = status;
        }
    }       
}
