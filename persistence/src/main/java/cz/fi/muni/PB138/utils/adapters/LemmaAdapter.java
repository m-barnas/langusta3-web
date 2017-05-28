package cz.fi.muni.PB138.utils.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by Erik Macej 433744 , on 28.5.17.
 *
 * @author Erik Macej 433744
 */
public class LemmaAdapter extends XmlAdapter<String, Boolean> {
    @Override
    public Boolean unmarshal(String s) throws Exception {
        return "yes".equals(s) ? true : false;
    }

    @Override
    public String marshal(Boolean aBoolean) throws Exception {
        return aBoolean ? "yes" : "false";
    }
}
