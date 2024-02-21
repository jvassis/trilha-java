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
