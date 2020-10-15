package invoice;

public class InvoiceView {

    public static void main(String[] args) {
        var invoiceView = new InvoiceView();
        invoiceView.printInvoices();
    }

    public void printInvoices()
    {
        InvoicesDao invoicesDao = new H2MemInvoicesDao();
        invoicesDao.save(new Invoice("Pelles gott",99.0));
        invoicesDao.save(new Invoice("ICA Mini",50.0));
        invoicesDao.save(new Invoice("Enegårdens kött",101.0));

        InvoiceFilter filter = new InvoiceFilter(invoicesDao);
        filter.filter().forEach(this::printInvoice);
    }

    public void printInvoice(Invoice invoice){
        System.out.println("Customer: " + invoice.getCustomer());
        System.out.println("Amount: " + invoice.getValue());
    }
}
