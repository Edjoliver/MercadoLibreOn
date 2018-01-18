package com.luwojtaszek.springbootjsp.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.luwojtaszek.springbootjsp.model.CategoryModel;
import com.luwojtaszek.springbootjsp.model.UserModel;
import com.luwojtaszek.springbootjsp.service.MerchantConnector;
import com.ning.http.client.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collector;

/**
 * Created by andresdkm on 17/01/18.
 */
@Repository
public class CategoryRepository {

    @Autowired
    private MerchantConnector merchantConnector;


    public List getAll(String countryId) {
        try {
            Type listType = new TypeToken<List<CategoryModel>>() {
            }.getType();
            Response response = this.merchantConnector.get("/sites/" + countryId + "/categories");
            Gson gson = new Gson();
            List<CategoryModel> categories = gson.fromJson(response.getResponseBody(), listType);
            return categories;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List getById(String categoryId) {
        try {
            Type listType = new TypeToken<List<CategoryModel>>() {
            }.getType();
            Response response = this.merchantConnector.get("/categories/" + categoryId);
            Gson gson = new Gson();
            List<CategoryModel> categories = gson.fromJson(response.getResponseBody(), listType);
            return categories;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
