package com.marcelosarinho.moviereview.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserCreateDTO {
    @NotBlank(message = "Nome é obrigatório!")
    private String name;

    @Email(message = "Email deve ter formato válido!")
    @NotBlank(message = "Email é obrigatório!")
    private String email;

    @NotBlank(message = "Senha é obrigatória!")
    private String password;
}
