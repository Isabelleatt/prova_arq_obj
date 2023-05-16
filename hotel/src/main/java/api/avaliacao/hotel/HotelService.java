package api.avaliacao.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

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

    public Hotel getHotel(Long idHotel) {
        return hotelRepository.findById(idHotel)
                .orElseThrow(() -> new HotelNotFoundException("Hotel não encontrado"));
    }    

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(Long idHotel) {
        hotelRepository.deleteById(idHotel);
    }

    public class HotelNotFoundException extends RuntimeException {
        public HotelNotFoundException(String message) {
            super(message);
        }
    }
    
}
