package br.com.Software_MS.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SoftwareDTO {

    private Long idSoftware;
    private String nome;
    private String versao;
    private String linkInstalacao;
    private boolean proprietario;
    private boolean disponivel;
    private LocalDateTime dataCadastro;
}
