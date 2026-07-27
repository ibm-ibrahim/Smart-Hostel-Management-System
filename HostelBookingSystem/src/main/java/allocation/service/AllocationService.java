package allocation.service;

import allocation.dao.AllocationDAO;
import allocation.model.RoomAllocation;

public class AllocationService {
    AllocationDAO dao = new AllocationDAO();

    public void addAllocation(RoomAllocation allocation) {
        dao.addAllocation(allocation);
    }

    public void viewAllocations() {
        dao.viewAllocations();
    }
}
