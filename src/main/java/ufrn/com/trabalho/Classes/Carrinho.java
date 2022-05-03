package ufrn.com.trabalho.Classes;

import java.util.ArrayList;

public class Carrinho {
    public Carrinho(ArrayList<Produtos> produtos) {
        super();
        this.produtos = produtos;
    }
    
    ArrayList<Produtos> produtos;
    
    public ArrayList<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produtos> produtos) {
        this.produtos = produtos;
    }

    public Produtos getProduto (int id){
        Produtos mp = null;
        
        for (Produtos p : produtos){
            if (p.getId() == id){
                return p;
            }
        }
        return mp;
    }

    public void removeProduto (int id){
        Produtos p = getProduto(id);
        produtos.remove(p); 
    }

    public void addProduto (Produtos p){
        produtos.add(p);
    }
}
