package module6_test.lesson6_shop;

import module6_test.lesson6_shop.model.Transaction;

public interface PaymentProcessor {

    void process(Transaction transaction);

}
