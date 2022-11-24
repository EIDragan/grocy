package com.endava.grocy.filters;

import com.endava.grocy.util.EnvReader;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;


public class AuthenticationFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification reqSpec, FilterableResponseSpecification responseSpec, FilterContext context){
        reqSpec.header("GROCY-API-KEY", EnvReader.getApiKey());
        return context.next(reqSpec, responseSpec);
    }

}

