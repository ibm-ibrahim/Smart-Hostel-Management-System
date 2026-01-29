// Facade Pattern: Unified interface for hostel-related services

public class HostelFacade {

    private RoomService roomService;
    private ComplaintService complaintService;
    private FeeService feeService;

    public HostelFacade() {
        roomService = new RoomService();
        complaintService = new ComplaintService();
        feeService = new FeeService();
    }

    public void studentOperations() {
        roomService.allocateRoom();
        complaintService.registerComplaint();
        feeService.payFee();
    }
}
