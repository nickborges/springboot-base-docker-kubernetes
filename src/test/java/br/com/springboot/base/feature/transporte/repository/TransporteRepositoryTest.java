package br.com.springboot.base.feature.transporte.repository;

import br.com.springboot.base.feature.transporte.entity.Veiculos;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * @DataJpaTest provides some standard setup needed for testing the persistence layer:
 *
 *  - configuring H2, an in-memory database
 *  - setting Hibernate, Spring Data, and the DataSource
 *  - performing an @EntityScan
 *  - turning on SQL logging
 */
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@DataMongoTest
//@AutoConfigureDataMongo
//@SpringBootTest
public class TransporteRepositoryTest {

    /*@Autowired
    TestEntityManager testEntityManager;*/

    @Autowired
    TransporteRepository transporteRepository;

    //@Test
    public void whenFindAll_thenReturnTransportes(){

        int aux=0;
        List<Veiculos> veiculos = new ArrayList<>();
        veiculos.add(new Veiculos(new ObjectId(),
                1,
                new Decimal128(new BigDecimal(1.15).setScale(2, RoundingMode.HALF_EVEN)),
                "descrição aqui do veiculo")
        );
        veiculos.add(new Veiculos(new ObjectId(),
                2,
                new Decimal128(new BigDecimal(1.15).setScale(2, RoundingMode.HALF_EVEN)),
                "descrição aqui do veiculo")
        );
        veiculos.add(new Veiculos(new ObjectId(),
                3,
                new Decimal128(new BigDecimal(1.15).setScale(2, RoundingMode.HALF_EVEN)),
                "descrição aqui do veiculo")
        );

        List<Veiculos> retorno = transporteRepository.findAll();

        for(Veiculos data: retorno){
            assert(data.getTipoVeiculo()).equals(veiculos.get(aux).getTipoVeiculo());
            aux++;
        }

    }

    //@Test
    public void whenFindByTipo_thenReturnTransporte(){
        Veiculos veiculos = new Veiculos(
                new ObjectId(),
                2,
                new Decimal128(new BigDecimal(1.15)),
                "Van de transporte"
        );

        Veiculos retorno = transporteRepository.findByTipoVeiculo(veiculos.getTipoVeiculo());

        assert(retorno.getTipoVeiculo()).equals(veiculos.getTipoVeiculo());
    }
}
