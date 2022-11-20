package com.trabfinal.aplicacao.casosDeUso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.negocio.servicos.ServicoAluguel;

@Component
public class CancelarPlanoDeVooUC {
    private ServicoAluguel servicoAluguel;

    @Autowired
    public CancelarPlanoDeVooUC(ServicoAluguel servicoAluguel) {
        this.servicoAluguel = servicoAluguel;
    }

    public String cancelarPlanoDeVoo(int id){
        try{
            servicoAluguel.cancelaAluguel(id);
        } catch(Exception e){
            e.printStackTrace();
            return "Erro ao cancelar voo";
        }
        return "Voo cancelado com sucesso";
    }
}
