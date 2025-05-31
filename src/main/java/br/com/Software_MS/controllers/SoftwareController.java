package br.com.Software_MS.controllers;

import br.com.Software_MS.dtos.SoftwareDTO;
import br.com.Software_MS.services.SoftwareService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/softwares")
@RequiredArgsConstructor
public class SoftwareController {

    private final SoftwareService softwareService;

    @GetMapping
    public List<SoftwareDTO> listarTodos() {
        return softwareService.listarTodos();
    }

    @PostMapping
    public SoftwareDTO criar(@RequestBody SoftwareDTO softwareDTO) {
        return softwareService.salvar(softwareDTO);
    }

    @PutMapping("/{id}")
    public SoftwareDTO atualizar(@PathVariable Long id, @RequestBody SoftwareDTO softwareDTO) {
        return softwareService.atualizar(id, softwareDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        softwareService.deletar(id);
    }
}
