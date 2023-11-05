import java.util.Scanner;

class AccountDetails {
    private String accno;
    private String name;
    private String acc_type;
    private long balance;

    public void openAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account no:");
        accno = scanner.next();

        System.out.println("Enter account type:");
        acc_type = scanner.next();

        System.out.println("Enter name:");
        name = scanner.next();

        System.out.println("Enter balance:");
        balance = scanner.nextLong();
    }

    public void showAccount() {
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no: " + accno);
        System.out.println("Account type: " + acc_type);
        System.out.println("Balance: " + balance);
    }

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        long amt;

        System.out.println("Enter the amount you want to deposit:");
        amt = scanner.nextLong();

        balance = balance + amt;
    }

    public void withdrawal() {
        Scanner scanner = new Scanner(System.in);
        long amt;

        System.out.println("Enter the amount you want to withdraw:");
        amt = scanner.nextLong();

        if (balance >= amt) {
            balance = balance - amt;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Your balance is less than " + amt + ". Transaction failed.");
        }
    }

    public boolean search(String ac_no) {
        if (accno.equals(ac_no)) {
            showAccount();
            return true;
        }
        return false;
    }
}

 class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many number of customers do you want to input? ");
        int n = sc.nextInt();
        AccountDetails[] accounts = new AccountDetails[n];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new AccountDetails();
            accounts[i].openAccount();
        }

        int choice;
        do {
            System.out.println("\n**Banking System Application**");
            System.out.println("1. Display all account details");
            System.out.println("2. Search by Account number");
            System.out.println("3. Deposit the amount");
            System.out.println("4. Withdraw the amount");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < accounts.length; i++) {
                        accounts[i].showAccount();
                    }
                    break;
                case 2:
                    System.out.print("Enter account no. you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for (int i = 0; i < accounts.length; i++) {
                        found = accounts[i].search(ac_no);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account no: ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < accounts.length; i++) {
                        found = accounts[i].search(ac_no);
                        if (found) {
                            accounts[i].deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account No: ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < accounts.length; i++) {
                        found = accounts[i].search(ac_no);
                        if (found) {
                            accounts[i].withdrawal();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist.");
                    }
                    break;
                case 5:
                    System.out.println("See you soon...");
                    break;
            }
        } while (choice != 5);
    }
}


