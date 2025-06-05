package br.com.Software_MS.services;

import br.com.Software_MS.dtos.SoftwareDTO;
import br.com.Software_MS.dtos.SoftwareDTOMapper;
import br.com.Software_MS.entities.Software;
import br.com.Software_MS.repositories.SoftwareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SoftwareService {

    private final SoftwareRepository softwareRepository;
    private final SoftwareDTOMapper softwareDTOMapper;

    public List<SoftwareDTO> listarTodos() {
        return softwareRepository.findAll()
                .stream()
                .map(softwareDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SoftwareDTO listarPorId(Long id) {
        Software software = softwareRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Software não encontrado com id: " + id));
        return softwareDTOMapper.toDTO(software);
    }

    public SoftwareDTO salvar(SoftwareDTO softwareDTO) {
        Software software = softwareDTOMapper.toEntity(softwareDTO);
        Software salvo = softwareRepository.save(software);
        return softwareDTOMapper.toDTO(salvo);
    }

    public SoftwareDTO atualizar(Long id, SoftwareDTO softwareDTOAtualizado) {
        Software software = softwareRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Software não encontrado com id: " + id));

        software.setNome(softwareDTOAtualizado.getNome());
        software.setVersao(softwareDTOAtualizado.getVersao());
        software.setLinkInstalacao(softwareDTOAtualizado.getLinkInstalacao());
        software.setProprietario(softwareDTOAtualizado.isProprietario());
        software.setDisponivel(softwareDTOAtualizado.isDisponivel());

        Software atualizado = softwareRepository.save(software);
        return softwareDTOMapper.toDTO(atualizado);
    }

    public String deletar(Long id) {
        softwareRepository.deleteById(id);
        return "Software Deletado com sucesso";
    }
}