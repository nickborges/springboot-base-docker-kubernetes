package br.com.springboot.base.feature.transporte.bean;

import br.com.springboot.base.core.bean.Messages;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class ConsultaVeiculoTipoResponse implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Messages messages;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Veiculos content;

}
