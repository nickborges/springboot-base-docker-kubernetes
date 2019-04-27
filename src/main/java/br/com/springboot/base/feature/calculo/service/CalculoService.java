package br.com.springboot.base.feature.calculo.service;

import br.com.springboot.base.feature.calculo.bean.Calculo;
import br.com.springboot.base.feature.calculo.bean.CalculoTransporteRequest;
import br.com.springboot.base.feature.calculo.bean.CalculoTransporteResponse;
import br.com.springboot.base.feature.transporte.bean.ConsultaVeiculoTipoResponse;
import br.com.springboot.base.feature.transporte.service.TransporteService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import br.com.springboot.base.core.error.ErrorApiException;

@Slf4j
@Service
public class CalculoService {

    @Autowired
    TransporteService transporteService;

    public CalculoTransporteResponse calculoTransporte(final CalculoTransporteRequest calculoTransporteRequest){

        CalculoTransporteResponse calculoTransporteResponse = new CalculoTransporteResponse();

        ConsultaVeiculoTipoResponse consultaVeiculoTipoResponse =
                transporteService.consultaVeiculoTipo(calculoTransporteRequest.getTipoVeiculo());

        Double calculo = new Double(0);
        //Pavimentada R$0,54 x Km
        if(calculoTransporteRequest.getDistanciaPavimentadoKm() > 0){
            calculo = calculo + (calculoTransporteRequest.getDistanciaPavimentadoKm() * 0.54);
        }
        //Não-pavimentada R$0,62 x Km
        if(calculoTransporteRequest.getDistanciaNaoPavimentadoKm() > 0){
            calculo = calculo + (calculoTransporteRequest.getDistanciaNaoPavimentadoKm() * 0.62);
        }

        calculo = calculo * consultaVeiculoTipoResponse.getContent().getFatorMultiplicador().doubleValue();

        //Tonelada excedente
        BigDecimal excedente = new BigDecimal(0);
        if(calculoTransporteRequest.getPesoCargaTonelada() > 5){
            excedente = new BigDecimal(
                    ((calculoTransporteRequest.getPesoCargaTonelada() - 5) * 0.02) *
                            (calculoTransporteRequest.getDistanciaPavimentadoKm() + calculoTransporteRequest.getDistanciaNaoPavimentadoKm())
            ).setScale(2, RoundingMode.HALF_EVEN);
        }

        excedente = new BigDecimal(excedente.doubleValue() + calculo).setScale(2, RoundingMode.HALF_EVEN);

        calculoTransporteResponse.setContent(new Calculo(excedente));

        return calculoTransporteResponse;
    }

}
