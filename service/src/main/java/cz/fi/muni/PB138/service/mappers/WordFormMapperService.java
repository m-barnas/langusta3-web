package cz.fi.muni.PB138.service.mappers;

import cz.fi.muni.PB138.dto.GenderDTO;
import cz.fi.muni.PB138.dto.ModelDTO;
import cz.fi.muni.PB138.entity.Word;

import java.util.List;

/**
 * Created by Martin on 9.6.2017.
 *
 * @author Martin Barnas 433523
 */
public interface WordFormMapperService {

    GenderDTO convertToDTO(List<Word> entity);
}
