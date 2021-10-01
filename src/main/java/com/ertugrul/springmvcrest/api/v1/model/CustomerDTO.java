package com.ertugrul.springmvcrest.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDTO {
    private long id;
    @ApiModelProperty(value = "This is the first name", required = true)
    private String firstName;
    @ApiModelProperty(required = true )
    private String lastName;
    private String customerUrl;
}
