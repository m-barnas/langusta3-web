package cz.fi.muni.PB138.service.mappers;

import cz.fi.muni.PB138.dto.GenderDTO;
import cz.fi.muni.PB138.entity.Word;
import cz.fi.muni.PB138.enums.Number;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Martin on 9.6.2017.
 *
 * @author Martin Barnas 433523
 */
@Service
public class WordFormMapperServiceImpl implements WordFormMapperService {

    @Override
    public GenderDTO convertToDTO(List<Word> words) {
        GenderDTO genderDTO = new GenderDTO();
        for(Word w: words) {
            Number number = w.getNumber();
            switch (w.getGrammaticalCase()) {
                case Nominative:
                    if (number.equals(Number.Singular)) {
                        genderDTO.getNominative().getSingulars().add(w.getDeclinedValue());
                    } else {
                        genderDTO.getNominative().getPlurals().add(w.getDeclinedValue());
                    }
                    break;
                case Genitive:
                    if (number.equals(Number.Singular)) {
                        genderDTO.getGenitive().getSingulars().add(w.getDeclinedValue());
                    } else {
                        genderDTO.getGenitive().getPlurals().add(w.getDeclinedValue());
                    }
                    break;
                case Dative:
                    if (number.equals(Number.Singular)) {
                        genderDTO.getDative().getSingulars().add(w.getDeclinedValue());
                    } else {
                        genderDTO.getDative().getPlurals().add(w.getDeclinedValue());
                    }
                    break;
                case Accusative:
                    if (number.equals(Number.Singular)) {
                        genderDTO.getAccusative().getSingulars().add(w.getDeclinedValue());
                    } else {
                        genderDTO.getAccusative().getPlurals().add(w.getDeclinedValue());
                    }
                    break;
                case Vocative:
                    if (number.equals(Number.Singular)) {
                        genderDTO.getVocative().getSingulars().add(w.getDeclinedValue());
                    } else {
                        genderDTO.getVocative().getPlurals().add(w.getDeclinedValue());
                    }
                    break;
                case Locative:
                    if (number.equals(Number.Singular)) {
                        genderDTO.getLocative().getSingulars().add(w.getDeclinedValue());
                    } else {
                        genderDTO.getLocative().getPlurals().add(w.getDeclinedValue());
                    }
                    break;
                case Instrumental:
                    if (number.equals(Number.Singular)) {
                        genderDTO.getInstrumental().getSingulars().add(w.getDeclinedValue());
                    } else {
                        genderDTO.getInstrumental().getPlurals().add(w.getDeclinedValue());
                    }
                    break;
            }
        }
        return genderDTO;
    }

}
