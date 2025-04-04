package com.smart.vm_avoca.Controller;

import com.smart.vm_avoca.model.Client;
import com.smart.vm_avoca.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class ClientResource {
    private ClientService clientService;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllEmployees () {
          List<Client> clients = clientService.findAllEmployees();
          return new ResponseEntity<>(clients, HttpStatus.OK);
        }

    @GetMapping("/find/{id}")
    public ResponseEntity<Client> getEmployeeById (@PathVariable("id") Long id) {
        Client client = clientService.findEmployeeById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Client> addEmployee (@RequestBody Client client) {
        Client newClient = clientService.addEmployee(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Client> updateEmployee (@RequestBody Client client) {
        Client updateClient = clientService.updateEmployee(client);
        return new ResponseEntity<>(updateClient, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Client> deleteEmployeeById (@PathVariable("id") Long id) {
        clientService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
