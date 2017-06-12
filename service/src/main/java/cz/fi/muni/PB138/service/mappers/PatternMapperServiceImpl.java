package cz.fi.muni.PB138.service.mappers;

import cz.fi.muni.PB138.dto.*;
import cz.fi.muni.PB138.entity.xml.Pattern;
import cz.fi.muni.PB138.entity.xml.PatternBase;
import cz.fi.muni.PB138.entity.xml.util.*;
import cz.fi.muni.PB138.service.utils.FormComparator;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Erik Macej 433744 , on 29.5.17.
 *
 * @author Erik Macej 433744
 */
@Service
public class PatternMapperServiceImpl implements PatternMapperService {

    @Override
    public BaseChangeDTO convertToDTO(BaseChange entity){

        BaseChangeDTO dto = new BaseChangeDTO();

        dto.setNo(entity.getNo());
        dto.setCharno(entity.getCharno());
        dto.setOperationType(entity.getOperationType());
        dto.setValue(entity.getValue());

        return dto;
    }

    @Override
    public ConditionListDTO convertToDTO(ConditionList entity){

        ConditionListDTO dto = new ConditionListDTO();

        dto.setConditionString(extractConditionString(entity.getConditions()));
        dto.setBasechanges(extractBasechangesIds(entity.getBaseChange()));
        dto.setLemma(entity.isLemma());

        return dto;
    }

    @Override
    public FormInfoDTO convertToDTO(FormInfo entity){

        FormInfoDTO dto = new FormInfoDTO();

        dto.setGrammaticalCase(entity.getGrammaticalCase());
        dto.setNumber(entity.getNumber());
        dto.setWordClass(entity.getWordClass());
        dto.setGrammaticalGender(entity.getGrammaticalGender());

        return dto;
    }

    @Override
    public FormDTO convertToDTO(Form entity){

        FormDTO dto = new FormDTO();

        dto.setSuffix(entity.getSuffix());
        dto.setBase(entity.getBase());

        if(entity.getFormInfo() != null) {
            dto.setFormInfo(convertToDTO(entity.getFormInfo()));
        }

        return dto;
    }

    @Override
    public PatternDTO convertToDTO(Pattern entity){

        PatternDTO dto = new PatternDTO();

        dto.setWordClass(entity.getWordClass());
        dto.setId(entity.getId());
        dto.setParent(entity.getParent());
        dto.setConditionLists(convertToDTOConditionList(entity.getConditionLists()));
        dto.setFormList(convertToDTOFormList(entity.getFormList()));
        dto.setAllPossibleBasechanges(extractAllPossibleBaseChanges(entity));

        return dto;
    }

    @Override
    public PatternBaseDTO convertToDTO(PatternBase entity) {
        PatternBaseDTO dto = new PatternBaseDTO();

        dto.setId(entity.getId());
        dto.setParent(entity.getParent());
        dto.setWordClass(entity.getWordClass());

        return dto;
    }

    @Override
    public List<PatternBaseDTO> convertToDTO(List<PatternBase> entities) {

        List<PatternBaseDTO> dtos = new ArrayList<>();

        for (PatternBase entity : entities) {
            dtos.add(convertToDTO(entity));
        }

        return Collections.unmodifiableList(dtos);
    }


    private Map<Integer, List<BaseChangeDTO>> extractAllPossibleBaseChanges(Pattern entity){

        Map<Integer, List<BaseChangeDTO>> result = new HashMap<>();

        for (Map.Entry<Integer, List<BaseChangeDTO>> entry :
                extractBasechanges(entity.getBaseChangeList()).entrySet()) {
            if (!result.containsKey(entry.getKey())) {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        for (ConditionList conditionList : entity.getConditionLists()) {
            for (Map.Entry<Integer, List<BaseChangeDTO>> entry :
                 extractBasechanges(conditionList.getBaseChange()).entrySet()) {
                if (!result.containsKey(entry.getKey())) {
                    result.put(entry.getKey(), entry.getValue());
                }
            }
        }

        return Collections.unmodifiableMap(result);
    }

    private List<FormDTO> convertToDTOFormList(List<Form> entity){

        List<FormDTO> result = new ArrayList<>();

        for (Form form : entity) {
            result.add(convertToDTO(form));
        }

        result.sort(new FormComparator());

        return Collections.unmodifiableList(result);
    }

    private List<ConditionListDTO> convertToDTOConditionList(List<ConditionList> entity){

        List<ConditionListDTO> dto = new ArrayList<>();

        for (ConditionList conditionList : entity) {
            dto.add(convertToDTO(conditionList));
        }

        return Collections.unmodifiableList(dto);
    }

    private String extractConditionString(List<Condition> conditions){

        String result = "";

        for (int i = conditions.size() - 1; i >= 0; i--) {
            result = result.length() == 0 ?
                    conditions.get(i).getValue() : result + " + " + conditions.get(i).getValue();
        }

        return result;
    }

    private Set<Integer> extractBasechangesIds(List<BaseChange> basechanges){

        Set<Integer> result = new HashSet<>();

        for (BaseChange baseChange : basechanges){
            result.add(baseChange.getNo());
        }

        return result;
    }

    private Map<Integer, List<BaseChangeDTO>> extractBasechanges(List<BaseChange> basechanges){

        Map<Integer, List<BaseChangeDTO>> result = new HashMap<>();

        for (BaseChange baseChange : basechanges){

            if(result.containsKey(baseChange.getNo())){
                result.get(baseChange.getNo()).add(convertToDTO(baseChange));
            }else{
                List<BaseChangeDTO> list = new ArrayList<>();

                list.add(convertToDTO(baseChange));
                result.put(baseChange.getNo(), list);
            }
        }

        return Collections.unmodifiableMap(result);
    }
}
