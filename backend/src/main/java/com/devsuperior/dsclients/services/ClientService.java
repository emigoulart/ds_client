package com.devsuperior.dsclients.services;

import com.devsuperior.dsclients.dto.ClientDTO;
import com.devsuperior.dsclients.entities.Client;
import com.devsuperior.dsclients.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private  ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<ClientDTO> findAll(){
        return clientRepository.findAll().stream().map(ClientDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        return clientRepository.findById(id).map(ClientDTO::new).orElse(null);
    }

    @Transactional
    public ClientDTO insert(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setBirthDate(clientDTO.getBirthDate());
        client.setIncome(clientDTO.getIncome());
        client.setChildren(clientDTO.getChildren());
        return new ClientDTO(clientRepository.save(client));
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        try {
            Client client = clientRepository.getOne(id);
            client.setName(clientDTO.getName());
            client.setCpf(clientDTO.getCpf());
            client.setBirthDate(clientDTO.getBirthDate());
            client.setIncome(clientDTO.getIncome());
            client.setChildren(clientDTO.getChildren());
            return new ClientDTO(clientRepository.save(client));
        } catch (EntityNotFoundException entityNotFoundException) {

        }
        return null;
    }
}
