package invoice;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class InvoiceFilterTest {

    @Test
    public void filterReturnsEmptyListWhenDatabaseHasNoItemsWithValueLessThan100() {
        //Arrange
        InvoiceFilter invoiceFilter = new InvoiceFilter( new InvoicesDaoStub() );
        //Act
        var result = invoiceFilter.filter();
        //Assert
        assertEquals(0, result.size());
    }

    @Test
    public void makeSureFilterCallsAllOnInvoicesDao(){
        //Don't do this too much. Only validate calls when really needed.
        var invoicesDaoSpy = new InvoicesDaoSpy();
        InvoiceFilter invoiceFilter = new InvoiceFilter(invoicesDaoSpy);
        invoiceFilter.filter();
        assertTrue(invoicesDaoSpy.allIsCalled);
    }

    @Test
    public void testfilterUsingMockitoToVerifyCallToAll(){
        //Using mock object as a spy
        var invoicesDaoMock = mock(InvoicesDao.class);
        InvoiceFilter invoiceFilter = new InvoiceFilter(invoicesDaoMock);
        invoiceFilter.filter();
        verify(invoicesDaoMock).all();
    }

    @Test
    public void testfilterUsingMockedStubOfAll(){
        //Using mock object as a stub
        var invoicesDaoMock = mock(InvoicesDao.class);
        var list = new ArrayList<Invoice>();
        list.add(new Invoice("Test",99.0));
        when(invoicesDaoMock.all()).thenReturn(list);

        InvoiceFilter invoiceFilter = new InvoiceFilter(invoicesDaoMock);
        var result = invoiceFilter.filter();
        assertEquals(list, result);
    }



}