import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, digite o número da conta! ");
        Integer numero = sc.nextInt();

        sc.nextLine();

        System.out.println("Agora, por favor, digite a agência! ");
        String agencia = sc.nextLine();

        System.out.println("Nome do cliente! ");
        String nome = sc.nextLine();
        
        System.out.println("Saldo! ");
        Float saldo = sc.nextFloat();
        
        System.out.println("Olá " + nome + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia +
            ", conta " + numero + " e seu saldo " + saldo + " já está disponível para saque.");

        sc.close();

    }
}
