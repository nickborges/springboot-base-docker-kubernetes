package br.com.springboot.base.feature.transporte.service;

import br.com.springboot.base.core.error.ErrorApiException;
import br.com.springboot.base.core.error.Messages;
import br.com.springboot.base.feature.transporte.bean.ConsultaVeiculoTipoResponse;
import br.com.springboot.base.feature.transporte.bean.ConsultaVeiculosResponse;
import br.com.springboot.base.feature.transporte.entity.Veiculos;
import br.com.springboot.base.feature.transporte.repository.TransporteRepository;
import com.mongodb.MongoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TransporteService {

    @Autowired
    private TransporteRepository transporteRepository;

    public ConsultaVeiculosResponse consultaVeiculos(){

        try{
            List<ConsultaVeiculosResponse.Veiculos> lista = new ArrayList();

            List<Veiculos> veiculos = transporteRepository.findAll();

            if(veiculos.size() > 0){
                veiculos.forEach(obj -> {
                    lista.add(
                            ConsultaVeiculosResponse.Veiculos
                                    .builder()
                                    .descricaoVeiculo(obj.getDescricaoVeiculo())
                                    .fatorMultiplicador(obj.getFatorMultiplicador().bigDecimalValue().setScale(2))
                                    .tipoVeiculo(obj.getTipoVeiculo())
                                    .build()
                    );
                });

                return ConsultaVeiculosResponse
                        .builder()
                        .content(lista)
                        .build();

            } else {
                throw new ErrorApiException(
                        Messages.VEHICLE_NOT_FOUND.getMessage(),
                        HttpStatus.BAD_REQUEST
                );
            }

        } catch(final MongoException exception){
            throw new ErrorApiException(exception,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ConsultaVeiculoTipoResponse consultaVeiculoTipo(final Integer tipo){

        try{

            Veiculos veiculos = transporteRepository.findByTipoVeiculo(tipo);

            if(veiculos != null){
                ConsultaVeiculoTipoResponse response =
                        ConsultaVeiculoTipoResponse
                                .builder()
                                .content(ConsultaVeiculoTipoResponse.Veiculos
                                        .builder()
                                        .descricaoVeiculo(veiculos.getDescricaoVeiculo())
                                        .fatorMultiplicador(veiculos.getFatorMultiplicador().bigDecimalValue().setScale(2))
                                        .tipoVeiculo(veiculos.getTipoVeiculo())
                                        .build())
                                .build();
                return response;

            } else {
                throw new ErrorApiException(
                        Messages.VEHICLE_TYPE_NOT_FOUND.getMessage(),
                        HttpStatus.BAD_REQUEST
                );
            }

        } catch(final MongoException exception){
            throw new ErrorApiException(exception,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
