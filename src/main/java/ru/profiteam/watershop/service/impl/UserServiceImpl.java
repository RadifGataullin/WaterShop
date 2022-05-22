package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.profiteam.watershop.builder.UserBuilder;
import ru.profiteam.watershop.domain.Address;
import ru.profiteam.watershop.domain.City;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.request.CreateUserDto;
import ru.profiteam.watershop.repository.AddressRepository;
import ru.profiteam.watershop.repository.CityRepository;
import ru.profiteam.watershop.repository.UserRepository;
import ru.profiteam.watershop.service.UserService;

import java.util.Optional;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {
    UserBuilder userBuilder;
    UserRepository userRepository;
    CityRepository cityRepository;
    AddressRepository addressRepository;

    @Autowired
    public UserServiceImpl(UserBuilder userBuilder, UserRepository userRepository, CityRepository cityRepository, AddressRepository addressRepository) {
        this.userBuilder = userBuilder;
        this.userRepository = userRepository;
        this.cityRepository = cityRepository;
        this.addressRepository = addressRepository;
    }


    @Override
    public void create(CreateUserDto request) {
        Optional<City> cityOpt = cityRepository.findById(request.getCityId());
        if (cityOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Optional<Address> addressOpt = addressRepository.findById(request.getAddressId());
        if (addressOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        User user = userBuilder.build(request, cityOpt.get(), addressOpt.get());
        userRepository.save(user);

    }
}
