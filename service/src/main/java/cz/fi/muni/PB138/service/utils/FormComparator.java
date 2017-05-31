package cz.fi.muni.PB138.service.utils;

import cz.fi.muni.PB138.dto.FormDTO;

import java.util.Comparator;

/**
 * Created by Erik Macej 433744 , on 30.5.17.
 *
 * @author Erik Macej 433744
 */
public class FormComparator implements Comparator<FormDTO> {

    @Override
    public int compare(FormDTO form, FormDTO t1) {
        if((form.getFormInfo().getGrammaticalGender().ordinal()
                - t1.getFormInfo().getGrammaticalGender().ordinal()) != 0 ){

            return form.getFormInfo().getGrammaticalGender().ordinal()
                    - t1.getFormInfo().getGrammaticalGender().ordinal();

        }else if((form.getFormInfo().getNumber().ordinal()
                - t1.getFormInfo().getNumber().ordinal()) != 0 ){

            return form.getFormInfo().getNumber().ordinal()
                    - t1.getFormInfo().getNumber().ordinal();

        }else{

            return form.getFormInfo().getGrammaticalCase().ordinal()
                    - form.getFormInfo().getGrammaticalCase().ordinal();

        }
    }
}
