package serenitylabs.tutorials.testdoubles.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import serenitylabs.tutorials.testdoubles.Authoriser;
import serenitylabs.tutorials.testdoubles.System;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WhenUsingAMock {

    @Mock
    Authoriser mock;
    @InjectMocks
    System system;

    @Test
    public void we_want_to_move_the_test_logic_from_the_test_to_the_mock_object() {
        //var mock = mock(Authoriser.class);
        //System system = new System(mock);
        system.login("bob", "SecretPassword");

        verify(mock).authorise("bob", "SecretPassword");
    }
}
