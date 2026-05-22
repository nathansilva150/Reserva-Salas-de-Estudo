package view;

import controller.UsuarioController;
import model.repository.*;
import model.entity.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static view.Inicializar.criarUsuarioController;

public class UsuarioView {

    Scanner sc = new Scanner(System.in);
    UsuarioController controller;

    public UsuarioView() {
        controller = criarUsuarioController();
    }

    public void cadastrarUsuario() {
        System.out.println("Digite o nome do usuario");
        String nome = sc.nextLine();
        System.out.println("Digite o CPF do usuario");
        String cpf = sc.nextLine();
        System.out.println("Digite o ID do usuario");
        String id = sc.nextLine();

            controller.cadastrarUsuario(nome, cpf, id);
            System.out.println("Usuario Cadastrado com sucesso!");
    }

    public void listarUsuarios() {
        Map<String, Usuario> listaUser = controller.listarUsuario();

        for(Usuario user: listaUser.values()) {
            System.out.println("ID: " +user.getId());
            System.out.println("CPF: " +user.getCpf());
            System.out.println("Nome: " +user.getNome());
        }
    }
}
