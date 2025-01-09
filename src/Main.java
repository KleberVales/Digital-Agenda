import service.AgendaService;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		AgendaService service = new AgendaService();
		Scanner scanner = new Scanner(System.in);

		try {
			while (true) {
				System.out.println("1. Adicionar Agenda");
				System.out.println("2. Listar Agendas");
				System.out.println("3. Adicionar Tarefa");
				System.out.println("4. Sair");

				int opcao = scanner.nextInt();
				scanner.nextLine(); // Consumir o newline

				switch (opcao) {
				case 1 -> {
					System.out.println("Ano:");
					int ano = scanner.nextInt();

					System.out.println("Mês:");
					int mes = scanner.nextInt();

					System.out.println("Dia:");
					int dia = scanner.nextInt();

					System.out.println("Hora:");
					int hora = scanner.nextInt();

					service.adicionarAgenda(ano, mes, dia, hora);

					System.out.println("Agenda adicionada com sucesso!");
				}
				case 2 -> service.listarAgendas()
						.forEach(agenda -> System.out.println(agenda.getAno() + " - " + agenda.getAno() + "/"
								+ agenda.getMes() + "/" + agenda.getDia() + " " + agenda.getHora() + ":00"));
				case 3 -> {

					System.out.println("ID da Agenda:");
					int agendaId = scanner.nextInt();
					scanner.nextLine(); // Consumir o newline

					System.out.println("Descrição da Tarefa:");
					String descricao = scanner.nextLine();

					service.adicionarTarefa(agendaId, descricao);
					System.out.println("Tarefa adicionada com sucesso!");

				}
				case 4 -> {
					System.out.println("Saindo...");
					return;
				}
				default -> System.out.println("Opção inválida!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
