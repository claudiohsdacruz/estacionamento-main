package br.edu.ifpb.padroes;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;


public abstract class Estacionamento {

    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Veiculo veiculo;

    public abstract BigDecimal obterTotalAPagar();

}
