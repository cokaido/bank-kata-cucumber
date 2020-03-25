package bankkata.domain.test;

import bankkata.domain.Account;
import bankkata.domain.Amount;
import bankkata.domain.Statement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;
import java.util.Date;

import static bankkata.builders.DateCreator.date;
import static bankkata.builders.TransactionBuilder.aTransaction;
import static bankkata.domain.Amount.amountOf;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
	
	@Mock private Statement statement;
	private Account account;

	@Before
	public void initialise() {
		account = new Account(statement);
	}
	
	@Test
    public void
	should_add_deposit_line_to_statement() {
		Date depositDate = date("10/01/2012");
		Amount depositAmount = amountOf(1000);
		
		account.deposit(depositAmount, depositDate);
		
		verify(statement).addLineContaining(aTransaction()
												.with(depositDate)
												.with(depositAmount).build(),
											currentBalanceEqualsTo(depositAmount));
	}
	
	@Test
    public void
	should_add_withdraw_line_to_statement() {
		Date withdrawalDate = date("12/01/2012");
		
		account.withdrawal(amountOf(500), withdrawalDate);
		
		verify(statement).addLineContaining(aTransaction()
											.with(amountOf(-500))
											.with(withdrawalDate).build(), 
											amountOf(-500));
	}
	
	@Test
    public void
	should_print_statement() {
		PrintStream printer = System.out;
		
		account.printStatement(printer);
		
		verify(statement).printTo(printer);
	}
	
	private Amount currentBalanceEqualsTo(Amount amount) {
		return amount;
	}

}
