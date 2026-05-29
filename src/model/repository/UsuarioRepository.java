package model.repository;

import model.entity.Usuario;

import java.util.HashMap;
import java.util.Map;

public class UsuarioRepository {

    private Map<String, Usuario> usuarios = new HashMap<>(); // HashMap que vai armazenar todos os usuarios

    // Usado para criar e atualizar cadastros dentro do HashMap (Create e o Update do CRUD)
    // O ".put()" vai colocar o usuário dentro da lista, e vai usar o ID como chave localizadora do HashMap
    public void salvar(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    // Usado para a leitura do HashMap (Read do CRUD)
    // Retorna TODOS os usuários da lista
    public Map<String, Usuario> listarUsuarios() {
        return new HashMap<>(usuarios); // Retorna uma lista com todos os usuarios para quem chamou esse método
    }

    // Usado para a leitura do HashMap (Read do CRUD)
    // Retorna APENAS o usuário da lista que possui o id informado
    public Usuario buscarUsuarioComId(String id) {
        return usuarios.get(id); // O ".get" vai buscar um usuário na lista através do ID fornecido
    }

    // Remove um usuário da lista pelo ID (Delete do CRUD)
    // Retorna true se conseguiu remover, ou false se o usuário não existia
    public boolean deletar(String id) {
        if(usuarios.containsKey(id)) { // Se existir algum usuário com esse ID...
            usuarios.remove(id);       // O código vai remover o usuário com esse ID fornecido
            return true;
        }
        return false;
        // IMPORTANTE! Use o true ou false que foi retornado para fazer o teste condicional na parte do código de vocês
        // Ex: se usuario.deletar(2) é falso, lançe um erro que diga "Erro! O usuário que você quer deletar não existe!"
    }

}
