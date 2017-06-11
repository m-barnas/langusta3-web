package cz.fi.muni.PB138.rest.controller;

import cz.fi.muni.PB138.dto.WordDTO;
import cz.fi.muni.PB138.dto.InputValueDTO;
import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.GrammaticalGender;
import cz.fi.muni.PB138.enums.Number;
import cz.fi.muni.PB138.enums.WordClass;
import cz.fi.muni.PB138.facade.WordFacade;
import cz.fi.muni.PB138.rest.Uri;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Martin on 8.6.2017.
 *
 * @author Martin Barnas 433523
 */
@RestController
@RequestMapping(path = Uri.ROOT_URI_WORD, produces = MediaType.APPLICATION_JSON_VALUE)
public class WordController {

    @Inject
    WordFacade wordFacade;

    @RequestMapping(path = "/find-infinitives", method = RequestMethod.GET)
    public List<String> findInfinitives(@RequestParam("pattern") String pattern) {
        return wordFacade.findInfinitivesByPattern(pattern);
    }

    @RequestMapping(path = "/find-by-number-of-patterns", method = RequestMethod.GET)
    public List<String> findByNumberOfPatterns(@RequestParam("number-of-patterns") Long numberOfPatterns) {
        return wordFacade.findByNumberOfPatterns(numberOfPatterns);
    }

    @RequestMapping(path = "/find-by-declined-value", method = RequestMethod.GET)
    public List<WordDTO> findByDeclinedValue(@RequestParam("declined-value") String declinedValue) {
        return wordFacade.findByDeclinedValue(declinedValue);
    }

    @RequestMapping(path = "/find-patterns", method = RequestMethod.GET)
    public List<String> findPatterns(@RequestParam("declined-value") String declinedValue) {
        return wordFacade.findPatterns(declinedValue);
    }

    /*
    @RequestMapping(path = "/analyze/find-all-forms", method = RequestMethod.GET)
    public WordFormDTO findPatterns(@RequestParam("infinitive") String infinitive,
                                    @RequestParam("pattern") String pattern) {
        return wordFacade.findAllForms(infinitive, pattern);
    }
    */

    @RequestMapping(path = "/analyze", method = RequestMethod.GET)
    public List<InputValueDTO> analyze(@RequestParam("text") String text) {
        return wordFacade.analyze(text);
    }

    @RequestMapping(path = "/find-words-by-patterns", method = RequestMethod.GET)
    public List<String> findWordsByPatterns(@RequestParam("pattern") List<String> patterns) {
        return wordFacade.findAllWordsByPatterns(patterns);
    }

    @RequestMapping(path = "/filter", method = RequestMethod.GET)
    public List<String> findFiltered(
            @RequestParam("matches") String matches,
            @RequestParam(value = "pattern", required = false) String pattern,
            @RequestParam(value = "word-class", required = false) WordClass wordClass,
            @RequestParam(value = "grammatical-gender", required = false) GrammaticalGender grammaticalGender,
            @RequestParam(value = "number", required = false) Number number,
            @RequestParam(value = "grammatical-case", required = false) GrammaticalCase grammaticalCase) {
        return wordFacade.findFiltered(matches, pattern, wordClass, grammaticalGender, number, grammaticalCase);
    }



//    @RequestMapping(path = "/find-by-word-class", method = RequestMethod.GET)
//    public List<WordDTO> findByWordClass(@RequestParam("word-class") WordClass wordClass) {
//        return wordFacade.findByWordClass(wordClass);
//    }
//
//    @RequestMapping(path = "/find-by-grammatical-gender", method = RequestMethod.GET)
//    public List<WordDTO> findByGrammaticalGender(@RequestParam("grammatical-gender") GrammaticalGender grammaticalGender) {
//        return wordFacade.findByGrammaticalGender(grammaticalGender);
//    }
//
//    @RequestMapping(path = "/find-by-number", method = RequestMethod.GET)
//    public List<WordDTO> findByNumber(@RequestParam("number") Number number) {
//        return wordFacade.findByNumber(number);
//    }
//
//    @RequestMapping(path = "/find-by-grammatical-case", method = RequestMethod.GET)
//    public List<WordDTO> findByGrammaticalCase(@RequestParam("grammatical-case") GrammaticalCase grammaticalCase) {
//        return wordFacade.findByGrammaticalCase(grammaticalCase);
//    }
}
