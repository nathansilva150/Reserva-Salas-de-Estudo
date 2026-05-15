package controller;

import model.service.UsuarioService;
import model.entity.Usuario;
import model.repository.UsuarioRepository;
import java.util.Map;

public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    //Cadastrar
    public void cadastrarUsuario(String nome, String cpf, String id){
        usuarioService.cadastrarUsuario(nome,cpf,id);
    }

    //Buscar
    public Usuario buscarUsuario(String id){
        return usuarioService.buscarUsuario(id);
    }

    //Listar
    public Map<String, Usuario> listarUsuario(){
        return usuarioService.listarUsuario();
    }

    //Remover
    public void removerusuario(String id){
        usuarioService.removerUsuario(id);
    }

}
