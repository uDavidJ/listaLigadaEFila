public class Tarefa {
    private String nome;
    private Integer urgencia;

    public Tarefa(String nome, Integer urgencia) {
        this.nome = nome;
        this.urgencia = urgencia;
    }
    public String getNome() {
        return nome;
    }
    public Integer getUrgencia() {
        return urgencia;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
}
