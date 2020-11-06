package lojacliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import loja.Iloja;

/**
 *
 * @author mgirlene
 */
public class LojaCliente {

    public static String menuLoja() {
        return "\n##############"
                + "\nMG INFORMÁTICA"
                + "\n##############"
                + "\n1- INSERIR PRODUTO"
                + "\n2- REMOVER PRODUTO"
                + "\n3- PROCURAR PRODUTO "
                + "\n4- ALTERAR PREÇO"
                + "\n0- SAIR"
                + "\n##############\n";
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nomeProduto;
        float precoProduto;
        try {
            Registry r = LocateRegistry.getRegistry(1234);
            Iloja loja = (Iloja) r.lookup("LojaServidor");
            while (true) {
                System.out.print(menuLoja());
                int escolha = teclado.nextInt();
                switch (escolha) {
                    case 1:
                        System.out.print("NOME DO PRODUTO:");
                        nomeProduto = teclado.next();
                        System.out.print("PREÇO DO PRODUTO:");
                        precoProduto = teclado.nextFloat();
                        System.out.print(loja.addProduto(nomeProduto, precoProduto));
                        break;
                    case 2:
                        System.out.print("NOME DO PRODUTO:");
                        nomeProduto = teclado.next();
                        System.out.print(loja.removerProduto(nomeProduto));
                        break;
                    case 3:
                        System.out.print("NOME DO PRODUTO:");
                        nomeProduto = teclado.next();
                        System.out.print(loja.pesquisarProduto(nomeProduto));
                        break;
                    case 4:
                        System.out.print("NOME DO PRODUTO:");
                        nomeProduto = teclado.next();
                        System.out.print("PREÇO DO PRODUTO:");
                        precoProduto = teclado.nextFloat();
                        System.out.print(loja.alterarProduto(nomeProduto, precoProduto));
                        break;
                }
                if (escolha == 0) {
                    System.out.println("OBRIGADA!!");
                    break;
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
