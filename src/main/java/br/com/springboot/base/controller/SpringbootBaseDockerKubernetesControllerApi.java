package br.com.springboot.base.controller;

import br.com.springboot.base.feature.calculo.bean.CalculoTransporteRequest;
import br.com.springboot.base.feature.calculo.bean.CalculoTransporteResponse;
import br.com.springboot.base.feature.transporte.bean.ConsultaVeiculosResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

@Api
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Bad Request: Parâmetro informado é inválido."),
        @ApiResponse(code = 401, message = "Usuário não autenticado."),
        @ApiResponse(code = 403, message = "Usuário sem permissão."),
        @ApiResponse(code = 404, message = "Recurso não encontrado."),
        @ApiResponse(code = 500, message = "Erro interno do servidor."),
        @ApiResponse(code = 503, message = "Erro comunicação gatway."),
        @ApiResponse(code = 504, message = "Serviço inexistente.")
})
interface SpringbootBaseDockerKubernetesControllerApi {

    @ApiOperation(value = "Retrieve a teste.")
    @ApiResponses({
            @ApiResponse(code = 200,
                    message = "Operação realizada com sucesso.",
                    response = String.class)
    })
    ResponseEntity<String> teste();

    @ApiOperation(value = "Retrieve a list of ConsultaVeiculosResponse.")
    @ApiResponses({
            @ApiResponse(code = 200,
                         message = "Operação realizada com sucesso.",
                         response = ConsultaVeiculosResponse.class)
    })
    ResponseEntity<ConsultaVeiculosResponse> consultaVeiculos();


    @ApiOperation(value = "Retrieve a list of CalculoTransporteResponse.")
    @ApiResponses({
            @ApiResponse(code = 200,
                         message = "Operação realizada com sucesso.",
                         response = CalculoTransporteResponse.class)
    })
    ResponseEntity<CalculoTransporteResponse> calculoTransporte(CalculoTransporteRequest calculoTransporteRequest);

}
