package com.smart.vm_avoca.service;

import com.smart.vm_avoca.exception.UserNotFoundException;
import com.smart.vm_avoca.model.Client;
import com.smart.vm_avoca.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    private ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client addEmployee(Client client){
        client.setEmployeeCode(UUID.randomUUID().toString());
        return clientRepo.save(client);
    }
    public List<Client> findAllEmployees(){
        return clientRepo.findAll();
    }

    public Client updateEmployee(Client client){
        return clientRepo.save(client);
    }

    public Client findEmployeeById(Long id){
        return clientRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User id" + id + "was not found "));
    }
    public void deleteEmployee(Long id){
         clientRepo.deleteEmployeeById(id);
    }
}
