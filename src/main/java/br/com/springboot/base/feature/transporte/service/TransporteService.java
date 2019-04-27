package br.com.springboot.base.feature.transporte.service;

import br.com.springboot.base.core.error.ErrorApiException;
import br.com.springboot.base.core.error.Messages;
import br.com.springboot.base.feature.transporte.bean.ConsultaVeiculoTipoResponse;
import br.com.springboot.base.feature.transporte.bean.ConsultaVeiculosResponse;
import br.com.springboot.base.feature.transporte.entity.Veiculos;
import br.com.springboot.base.feature.transporte.repository.TransporteRepository;
import com.mongodb.MongoException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
            List veiculos = new ArrayList();//transporteRepository.findAll();

            if(veiculos.size() > 0){
                ConsultaVeiculosResponse consultaVeiculosResponse = new ConsultaVeiculosResponse();
                veiculos.forEach(obj -> {
                    consultaVeiculosResponse.getContent().add(
                            new ModelMapper().map(obj, br.com.springboot.base.feature.transporte.bean.Veiculos.class)
                    );
                });

                return consultaVeiculosResponse;

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

            Veiculos veiculos = null;//transporteRepository.findByTipoVeiculo(tipo);

            if(veiculos != null){
                ConsultaVeiculoTipoResponse consultaVeiculoTipoResponse = new ConsultaVeiculoTipoResponse();
                consultaVeiculoTipoResponse.setContent(new ModelMapper().map(veiculos, br.com.springboot.base.feature.transporte.bean.Veiculos.class));
                return consultaVeiculoTipoResponse;

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
