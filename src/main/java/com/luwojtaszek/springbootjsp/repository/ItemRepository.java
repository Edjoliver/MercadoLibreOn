package com.luwojtaszek.springbootjsp.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.luwojtaszek.springbootjsp.model.CategoryModel;
import com.luwojtaszek.springbootjsp.model.ItemModel;
import com.luwojtaszek.springbootjsp.service.MerchantConnector;
import com.ning.http.client.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by andresdkm on 17/01/18.
 */
@Repository
public class ItemRepository {

    @Autowired
    private MerchantConnector merchantConnector;

    public List<ItemModel> search(String countryId, String word) {
        try {
            Type listType = new TypeToken<List<ItemModel>>() {
            }.getType();
            Response response = this.merchantConnector.get("/sites/" + countryId + "/search?q=" + word + "&condition=new&sort=price_asc");
            Gson gson = new Gson();
            List<ItemModel> items = gson.fromJson(response.getResponseBody(), listType);
            return items;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
