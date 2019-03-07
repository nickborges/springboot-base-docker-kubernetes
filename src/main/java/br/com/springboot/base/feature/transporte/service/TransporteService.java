package br.com.springboot.base.feature.transporte.service;

import br.com.springboot.base.core.error.ErrorGenericApiException;
import br.com.springboot.base.core.error.ErrorParamInvalidApiException;
import br.com.springboot.base.feature.transporte.bean.ConsultaVeiculoTipoResponse;
import br.com.springboot.base.feature.transporte.bean.ConsultaVeiculosResponse;
import br.com.springboot.base.feature.transporte.entity.Veiculos;
import br.com.springboot.base.feature.transporte.repository.TransporteRepository;
import br.com.springboot.base.core.util.Mensagens;
import com.mongodb.MongoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransporteService {

    private final Logger log = LogManager.getLogger(this.getClass());

    @Autowired
    private TransporteRepository transporteRepository;

    public ConsultaVeiculosResponse consultaVeiculos(){

        try{
            List veiculos = transporteRepository.findAll();

            if(veiculos.size() > 0){
                ConsultaVeiculosResponse consultaVeiculosResponse = new ConsultaVeiculosResponse();
                veiculos.forEach(obj -> {
                    consultaVeiculosResponse.getContent().add(
                            new ModelMapper().map(obj, br.com.springboot.base.feature.transporte.bean.Veiculos.class)
                    );
                });

                return consultaVeiculosResponse;

            } else {
                throw new ErrorParamInvalidApiException(
                        Mensagens.T001, Mensagens.ERROR_MESSAGE_TRANPOSTE_N_ENCONTRADO
                );
            }

        } catch(final MongoException ex){
            throw new ErrorGenericApiException(ex);
        }
    }

    public ConsultaVeiculoTipoResponse consultaVeiculoTipo(final Integer tipo){

        try{
            Veiculos veiculos = transporteRepository.findByTipoVeiculo(tipo);

            if(veiculos != null){
                ConsultaVeiculoTipoResponse consultaVeiculoTipoResponse = new ConsultaVeiculoTipoResponse();
                consultaVeiculoTipoResponse.setContent(new ModelMapper().map(veiculos, br.com.springboot.base.feature.transporte.bean.Veiculos.class));
                return consultaVeiculoTipoResponse;
            } else {
                throw new ErrorParamInvalidApiException(Mensagens.T001, Mensagens.ERROR_MESSAGE_TRANPOSTE_N_ENCONTRADO);
            }

        } catch(final MongoException ex){
            throw new ErrorGenericApiException(ex);
        }
    }

}
