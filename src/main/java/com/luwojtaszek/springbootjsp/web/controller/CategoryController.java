package com.luwojtaszek.springbootjsp.web.controller;

import com.luwojtaszek.springbootjsp.model.ApiResponse;
import com.luwojtaszek.springbootjsp.repository.CategoryRepository;
import com.luwojtaszek.springbootjsp.util.exception.TechnicalException;
import com.luwojtaszek.springbootjsp.web.UrlPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by andresdkm on 17/01/18.
 */
@RestController
@RequestMapping(UrlPaths.CATEGORIES)
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse index() {
        try {
            List data=this.categoryRepository.getAll("MCO");
            return new ApiResponse(true, data);
        } catch (TechnicalException ex) {
            return new ApiResponse(false, ex.getMessage(), ex.getCause().getMessage());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse show(@PathVariable String id) {
        try {
            Object data = this.categoryRepository.getById(id);
            return new ApiResponse(data);
        } catch (TechnicalException ex) {
            return new ApiResponse(false, ex.getMessage(), ex.getCause().getMessage());
        }
    }
}
