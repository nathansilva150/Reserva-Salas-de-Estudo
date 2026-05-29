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
        ReservaRepository reservaRepository = new ReservaRepository();
        SalaRepository salaRepository = new SalaRepository();
        ReservaService reservaService = new ReservaService(reservaRepository, salaRepository, repository);

         return new UsuarioController(service, reservaService);
    }

    public static SalaController criarSalaController(){
        SalaRepository repository = new SalaRepository();
        SalaService service = new SalaService(repository);
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        ReservaRepository reservaRepository = new ReservaRepository();
        ReservaService reservaService = new ReservaService(reservaRepository,repository ,usuarioRepository );
        return new SalaController(service, reservaService);
    }

    public static ReservaController criarReservaController() {
        ReservaRepository repository = new ReservaRepository();
        SalaRepository salaRepository = new SalaRepository();
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        ReservaService service = new ReservaService(repository, salaRepository, usuarioRepository);
        return new ReservaController(service);
    }
}
