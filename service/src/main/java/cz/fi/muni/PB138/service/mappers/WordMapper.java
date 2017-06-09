package cz.fi.muni.PB138.service.mappers;

import cz.fi.muni.PB138.dto.WordDTO;
import cz.fi.muni.PB138.entity.Word;
import fr.xebia.extras.selma.Mapper;


/**
 * Created by Martin on 8.6.2017.
 *
 * @author Martin Barnas 433523
 */
@Mapper
public interface WordMapper extends EntityDTOMapper<Word, WordDTO> {
}
