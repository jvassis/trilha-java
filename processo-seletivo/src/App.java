import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) throws Exception {
        // analisarCandidato(19000.0);
        // analisarCandidato(2000.0);
        // analisarCandidato(2100.0);

        // selecionarCandidatos();

        // imprimirCandidatosSelecionados();

        // String[] candidatos = { "Marcia", "Felipe", "João", "Pedro", "Elka", "Carla", "Julia", "Pedro", "Eva", "Fernanda" };
        // for (String candidato : candidatos) {
        //     entrandoEmContato(candidato);
        // }
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM UMA CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }

    static void selecionarCandidatos() {
        String[] candidatos = { "Marcia", "Felipe", "João", "Pedro", "Elka", "Carla", "Julia", "Pedro", "Eva", "Fernanda" };

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário: " + salarioPretendido + "");

            if (salarioBase > salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para vaga!\n");

                candidatosSelecionados++;
            } else {
                System.out.println("\n");
            }

            candidatoAtual++;
        }
    }

    static void imprimirCandidatosSelecionados() {
        String[] candidatos = { "Marcia", "Felipe", "João", "Pedro", "Elka", "Carla", "Julia", "Pedro", "Eva", "Fernanda" };

        for (String candidato : candidatos) {
            System.out.println("Candidato selecionado: " + candidato);
        }
    }

    static void entrandoEmContato(String candidato) {
        int numTentativas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;

            if (continuarTentando) {
                numTentativas++;
            } else {
                System.out.println("CONTATO REALIZADO COM SUCESSO!");
            }

        } while(continuarTentando && numTentativas < 3);

        if (atendeu) {
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + numTentativas + " TENTATIVA\n");
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + " NA " + numTentativas + " TENTATIVA\n");
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }
}
