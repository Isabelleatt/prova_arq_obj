package api.avaliacao.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    // GET /hotel -> lista todos os filmes cadastrados. Esta rota deve ter dois query params, um que filtra os hoteis pelo número de estrelas, de 1 a 5, e outro que filtra pelo valor minímo da diária.
    public List<Hotel> getHotels(Integer estrelas, Double valorMinimoDiaria) {
        if (estrelas != null && valorMinimoDiaria != null) {
            return hotelRepository.findByEstrelasAndValorDiariaGreaterThanEqual(estrelas, valorMinimoDiaria);
        } else if (estrelas != null) {
            return hotelRepository.findByEstrelas(estrelas);
        } else if (valorMinimoDiaria != null) {
            return hotelRepository.findByValorDiariaGreaterThanEqual(valorMinimoDiaria);
        } else {
            return hotelRepository.findAll();
        }
    }

    // GET /hotel/{idHotel} -> Recupera um hotel específico.POST /hotel -> Cria um hotel, podem definir os dados que serão salvos, mas no minímo deve ter o número de estrelas e o valor da diária.
    public Hotel getHotel(Long idHotel) {
        return hotelRepository.findById(idHotel)
                .orElseThrow(() -> new HotelNotFoundException("Hotel não encontrado"));
    }    

    // POST /hotel -> Cria um hotel, podem definir os dados que serão salvos, mas no minímo deve ter o número de estrelas e o valor da diária.
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    // DELETE /hotel -> Deleta um hotel do banco de dados.
    public void deleteHotel(Long idHotel) {
        hotelRepository.deleteById(idHotel);
    }

    // Exceção para quando o hotel não for encontrado
    public class HotelNotFoundException extends RuntimeException {
        public HotelNotFoundException(String message) {
            super(message);
        }
    }
    
}
