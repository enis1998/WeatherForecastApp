package com.eniskeskin.weatherforecastapp.service;

import com.eniskeskin.weatherforecastapp.dao.UserRepository;
import com.eniskeskin.weatherforecastapp.entity.City;
import com.eniskeskin.weatherforecastapp.entity.UserProfile;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;
    private static List<City> cityList;

    private static Long id;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        cityList = new ArrayList<>();
    }
    public boolean saveUser(String email, String password, String password2) {
        if (password.equals(password2)) {
            List<UserProfile> userProfileList = userRepository.findAll();
            List<UserProfile> userFiltered = userProfileList.stream().filter(c -> c.getEmail().equals(email)).collect(Collectors.toList());

            if (userFiltered.isEmpty()) {
                UserProfile userProfile = new UserProfile(email, password);
                userRepository.save(userProfile);
                return true;
            }
        }
        return false;
    }
    public boolean loginCheck(String email, String password) {
        List<UserProfile> userProfileList = userRepository.findAll();
        if (userProfileList.isEmpty()) {
            return false;
        }
        Optional<UserProfile> userProfile = userProfileList.stream().filter(c -> c.getEmail().equals(email) && c.getPassword().equals(password)).findFirst();
        if (userProfile.isEmpty()) {
            return false;
        }
        id = userProfile.get().getId();
        return true;
    }
    public void saveCountry(String country) {
        List<UserProfile> userProfileList = userRepository.findAll();
        if (!userProfileList.isEmpty()) {
            Optional<UserProfile> userProfile = userProfileList.stream().filter(c -> c.getId().equals(id)).findFirst();
            City city = new City(userProfile.get(), country);
            cityList.add(city);
            userProfile.get().setCityList(cityList);
        }

    }
}
