package com.eniskeskin.weatherforecastapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name="USER_PROFILE")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String email;
    private String password;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userProfile")
    private List<City> cityList;

    public UserProfile(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
