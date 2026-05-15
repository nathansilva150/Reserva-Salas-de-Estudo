package model.repository;

import model.entity.Reserva;

import java.util.HashMap;
import java.util.Map;

public class ReservaRepository {

    private Map<String, Reserva> reservas = new HashMap<>(); // HashMap que vai armazenar todas as reservas

    // Usado para criar e atualizar cadastros dentro do HashMap (Create e o Update do CRUD)
    // O ".put()" vai colocar a reserva dentro da lista, e vai usar o ID como chave localizadora do HashMap
    public void salvar(Reserva reserva) {
        reservas.put(reserva.getId(), reserva);
    }

    // Usado para a leitura do HashMap (Read do CRUD)
    // Retorna TODAS as reservas da lista
    public Map<String, Reserva> listarReservas() {
        return new HashMap<>(reservas); // Retorna uma lista com todas as reservas para quem chamou esse método
    }

    // Usado para a leitura do HashMap (Read do CRUD)
    // Retorna APENAS a reserva da lista que possui o ID informado
    public Reserva buscarReservaComId(String id) {
        return reservas.get(id); // O ".get" vai buscar uma reserva na lista através do ID fornecido
    }

    // Remove uma reserva da lista pelo ID (Delete do CRUD)
    // Retorna true se conseguiu remover, ou false se a reserva não existia
    public boolean deletar(String id) {
        if(reservas.containsKey(id)) { // Se existir alguma reserva com esse ID...
            reservas.remove(id);       // O código vai remover a reserva com esse ID fornecido
            return true;
        }
        return false;
        // IMPORTANTE! Use o true ou false que foi retornado para fazer o teste condicional na parte do código de vocês
        // Ex: se reserva.deletar(2) é falso, lançe um erro que diga "Erro! A reserva que você quer deletar não existe!"
    }
}
