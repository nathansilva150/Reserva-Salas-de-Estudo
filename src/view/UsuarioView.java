package view;

import controller.UsuarioController;
import model.repository.*;
import model.entity.*;

import java.util.HashMap;
import java.util.InputMismatchException;
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

            controller.cadastrarUsuario(id ,nome, cpf);
            System.out.println("Usuario Cadastrado com sucesso!");
    }

    public void listarUsuarios() {
        Map<String, Usuario> listaUser = controller.listarUsuario();

        for(Usuario user: listaUser.values()) {
            System.out.println("ID: " +user.getId());
            System.out.println("CPF: " +user.getCpf());
            System.out.println("Nome: " +user.getNome());
        }
    } //nicolas

    public void removerUsuario() {
        System.out.println("Digite o ID do Usuario que deseja remover: ");
        controller.removerUsuario(sc.nextLine());
        System.out.println("Usuario removido com sucesso!");
    }

    public void atualizarUsuario() {
        int opc = 0;
        do {
            try {
                System.out.println("O que voce deseja alterar?");
                System.out.println("Digite : Para ");
                System.out.println("1    :  Nome");
                System.out.println("2    : CPF");
                System.out.println("0    : Sair ");
                opc = sc.nextInt();
                sc.nextLine();
            } catch(InputMismatchException e) {
                System.out.println("ERRO - Input invalido");
            }
            switch (opc) {
                case 1 -> {
                        try {
                            atualizarNomeUsuario();
                        } catch(IllegalArgumentException e) {
                            System.out.println(e);
                        }
                    }
                case 2 -> {
                    try{
                        atualizarCPFUsuario();
                    } catch( IllegalArgumentException e) {
                        System.out.println(e);
                        }
                    }
                case 0 -> {
                    System.out.println("Saindo");
                }
            }
        } while (opc != 0) ;
        }


    public void atualizarNomeUsuario() {
        System.out.println("Selecione o usuario a ser alterado pelo ID");
        String idUser = sc.nextLine();
        System.out.println("Digite o novo Nome:");
        String nome = sc.nextLine();
        controller.atualizarNome(idUser, nome);
        System.out.println("Usuario Alterado com sucesso!");
    }

    public void atualizarCPFUsuario() {
        System.out.println("Selecione o usuario a ser alterado pelo ID:");
        String idUser = sc.nextLine();
        System.out.println("Digite o novo CPF:");
        String cpf = sc.nextLine();
        controller.atualizarCPF(idUser, cpf);
        System.out.println("Usuario Alterado com sucesso!");
    }

    public void buscarUsuario() {
        System.out.println("digite o Id do Usuario");
        String id = sc.nextLine();
        Usuario usuario = controller.buscarUsuario(id);
        System.out.println("ID: "+usuario.getId());
        System.out.println("Nome: "+usuario.getNome());
        System.out.println("CPF: "+usuario.getCpf());
    }
}
