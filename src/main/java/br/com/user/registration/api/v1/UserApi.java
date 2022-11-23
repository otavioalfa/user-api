package br.com.user.registration.api.v1;

import br.com.register.commons.v1.dto.ClientDTO;
import br.com.register.commons.v1.errors.Erro400;
import br.com.register.commons.v1.errors.Erro500;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserApi {

    @ApiOperation(value = "Cadastra um novo cliente", nickname = "Cadastro", notes = "Serviço realiza o cadastro de novos clientes.", response = String.class, authorizations = {
            @Authorization(value = "BasicAuth")}, tags = {"Cadastro",})
    @ApiResponses(value = {@ApiResponse(code = 202, message = "Registrando", response = String.class),
            @ApiResponse(code = 400, message = "Requisição inválida", response = Erro400.class),
            @ApiResponse(code = 401, message = "Requisição não autorizada"),
            @ApiResponse(code = 500, message = "Erro interno do servidor", response = Erro500.class)})
    @PostMapping(path = "v1/new-client", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> register(@RequestBody ClientDTO clientDTO);

}
