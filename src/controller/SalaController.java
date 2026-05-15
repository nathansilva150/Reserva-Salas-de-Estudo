package controller;

import model.entity.Sala;
import model.repository.SalaRepository;
import model.service.SalaService;
import java.util.Map;

public class SalaController {
    private SalaService salaService;

    public SalaController(SalaService salaService){
        this.salaService = salaService;
    }

    //Cadastrar
    public void cadastrarSala(String id, int numero, int capacidade, boolean disponivel){
        salaService.cadastrarSala(id,numero,capacidade,disponivel);
    }

    //Buscar
    public Sala buscarSala(String id){
        return salaService.busacrSala(id);
    }

    //Listar
    public Map<String, Sala> listarSala(){
        return salaService.listarSala();
    }

    //Remover
    public void removerSala(String id){
        salaService.removerSala(id);
    }
}
