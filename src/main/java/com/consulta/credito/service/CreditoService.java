package com.consulta.credito.service;

import com.consulta.credito.model.Credito;
import com.consulta.credito.repository.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditoService {

    @Autowired
    private CreditoRepository creditoRepository;

    public List<Credito> buscarPorNumeroNfse(String numeroNfse) {
        if (numeroNfse == null || numeroNfse.trim().isEmpty()) {
            throw new IllegalArgumentException("Número da NFS-e é obrigatório");
        }
        return creditoRepository.findByNumeroNfse(numeroNfse);
    }

    public Optional<Credito> buscarPorNumeroCredito(String numeroCredito) {
        if (numeroCredito == null || numeroCredito.trim().isEmpty()) {
            throw new IllegalArgumentException("Número do crédito é obrigatório");
        }
        return creditoRepository.findByNumeroCredito(numeroCredito);
    }

    public List<Credito> listarTodos() {
        return creditoRepository.findAll();
    }

    public Credito salvar(Credito credito) {
        if (credito == null) {
            throw new IllegalArgumentException("Crédito não pode ser nulo");
        }
        return creditoRepository.save(credito);
    }

    public boolean existePorNumeroCredito(String numeroCredito) {
        return creditoRepository.findByNumeroCredito(numeroCredito).isPresent();
    }

    public long contarTotal() {
        return creditoRepository.count();
    }
}