package cz.fi.muni.PB138.dto;

/**
 * Created by Erik Macej 433744 , on 29.5.17.
 *
 * @author Erik Macej 433744
 */
public class FormDTO {

    private Integer baseId;
    private String base;
    private String suffix;
    private FormInfoDTO formInfo;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public FormInfoDTO getFormInfo() {
        return formInfo;
    }

    public void setFormInfo(FormInfoDTO formInfo) {
        this.formInfo = formInfo;
    }

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }
}
