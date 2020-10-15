package invoice;

import java.util.List;

public interface InvoicesDao {
    List<Invoice> all();

    void save(Invoice inv);

    void close();
}
