document.addEventListener('DOMContentLoaded', function () {
    const hotelForm = document.getElementById('hotel-form');
    const hotelList = document.getElementById('hotel-list');
  
    hotelForm.addEventListener('submit', function (e) {
      e.preventDefault();
  
      const estrelasInput = document.getElementById('estrelas');
      const valorDiariaInput = document.getElementById('valorDiaria');
  
      const hotelData = {
        estrelas: parseInt(estrelasInput.value),
        valorDiaria: parseFloat(valorDiariaInput.value)
      };
  
      createHotel(hotelData);
      hotelForm.reset();
    });
  
    function createHotel(hotelData) {
      fetch('http://localhost:8080/hotel', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(hotelData)
      })
        .then(response => response.json())
        .then(data => {
          // Exemplo de exibição do ID do hotel após salvar
          alert(`Hotel salvo com sucesso! ID: ${data.id}`);
        })
        .catch(error => {
          console.error('Erro ao salvar hotel:', error);
        });
    }
  
    function getHotels() {
      fetch('http://localhost:8080/hotel')
        .then(response => response.json())
        .then(data => {
          hotelList.innerHTML = '';
  
          data.forEach(hotel => {
            const li = document.createElement('li');
            li.textContent = `ID: ${hotel.id}, Estrelas: ${hotel.estrelas}, Valor Diária: ${hotel.valorDiaria}`;
            hotelList.appendChild(li);
          });
        })
        .catch(error => {
          console.error('Erro ao obter hotéis:', error);
        });
    }
  
    // Chama a função para obter os hotéis quando a página é carregada
    getHotels();
  });
  