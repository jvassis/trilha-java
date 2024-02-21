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
