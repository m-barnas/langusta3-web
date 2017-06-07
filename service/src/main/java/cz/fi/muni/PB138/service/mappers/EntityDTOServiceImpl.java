package cz.fi.muni.PB138.service.mappers;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Martin on 8.6.2017.
 *
 * @author Martin Barnas 433523
 */
public abstract class EntityDTOServiceImpl<Entity, DTO> implements EntityDTOService<Entity, DTO> {

    @Override
    public abstract <Mapper extends EntityDTOMapper<Entity, DTO>> Mapper getMapper();

    @Override
    public DTO asDto(Entity entity) {
        return entity == null ? null : getMapper().asDto(entity);
    }

    @Override
    public Entity asEntity(DTO dto) {
        return dto == null ? null : getMapper().asEntity(dto);
    }

    @Override
    public List<DTO> asDtos(Collection<Entity> entities) {
        return entities == null ?
                Collections.emptyList() : entities.stream().map(this::asDto).collect(Collectors.toList());
    }

    @Override
    public List<Entity> asEntities(Collection<DTO> dtos) {
        return dtos == null ?
                Collections.emptyList() : dtos.stream().map(this::asEntity).collect(Collectors.toList());
    }
}
