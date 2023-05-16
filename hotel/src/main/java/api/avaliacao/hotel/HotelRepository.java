package api.avaliacao.hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByEstrelas(Integer estrelas);
    List<Hotel> findByValorDiariaGreaterThanEqual(Double valorMinimoDiaria);
    List<Hotel> findByEstrelasAndValorDiariaGreaterThanEqual(Integer estrelas, Double valorMinimoDiaria);
}

