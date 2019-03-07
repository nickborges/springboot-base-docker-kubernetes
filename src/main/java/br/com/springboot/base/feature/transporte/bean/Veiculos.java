package br.com.springboot.base.feature.transporte.bean;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Veiculos {

    private String id;
    private Integer tipoVeiculo;
    private BigDecimal fatorMultiplicador;
    private String descricaoVeiculo;

}
