package com.eniskeskin.weatherforecastapp.dto.request;

import com.eniskeskin.weatherforecastapp.entity.City;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String email;
    private String password;
    private String password2;

    public UserRequest(String email, String password, String password2) {
        this.email = email;
        this.password = password;
        this.password2 = password2;
    }
}
