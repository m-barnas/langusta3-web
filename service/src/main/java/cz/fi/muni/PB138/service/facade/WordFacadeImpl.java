package cz.fi.muni.PB138.service.facade;

import cz.fi.muni.PB138.dto.WordDTO;
import cz.fi.muni.PB138.entity.Word;
import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.GrammaticalGender;
import cz.fi.muni.PB138.facade.WordFacade;
import cz.fi.muni.PB138.service.WordService;
import cz.fi.muni.PB138.service.mappers.WordMapperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
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
    public List<WordDTO> findByInfinitive(String infinitive) {
        return mapperService.asDtos(wordService.findByInfinitive(infinitive));
    }

    @Override
    public List<WordDTO> findWordsByPattern(String pattern) {
        return mapperService.asDtos(wordService.findWordsByPattern(pattern));
    }

    @Override
    public List<WordDTO> findByDeclinedValue(String declinedValue) {
        return mapperService.asDtos(wordService.findByDeclinedValue(declinedValue));
    }

    @Override
    public List<WordDTO> findByWordClass(String wordClass) {
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

    @Override
    public List<WordDTO> findByNumberOfPattern(int numberOfPatterns) {
        return mapperService.asDtos(wordService.findByNumberOfPattern(numberOfPatterns));
    }
}
