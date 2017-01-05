package com.pivotal.nab.api.fx.demo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:nabapikey.properties")
public class NabApiKey
{
    @Value("${NAB_API_KEY}")
    private String nabApiKey;

    public NabApiKey()
    {
    }

    public String getNabApiKey() {
        return nabApiKey;
    }

    public void setNabApiKey(String nabApiKey) {
        this.nabApiKey = nabApiKey;
    }

    @Override
    public String toString() {
        return "NabApiKey{" +
                "nabApiKey='" + nabApiKey + '\'' +
                '}';
    }
}
