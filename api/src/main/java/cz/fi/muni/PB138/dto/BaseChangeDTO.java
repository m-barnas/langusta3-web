package cz.fi.muni.PB138.dto;

import cz.fi.muni.PB138.enums.OperationType;

/**
 * Created by Erik Macej 433744 , on 29.5.17.
 *
 * @author Erik Macej 433744
 */
public class BaseChangeDTO {

    private Integer no;
    private OperationType operationType;
    private String value;
    private Integer charno;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getCharno() {
        return charno;
    }

    public void setCharno(Integer charno) {
        this.charno = charno;
    }
}
