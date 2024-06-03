package com.transac.transac.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder

public class WebResponeModel<T> {

    private int status;
    private String errors;
    private String message;
    private T data;
    
}
