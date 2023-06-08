package com.eniskeskin.weatherforecastapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name="CITY")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_PROFILE_ID",referencedColumnName = "id", nullable=false)
    private UserProfile userProfile;
    private String cityName;

    public City(UserProfile userProfile, String country) {
        this.userProfile = userProfile;
        this.cityName = country;
    }
}
