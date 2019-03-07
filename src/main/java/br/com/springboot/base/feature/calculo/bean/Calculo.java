package br.com.springboot.base.feature.calculo.bean;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Calculo implements Serializable {

    private BigDecimal valorTotal;

}
