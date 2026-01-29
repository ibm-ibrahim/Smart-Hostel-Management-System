public class MonthlyFee implements FeeStrategy {

    @Override
    public void payFee() {
        System.out.println("Monthly Fee Paid");
    }
}

