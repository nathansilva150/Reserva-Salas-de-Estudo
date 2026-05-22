package view;

import controller.SalaController;
import controller.UsuarioController;
import model.repository.SalaRepository;
import model.repository.UsuarioRepository;
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
}
