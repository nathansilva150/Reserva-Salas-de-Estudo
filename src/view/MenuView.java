package view;

import controller.ReservaController;
import controller.SalaController;
import controller.UsuarioController;

import java.util.Scanner;

public class MenuView {

    ReservaController reservaController;
    SalaController salaController;
    UsuarioController usuarioController;
    Scanner sc;

    public MenuView(ReservaController reservaController, SalaController salaController, UsuarioController usuarioController) {
        sc = new Scanner(System.in);
        reservaController = this.reservaController;
        salaController = this.salaController;
        usuarioController = this.usuarioController;

    }

    public void menuPrincipal(){
        int opc = 0;
        do{
            System.out.println("Digite : para");
            System.out.println("   1   : Cadastro ");
            System.out.println("   2   : listar");
            System.out.println("   3   : Remover / cancelar");
            System.out.println("   4   : Atualizar");
            System.out.println("   5   : Buscar por ID");
            System.out.println("   0   : Sair");
            try {
                opc = sc.nextInt();
                sc.nextLine();
            } catch (RuntimeException e) {
                System.out.println("ERRO - ...");
            }
            switch (opc) {
                case 1 -> {
                    cadastro();
                }
            }

        } while (opc != 0);
    }
    public void cadastro() {
        int opc = 0;
        do{
            System.out.println("Digite : para");
            System.out.println("   1   : Cadastrar Usuario ");
            System.out.println("   2   : Cadastrar Sala");
            System.out.println("   3   : Criar Reserva");
            System.out.println("   0   : Sair");
            try {
                opc = sc.nextInt();
                sc.nextLine();
            } catch (RuntimeException e) {
                System.out.println("ERRO - ...");
            }
            switch (opc) {
                case 1 -> {

                    }
                case 2 -> {
                    salaController.cadastrarSala();
                }
            }
        }while (opc != 0);
    }
}
