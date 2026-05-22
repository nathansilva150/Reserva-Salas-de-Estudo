package view;

import controller.UsuarioController;
import model.repository.UsuarioRepository;
import model.service.UsuarioService;

public class Inicializar {

    public static UsuarioController criarUsuarioController() {
        UsuarioRepository repository = new UsuarioRepository();
        UsuarioService service = new UsuarioService(repository);
         return new UsuarioController(service);
    }


}
