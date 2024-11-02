package com.historicopaciente.historicopaciente.consultamedica;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultaMedicaService {

    private final ConsultaMedicaRepository consultaMedicaRepository;
}
