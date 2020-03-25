package bankkata;

import bankkata.domain.Account;
import bankkata.domain.Statement;

import static bankkata.builders.DateCreator.date;
import static bankkata.domain.Amount.amountOf;

public class StartApp {
	
	public static void main(String[] args) {
		Account account = new Account(new Statement());
		
		account.deposit(amountOf(1000), date("10/01/2012"));
		account.deposit(amountOf(2000), date("13/01/2012"));
		account.withdrawal(amountOf(500), date("14/01/2012"));
		
		account.printStatement(System.out);
	}

}
