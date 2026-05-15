package controller;

import model.entity.Reserva;
import model.repository.ReservaRepository;
import model.service.ReservaService;

import java.util.Map;

public class ReservaController {
    private ReservaService service;

    public ReservaController(ReservaService service){
        this.service = service;
    }

    // CADASTRAR RESERVA
    public void cadastrarReserva(String idUsuario, String idReserva, String idSala, String data, String horario, String status){
        service.cadastrarReserva(idUsuario, idReserva, idSala, data, horario, status);
    }

    // CANCELAR
    public void cancelarReserva(String idReserva){
        service.cancelarReserva(idReserva);
    }
}
