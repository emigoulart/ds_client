package com.devsuperior.dsclients.repositories;

import com.devsuperior.dsclients.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
