package view;

import controller.SalaController;
import java.util.Scanner;
import static view.Inicializar.criarSalaController;

public class SalaView {

    Scanner sc;
    SalaController controller;

    public SalaView() {
        controller = Inicializar.criarSalaController();
        sc = new Scanner(System.in);
    }

    public void cadastrarSala() {
        System.out.println("Digite o Id da sala");
        String id = sc.nextLine();
        System.out.println("Digite o numero da sala");
        int num = sc.nextInt();
        System.out.println("Digite a capacidade da Sala");
        int capacidade = sc.nextInt();

            controller.cadastrarSala(id, num, capacidade, true);
            System.out.println("Usuario Cadastrado com sucesso!");


    }
}
