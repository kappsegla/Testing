package legacy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TestedClassTest {

    @Test
    public void loginMethodReturnsLoginContext(){
        var mock = mock(LoginContext.class);

        TestedClass testedClass = new TestedClass(() -> {return mock;});
    }

}