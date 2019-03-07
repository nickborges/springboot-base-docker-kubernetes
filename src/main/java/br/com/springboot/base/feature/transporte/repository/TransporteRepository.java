package br.com.springboot.base.feature.transporte.repository;

import br.com.springboot.base.feature.transporte.entity.Veiculos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransporteRepository extends MongoRepository<Veiculos, Long>{

    List<Veiculos> findAll();
    Veiculos findByTipoVeiculo(final Integer tipoVeiculo);



}
