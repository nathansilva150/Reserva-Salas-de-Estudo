package controller;

import model.entity.Reserva;
import model.repository.ReservaRepository;
import model.service.ReservaService;
import model.service.UsuarioService;

import model.entity.Usuario;
import model.repository.UsuarioRepository;
import java.util.Map;

public class UsuarioController {
    private UsuarioService usuarioService;
    private ReservaService reservaService;

    public UsuarioController(UsuarioService usuarioService, ReservaService reservaService){
        this.usuarioService = usuarioService;
        this.reservaService = reservaService;
    }

    //Cadastrar
    public void cadastrarUsuario(String id, String nome, String cpf){
        usuarioService.cadastrarUsuario(id, nome, cpf);
    }

    //Buscar
    public Usuario buscarUsuario(String id){
        return usuarioService.buscarUsuario(id);
    }

    //Listar
    public Map<String, Usuario> listarUsuario(){
        return usuarioService.listarUsuario();
    }

    //Remover
    public void removerUsuario(String id){
        validarDelete(id);
        usuarioService.removerUsuario(id);
    }

    public void validarDelete(String id) {
        Map<String, Reserva> listaReserva = reservaService.listarReservas();

        for (Reserva reserva: listaReserva.values()) {
            if(reserva.getSala().getId().equals(id)){
                throw new IllegalArgumentException("ERRO - Usuario ainda possui reservas pendentes");
            }
        }
    }

    public void atualizarNome(String idUser, String nome){
        usuarioService.atualizarNome(idUser, nome);
    }

    public void atualizarCPF(String idUser, String cpf){
        usuarioService.atualizarCPF(idUser, cpf);
    }





}
