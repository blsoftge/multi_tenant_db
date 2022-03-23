package br.com.blsoft.multitenantdb.multitentantdb.clientes_sistema;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente-sistema")
public class ClientesistemaController {

    private final ClienteSistemaService clienteSistemaService;

    public ClientesistemaController(ClienteSistemaService clienteSistemaService) {
        this.clienteSistemaService = clienteSistemaService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteSistema>> getAllClienteSistemas() {
        List<ClienteSistema> clienteSistema = clienteSistemaService.getClientesSistema();
        return new ResponseEntity<>(clienteSistema, HttpStatus.OK);
    }

    @GetMapping({"/{clienteSistemaId}"})
    public ResponseEntity<ClienteSistema> getClienteSistema(@PathVariable Long clienteSistemaId) {
        return new ResponseEntity<>(clienteSistemaService.getClienteSistemaById(clienteSistemaId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteSistema> saveClienteSistema(@RequestBody ClienteSistema pClienteSistema) {
        ClienteSistema clienteSistema = clienteSistemaService.insert(pClienteSistema);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("clienteSistema", "/api/cliente-sistema/" + clienteSistema.getId().toString());
        return new ResponseEntity<>(clienteSistema, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{clienteSistemaId}"})
    public ResponseEntity<ClienteSistema> updateClienteSistema(@PathVariable("clienteSistemaId") Long clienteSistemaId, @RequestBody ClienteSistema clienteSistema) {
        clienteSistemaService.update(clienteSistemaId, clienteSistema);
        return new ResponseEntity<>(clienteSistemaService.getClienteSistemaById(clienteSistemaId), HttpStatus.OK);
    }

    @DeleteMapping({"/{clienteSistemaId}"})
    public ResponseEntity<ClienteSistema> deleteClienteSistema(@PathVariable("clienteSistemaId") Long clienteSistemaId) {
        clienteSistemaService.delete(clienteSistemaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
