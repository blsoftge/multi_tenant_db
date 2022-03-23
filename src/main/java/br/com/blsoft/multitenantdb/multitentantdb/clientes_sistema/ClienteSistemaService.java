package br.com.blsoft.multitenantdb.multitentantdb.clientes_sistema;

import java.util.List;

public interface ClienteSistemaService {
    List<ClienteSistema> getClientesSistema();
    ClienteSistema getClienteSistemaById(Long id);
    ClienteSistema insert(ClienteSistema clienteSistema);
    void update(Long id, ClienteSistema clienteSistema);
    void delete(Long id);
}
