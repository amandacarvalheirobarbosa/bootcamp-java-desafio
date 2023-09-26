package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
  public static void main(String[] args) {
    String[] candidatos = { "Amanda", "Leandro", "Maria", "Felipe", "Lucas" };
    for (String cadidato : candidatos) {
      entrandoEmContato(cadidato);
    }
  }

  static void entrandoEmContato(String candidato) {
    int tentativasRealizadas = 1;
    boolean continuarTentando = true;
    boolean atendeu = false;

    do {
      atendeu = atender();
      continuarTentando = !atendeu;
      if (continuarTentando) {
        tentativasRealizadas++;
      } else {
        System.out.println("Contato realizado com sucesso.");
      }
    } while (continuarTentando && tentativasRealizadas < 3);

    if (atendeu) {
      System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas);
    } else {
      System.out.println("Não conseguimos contato com " + candidato + ", número máximo de tentativas excedido.");
    }
  }

  // Método auxiliar
  static boolean atender() {
    return new Random().nextInt(3) == 1;
  }

  static void imprimirSelecionados() {
    String[] candidatos = { "Amanda", "Leandro", "Maria", "Felipe", "Lucas" };
    System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

    for (int i = 0; i < candidatos.length; i++) {
      System.out.println("O candidado de nº " + (i + 1) + "é o " + candidatos[i]);
    }

    // Forma abreviada (foreach)
    /*
     * for (String candidato : candidatos) {
     * System.out.println("O candidado de selecionado foi " + candidatos);
     * }
     */
  }

  static void selecaoCandidatos() {
    String[] candidatos = { "Amanda", "Leandro", "Maria", "Felipe", "Lucas", "Juliana", "Mateus", "Welton", "Maristela",
        "Fernando" };
    int candidatosSelecionados = 0;
    int candidatoAtual = 0;
    double salarioBase = 2000.00;
    while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
      String candidato = candidatos[candidatoAtual];
      double salarioPretendido = valorPretendido();

      System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
      if (salarioBase >= salarioPretendido) {
        System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
        candidatosSelecionados++;
      }
      candidatoAtual++;
    }
  }

  static double valorPretendido() {
    return ThreadLocalRandom.current().nextDouble(1800, 2200);
  }

  static void analisarCandidato(double salarioPretendido) {
    double salarioBase = 2000.0;
    if (salarioBase > salarioPretendido) {
      System.out.println("Ligar para o candidato.");
    } else if (salarioBase == salarioPretendido) {
      System.out.println("Aguardando o resultado dos demais candidatos.");
    } else {
      System.out.println("Ligar para o candidato com contra proposta");
    }
  }
}