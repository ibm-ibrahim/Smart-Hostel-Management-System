package fee.strategy;

public class MonthlyFee implements FeeStrategy {

    @Override
    public void payFee() {
        System.out.println("Monthly Fee Paid");
    }

    @Override
    public String getFeeType() {
        return "MONTHLY";
    }
}
