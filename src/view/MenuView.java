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
                case 2 -> {

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
                case 0 -> {
                    break;
                }
                default -> {
                    System.out.println("Inválido!");
                    break;
                }
            }
        }while (opc != 0);
    }

    public void listar() {
        int opc = 0;
        do {
            try {
                System.out.println("digite para listar:");
                System.out.println(" 1 ---- Usuarios");
                System.out.println(" 2 ---- Salas");
                System.out.println(" 3 ---- Reservas");
                opc = sc.nextInt();
                if(opc> 3 || opc < 0){
                    throw new IllegalArgumentException("Numero fora do intervalo permitido");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("ERRO - Input invalido"+ e);
            }
            switch (opc) {
                case 1 -> {
                    usuarioView.listarUsuarios();
                }
                case 2 -> {
                    salaView.listarSalas();
                }
                case 3 -> {
                    reservaView.listarReservas();
                }
            }



        } while (opc != 0);
    }

    public void remover() {
        int opc = 0;

        do {
            System.out.println("Digite para remover");
            System.out.println("1 ------ Usuario");
            System.out.println("2 ------ Sala");
            System.out.println("3 ------ Reserva");

            switch(opc) {
                case 1 -> {
                    usuarioView.removerUsuario();
                }
                case 2 -> {

                }

            }
        }while (opc != 0);
    }
}
