// Antonio Thiago (00000849657), Breno Fernandes(00000849751)

package prova;

import java.util.Random;

public class prova {

  public static void main(String[] args) {
    int tVetor = 100000;
    int[] vetor = new int[tVetor];

  
    Random rand = new Random();
    for (int i = 0; i < tVetor; i++) {
      vetor[i] = rand.nextInt(200);
    }

    
    long tInicioBolha = System.currentTimeMillis();
    metodoBolha(vetor.clone());
    long tFimBolha = System.currentTimeMillis();
    long tempoExecucaoBolha = tFimBolha - tInicioBolha;

    long tempoInicioInsercao = System.currentTimeMillis();
    insercaoDireta(vetor.clone());
    long tempoFimInsercao = System.currentTimeMillis();
    long tempoExecucaoInsercao = tempoFimInsercao - tempoInicioInsercao;
    
    long tempoInicioSelecao = System.currentTimeMillis();
    selecaoDireta(vetor.clone());
    long tempoFimSelecao = System.currentTimeMillis();
    long tempoExecucaoSelecao = tempoFimSelecao - tempoInicioSelecao;

    System.out.println(
      "Tempo da Bolha: " + tempoExecucaoBolha + " milissegundos"
    );
    System.out.println(
      "Tempo de Inserção Direta: " + tempoExecucaoInsercao + " milissegundos"
    );
    System.out.println(
      "Tempo de Seleção Direta: " + tempoExecucaoSelecao + " milissegundos"
    );
  }

  public static void metodoBolha(int[] vetor) {
    int n = vetor.length;
    boolean trocou;

    do {
      trocou = false;
      for (int i = 1; i < n; i++) {
        if (vetor[i - 1] > vetor[i]) {
          int temp = vetor[i - 1];
          vetor[i - 1] = vetor[i];
          vetor[i] = temp;
          trocou = true;
        }
      }
    } while (trocou);
  }

  public static void insercaoDireta(int[] vetor) {
    int n = vetor.length;

    for (int i = 1; i < n; i++) {
      int chave = vetor[i];
      int j = i - 1;

      while (j >= 0 && vetor[j] > chave) {
        vetor[j + 1] = vetor[j];
        j--;
      }

      vetor[j + 1] = chave;
    }
  }

  public static void selecaoDireta(int[] vetor) {
    int n = vetor.length;

    for (int i = 0; i < n - 1; i++) {
      int indiceMenor = i;

      for (int j = i + 1; j < n; j++) {
        if (vetor[j] < vetor[indiceMenor]) {
          indiceMenor = j;
        }
      }

      int temp = vetor[i];
      vetor[i] = vetor[indiceMenor];
      vetor[indiceMenor] = temp;
    }
  }
}
