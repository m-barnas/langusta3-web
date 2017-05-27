package cz.fi.muni.PB138.utils.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by Erik Macej 433744 , on 26.5.17.
 *
 * @author Erik Macej 433744
 */
public class CharnoAdapter extends XmlAdapter<String, Integer> {

    @Override
    public Integer unmarshal(String s) throws Exception {
        s = s.trim();
        return Integer.parseInt(s);
    }

    @Override
    public String marshal(Integer integer) throws Exception {
        return integer.toString();
    }
}
