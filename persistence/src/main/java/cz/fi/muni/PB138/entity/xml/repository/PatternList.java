package cz.fi.muni.PB138.entity.xml.repository;

import cz.fi.muni.PB138.entity.xml.Pattern;

import javax.xml.bind.annotation.*;
import java.util.Collections;
import java.util.List;

/**
 * Created by Erik Macej 433744 , on 28.5.17.
 *
 * @author Erik Macej 433744
 */

@XmlRootElement(name = "pattern-list")
@XmlAccessorType(XmlAccessType.NONE)
public class PatternList {

    @XmlElement(name = "pattern")
    private List<Pattern> patternList;

    public List<Pattern> getPatternList() {
        return Collections.unmodifiableList(patternList);
    }

    public void setPatternList(List<Pattern> patternList) {
        this.patternList = patternList;
    }
}
