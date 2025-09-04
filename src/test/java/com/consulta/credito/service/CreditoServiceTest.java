package com.consulta.credito.service;

import com.consulta.credito.model.Credito;
import com.consulta.credito.repository.CreditoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreditoServiceTest {

    @Mock
    private CreditoRepository creditoRepository;

    @InjectMocks
    private CreditoService creditoService;

    @Test
    void testBuscarPorNumeroNfse() {
        // Given
        String numeroNfse = "7891011";
        List<Credito> creditos = Arrays.asList(new Credito());
        
        when(creditoRepository.findByNumeroNfse(numeroNfse)).thenReturn(creditos);

        // When
        List<Credito> resultado = creditoService.buscarPorNumeroNfse(numeroNfse);

        // Then
        assertEquals(1, resultado.size());
        verify(creditoRepository).findByNumeroNfse(numeroNfse);
    }

    @Test
    void testBuscarPorNumeroCredito() {
        // Given
        String numeroCredito = "123456";
        Credito credito = new Credito();
        
        when(creditoRepository.findByNumeroCredito(numeroCredito)).thenReturn(Optional.of(credito));

        // When
        Optional<Credito> resultado = creditoService.buscarPorNumeroCredito(numeroCredito);

        // Then
        assertTrue(resultado.isPresent());
    }

    @Test
    void testListarTodos() {
        // Given
        List<Credito> creditos = Arrays.asList(new Credito(), new Credito());
        when(creditoRepository.findAll()).thenReturn(creditos);

        // When
        List<Credito> resultado = creditoService.listarTodos();

        // Then
        assertEquals(2, resultado.size());
    }

    @Test
    void testValidacaoNumeroNfseNulo() {
        // When/Then
        assertThrows(IllegalArgumentException.class, 
                () -> creditoService.buscarPorNumeroNfse(null));
    }

    @Test
    void testValidacaoNumeroCreditoNulo() {
        // When/Then
        assertThrows(IllegalArgumentException.class, 
                () -> creditoService.buscarPorNumeroCredito(null));
    }
}