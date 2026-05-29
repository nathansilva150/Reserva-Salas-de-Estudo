package view;

import controller.ReservaController;
import controller.SalaController;
import controller.UsuarioController;

import model.repository.ReservaRepository;
import model.repository.SalaRepository;
import model.repository.UsuarioRepository;

import model.service.ReservaService;
import model.service.SalaService;
import model.service.UsuarioService;

public class Inicializar {

    // =========================
    // REPOSITORIES
    // =========================

    private static UsuarioRepository usuarioRepository =
            new UsuarioRepository();

    private static SalaRepository salaRepository =
            new SalaRepository();

    private static ReservaRepository reservaRepository =
            new ReservaRepository();

    // =========================
    // SERVICES
    // =========================

    private static UsuarioService usuarioService =
            new UsuarioService(usuarioRepository);

    private static SalaService salaService =
            new SalaService(salaRepository);

    private static ReservaService reservaService =
            new ReservaService(
                    reservaRepository,
                    salaRepository,
                    usuarioRepository
            );

    // =========================
    // CONTROLLERS
    // =========================

    private static UsuarioController usuarioController =
            new UsuarioController(
                    usuarioService,
                    reservaService
            );

    private static SalaController salaController =
            new SalaController(
                    salaService,
                    reservaService
            );

    private static ReservaController reservaController =
            new ReservaController(
                    reservaService
            );

    // =========================
    // METODOS
    // =========================

    public static UsuarioController criarUsuarioController() {
        return usuarioController;
    }

    public static SalaController criarSalaController() {
        return salaController;
    }

    public static ReservaController criarReservaController() {
        return reservaController;
    }
}