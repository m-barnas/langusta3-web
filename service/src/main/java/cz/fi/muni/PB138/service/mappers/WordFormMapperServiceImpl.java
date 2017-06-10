package cz.fi.muni.PB138.service.mappers;

import cz.fi.muni.PB138.dto.DeclinedWordDTO;
import cz.fi.muni.PB138.dto.GrammaticalCaseDTO;
import cz.fi.muni.PB138.entity.Word;
import cz.fi.muni.PB138.enums.Number;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 9.6.2017.
 *
 * @author Martin Barnas 433523
 */
@Service
public class WordFormMapperServiceImpl implements WordFormMapperService {

    @Override
    public DeclinedWordDTO convertToDTO(List<Word> words) {
        DeclinedWordDTO declinedWordDTO = new DeclinedWordDTO();
        Word word = words.get(0);
        declinedWordDTO.setPattern(word.getPattern());
        declinedWordDTO.setWordClass(word.getWordClass());
        declinedWordDTO.setGrammaticalGender(word.getGrammaticalGender());
        for(Word w: words) {
            Number number = w.getNumber();
            switch (w.getGrammaticalCase()) {
                case Nominative:
                    if (number.equals(Number.Singular)) {
                        declinedWordDTO.getNominative().getSingulars().add(w.getDeclinedValue());
                    } else {
                        declinedWordDTO.getNominative().getPlurals().add(w.getDeclinedValue());
                    }
                    break;
                case Genitive:
                    if (number.equals(Number.Singular)) {
                        declinedWordDTO.getGenitive().getSingulars().add(w.getDeclinedValue());
                    } else {
                        declinedWordDTO.getGenitive().getPlurals().add(w.getDeclinedValue());
                    }
                    break;
                case Dative:
                    if (number.equals(Number.Singular)) {
                        declinedWordDTO.getDative().getSingulars().add(w.getDeclinedValue());
                    } else {
                        declinedWordDTO.getDative().getPlurals().add(w.getDeclinedValue());
                    }
                    break;
                case Accusative:
                    if (number.equals(Number.Singular)) {
                        declinedWordDTO.getAccusative().getSingulars().add(w.getDeclinedValue());
                    } else {
                        declinedWordDTO.getAccusative().getPlurals().add(w.getDeclinedValue());
                    }
                    break;
                case Vocative:
                    if (number.equals(Number.Singular)) {
                        declinedWordDTO.getVocative().getSingulars().add(w.getDeclinedValue());
                    } else {
                        declinedWordDTO.getVocative().getPlurals().add(w.getDeclinedValue());
                    }
                    break;
                case Locative:
                    if (number.equals(Number.Singular)) {
                        declinedWordDTO.getLocative().getSingulars().add(w.getDeclinedValue());
                    } else {
                        declinedWordDTO.getLocative().getPlurals().add(w.getDeclinedValue());
                    }
                    break;
                case Instrumental:
                    if (number.equals(Number.Singular)) {
                        declinedWordDTO.getInstrumental().getSingulars().add(w.getDeclinedValue());
                    } else {
                        declinedWordDTO.getInstrumental().getPlurals().add(w.getDeclinedValue());
                    }
                    break;
            }
        }
        return declinedWordDTO;
    }

}
