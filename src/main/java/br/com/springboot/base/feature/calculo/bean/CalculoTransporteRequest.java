package br.com.springboot.base.feature.calculo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class CalculoTransporteRequest implements Serializable {

    @JsonProperty(value = "distanciaPavimentadoKm", required = true)
    private int distanciaPavimentadoKm;

    @JsonProperty(value = "distanciaNaoPavimentadoKm", required = true)
    private int distanciaNaoPavimentadoKm;

    @JsonProperty(value = "tipoVeiculo", required = true)
    private int tipoVeiculo;

    @JsonProperty(value = "pesoCargaTonelada", required = true)
    private int pesoCargaTonelada;

}
