package fr.polytech.sixnez.services;

import fr.polytech.sixnez.repositories.MetierRepository;
import fr.polytech.sixnez.repositories.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetierService {

    @Autowired
    MetierRepository metierRepository;

    public MetierService(MetierRepository metierRepository) {
        this.metierRepository = metierRepository;
    }

    public List<String> getMetier() {
        return metierRepository.findAll().stream().map(metier -> metier.getMetier()).collect(Collectors.toList());
    }
}
