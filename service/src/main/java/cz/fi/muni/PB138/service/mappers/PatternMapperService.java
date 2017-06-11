package cz.fi.muni.PB138.service.mappers;

import cz.fi.muni.PB138.dto.*;
import cz.fi.muni.PB138.entity.xml.Pattern;
import cz.fi.muni.PB138.entity.xml.PatternBase;
import cz.fi.muni.PB138.entity.xml.util.BaseChange;
import cz.fi.muni.PB138.entity.xml.util.ConditionList;
import cz.fi.muni.PB138.entity.xml.util.Form;
import cz.fi.muni.PB138.entity.xml.util.FormInfo;

import java.util.List;

/**
 * Created by Erik Macej 433744 , on 31.5.17.
 *
 * @author Erik Macej 433744
 */
public interface PatternMapperService {

    public BaseChangeDTO convertToDTO(BaseChange entity);
    public ConditionListDTO convertToDTO(ConditionList entity);
    public FormInfoDTO convertToDTO(FormInfo entity);
    public FormDTO convertToDTO(Form entity);
    public PatternDTO convertToDTO(Pattern entity);
    public PatternBaseDTO convertToDTO(PatternBase entity);
    public List<PatternBaseDTO> convertToDTO(List<PatternBase> entities);
}
