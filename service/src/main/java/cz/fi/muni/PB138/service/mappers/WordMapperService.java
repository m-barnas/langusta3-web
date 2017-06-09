package cz.fi.muni.PB138.service.mappers;

import cz.fi.muni.PB138.dto.WordDTO;
import cz.fi.muni.PB138.entity.Word;
import fr.xebia.extras.selma.Selma;
import org.springframework.stereotype.Service;

/**
 * Created by Martin on 8.6.2017.
 *
 * @author Martin Barnas 433523
 */
@Service
public class WordMapperService extends EntityDTOServiceImpl<Word, WordDTO> {

    private WordMapper mapper = Selma.builder(WordMapper.class).build();

    @SuppressWarnings("unchecked")
    @Override
    public WordMapper getMapper() {
        return mapper;
    }
}
