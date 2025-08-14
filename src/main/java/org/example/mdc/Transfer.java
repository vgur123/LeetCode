package org.example.mdc;

import lombok.Data;

@Data
public class Transfer {
    private String transactionId;
    private String sender;
    private Long amount;

    public Transfer(String transactionId, String sender, long amount) {
        this.transactionId = transactionId;
        this.sender = sender;
        this.amount = amount;
    }


}