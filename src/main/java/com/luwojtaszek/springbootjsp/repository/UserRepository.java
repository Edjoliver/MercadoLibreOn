package com.luwojtaszek.springbootjsp.repository;

import com.google.gson.Gson;
import com.luwojtaszek.springbootjsp.model.UserModel;
import com.luwojtaszek.springbootjsp.service.MerchantConnector;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * Created by andresdkm on 17/01/18.
 */
@Repository
public class UserRepository {

    @Autowired
    private MerchantConnector merchantConnector;


    public UserModel me() {
        try {
            Response response = this.merchantConnector.get("/users/me");
            Gson gson = new Gson();
            UserModel userModel = gson.fromJson(response.getResponseBody(), UserModel.class);
            return userModel;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
