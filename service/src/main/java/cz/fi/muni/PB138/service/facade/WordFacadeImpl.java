package cz.fi.muni.PB138.service.facade;

import cz.fi.muni.PB138.dto.GenderDTO;
import cz.fi.muni.PB138.dto.WordDTO;
import cz.fi.muni.PB138.dto.ModelDTO;
import cz.fi.muni.PB138.dto.InputValueDTO;
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
    public List<String> findInfinitivesByPattern(String pattern) {
        return wordService.findInfinitivesByPattern(pattern);
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
    public GenderDTO findAllForms(String infinitive, String pattern, GrammaticalGender gender) {
        return wordFormMapperService.convertToDTO(wordService.findAllForms(infinitive, pattern));
    }

    @Override
    public List<InputValueDTO> analyze(String text) {
        List<String> inputValues = Parser.parseText(text);
        List<InputValueDTO> inputValueDTOS = new ArrayList<>();
        boolean isValid = true;
        for(String inputValue : inputValues) {
            InputValueDTO inputValueDTO = new InputValueDTO();
            inputValueDTO.setInputValue(inputValue);
            List<String> infinitives = wordService.findInfinitivesByDeclinedValue(inputValue);
            isValid = !infinitives.isEmpty();
            for(String infinitive : infinitives) {
                List<String> patterns = wordService.findPatternsByInfinitive(infinitive);
                isValid = !patterns.isEmpty();
                for(String pattern : patterns) {
                    ModelDTO modelDTO = new ModelDTO();
                    modelDTO.setInfinitive(infinitive);
                    modelDTO.setPattern(pattern);
                    List<GrammaticalGender> genders = wordService.findGrammaticalGenders(infinitive, pattern);
                    for(GrammaticalGender gender : genders) {
                        List<Word> forms = wordService.findAllForms(infinitive, pattern, gender);
                        if (forms.size() > 0 && modelDTO.getWordClass() == null) {
                            modelDTO.setWordClass(forms.get(0).getWordClass());
                        }
                        GenderDTO genderDTO = wordFormMapperService.convertToDTO(forms);
                        genderDTO.setGrammaticalGender(gender);
                        modelDTO.getGenders().add(genderDTO);
                    }
                    inputValueDTO.getPatterns().add(modelDTO);
                }
            }
            if (isValid) {
                inputValueDTOS.add(inputValueDTO);
            }
        }
        return inputValueDTOS;
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
