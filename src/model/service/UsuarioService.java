package model.service;

import model.entity.Usuario;
import model.repository.*;

import java.util.Map;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrarUsuario(String nome, String cpf, String id){
        validarUsuarioNome(nome);
        validarUsuarioCpf(cpf);
        validarUSuarioId(id);

        Usuario usuario = new Usuario(nome,cpf,id);
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
}
