package com.idms.idms_backend.dto;

import lombok.Data;

@Data
public class InternResponseDTO {

    private String internId;

    private String name;

    private String email;

    private String mobile;

    private String idCardType;

    private String batchName;
}
