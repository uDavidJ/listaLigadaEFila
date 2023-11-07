import java.util.LinkedList;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {

        String resp;

        do {

            resp = JOptionPane.showInputDialog("1 - Exercício 1\n2 - Exercício 2\n0 - Sair");

            if (resp.equals("1"))
                exercicio1();
            else
                exercicio2();

        } while (!(resp.equals("0")));

    }

    public static void exercicio1() {
        LinkedList<Tarefa> lista = new LinkedList<Tarefa>();

        String resp;
        String nomeTarefa;
        Integer urgencia;

        do {
            resp = JOptionPane
                    .showInputDialog("1 - Cadastrar tarefa\n2 - Listar tarefas\n3 - remover tarefa\n0 - sair");

            if (resp.equals("1")) {
                nomeTarefa = JOptionPane.showInputDialog("Nome da tarefa");
                urgencia = Integer.valueOf(JOptionPane.showInputDialog("Urgencia da tarefa (1 a 5)"));

                Tarefa t1 = new Tarefa(nomeTarefa, urgencia);

                if (lista.isEmpty())
                    lista.add(t1);
                else {
                    if (lista.get(0).getUrgencia() > t1.getUrgencia())
                        lista.add(1, t1);
                    else
                        lista.add(0, t1);
                }

            } else if (resp.equals("2")) {
                int i = 1;
                for (Tarefa t : lista) {
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Tarefa " + i + ": " + t.getNome());
                    System.out.println("Urgencia " + t.getUrgencia());
                    i++;
                }
                System.out.println("\n");

            } else if (resp.equals("3")) {
                String nome = JOptionPane.showInputDialog("Digite o nome da tarefa a ser removida");

                int i = 0;
                for (Tarefa t : lista) {
                    if (t.getNome().equals(nome)) {
                        lista.remove(i);
                        break;
                    }
                    i++;
                }
            }

        } while (!(resp.equals("0")));
    }

    public static void exercicio2() {

        QueueL<Pessoa> filaNormaL = new QueueL<>();
        QueueL<Pessoa> filaIdosos = new QueueL<>();

        String resp;

        do {
            resp = JOptionPane.showInputDialog("1 - Adicionar pessoas\n2 - Gerar ordem de chamada\n0 - Sair");

            if(resp.equals("1")) {

                String nome = JOptionPane.showInputDialog("Digite o nome");
                Integer idade = Integer.valueOf(JOptionPane.showInputDialog("Digite a idade"));

                Pessoa p = new Pessoa(nome, idade);

                if(p.getIdade() < 60)
                    filaNormaL.enqueue(p);
                else
                    filaIdosos.enqueue(p);

            }else if(resp.equals("2")) {
                    Integer contador = 0;
                    Integer contador2 = 1;

                    while(!(filaIdosos.isEmpty() && filaNormaL.isEmpty())) {
                        if(filaNormaL.isEmpty()) {
                            for(int i = 0; i < filaIdosos.size(); i++)
                                System.out.println("Chamada " + contador2 + " - " + filaIdosos.dequeue().getNome() + " - prioritária");
                            break;
                        }

                        else if(filaIdosos.isEmpty()) {
                            for(int i = 0; i < filaNormaL.size(); i++)
                                System.out.println("Chamada " + contador2 + " - " + filaNormaL.dequeue().getNome() + " - normal");    
                            break;
                        }

                        while (contador < 2) {                            
                            System.out.println("Chamada " + contador2 + " - " + filaIdosos.dequeue().getNome() + " - prioritária");
                            contador2++;
                            contador++;

                            if(filaIdosos.isEmpty())
                                break;
                        } 

                        System.out.println("Chamada " + contador2 + " - " + filaNormaL.dequeue().getNome() + " - normal");
                        contador2++;
                        contador = 0;
                    }

                }
        
        }while(!(resp.equals("0")));
    } 
}
