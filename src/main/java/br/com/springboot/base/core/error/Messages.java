package br.com.springboot.base.core.error;

import lombok.Getter;

@Getter
public enum Messages {
    INVALID_PARAM("Parâmetro inválido."),
    VEHICLE_NOT_FOUND("Veículo não encontrado."),
    VEHICLE_TYPE_NOT_FOUND("Tipo de veículo não encontrado."),
    TRANSPORT_NOT_FOUND("O dados do transporte não foram encontrados.");

    private String message;

    Messages(String message) {
        this.message = message;
    }
}
