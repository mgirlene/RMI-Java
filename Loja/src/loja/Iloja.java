package loja;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author mgirlene
 */
public interface Iloja extends Remote {

    public String addProduto(String nome, float valor) throws RemoteException;

    public String removerProduto(String nome) throws RemoteException;

    public String pesquisarProduto(String nome) throws RemoteException;

    public String alterarProduto(String nome, float valor) throws RemoteException;
}
