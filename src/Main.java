import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner in = new Scanner(System.in);
        Arvore a1;
        int op, continuar, aux, busca;
        System.out.println("\n\n><><>< ÁRVORE BINÁRIA ><><><\n");
        System.out.print("<><> DEFINA UM VALOR PARA A RAIZ DA SUA ÁRVORE: ");
        a1 = new Arvore(in.nextInt());
        do {
            System.out.println();
            new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("\n\n><><>< ÁRVORE BINÁRIA ><><><\n");
            System.out.println("< 1 > INSERIR");
            System.out.println("< 2 > REMOVER");
            System.out.println("< 3 > BUSCAR");
            System.out.println("< 4 > ENCONTRAR MÍNIMO/MÁXIMO");
            System.out.println("< 5 > SUCESSOR / PREDECESSOR");
            System.out.println("< 6 > REALIZAR PERCURSOS");
            System.out.println("< 7 > SAIR");
            System.out.print("Opcão: ");
            op = in.nextInt();
            switch (op) {
                case 1:
                    System.out.println("\n\n><><><  INSERIR NODO  ><><><\n");
                    continuar = 1;
                    while (continuar == 1) {
                        System.out.print("\n<> Digite o número que deseja inserir na árvore:");
                        a1.inserir(in.nextInt());
                        System.out.print("Número adicionado!");
                        System.out.println("\n\n<> Deseja inserir mais algum número? 1 - SIM  2 - NÃO");
                        continuar = in.nextInt();
                        while (continuar != 1 && continuar != 2) {
                            System.out.print("OPÇÃO INVÁLIDA");
                            System.out.println("\n<> Deseja inserir mais algum número? 1 - SIM  2 - NÃO");
                            continuar = in.nextInt();
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n\n><><><  REMOVER NODO  ><><><\n");
                    continuar = 1;
                    while (continuar == 1) {
                        System.out.print("\n<> Digite o número que deseja remover da árvore: ");
                        aux = in.nextInt();
                        if ((a1.busca(a1.getRaiz(), aux)) != null) {
                            a1.remocao((a1.busca(a1.getRaiz(), aux)));
                            System.out.print("Número removido!");
                        } else {
                            System.out.print("Número não existente na árvore.");
                        }
                        System.out.println("\n\n<> Deseja remover mais algum número? 1 - SIM  2 - NÃO");
                        continuar = in.nextInt();
                        while (continuar != 1 && continuar != 2) {
                            System.out.print("OPÇÃO INVÁLIDA");
                            System.out.println("\n<> Deseja remover mais algum número? 1 - SIM  2 - NÃO");
                            continuar = in.nextInt();
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n\n><><><  BUSCAR NODO  ><><><\n");
                    continuar = 1;
                    while (continuar == 1) {
                        System.out.print("\n<> Digite o número que deseja buscar da árvore: ");
                        aux = in.nextInt();
                        try {
                            if ((a1.busca(a1.getRaiz(), aux)) != null) {
                                int pai = (((a1.busca(a1.getRaiz(), aux))).getPai()).getKey();
                                System.out.printf("<> NÓ ENCONTRADO! DESCENDENTE DE %d. <>", pai);
                            }
                        } catch (NullPointerException e) {
                            //Caso a exceção seja lançada, o nó buscado se encontra na raiz.
                            System.out.printf("<> NÓ ENCONTRADO! RAIZ DA ÁRVORE <>");
                        }
                        System.out.println("\n\n<> Deseja buscar mais algum número? 1 - SIM  2 - NÃO");
                        continuar = in.nextInt();
                        while (continuar != 1 && continuar != 2) {
                            System.out.print("OPÇÃO INVÁLIDA");
                            System.out.println("\n<> Deseja buscar mais algum número? 1 - SIM  2 - NÃO");
                            continuar = in.nextInt();
                        }
                    }
                    break;
                case 4:
                    System.out.println("\n\n><><><  MÁXIMO/MÍNIMO  ><><><\n");
                    System.out.println("< 1 > MÁXIMO");
                    System.out.println("< 2 > MÍNIMO");
                    System.out.print("Opção: ");
                    op = in.nextInt();
                    switch (op) {
                        case 1:
                            System.out.printf("<> O máximo da árvore é %d <>", a1.maximo(a1.getRaiz()).getKey());
                            break;
                        case 2:
                            System.out.printf("<> O mínimo da árvore é %d <>", a1.minimo(a1.getRaiz()).getKey());
                            break;
                        default:
                            System.out.println("OPÇÃO INVÁLIDA!");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("\n\n><> SUCESSOR/PREDECESSOR <><\n");
                    System.out.println("< 1 > SUCESSOR");
                    System.out.println("< 2 > PREDECESSOR");
                    System.out.print("Opção: ");
                    op = in.nextInt();
                    switch (op) {
                        case 1:
                            System.out.print("Digite o número qual deseja obter o sucessor: ");
                            aux = in.nextInt();
                            a1.sucessor(a1.busca(a1.getRaiz(), aux));
                            if ((a1.sucessor(a1.busca(a1.getRaiz(), aux))) == null) {
                                System.out.printf("<> O número não possui um sucessor.");
                            } else {
                                busca = (a1.sucessor(a1.busca(a1.getRaiz(), aux))).getKey();
                                System.out.printf("<> O sucessor de %d é %d <>", aux, busca);
                            }
                            break;
                        case 2:
                            System.out.print("Digite o número qual deseja obter o predecessor: ");
                            aux = in.nextInt();
                            if ((a1.predecessor(a1.busca(a1.getRaiz(), aux))) == null) {
                                System.out.printf("<> O número não possui um predecessor.");
                            } else {
                                busca = (a1.predecessor(a1.busca(a1.getRaiz(), aux))).getKey();
                                System.out.printf("<> O predecessor de %d é %d <>", aux, busca);
                            }
                            break;
                        default:
                            System.out.println("OPÇÃO INVÁLIDA!");
                            break;
                    }
                    break;
                case 6:
                    System.out.println("\n\n><><><   PERCURSOS   ><><><\n");
                    System.out.println("< 1 > EM ORDEM");
                    System.out.println("< 2 > PRÉ ORDEM");
                    System.out.println("< 3 > PÓS ORDEM");
                    System.out.print("Opção: ");
                    op = in.nextInt();
                    switch (op) {
                        case 1:
                            a1.emOrdem(a1.getRaiz());
                            break;
                        case 2:
                            a1.preOrdem(a1.getRaiz());
                            break;
                        case 3:
                            a1.posOrdem(a1.getRaiz());
                            break;
                        default:
                            System.out.println("OPÇÃO INVÁLIDA!");
                            break;
                    }
                    break;
                case 7:
                    System.out.println("\nFIM!\n");

                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
            }
        } while (op != 7);
    }
}
