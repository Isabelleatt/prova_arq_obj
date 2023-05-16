package api.avaliacao.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // GET /hotel -> lista todos os filmes cadastrados. Esta rota deve ter dois query params, um que filtra os hoteis pelo número de estrelas, de 1 a 5, e outro que filtra pelo valor minímo da diária.
    @GetMapping
    public List<Hotel> getHotels(@RequestParam(required = false) Integer estrelas,
                                 @RequestParam(required = false) Double valorMinimoDiaria) {
        return hotelService.getHotels(estrelas, valorMinimoDiaria);
    }

    // GET /hotel/{idHotel} -> Recupera um hotel específico.POST /hotel -> Cria um hotel, podem definir os dados que serão salvos, mas no minímo deve ter o número de estrelas e o valor da diária.
    @GetMapping("/{idHotel}")
    public Hotel getHotel(@PathVariable Long idHotel) {
        return hotelService.getHotel(idHotel);
    }

    // POST /hotel -> Cria um hotel, podem definir os dados que serão salvos, mas no minímo deve ter o número de estrelas e o valor da diária.
    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.createHotel(hotel);
    }

    // DELETE /hotel -> Deleta um hotel do banco de dados.
    @DeleteMapping("/{idHotel}")
    public void deleteHotel(@PathVariable Long idHotel) {
        hotelService.deleteHotel(idHotel);
    }
}



