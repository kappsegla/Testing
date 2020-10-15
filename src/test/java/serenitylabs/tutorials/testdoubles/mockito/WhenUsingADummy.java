package serenitylabs.tutorials.testdoubles.mockito;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import serenitylabs.tutorials.testdoubles.Authoriser;
import serenitylabs.tutorials.testdoubles.System;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WhenUsingADummy {

    @Test
    @Disabled("Implement me, please ...")
    public void we_do_not_worry_about_the_value_it_returns_because_we_know_it_will_never_be_used() {

        var mock = mock(Authoriser.class);

        System system = new System(mock);

        assertThat(system.numberOfActiveUsers()).isEqualTo(0);
    }

    @Test
    public void we_make_it_return_a_null_so_that_it_does_not_get_used_accidentally() {
        /*
         * Mockito always returns a 'nice' value, so we son't get a null unless the method in question
         * returns a custom object
         *
         * https://github.com/mockito/mockito/wiki/FAQ#what-values-do-mocks-return-by-default
         */
        var mock = mock(Authoriser.class);
        when(mock.authorise(anyString(),anyString())).thenReturn(null);

        System system = new System(mock);
        assertThatThrownBy(() -> system.login("bob", "SecretPassword")).isInstanceOf(NullPointerException.class);


    }
}
