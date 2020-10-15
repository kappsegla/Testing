package invoice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceFilterTest {

    @Test
    public void filterReturnsEmptyListWhenDatabaseHasNoItemsWithValueLessThan100() {
        //Arrange
        InvoiceFilter invoiceFilter = new InvoiceFilter(  );

        //Act

        //Assert

    }


}