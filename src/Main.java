import service.AgendaService;
import java.util.Scanner;

//testando nova branch

public class Main {
	public static void main(String[] args) {

		AgendaService service = new AgendaService();
		Scanner scanner = new Scanner(System.in);

		try {
			while (true) {
				System.out.println("1. Adicionar Agenda");
				System.out.println("2. Listar Tarefas");
				System.out.println("3. Sair");

				int opcao = scanner.nextInt();
				scanner.nextLine();

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

					System.out.println("Lembrete:");
					String descricao = scanner.next();

					service.adicionarAgenda(ano, mes, dia, hora, descricao);

					System.out.println("Agenda adicionada com sucesso!");
				}
				case 2 -> {
					service.listarAgendas().forEach(agenda -> System.out.println(agenda.getAno() + "/" + agenda.getMes() + "/"
							+ agenda.getDia() + " - " + agenda.getHora() + ":00 " + agenda.getDescricao()));
					
				}
				case 3 -> {
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
