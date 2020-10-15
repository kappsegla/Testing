package invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoicesDaoStub implements InvoicesDao{

    @Override
    public List<Invoice> all() {
        var v = new ArrayList<Invoice>();
        v.add(new Invoice("HejåHå",101.0));
        return v;
    }

    @Override
    public void save(Invoice inv) {

    }

    @Override
    public void close() {

    }
}
