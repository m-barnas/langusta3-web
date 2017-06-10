package cz.fi.muni.PB138.service.facade;

import cz.fi.muni.PB138.dto.WordDTO;
import cz.fi.muni.PB138.dto.DeclinedWordDTO;
import cz.fi.muni.PB138.dto.InfinitiveDTO;
import cz.fi.muni.PB138.entity.Word;
import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.GrammaticalGender;
import cz.fi.muni.PB138.enums.WordClass;
import cz.fi.muni.PB138.facade.WordFacade;
import cz.fi.muni.PB138.service.WordService;
import cz.fi.muni.PB138.service.mappers.WordFormMapperService;
import cz.fi.muni.PB138.service.mappers.WordMapperService;
import cz.fi.muni.PB138.service.utils.Parser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 7.6.2017.
 *
 * @author Martin Barnas 433523
 */
@Service
@Transactional
public class WordFacadeImpl implements WordFacade {

    @Inject
    private WordService wordService;

    @Inject
    private WordMapperService mapperService;

    @Inject
    private WordFormMapperService wordFormMapperService;

    @Override
    public void create(WordDTO word) {
        Word w = mapperService.asEntity(word);
        wordService.create(w);
        word.setId(w.getId());
    }

    @Override
    public WordDTO findById(Long id) {
        Word word = wordService.findById(id);
        return mapperService.asDto(word);
    }

    @Override
    public List<WordDTO> findAll() {
        return mapperService.asDtos(wordService.findAll());
    }

    @Override
    public List<String> findInfinitives(String pattern) {
        return wordService.findInfinitives(pattern);
    }

    @Override
    public List<String> findByNumberOfPatterns(Long numberOfPatterns) {
        return wordService.findByNumberOfPatterns(numberOfPatterns);
    }

    @Override
    public List<WordDTO> findByDeclinedValue(String declinedValue) {
        return mapperService.asDtos(wordService.findByDeclinedValue(declinedValue));
    }

    @Override
    public List<String> findPatterns(String infinitive) {
        return wordService.findPatterns(infinitive);
    }

    @Override
    public DeclinedWordDTO findAllForms(String infinitive, String pattern) {
        return wordFormMapperService.convertToDTO(wordService.findAllForms(infinitive, pattern));
    }

    @Override
    public List<InfinitiveDTO> analyze(String text) {
        List<String> inputValues = Parser.parseText(text);
        List<InfinitiveDTO> infinitiveDTOS = new ArrayList<>();
        for(String inputValue : inputValues) {
            List<String> patterns = wordService.findPatterns(inputValue);
            if (!patterns.isEmpty()) {
                String infinitive = wordService.findInfinitive(inputValue);
                InfinitiveDTO infinitiveDTO = new InfinitiveDTO();
                infinitiveDTO.setInfinitive(infinitive);
                infinitiveDTO.setInputValue(inputValue);
                List<DeclinedWordDTO> declinedWordDTOS = new ArrayList<>();
                for(String pattern : patterns) {
                    declinedWordDTOS.add(findAllForms(infinitive, pattern));
                }
                infinitiveDTO.setPatterns(declinedWordDTOS);
                infinitiveDTOS.add(infinitiveDTO);
            }
        }
        return infinitiveDTOS;
    }


    @Override
    public List<WordDTO> findByWordClass(WordClass wordClass) {
        return mapperService.asDtos(wordService.findByWordClass(wordClass));
    }

    @Override
    public List<WordDTO> findByGrammaticalGender(GrammaticalGender grammaticalGender) {
        return mapperService.asDtos(wordService.findByGrammaticalGender(grammaticalGender));
    }

    @Override
    public List<WordDTO> findByNumber(Number number) {
        return mapperService.asDtos(wordService.findByNumber(number));
    }

    @Override
    public List<WordDTO> findByGrammaticalCase(GrammaticalCase grammaticalCase) {
        return mapperService.asDtos(wordService.findByGrammaticalCase(grammaticalCase));
    }
}
