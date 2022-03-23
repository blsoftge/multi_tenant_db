package br.com.blsoft.multitenantdb.multitentantdb.clientes_sistema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CLIENTES_DO_SISTEMA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteSistema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 200)
    private String nome;

    @Column(name = "EMPRESA", nullable = false, length = 200)
    private String empresa;

    @Column(name = "SCHEMA_ASSOCIADO", nullable = false, length = 25)
    private String schemaAssociado;

}
