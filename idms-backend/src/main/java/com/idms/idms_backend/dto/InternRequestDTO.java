package com.idms.idms_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import java.time.LocalDate;

@Data
public class InternRequestDTO {

    @NotBlank
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "^[0-9]{10}$")
    private String mobile;

    @NotNull
    private String idCardType;

    @NotNull
    private LocalDate dateOfJoining;

    @NotNull
    private Long batchId;
}
