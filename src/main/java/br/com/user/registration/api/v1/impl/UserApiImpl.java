package br.com.user.registration.api.v1.impl;

import br.com.register.commons.v1.dto.ClientDTO;
import br.com.user.registration.api.v1.UserApi;
import br.com.user.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserApiImpl implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<String> register(ClientDTO clientDTO) {
        userService.newClient(clientDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
