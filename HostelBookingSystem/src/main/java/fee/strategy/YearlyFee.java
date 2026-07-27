package fee.strategy;

public class YearlyFee implements FeeStrategy {

    @Override
    public void payFee() {
        System.out.println("Yearly Fee Paid");
    }

    @Override
    public String getFeeType() {
        return "YEARLY";
    }
}
