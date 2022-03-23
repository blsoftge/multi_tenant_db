package br.com.blsoft.multitenantdb.multitentantdb.clientes_sistema;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ClienteSistemaServiceImpl implements ClienteSistemaService{

    private ClienteSistemaRepository clienteSistemaRepository;


    public ClienteSistemaServiceImpl(ClienteSistemaRepository clienteSistemaRepository) {
        this.clienteSistemaRepository = clienteSistemaRepository;
    }


    @Override
    public List<ClienteSistema> getClientesSistema() {
        List<ClienteSistema> clienteSistemas = new ArrayList<>();
        this.clienteSistemaRepository.findAll().forEach(clienteSistemas::add);
        return clienteSistemas;
    }

    @Override
    public ClienteSistema getClienteSistemaById(Long id) {
        return this.clienteSistemaRepository.findById(id).get();
    }

    @Override
    public ClienteSistema insert(ClienteSistema clienteSistema) {
        return this.clienteSistemaRepository.save(clienteSistema);
    }

    @Override
    public void update(Long id, ClienteSistema clienteSistema) {
        ClienteSistema clienteSistemaFromDb = this.clienteSistemaRepository.findById(id).get();
        System.out.println(clienteSistemaFromDb.toString());
        clienteSistemaFromDb.setNome(clienteSistema.getNome());
        clienteSistemaFromDb.setEmpresa(clienteSistema.getEmpresa());
        clienteSistemaFromDb.setSchemaAssociado(clienteSistema.getSchemaAssociado());
        clienteSistemaRepository.save(clienteSistemaFromDb);
    }

    @Override
    public void delete(Long id) {
        this.clienteSistemaRepository.deleteById(id);
    }
    
}
