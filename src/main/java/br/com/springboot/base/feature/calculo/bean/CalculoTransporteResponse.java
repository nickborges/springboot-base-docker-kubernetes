package br.com.springboot.base.feature.calculo.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
@ToString
public class CalculoTransporteResponse implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Calculo content;

    @Builder
    @Getter
    @Setter
    public static class Calculo{
        private BigDecimal valorTotal;
    }
}
