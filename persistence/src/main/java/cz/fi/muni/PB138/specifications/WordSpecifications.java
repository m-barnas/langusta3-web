package cz.fi.muni.PB138.specifications;

import cz.fi.muni.PB138.entity.Word;
import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.GrammaticalGender;
import cz.fi.muni.PB138.enums.Number;
import cz.fi.muni.PB138.enums.WordClass;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by Martin on 10.6.2017.
 *
 * @author Martin Barnas 433523
 */
public class WordSpecifications {

    public static Specification<Word> hasPattern(String pattern) {
        return (root, query, builder) ->
                builder.equal(root.get("pattern"), pattern.toLowerCase());
    }

    public static Specification<Word> hasDeclinedValue(String declinedValue) {
        return (root, query, builder) ->
                builder.like(root.get("declinedValue"), declinedValue.toLowerCase());
    }

    public static Specification<Word> hasWordClass(WordClass wordClass) {
        return (root, query, builder) ->
                builder.equal(root.get("wordClass"), wordClass);
    }

    public static Specification<Word> hasGrammaticalGender(GrammaticalGender grammaticalGender) {
        return (root, query, builder) ->
                builder.equal(root.get("grammaticalGender"), grammaticalGender);
    }

    public static Specification<Word> hasNumber(Number number) {
        return (root, query, builder) ->
                builder.equal(root.get("number"), number);
    }

    public static Specification<Word> hasGrammaticalCase(GrammaticalCase grammaticalCase) {
        return (root, query, builder) ->
                builder.equal(root.get("grammaticalCase"), grammaticalCase);
    }
}
