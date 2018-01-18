package com.luwojtaszek.springbootjsp.web.controller;


import com.luwojtaszek.springbootjsp.model.ApiResponse;
import com.luwojtaszek.springbootjsp.repository.ItemRepository;
import com.luwojtaszek.springbootjsp.util.exception.TechnicalException;
import com.luwojtaszek.springbootjsp.web.UrlPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlPaths.PRODUCTS)
public class ProductController {

    @Autowired
    private ItemRepository itemRepository;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = {"/{search}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse show(@PathVariable String search) {
        try {
            List data = itemRepository.search("MCO", search);
            return new ApiResponse(data);
        } catch (TechnicalException ex) {
            return new ApiResponse(false, ex.getMessage(), ex.getCause().getMessage());
        }
    }


}
