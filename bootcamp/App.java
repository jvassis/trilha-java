import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;

class HelloWorld {
    public static void main(String[] args) {
        Curso cursoJava = new Curso();
        cursoJava.setTitulo("Curso Java");
        cursoJava.setDescricao("Descricao do curso java");
        cursoJava.setCargaHoraria(8);
        
        Curso cursoC = new Curso();
        cursoC.setTitulo("Curso C");
        cursoC.setDescricao("Descricao do curso C");
        cursoC.setCargaHoraria(12);
        
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria Java");
        mentoria.setDescricao("Descricao da mentoria java");
        mentoria.setData(LocalDate.now());
        
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descricao do Bootcamp Java Developer");
        bootcamp.getConteudos().add(cursoJava);
        bootcamp.getConteudos().add(cursoC);
        bootcamp.getConteudos().add(mentoria);
        
        Dev devJack = new Dev();
        devJack.setNome("Jack");

        Dev devCamilla = new Dev();
        devCamilla.setNome("Camilla");

        System.out.println("> Jack");
        System.out.println("Conteudos Inscritos: " + devJack.getConteudosInscritos());
        System.out.println("Conteudos Concluidos: " + devJack.getConteudosConcluidos());
        System.out.println("> Camilla");
        System.out.println("Conteudos Inscritos: " + devCamilla.getConteudosInscritos());
        System.out.println("Conteudos Concluidos: " + devCamilla.getConteudosConcluidos());
        
        devJack.inscreverBootcamp(bootcamp);
        devCamilla.inscreverBootcamp(bootcamp);
        
        System.out.println("\n=== Apos Insercao ===");
        System.out.println("> Jack");
        System.out.println("Conteudos Inscritos: " + devJack.getConteudosInscritos());
        System.out.println("Conteudos Concluidos: " + devJack.getConteudosConcluidos());
        System.out.println("Xp: " + devJack.calcularTotalXp());
        System.out.println("> Camilla");
        System.out.println("Conteudos Inscritos: " + devCamilla.getConteudosInscritos());
        System.out.println("Conteudos Concluidos: " + devCamilla.getConteudosConcluidos());
        System.out.println("Xp: " + devCamilla.calcularTotalXp());
        
        devJack.progredir();
        devCamilla.progredir();
        
        System.out.println("\n=== Apos Progressao ===");
        System.out.println("> Jack");
        System.out.println("Conteudos Inscritos: " + devJack.getConteudosInscritos());
        System.out.println("Conteudos Concluidos: " + devJack.getConteudosConcluidos());
        System.out.println("Xp: " + devJack.calcularTotalXp());
        System.out.println("> Camilla");
        System.out.println("Conteudos Inscritos: " + devCamilla.getConteudosInscritos());
        System.out.println("Conteudos Concluidos: " + devCamilla.getConteudosConcluidos());
        System.out.println("Xp: " + devCamilla.calcularTotalXp());

        devJack.progredir();
        devCamilla.progredir();
        
        System.out.println("\n=== Apos Mais Uma Progressao ===");
        System.out.println("> Jack");
        System.out.println("Conteudos Inscritos: " + devJack.getConteudosInscritos());
        System.out.println("Conteudos Concluidos: " + devJack.getConteudosConcluidos());
        System.out.println("Xp: " + devJack.calcularTotalXp());
        System.out.println("> Camilla");
        System.out.println("Conteudos Inscritos: " + devCamilla.getConteudosInscritos());
        System.out.println("Conteudos Concluidos: " + devCamilla.getConteudosConcluidos());
        System.out.println("Xp: " + devCamilla.calcularTotalXp());
        
        devJack.progredir();
        
        System.out.println("\n=== Apos Jack Realizar Todas Progressoes ===");
        System.out.println("> Jack");
        System.out.println("Conteudos Inscritos: " + devJack.getConteudosInscritos());
        System.out.println("Conteudos Concluidos: " + devJack.getConteudosConcluidos());
        System.out.println("Xp: " + devJack.calcularTotalXp());
        System.out.println("> Camilla");
        System.out.println("Conteudos Inscritos: " + devCamilla.getConteudosInscritos());
        System.out.println("Conteudos Concluidos: " + devCamilla.getConteudosConcluidos());
        System.out.println("Xp: " + devCamilla.calcularTotalXp());
        
    }
}

abstract class Conteudo {
    protected static final double XP_PADRAO = 10d;
    
    private String titulo;
    private String descricao;
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public abstract double calcularXp();
}

class Curso extends Conteudo {
    private int cargaHoraria;
    
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }
    
    @Override
    public String toString() {
        return "Curso{titulo=" + getTitulo() +
            ", descricao=" + getDescricao() +
            ", cargaHoraria=" + cargaHoraria +
            "}";
    }
}

class Mentoria extends Conteudo {
    private LocalDate data;
    
    public LocalDate getData() {
        return data;
    }
    
    public void setData(LocalDate data) {
        this.data = data;
    }
    
    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }
    
    @Override
    public String toString() {
        return "Mentoria{titulo=" + getTitulo() +
            ", descricao=" + getDescricao() +
            ", data=" + data +
            "}";
    }
}

class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();
        
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public LocalDate getDataInicial() {
        return dataInicial;
    }
    
    public LocalDate getDataFinal() {
        return dataFinal;
    }
    
    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }
    
    public void setDevsInscritos(Set<Dev> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }
    
    public Set<Conteudo> getConteudos() {
        return conteudos;
    }
    
    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) &&
            Objects.equals(descricao, bootcamp.descricao) &&
            Objects.equals(dataInicial, bootcamp.dataInicial) &&
            Objects.equals(dataFinal, bootcamp.dataFinal) &&
            Objects.equals(devsInscritos, bootcamp.devsInscritos) &&
            Objects.equals(conteudos, bootcamp.conteudos);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal, devsInscritos, conteudos);
    }
}

class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos  = new LinkedHashSet<>();
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }
    
    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }
    
    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }
    
    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }
    
    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }
    
    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Voce nao esta matriculado em nenhum conteudo!");
        }
    }
    
    public double calcularTotalXp() {
        return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) &&
            Objects.equals(conteudosInscritos, dev.conteudosInscritos) &&
            Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
