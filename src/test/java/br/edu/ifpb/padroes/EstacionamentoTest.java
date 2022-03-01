package br.edu.ifpb.padroes;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import static br.edu.ifpb.padroes.EstacionamentoDiaria.*;
import static br.edu.ifpb.padroes.EstacionamentoMensal.*;
import static br.edu.ifpb.padroes.EstacionamentoHora.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstacionamentoTest {

    //private Estacionamento estacionamento = new Estacionamento();
    public EstacionamentoHora estacionamentoHora = new EstacionamentoHora();
    public EstacionamentoDiaria estacionamentoDiaria = new EstacionamentoDiaria();
    public EstacionamentoMensal estacionamentoMensal = new EstacionamentoMensal();

    @Test
    public void obterTotalAPagarTeste_hora() {
        LocalDateTime entrada = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
        LocalDateTime saida = LocalDateTime.of(2021, 1, 1, 11, 0, 0);
        Veiculo veiculo = new Veiculo("ABC-123",  "Chevrolet Onix", "Azul");
        estacionamentoHora.setEntrada(entrada);
        estacionamentoHora.setSaida(saida);
        estacionamentoHora.setVeiculo(veiculo);
        System.out.println(estacionamentoHora.obterTotalAPagar());
        long diferenca = Duration.between(entrada, saida).toHours();
        assertEquals(estacionamentoHora.obterTotalAPagar(), VALOR_HORA.multiply(new BigDecimal(diferenca)));
    }

    @Test
    public void obterTotalAPagarTeste_diaria() {
        LocalDateTime entrada = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
        LocalDateTime saida = LocalDateTime.of(2021, 1, 12, 0, 0, 0);
        Veiculo veiculo = new Veiculo("ABC-123",  "Chevrolet Onix", "Azul");
        estacionamentoDiaria.setEntrada(entrada);
        estacionamentoDiaria.setSaida(saida);
        estacionamentoDiaria.setVeiculo(veiculo);
        System.out.println(estacionamentoDiaria.obterTotalAPagar());
        long diferenca = Duration.between(entrada, saida).toDays();
        assertEquals(estacionamentoDiaria.obterTotalAPagar(), VALOR_DIARIA.multiply(new BigDecimal(diferenca)));
    }

    @Test
    public void obterTotalAPagarTeste_mensalidade() {
        LocalDateTime entrada = LocalDateTime.of(2021, 1, 17, 0, 0, 0);
        LocalDateTime saida = LocalDateTime.of(2021, 3, 1, 0, 0, 0);
        Veiculo veiculo = new Veiculo("ABC-123",  "Chevrolet Onix", "Azul");
        estacionamentoMensal.setEntrada(entrada);
        estacionamentoMensal.setSaida(saida);
        estacionamentoMensal.setVeiculo(veiculo);
        System.out.println(estacionamentoMensal.obterTotalAPagar());
        assertEquals(estacionamentoMensal.obterTotalAPagar(), VALOR_MENSALIDADE);
    }

}
