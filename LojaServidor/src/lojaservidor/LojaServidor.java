package lojaservidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import loja.Iloja;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 *
 * @author mgirlene
 */
public class LojaServidor extends UnicastRemoteObject implements Iloja {

    public static HashMap<String, Float> produtos;

    public LojaServidor() throws RemoteException {
        super();
        produtos = new HashMap<String, Float>();
    }

    @Override
    public String addProduto(String nome, float valor) throws RemoteException {
        if (produtos.containsKey(nome)) {
            return "\nESSE PRODUTO JÁ FOI ADICIONADO!";
        } else {
            produtos.put(nome, valor);
            return "\nPRODUTO ADICONADO COM SUCESSO!!";
        }
    }

    @Override
    public String removerProduto(String nome) throws RemoteException {
        if (produtos.containsKey(nome)) {
            produtos.remove(nome);
            return "\nPRODUTO REMOVIDO!!";
        } else {
            return "\nNENHUM PRODUTO ENCONTRADO!!";
        }
    }

    @Override
    public String pesquisarProduto(String nome) throws RemoteException {
        if (produtos.containsKey(nome)) {
            return "\nPRODUTO PESQUISADO: " + nome + " - " + "PREÇO = R$" + produtos.get(nome);
        } else {
            return "\nNENHUM PRODUTO ENCONTRADO!!";
        }
    }

    @Override
    public String alterarProduto(String nome, float valor) throws RemoteException {
        if (produtos.containsKey(nome)) {
            produtos.put(nome, valor);
            return "\nPRODUTO EDITADO!!";
        } else {
            return "\nPRODUTO NÃO ENCONTRADO!!";
        }
    }

    public static void main(String[] args) {
        try {
            Registry r = LocateRegistry.createRegistry(1234);
            Iloja loja = new LojaServidor();
            r.rebind("LojaServidor", loja);
            System.out.println("AGUARDANDO CONEXAO!");
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
