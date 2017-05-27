package cz.fi.muni.PB138.utils.adapters;

import cz.fi.muni.PB138.enums.OperationType;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by Erik Macej 433744 , on 27.5.17.
 *
 * @author Erik Macej 433744
 */
public class OperationTypeAdapter extends XmlAdapter<String, OperationType> {
    @Override
    public OperationType unmarshal(String s) throws Exception {
        switch (s){
            case "chop" :
                return OperationType.Chop;
            case "softenB" :
                return OperationType.SoftenB;
            case "softenA" :
                return OperationType.SoftenA;
            case "append" :
                return OperationType.Append;
            case "shorten" :
                return OperationType.Shorten;
            default: return null;
        }
    }

    @Override
    public String marshal(OperationType operationType) throws Exception {
        return operationType != null ? operationType.toString().toLowerCase().toString().toLowerCase() : " ";
    }
}
