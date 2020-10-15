package serenitylabs.tutorials.testdoubles.mockito;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import serenitylabs.tutorials.testdoubles.Authoriser;
import serenitylabs.tutorials.testdoubles.System;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WhenUsingAStub {

    @Test
    public void we_want_to_control_the_returned_value_to_make_the_system_under_test_accept_the_login_attempt() {
        var mock = mock(Authoriser.class);
        when(mock.authorise(anyString(),anyString())).thenReturn(true);

        System system = new System(mock);

        system.login("bob", "SecretPassword");

        assertThat(system.numberOfActiveUsers()).isEqualTo(1);
    }

    @Test
    public void we_want_to_control_the_returned_value_to_make_the_system_under_test_reject_the_login_attempt() {
        var mock = mock(Authoriser.class);

        System system = new System(mock);
        system.login("bob", "SecretPassword");

        assertThat(system.numberOfActiveUsers()).isEqualTo(0);
    }
}
