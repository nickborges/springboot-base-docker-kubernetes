package br.com.springboot.base.core.error;

import lombok.*;
import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorApiResponse implements Serializable {

    private String message;

}
