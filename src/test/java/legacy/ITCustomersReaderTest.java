package legacy;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ITCustomersReaderTest {

    @Mock
    private ConfigurationService configurationService;

    private WireMockServer wireMockServer;
    private CustomersReader customersReader;

    @BeforeEach
    public void setUp() {
        wireMockServer = new WireMockServer(options().port(8080)); //No-args constructor will start on port 8080, no HTTPS
        wireMockServer.start();
        customersReader = new CustomersReader(configurationService, HttpClients.createDefault());
    }

    @AfterEach
    public void tearDown() {
        wireMockServer.stop();
    }

    @Test
    public void should_return_json() throws IOException {

        //Configure wireMockServer
        stubFor(get(urlEqualTo("/info"))
                //.withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"hello\" : \"world\" }")));

        when(configurationService.getCustomersUrl()).thenReturn("http://localhost:8080/info");
        JSONObject json = customersReader.read();

        assertThat(json.has("hello"));
        assertThat(json.get("hello")).isEqualTo("world");
    }
}
