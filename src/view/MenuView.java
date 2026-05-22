package view;

import controller.ReservaController;
import controller.SalaController;
import controller.UsuarioController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {


    Scanner sc;
    UsuarioView usuarioView;
    SalaView salaView;
    ReservaView reservaView;
    public MenuView() {
        sc = new Scanner(System.in);
        usuarioView = new UsuarioView();
        salaView = new SalaView();
        reservaView = new ReservaView();

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
                        try {
                            usuarioView.cadastrarUsuario();
                        } catch(IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        } catch(InputMismatchException e){
                            System.out.println("ERRO - Input Inválido");
                        } catch(RuntimeException e) {
                            System.out.println("ERRO - "+e.getMessage());
                        }
                    }
                case 2 -> {
                    try {
                        salaView.cadastrarSala();
                    } catch(IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch(InputMismatchException e) {
                        System.out.println("ERRO - Input Inválido");
                    } catch(RuntimeException e) {
                        System.out.println("ERRO - "+e.getMessage());
                    }
                }
                case 3 -> {
                    try{
                        reservaView.cadastrarReserva();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e){
                        System.out.println("ERRO - Input inválido");
                    } catch (RuntimeException e) {
                        System.out.println("ERRO - "+ e.getMessage());
                    }
                }
            }
        }while (opc != 0);
    }
}
