package cz.fi.muni.PB138.specifications;

import cz.fi.muni.PB138.entity.Word;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * Created by Martin on 10.6.2017.
 *
 * @author Martin Barnas 433523
 */
public class WordSpecifications {

    public static Specification<Word> isNotRepresentedByPattern(String pattern) {
        return (root, query, builder) -> builder.notLike(root.get("pattern"), "%" + pattern + "%");
    }

    public static Specification<Word> isNotPresentInInfinitives(List<String> infinitives) {
        return (root, query, builder) -> builder.not(root.get("infinitive").in(infinitives));
    }

}
