package serenitylabs.tutorials.testdoubles.mockito;

import org.junit.jupiter.api.Test;
import serenitylabs.tutorials.testdoubles.Authoriser;
import serenitylabs.tutorials.testdoubles.System;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WhenUsingASpy {

    @Test
    public void we_want_to_ensure_that_the_spy_was_called() {
        var mock = mock(Authoriser.class);

        System system = new System(mock);

        system.login("bob", "SecretPassword");

        verify(mock).authorise("bob", "SecretPassword");
    }
}
