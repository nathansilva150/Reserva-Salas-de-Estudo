package view;

import controller.ReservaController;
import controller.SalaController;
import controller.UsuarioController;
import model.entity.Sala;
import model.repository.ReservaRepository;
import model.repository.SalaRepository;
import model.repository.UsuarioRepository;
import model.service.ReservaService;
import model.service.SalaService;
import model.service.UsuarioService;


public class Inicializar {

    public static UsuarioController criarUsuarioController() {
        UsuarioRepository repository = new UsuarioRepository();
        UsuarioService service = new UsuarioService(repository);
         return new UsuarioController(service);
    }

    public static SalaController criarSalaController(){
        SalaRepository repository = new SalaRepository();
        SalaService service = new SalaService(repository);
        return new SalaController(service);
    }

    public static ReservaController criarReservaController() {
        ReservaRepository repository = new ReservaRepository();
        SalaRepository salaRepository = new SalaRepository();
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        ReservaService service = new ReservaService(repository, salaRepository, usuarioRepository);
        return new ReservaController(service);
    }
}
