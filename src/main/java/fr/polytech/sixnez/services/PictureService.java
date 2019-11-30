package fr.polytech.sixnez.services;

import fr.polytech.sixnez.dtos.FilmIdDTO;
import fr.polytech.sixnez.dtos.FilmURLDTO;
import fr.polytech.sixnez.entities.FilmEntity;
import fr.polytech.sixnez.model.BetterReader;
import fr.polytech.sixnez.model.BetterString;
import fr.polytech.sixnez.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PictureService {

    private BetterString bufferLine;

    @Autowired
    private FilmRepository filmRepository;

    public PictureService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<FilmURLDTO> getPictures(List<FilmIdDTO> ids) {

        List<FilmEntity> films = filmRepository.findAllById(ids.stream().map( filmIdDTO -> filmIdDTO.getId()).collect(Collectors.toList()));

        films.parallelStream().forEach(filmEntity -> {
            if (filmEntity.getImage() == null) {
                try {
                    filmEntity.setImage(getPicture(filmEntity.getIdFilm()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                films.stream().forEach(filmEntity -> filmRepository.save(filmEntity));
            }
        }).start();

        return films.stream().map(filmEntity -> new FilmURLDTO(filmEntity.getImage(), filmEntity.getIdFilm())).collect(Collectors.toList());
    }

    public String getPicture(String movieID) throws IOException {
        URL url = new URL("https://www.imdb.com/title/" + movieID + "/");
        BetterReader reader = new BetterReader(url.openStream());

        while ((bufferLine = reader.readLine()) != null) {
            if (!bufferLine.endsWith()) continue;

            for (int i = 0; i < 3; ++i) {
                if ((bufferLine = reader.readLine()) == null) return null;
            }

            if (bufferLine.startsWith()) {
                return bufferLine.substring(5, bufferLine.length() - 4);
            } else {
                return "";
            }
        }

        return "";
    }
}
