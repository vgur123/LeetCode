package org.example.mdc;

public abstract class TransferService {

    public boolean transfer(long amount) {
        beforeTransfer(amount);
        //System.out.println("Transfered: "+amount);
        afterTransfer(amount, true);
        return true;
    }

    abstract protected void beforeTransfer(long amount);

    abstract protected void afterTransfer(long amount, boolean outcome);
}
