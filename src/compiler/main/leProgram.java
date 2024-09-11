package compiler.main;

import java.util.Scanner;
public class leProgram { 
  public static void main(String[] args) { 
  Scanner _scInpt = new Scanner(System.in);
    int a;
    double b;
    String c;
    String d;
    double exemplo;
    int count;
    // Tres tipos de variaveis: INT, DOUBLE, STRING ^

    // Atribuicao de variaveis:

    a = 3 + 4;
    b = 2.442 - 44.1 * -3;
    c = "Hello World!";
    // Comando de print:

    System.out.print(a);
    // Comando de print com quebra de linha

    System.out.println(b);
    System.out.println(c);
    // Atribuicao com varios tipos -> String 

    // prevalece sobre double, que prevalece sobre int

    c = "b + 3 - 2 *  + Oieee ";
    // Concatenado no todo para evitar erro do Java em casos de ''STRING'' - ''STRING''...

    System.out.print("Valor de c: ");
    System.out.println(c);
    // Comando de leitura

    System.out.print("Insira um valor inteiro para a: ");
    a = _scInpt.nextInt();
    System.out.println("");
    System.out.print("Valor lido de a:");
    System.out.println(a);
    // Comando IF

    if (a < b) {
System.out.println("b é maior que a!");
}
 else {
System.out.println("a é maior que b!");
}
    // Comando While

    c = "Comando While! Numero par! ";
    System.out.println("------ Entrando no comando While! \n\n");
    System.out.print("Insira um valor para a: ");
    a = _scInpt.nextInt();
    System.out.println("");
    System.out.print("Repetindo ");
    System.out.print(a);
    System.out.println(" vezes!");
    count = 0;
    while (count < a) {
if (count % 2 == 0) {
System.out.println(c);
}
 else {
System.out.print(count);
System.out.println(" é um número ímpar.");
}
count = count + 1;
}
    System.out.print("----- Fim do comando While!\n\n");
    // Para dar erro: variavel nao declarada

    // print(naoDeclarada);

    // Para dar erro: variavel nao inicializada

    // print(d);

  }
}

