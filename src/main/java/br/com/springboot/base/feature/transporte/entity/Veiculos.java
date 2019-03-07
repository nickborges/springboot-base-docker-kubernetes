package br.com.springboot.base.feature.transporte.entity;

import lombok.*;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @TextIndexed
 * @TextScore
 */
@Document(collection="veiculos")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Veiculos {

    @Id
    private ObjectId id;
    private Integer tipoVeiculo;
    private Decimal128 fatorMultiplicador;
    private String descricaoVeiculo;
}
