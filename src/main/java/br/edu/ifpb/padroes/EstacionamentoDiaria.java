package br.edu.ifpb.padroes;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
public class EstacionamentoDiaria extends Estacionamento{

    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Veiculo veiculo;

    public static BigDecimal VALOR_DIARIA = new BigDecimal("26.00");

    public BigDecimal obterTotalAPagar() {
        long periodoDias = Duration.between(entrada, saida).toDays();
        BigDecimal valor = new BigDecimal(0);
        valor = VALOR_DIARIA.multiply(new BigDecimal(periodoDias));

        return valor;
    }
}
