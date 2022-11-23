package br.com.user.registration.service.Impl;

import br.com.register.commons.v1.dto.ClientDTO;
import br.com.user.registration.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClientServiceImpl implements UserService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private static final String topic = "Registrar.usuario";

    @Override
    public void newClient(ClientDTO clientDTO) {
        log.info("[UserService.clientRegister] Inicio metodo");

        try {
            if (clientDTO != null) {
                kafkaTemplate.send(topic, clientDTO);
            }
        } catch (Exception e) {
            log.error("UserService.clientRegister: {}", e);
        }
    }
}
