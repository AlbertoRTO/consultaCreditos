package com.consulta.credito.controller;

import com.consulta.credito.model.Credito;
import com.consulta.credito.service.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    @Autowired
    private CreditoService creditoService;

    @GetMapping("/{numeroNfse}")
    public ResponseEntity<List<Credito>> buscarPorNfse(@PathVariable String numeroNfse) {
        try {
            List<Credito> creditos = creditoService.buscarPorNumeroNfse(numeroNfse);
            if (creditos.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(creditos);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/credito/{numeroCredito}")
    public ResponseEntity<Credito> buscarPorNumeroCredito(@PathVariable String numeroCredito) {
        try {
            Optional<Credito> credito = creditoService.buscarPorNumeroCredito(numeroCredito);
            if (credito.isPresent()) {
                return ResponseEntity.ok(credito.get());
            }
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/todos")
    public List<Credito> listarTodos() {
        return creditoService.listarTodos();
    }
}