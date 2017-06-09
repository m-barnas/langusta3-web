package cz.fi.muni.PB138.service.mappers;

/**
 * Created by Martin on 8.6.2017.
 *
 * @author Martin Barnas 433523
 */
public interface EntityDTOMapper <Entity, DTO> {

    DTO asDto(Entity entity);

    Entity asEntity(DTO dto);
}
