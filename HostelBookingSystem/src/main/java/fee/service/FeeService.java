package fee.service;

import fee.dao.FeeDAO;
import fee.model.Fee;
import fee.strategy.FeeStrategy;

public class FeeService {
    FeeDAO dao = new FeeDAO();

    // Strategy Pattern: the actual fee behaviour (monthly/yearly) is picked at runtime
    public void payFee(int bookingId, double amount, FeeStrategy strategy) {
        strategy.payFee();
        Fee fee = new Fee(bookingId, amount, strategy.getFeeType());
        dao.payFee(fee);
    }
}
