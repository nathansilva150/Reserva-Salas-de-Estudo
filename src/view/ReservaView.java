package view;

import controller.ReservaController;
import model.entity.Reserva;

import java.util.Map;
import java.util.Scanner;

import static view.Inicializar.criarReservaController;

    public class ReservaView {

        Scanner sc;
        ReservaController controller;

        public ReservaView() {
                sc = new Scanner(System.in);
                controller = criarReservaController();
        }

        public void cadastrarReserva() {

            System.out.println("Selecione o Usuario pelo Id:");
            String idUser = sc.nextLine();
            System.out.println("Selecione a Sala pelo Id:");
            String idSala = sc.nextLine();
            System.out.println("Digite o ID da reserva:");
            String id = sc.nextLine();
            System.out.println("Digite a Data Atual:");
            String data = sc.nextLine();
            System.out.println("Digite a Hora Atual:");
            String hora = sc.nextLine();
            System.out.println("Digite o Status da reserva");
            String status = sc.nextLine();

            controller.cadastrarReserva(idUser, id, idSala, data, hora, status);
        }

        public void listarReservas() {
            Map<String, Reserva> listaReservas = controller.listarReservas();

            for(Reserva reserva: listaReservas.values()) {
                System.out.println("ID :"+reserva.getId());
                System.out.println("Sala :"+reserva.getSala().getNumero());
                System.out.println("Usuario :"+reserva.getUsuario().getNome());
                System.out.println("Data :"+reserva.getData());
                System.out.println("Hora :" +reserva.getHorario());
                System.out.println("Status :"+reserva.getStatus());
            }
        }

        public void removerReserva() {
            System.out.println("Selecione a Reserva pelo ID");
            controller.cancelarReserva(sc.nextLine());
            System.out.println("Reserva Canceçada com sucesso!");
        }

    }
