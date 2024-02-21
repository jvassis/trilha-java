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
