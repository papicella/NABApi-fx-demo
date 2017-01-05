package com.pivotal.nab.api.fx.demo;

import com.pivotal.nab.api.fx.demo.beans.FxRate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class Utils
{
    //private static String NAB_API_KEY = "181e2d8d-4d55-4a41-b2ce-3761455fb1ea";

    private static Log logger = LogFactory.getLog(Utils.class);
    private static final JsonParser parser = JsonParserFactory.getJsonParser();

    public static List<FxRate> getFx (String nabApiKey) throws Exception
    {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.developer.nab.com.au/v2/fxrates?v=1";

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-nab-key", nabApiKey);

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HttpEntity<String> response = null;

        response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        Map<String, Object> jsonMap = parser.parseMap(response.getBody());

        Map fxRatesMap = (Map) jsonMap.get("fxRatesResponse");
        List<FxRate> ratesList = (List<FxRate>) fxRatesMap.get("fxRates");

/*        ObjectMapper mapper = new ObjectMapper();
        List<FxRate> rates = mapper.readValue(Arrays.toString(ratesList.toArray()),
            mapper.getTypeFactory().constructCollectionType(List.class, FxRate.class));
*/
        return ratesList;
    }

}
