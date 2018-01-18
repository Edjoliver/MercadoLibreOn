package com.luwojtaszek.springbootjsp.service;

import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;
import jdk.internal.util.xml.impl.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by andresdkm on 16/01/18.
 */
@Service
public class MerchantConnector {

    private Meli meli;

    @Value("${key}")
    private String clientKey;

    @Value("${id}")
    private Long clientId;

    @PostConstruct
    public void load() {
        this.meli = new Meli(this.clientId, this.clientKey);
    }

    public Meli getMeli() {
        return meli;
    }

    public Response get(String url, Map<String, String> headers) {
        try {
            FluentStringsMap params = new FluentStringsMap();
            params.add("access_token", this.meli.getAccessToken());
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                params.add(entry.getKey(), entry.getValue());
            }
            return this.meli.get(url, params);
        } catch (MeliException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Response get(String url) {
        try {
            FluentStringsMap params = new FluentStringsMap();
            params.add("access_token", this.meli.getAccessToken());
            return this.meli.get(url, params);
        } catch (MeliException e) {
            e.printStackTrace();
        }
        return null;
    }


}
