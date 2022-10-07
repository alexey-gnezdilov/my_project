package services.docservices.impl;

import services.docservices.IsNumeric;

public class IsNumericImpl implements IsNumeric {
    public boolean isNumeric(String regNum) {
        return regNum.matches("^[^0]\\d{2,4}$");
    }
}
