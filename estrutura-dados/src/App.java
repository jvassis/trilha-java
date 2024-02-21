public class App {
    public static void main(String[] args) throws Exception {
        //pilha();
        //fila();
        //listaEncadeada();
        //listaDuplamenteEncadeada();
        listaCircular();
    }

    static void pilha() {
        Pilha p = new Pilha();

        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.push(5);
        p.push(6);

        System.out.println(p);

        p.pop();

        System.out.println(p);

        p.push(new No<Integer>(99));

        System.out.println(p);
    }

    static void fila() {
        Fila<String> f = new Fila<>();

        f.enqueue("1º");
        f.enqueue("2º");
        f.enqueue("3");
        f.enqueue("4");

        System.out.println(f);

        System.out.println(f.dequeue());

        System.out.println(f);

        f.enqueue("ultimo");

        System.out.println(f);

        System.out.println(f.first());

        System.out.println(f);

    }

    static void listaEncadeada() {
        ListaEncadeada<String> l = new ListaEncadeada<>();

        l.add("1");
        l.add("2");
        l.add("3");
        l.add("4");

        System.out.println(l.get(0));

        System.out.println(l);

        l.remove(3);

        System.out.println(l);
    }

    static void listaDuplamenteEncadeada() {
        ListaDuplamenteEncadeada<String> l = new ListaDuplamenteEncadeada<>();

        l.add("c1");
        l.add("c2");
        l.add("c3");
        l.add("c4");
        l.add("c5");
        l.add("c6");
        l.add("c7");

        System.out.println(l);

        l.remove(3);

        System.out.println(l);

        l.add("c4", 3);

        System.out.println(l);

        System.out.println(l.get(3));
    }

    static void listaCircular() {
        ListaCircular<String> l = new ListaCircular<>();

        l.add("c0");

        System.out.println(l);

        l.remove(0);

        System.out.println(l);

        l.add("c1");
        l.add("c2");
        l.add("c3");

        System.out.println(l);

        System.out.println(l.get(0));
        System.out.println(l.get(1));
        System.out.println(l.get(2));
        System.out.println(l.get(3));
        System.err.println(l.get(100));
    }
}
