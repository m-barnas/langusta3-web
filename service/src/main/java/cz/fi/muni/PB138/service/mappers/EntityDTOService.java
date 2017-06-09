package cz.fi.muni.PB138.service.mappers;

import java.util.Collection;
import java.util.List;

/**
 * Created by Martin on 8.6.2017.
 *
 * @author Martin Barnas 433523
 */
public interface EntityDTOService<Entity, DTO> extends EntityDTOMapper<Entity, DTO> {

    <Mapper extends EntityDTOMapper<Entity, DTO>> Mapper getMapper();

    DTO asDto(Entity entity);

    Entity asEntity(DTO dto);

    List<DTO> asDtos(Collection<Entity> entities);

    List<Entity> asEntities(Collection<DTO> dtos);
}
