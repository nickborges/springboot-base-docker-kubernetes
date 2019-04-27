package br.com.springboot.base.core.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GET: não deve atualizar nada. Deve ser independete. Possíveis Códigos de Retorno 200 (OK), 404 (NÃO ENCONTRADOS), 400 (BAD REQUEST)
 * POST: deve criar um novo recurso. O ideal é retornar JSON com link para o recurso recém-criado. Os mesmos códigos de retorno que forem possíveis. Além disso - o código de retorno 201 (CREATED) pode ser usado.
 * PUT: atualiza um recurso conhecido. ex: atualiza detalhes do cliente. Códigos de retorno possíveis: 200 (OK) + 404 (NÃO ENCONTRADO) +400 (PEDIDO PROBLEMA)
 * DELETE: Usado para excluir um recurso. Códigos de retorno possíveis: 200 (OK).
 */
@Slf4j
@RestControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(ErrorApiException.class)
    public final ResponseEntity<ErrorApiResponse> handler(final ErrorApiException exception){
        log.error("Error", exception);
        return new ResponseEntity<>(
                exception.getErrorApiResponse(),
                exception.getHttpStatus()
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<ErrorApiResponse> handler(final RuntimeException exception){
        log.error("Error", exception);
        ErrorApiResponse response =
                new ErrorApiResponse(exception.toString());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
