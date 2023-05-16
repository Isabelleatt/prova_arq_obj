package api.avaliacao.hotel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer estrelas;
    private Double valorDiaria;

    // Construtores, getters e setters omitidos para fazer o que é importante para a avaliação
    
    // Se necessário comentar o código acima para fazer o que é pedido na avaliação.
    public Hotel() {
    }

    public Hotel(Integer estrelas, Double valorDiaria) {
        this.estrelas = estrelas;
        this.valorDiaria = valorDiaria;
    }

    public Hotel(Long id, Integer estrelas, Double valorDiaria) {
        this.id = id;
        this.estrelas = estrelas;
        this.valorDiaria = valorDiaria;
    }

    public Long getId() {
        return id;
    }

    public Integer getEstrelas() {
        return estrelas;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEstrelas(Integer estrelas) {
        this.estrelas = estrelas;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", estrelas=" + estrelas +
                ", valorDiaria=" + valorDiaria +
                '}';
    }

    public boolean equals(Hotel hotel) {
        return this.id == hotel.getId() &&
                this.estrelas == hotel.getEstrelas() &&
                this.valorDiaria == hotel.getValorDiaria();
    }

}
