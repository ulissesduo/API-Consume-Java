package ConsumeAPI.AlphaVantageAPI.service;

import ConsumeAPI.AlphaVantageAPI.FinanceEntity;
import ConsumeAPI.AlphaVantageAPI.FinanceEntity2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.net.HttpURLConnection;
import java.util.Collections;

@Service
public class FinanceService {

    private static HttpURLConnection con;
    private static final String apiKey = "apikey";

    private static final String url = "https://financialmodelingprep.com/api/v3/profile/{symbol}?apikey=" + apiKey;

    @Autowired
    private RestTemplate restTemplate;

    public FinanceEntity[] getAllFinanceData(String symbol) {
        try {
            String actualUrl = url.replace("{symbol}", symbol);

            HttpHeaders headers = new HttpHeaders();
            headers.set("apiKey", apiKey);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            ResponseEntity<FinanceEntity[]> response = restTemplate.exchange(actualUrl, HttpMethod.GET, new HttpEntity<>(headers), FinanceEntity[].class);

            return response.getBody();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong");
        }
    }

    public FinanceEntity2[] getAllFinanceDataNasdac(String symbol) {
        try {
            //String actualUrl = url.replace("{symbol}", symbol);

            HttpHeaders headers = new HttpHeaders();
            headers.set("apiKey", apiKey);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            ResponseEntity<FinanceEntity2[]> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), FinanceEntity2[].class);


            return response.getBody();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong");
        }
    }
}
