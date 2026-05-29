package model.service;

import model.entity.Reserva;
import model.entity.Sala;
import model.entity.Usuario;
import java.util.Map;
import model.repository.ReservaRepository;
import model.repository.SalaRepository;
import model.repository.UsuarioRepository;

public class ReservaService {

    private UsuarioRepository usuarioRepository;
    private SalaRepository salaRepository;
    private ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository, SalaRepository salaRepository, UsuarioRepository usuarioRepository){
        this.reservaRepository = reservaRepository;
        this.salaRepository = salaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrarReserva(String idUsuario, String idReserva, String idSala, String data, String horario, String status){
        validarReservaId(idReserva);
        validarReservaData(data);
        validarReservaHorario(horario);

        //Verificar Usuario>
        Usuario usuario = usuarioRepository.buscarUsuarioComId(idUsuario);
        if(usuario == null){
            throw new IllegalArgumentException("ERRO! Usuario inexistente!");
        }

        //Verificar Sala>
        Sala sala = salaRepository.buscarSalaComId(idSala);
        if(sala == null){
            throw new IllegalArgumentException("ERRO! Sala inexistente ");
        }

        //Verificar Capacidade>
        if(sala.getCapacidade() <= 0){
            throw new IllegalArgumentException("ERRO! A capacidade da sala deve ser maior que zero!");
        }

        //Verificar Disponibilidade>
        if(!sala.getDisponivel()){
            throw new IllegalArgumentException("ERRO! Sala indisponivel!");
        }

        //Verificar Conflito>
        validarReservaDuplicada(sala,data,horario);
        Reserva reserva = new Reserva(idReserva, usuario, sala, horario, data, status);

        reservaRepository.salvar(reserva);

        //Caso de sala oucupada>

        sala.setDisponivel(false);

    }

    //Cancelar reserva
    public void cancelarReserva(String idReserva){
        Reserva reserva = reservaRepository.buscarReservaComId(idReserva);

        if(reserva == null){
            throw new IllegalArgumentException("ERRO! Reserva Inexistente!");
        }

        Sala sala = reserva.getSala();
        sala.setDisponivel(true);
        reservaRepository.deletar(idReserva);
    }

    public void validarReservaDuplicada(Sala sala, String data, String horario){
        for(Reserva reserva : reservaRepository.listarReservas().values()){

            boolean mesmaSala = reserva.getSala().getId().equals(sala.getId());
            boolean mesmaData = reserva.getData().equals(data);
            boolean mesmoHorario = reserva.getHorario().equals(horario);

            if(mesmaSala && mesmaData && mesmoHorario){
                throw new IllegalArgumentException("ERRO! Já existe reserva nesta sala neste horario!");
            }
        }
    }

    public void validarReservaId(String id){
        if(id == null || id.isBlank()){
            throw  new IllegalArgumentException("ERRO! O ID não pode estar vazio!");
        }
    }

    public void validarReservaData(String data){
        if(data == null || data.isBlank()){
            throw new IllegalArgumentException("ERRO! A Data não pode estar vazia!");
        }
    }

    public void validarReservaHorario(String horario){
        if(horario == null || horario.isBlank()){
            throw new IllegalArgumentException("ERRO! O Horario não pode estar vazio!");
        }
    }

    public Map<String, Reserva> listarReservas() {
        return reservaRepository.listarReservas();
    }


}
