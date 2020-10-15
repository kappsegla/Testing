package invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoicesDaoSpy implements InvoicesDao {
    public boolean allIsCalled;

    @Override
    public List<Invoice> all() {
        allIsCalled = true;
        return new ArrayList<>();
    }

    @Override
    public void save(Invoice inv) {

    }

    @Override
    public void close() {

    }
}
