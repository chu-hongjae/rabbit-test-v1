package com.example.securityv1.model.vo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MessageVO {

    @NotBlank
    private String messageId;
    @NotBlank
    private String body;
}
