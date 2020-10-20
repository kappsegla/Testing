package legacy;

public class TestedClass {

    public TestedClass(){
        //Existing code will instantiate this class using the default constructor.
        loginContextFactory = () -> new LoginContext("login", System.out::println);
      }

    private final LoginContextFactory loginContextFactory;

    public TestedClass(LoginContextFactory loginContextFactory)
    {
        //Added new constructor to make the class testable
        this.loginContextFactory = loginContextFactory;
    }


    public LoginContext login(String user, String password) {
        LoginContext lc = loginContextFactory.createLoginContext();
        lc.doThis();
        lc.doThat();
        return lc;
    }
}
interface LoginContextFactory{
    LoginContext createLoginContext();
}


