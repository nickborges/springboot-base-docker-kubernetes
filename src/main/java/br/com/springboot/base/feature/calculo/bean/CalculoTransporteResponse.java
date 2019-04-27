package br.com.springboot.base.feature.calculo.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CalculoTransporteResponse implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Calculo content;
}
