package br.com.springboot.base.feature.transporte.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ConsultaVeiculosResponse implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Veiculos> content;

    public List<Veiculos> getContent() {
        if(content == null)
            content = new ArrayList<>();
        return content;
    }
}
