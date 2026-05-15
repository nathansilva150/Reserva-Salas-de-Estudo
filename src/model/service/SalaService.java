package model.service;

import java.util.HashMap;
import java.util.Map;

import model.entity.Sala;
import model.repository.SalaRepository;

public class SalaService {
    private SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository){
        this.salaRepository = salaRepository;
    }

    public void cadastrarSala(String id, int numero, int capacidade, boolean disponivel){
        validarSalaId(id);
        validarSalaNumero(numero);
        validarSalaCapacidade(capacidade);

        Sala sala = new Sala(id, numero, capacidade, disponivel);
        salaRepository.salvar(sala);
    }

    public void validarSalaId(String id){
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("ERRO! O ID não pode estar vazio!");
        }
    }

    public void validarSalaNumero(int numero){
        if(numero <= 0){
            throw new IllegalArgumentException("ERRO! O Numero deve ser maior que zero!");
        }
    }

    public void validarSalaCapacidade(int capacidade){
        if(capacidade <= 0){
            throw new IllegalArgumentException("ERRO! A Capacidade deve ser maior que zero!");
        }
    }

    //Busacr
    public Sala busacrSala(String id){
        Sala sala = salaRepository.buscarSalaComId(id);

        if(sala == null){
            throw new IllegalArgumentException("ERRO! Sala não encontrada!");
        }

        return sala;
    }

    //Listar
    public Map<String, Sala> listarSala(){
        return salaRepository.listarSalas();
    }

    //Remover
    public void removerSala(String id){
        boolean removido = salaRepository.deletar(id);

        if(!removido){
            throw new IllegalArgumentException("ERRO! A Sala não existe!");
        }
    }

}
