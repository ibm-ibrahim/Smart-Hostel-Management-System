public class YearlyFee implements FeeStrategy {

    @Override
    public void payFee() {
        System.out.println("Yearly Fee Paid");
    }
}
