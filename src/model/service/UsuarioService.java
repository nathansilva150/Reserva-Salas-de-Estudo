package model.service;

import model.entity.Usuario;
import model.repository.*;

import java.util.Map;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrarUsuario(String id, String nome, String cpf){
        validarUsuarioNome(nome);
        validarUsuarioCpf(cpf);
        validarUSuarioId(id);

        Usuario usuario = new Usuario(id, nome, cpf);
        usuarioRepository.salvar(usuario);
    }

    public void validarUsuarioNome(String nome){
        if(nome == null || nome.isBlank()){
            throw new IllegalArgumentException("ERRO! O Nome não pode estar vazio!");
        }
    }

    public void validarUsuarioCpf(String cpf){
        if(cpf == null || cpf.isBlank()){
            throw new IllegalArgumentException("ERRO! O CPF não pode estar vazio!");
        }
    }

    public void validarUSuarioId(String id){
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("ERRO! O ID não pode estar vazio!");
        }
    }

    //Buscar
    public Usuario buscarUsuario(String id){
        Usuario usuario = usuarioRepository.buscarUsuarioComId(id);

        if(usuario == null){
            throw new IllegalArgumentException("ERRO! Usuario não encontrado!");
        }

        return usuario;
    }

    //Listar
    public Map<String, Usuario> listarUsuario(){
        return usuarioRepository.listarUsuarios();
    }

    //Remover
    public void removerUsuario(String id){
        boolean removido = usuarioRepository.deletar(id);

        if(!removido){
            throw new IllegalArgumentException("ERRO! Usuario não existe!");
        }
    }

    public void validarUsuarioCpfDuplicado(String cpf){
        Map<String, Usuario> usuarios = usuarioRepository.listarUsuarios();

        for(Usuario usuario : usuarios.values()){
            if(usuario.getCpf().equals(cpf)){
                throw new IllegalArgumentException("ERRO! CPF ja cadastrado!");
            }
        }
    }

    public void atualizarNome(String idUser, String nome){
        Usuario usuarioAlterado = buscarUsuario(idUser);
        usuarioAlterado.setNome(nome);
        cadastrarUsuario(usuarioAlterado.getId(), usuarioAlterado.getNome(), usuarioAlterado.getCpf());

        // o metodo cadastrar ele utiliza o put no hashMap, o push verifica se a chave é repetida, se ela for ele só substitui, se não for adiciona uma nova
    }

    public void atualizarCPF(String idUser, String cpf) {
        Usuario usuarioAlterado = buscarUsuario(idUser);
        usuarioAlterado.setCpf(cpf);
        cadastrarUsuario(usuarioAlterado.getId(), usuarioAlterado.getNome(), usuarioAlterado.getCpf());

    }
}
