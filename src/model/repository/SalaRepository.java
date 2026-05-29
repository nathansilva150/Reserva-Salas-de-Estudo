package model.repository;

import model.entity.Sala;

import java.util.HashMap;
import java.util.Map;

public class SalaRepository {

    private Map<String, Sala> salas = new HashMap<>(); // HashMap que vai armazenar todas as salas

    // Usado para criar e atualizar cadastros dentro do HashMap (Create e o Update do CRUD)
    // O ".put()" vai colocar a sala dentro da lista, e vai usar o ID como chave localizadora do HashMap
    public void salvar(Sala sala) {
        salas.put(sala.getId(), sala);
    }

    // Usado para a leitura do HashMap (Read do CRUD)
    // Retorna TODAS as salas da lista
    public Map<String, Sala> listarSalas() {
        return new HashMap<>(salas); // Retorna uma lista com todas as salas para quem chamou esse método
    }

    // Usado para a leitura do HashMap (Read do CRUD)
    // Retorna APENAS a sala da lista que possui o ID informado
    public Sala buscarSalaComId(String id) {
        return salas.get(id); // O ".get" vai buscar uma sala na lista através do ID fornecido
    }

    // Remove uma sala da lista pelo ID (Delete do CRUD)
    // Retorna true se conseguiu remover, ou false se a sala não existia
    public boolean deletar(String id) {
        if(salas.containsKey(id)) { // Se existir alguma sala com esse ID...
            salas.remove(id);       // O código vai remover a sala com esse ID fornecido
            return true;
        }
        return false;
        // IMPORTANTE! Use o true ou false que foi retornado para fazer o teste condicional na parte do código de vocês
        // Ex: se sala.deletar(2) é falso, lançe um erro que diga "Erro! A sala que você quer deletar não existe!"
    }
}
