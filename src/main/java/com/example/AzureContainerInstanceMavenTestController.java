package com.example;

import io.micronaut.http.annotation.*;

@Controller("/azureContainerInstanceMavenTest")
public class AzureContainerInstanceMavenTestController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}