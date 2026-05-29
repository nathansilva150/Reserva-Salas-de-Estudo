package view;

import controller.SalaController;
import model.entity.Sala;

import java.util.InputMismatchException;
import java.util.Map;
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
        String id = "0";
        int num = 0;
        int capacidade =0;
        try {
            System.out.println("Digite o Id da sala");
            id = sc.nextLine();
            System.out.println("Digite o numero da sala");
            num = sc.nextInt();
            sc.nextLine();
            System.out.println("Digite a capacidade da Sala");
            capacidade = sc.nextInt();
            sc.nextLine();
        } catch(InputMismatchException e) {
            System.out.println("ERRO - Input invalido");
        }
        controller.cadastrarSala(id, num, capacidade, true);
            System.out.println("Sala Cadastrado com sucesso!");


    }

    public void listarSalas() {
        Map<String, Sala> listaSalas = controller.listarSala();

        for (Sala sala: listaSalas.values()){
            System.out.println("ID :" + sala.getId());
            System.out.println("Numero :"+sala.getNumero());
            System.out.println("Capacidade :"+sala.getCapacidade());
            System.out.println("Disponivel :"+sala.getDisponivel());
        }
    }


    public void removerSala() {
        System.out.println("Digite a Sala a ser removida pelo ID:");
        controller.removerSala(sc.nextLine());
        System.out.println("Sala removida com sucesso!");
    }
}
