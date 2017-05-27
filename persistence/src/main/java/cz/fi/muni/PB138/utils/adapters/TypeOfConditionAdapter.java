package cz.fi.muni.PB138.utils.adapters;

import cz.fi.muni.PB138.enums.TypeOfCondition;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by Erik Macej 433744 , on 26.5.17.
 *
 * @author Erik Macej 433744
 */
public class TypeOfConditionAdapter extends XmlAdapter<String, TypeOfCondition> {

    @Override
    public TypeOfCondition unmarshal(String s) throws Exception {
        switch (s){
            case "equal":
                return TypeOfCondition.Equal;
            case "class":
                return TypeOfCondition.Class;
            default: return null;
        }
    }

    @Override
    public String marshal(TypeOfCondition typeOfCondition) throws Exception {
        return typeOfCondition != null ? typeOfCondition.toString().toLowerCase() : " ";
    }
}
