package br.com.Software_MS.dtos;

import br.com.Software_MS.entities.Software;
import org.springframework.stereotype.Component;

@Component
public class SoftwareDTOMapper {

    public SoftwareDTO toDTO(Software software) {
        return SoftwareDTO.builder()
                .idSoftware(software.getIdSoftware())
                .nome(software.getNome())
                .versao(software.getVersao())
                .linkInstalacao(software.getLinkInstalacao())
                .proprietario(software.isProprietario())
                .disponivel(software.isDisponivel())
                .dataCadastro(software.getDataCadastro())
                .build();
    }

    public Software toEntity(SoftwareDTO softwareDTO) {
        Software software = new Software();
        software.setIdSoftware(softwareDTO.getIdSoftware());
        software.setNome(softwareDTO.getNome());
        software.setVersao(softwareDTO.getVersao());
        software.setLinkInstalacao(softwareDTO.getLinkInstalacao());
        software.setProprietario(softwareDTO.isProprietario());
        software.setDisponivel(softwareDTO.isDisponivel());
        software.setDataCadastro(softwareDTO.getDataCadastro());
        return software;
    }
}
