package com.io.znk.ctalin.service;

import com.io.znk.ctalin.model.jpa.Customer;
import com.io.znk.ctalin.model.jpa.Receipt;
import java.util.List;

public interface ReceiptService {

    List<Receipt> findAll();

    boolean deleteReceipt(Receipt cus);

    Receipt updateReceipt(Receipt cus);

    Receipt findReceipt(Receipt cus);

    List<Receipt> findByCustomer(Customer customer);

    Receipt createReceipt(Receipt receipt);
}
