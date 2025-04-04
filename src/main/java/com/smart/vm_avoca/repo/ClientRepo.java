package com.smart.vm_avoca.repo;

import com.smart.vm_avoca.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client,Long> {


    void deleteEmployeeById(Long id);

    Optional<Client> findEmployeeById(Long id);
}
