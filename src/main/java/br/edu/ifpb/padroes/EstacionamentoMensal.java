package br.edu.ifpb.padroes;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class EstacionamentoMensal extends Estacionamento{

    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Veiculo veiculo;

    public static BigDecimal VALOR_MENSALIDADE = new BigDecimal("300.00");

    public BigDecimal obterTotalAPagar() {

        return VALOR_MENSALIDADE;
    }

}
