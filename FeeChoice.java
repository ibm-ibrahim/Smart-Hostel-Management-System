public class FeeChoice {

    private FeeStrategy feeStrategy;

    public FeeChoice(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public void executePayment() {
        feeStrategy.payFee();
    }
}