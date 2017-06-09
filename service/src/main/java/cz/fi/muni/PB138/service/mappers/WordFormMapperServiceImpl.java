package cz.fi.muni.PB138.service.mappers;

import cz.fi.muni.PB138.dto.DeclinedWordDTO;
import cz.fi.muni.PB138.dto.WordFormDTO;
import cz.fi.muni.PB138.entity.Word;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 9.6.2017.
 */
@Service
public class WordFormMapperServiceImpl implements WordFormMapperService {


    @Override
    public DeclinedWordDTO convertToDTO(Word entity) {
        if (entity == null) {
            return null;
        }
        DeclinedWordDTO dto = new DeclinedWordDTO();
        dto.setId(entity.getId());
        dto.setDeclinedValue(entity.getDeclinedValue());
        dto.setGrammaticalCase(entity.getGrammaticalCase());
        dto.setNumber(entity.getNumber());
        return dto;
    }

    @Override
    public WordFormDTO convertToDTO(List<Word> entity) {
        if (entity.isEmpty()) {
            return null;
        }
        WordFormDTO result = new WordFormDTO();
        Word word = entity.get(0);
        result.setPattern(word.getPattern());
        result.setInfinitive(word.getInfinitive());
        result.setWordClass(word.getWordClass());
        result.setGrammaticalGender(word.getGrammaticalGender());

        List<DeclinedWordDTO> words = new ArrayList<>();
        for(Word w: entity) {
            words.add(convertToDTO(w));
        }
        result.setDeclinedWordDTOS(words);
        return result;
    }
}
