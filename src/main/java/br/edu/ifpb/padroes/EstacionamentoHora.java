package br.edu.ifpb.padroes;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
public class EstacionamentoHora extends Estacionamento {

    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Veiculo veiculo;

    public static BigDecimal VALOR_HORA = new BigDecimal("2.00");

    public BigDecimal obterTotalAPagar() {
        long periodoHoras = Duration.between(entrada, saida).toHours();
        BigDecimal valor = new BigDecimal(0);
        valor = VALOR_HORA.multiply(new BigDecimal(periodoHoras));

        return valor;
    }
}
