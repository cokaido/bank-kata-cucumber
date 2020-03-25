package bankkata.builders;

import java.util.Date;

import bankkata.domain.Amount;
import bankkata.domain.Transaction;

public class TransactionBuilder {

    private Date date;
    private Amount value;

    public static TransactionBuilder aTransaction() {
        return new TransactionBuilder();
    }

    public TransactionBuilder with(Date date) {
        this.date = date;
        return this;
    }

    public TransactionBuilder with(Amount value) {
        this.value = value;
        return this;
    }

    public Transaction build() {
        Transaction transaction = new Transaction(value, date);
        return transaction;
    }
}
