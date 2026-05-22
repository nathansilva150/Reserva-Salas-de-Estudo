package controller;

import model.entity.Reserva;
import model.entity.Sala;
import model.repository.SalaRepository;
import model.service.ReservaService;
import model.service.SalaService;
import java.util.Map;

public class SalaController {
    private SalaService salaService;
    private ReservaService reservaService;
    public SalaController(SalaService salaService, ReservaService reservaService){
        this.salaService = salaService;
        this.reservaService = reservaService;
    }

    //Cadastrar
    public void cadastrarSala(String id, int numero, int capacidade, boolean disponivel){
        salaService.cadastrarSala(id,numero,capacidade,disponivel);
    }

    //Buscar
    public Sala buscarSala(String id){
        return salaService.buscarSala(id);
    }

    //Listar
    public Map<String, Sala> listarSala(){
        return salaService.listarSala();
    }

    //Remover
    public void removerSala(String id){
        Map<String, Reserva> listaReserva = reservaService.listarReservas();

        for (Reserva reserva: listaReserva.values()) {
            if (reserva.getSala().getId().equals(id)){
                throw new IllegalArgumentException("ERRO - Sala não pode ser deletada pois ainda está reservada");
            }
        }
            salaService.removerSala(id);
    }
}
