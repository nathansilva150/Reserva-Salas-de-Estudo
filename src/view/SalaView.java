package view;

import controller.SalaController;
import model.entity.Sala;

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
        System.out.println("Digite o Id da sala");
        String id = sc.nextLine();
        System.out.println("Digite o numero da sala");
        int num = sc.nextInt();
        System.out.println("Digite a capacidade da Sala");
        int capacidade = sc.nextInt();

            controller.cadastrarSala(id, num, capacidade, true);
            System.out.println("Usuario Cadastrado com sucesso!");


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


}
