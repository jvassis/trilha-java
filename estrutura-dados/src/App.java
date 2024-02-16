class No<T> {
    private T obj;
    private No<T> refNo;

    public No(T obj) {
        this.obj = obj;
        this.refNo = null;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public No<T> getRefNo() {
        return refNo;
    }

    @SuppressWarnings("unchecked")
    public void setRefNo(No<?> refAux) {
        this.refNo = (No<T>) refAux;
    }

    @Override
    public String toString() {
        return "[No{Objeto=" + this.obj + "}]";
    }
}

class Pilha {
    private No<?> refNoEntradaPilha;

    public Pilha() {
        this.refNoEntradaPilha = null;
    }

    public boolean isEmpty() {
        return refNoEntradaPilha == null ? true : false;
    }

    public No<?> top() {
        return refNoEntradaPilha;
    }

    public void push(Object obj) {
        No<?> novoNo = new No<>(obj);
        No<?> refAux = refNoEntradaPilha;
        refNoEntradaPilha = novoNo;
        refNoEntradaPilha.setRefNo(refAux);
    }

    public No<?> pop() {
        if (!isEmpty()) {
            No<?> noPoped = refNoEntradaPilha;
            refNoEntradaPilha = refNoEntradaPilha.getRefNo();
            
            return noPoped;
        }

        return null;
    }

    @Override
    public String toString() {
        String s = "------------------\n";
        s += "Pilha\n";
        s += "------------------\n";

        No<?> noAux = refNoEntradaPilha;

        while (true) {
            if (noAux != null) {
                s += "[No(dado=" + noAux.getObj() + ")]\n";
                noAux = noAux.getRefNo();
            } else {
                break;
            }
        }

        s += "==================\n";

        return s;
    }


}

class Fila<T> {
    private No<T> refNoEntradaFila;

    public Fila() {
        this.refNoEntradaFila = null;
    }

    public boolean isEmpty() {
        return refNoEntradaFila == null ? true : false;
    }

    public void enqueue(T obj) {
        No<T> novoNo = new No<T>(obj);
        novoNo.setRefNo(refNoEntradaFila);
        refNoEntradaFila = novoNo;
    }

    public T first() {
        if (!this.isEmpty()) {
            No<T> primeiroNo = refNoEntradaFila;
            while (true) {
                if (primeiroNo.getRefNo() != null) {
                    primeiroNo = primeiroNo.getRefNo();
                } else {
                    break;
                }
            }

            return (T) primeiroNo.getObj();
        }
        
        return null;
    }

    public T dequeue() {
        if (!this.isEmpty()) {
            No<T> primeiroNo = refNoEntradaFila;
            No<T> noAux = refNoEntradaFila;
            while (true) {
                if (primeiroNo.getRefNo() != null) {
                    noAux = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                } else {
                    noAux.setRefNo(null);
                    break;
                }
            }

            return (T) primeiroNo.getObj();
        }
        
        return null;
    } 

    @Override
    public String toString() {
        String s = "";
        No<T> noAux = refNoEntradaFila;
        
        if (refNoEntradaFila != null) {
            while (true) {
                s += "[No{objeto=" + noAux.getObj() + "}]-->";
                if (noAux.getRefNo() != null) {
                    noAux = noAux.getRefNo();
                } else {
                    s += null;
                    break;
                }
            }
        } else {
            s = "null";
        }
        
        return s;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        //pilha();
        fila();
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
}
