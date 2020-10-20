package legacy;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import java.io.IOException;

public class CustomersReader {

    private final ConfigurationService configurationService;
    private final CloseableHttpClient httpClient;

    public CustomersReader(ConfigurationService configurationService, CloseableHttpClient httpClient){
        this.configurationService = configurationService;
        this.httpClient = httpClient;
    }


    public JSONObject read() throws IOException {
        String url = configurationService.getCustomersUrl();
        HttpGet get = new HttpGet(url);
        try (CloseableHttpResponse response = httpClient.execute(get)) {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            return new JSONObject(result);
        }
    }
}