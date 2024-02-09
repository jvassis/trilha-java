import java.util.Scanner;

class ParametroInvalidosException extends Exception {
    public ParametroInvalidosException() {
        super();
    }

    public ParametroInvalidosException(String mensagem) {
        super(mensagem);
    }
}

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        
        int parametroUm = terminal.nextInt();
        int parametroDois = terminal.nextInt();

        terminal.close();

        try {
            contar(parametroUm, parametroDois);
        } catch(ParametroInvalidosException exception) {
            System.out.println("Exceção capturada: " + exception.getMessage());
        }
    }

    static void contar(int parametroUm, int parametroDois) throws ParametroInvalidosException {
        if (parametroUm > parametroDois) {
            throw new ParametroInvalidosException("O segundo parâmetro foi maior que o primeiro!");
        }

        int contagem = parametroDois - parametroUm;
        
        for (int i = 1; i <= contagem; i++) {
            System.out.println(i);
        }
    }
}
