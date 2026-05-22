package view;

import controller.UsuarioController;
import model.repository.*;
import model.entity.*;

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

        try {
            controller.cadastrarUsuario(nome, cpf, id);
            System.out.println("Usuario Cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
