/** regular expression matcher */
function validator(txtField, regXPattern, warningText, errorLbl, nextTxtField) {
    /**
     * How to use this method ?
     *      -------------------------------------------------------------------------->
     *      txtField        -    pass text field if you want to select
     *      regXPattern     -    pass your reg-x pattern here and validate your text
     *      warningText     -    pass your validation error, warning message
     *      errorLbl        -    pass id if you have error label
     *      nextTxtField    -    pass next text field id here
     *      -------------------------------------------------------------------------->
     *
     *      © 2022 mGunawardhana,INC. ALL RIGHTS RESERVED.
     * */

    $(txtField).on('keyup', function (e) {

            if (regXPattern.test($(txtField).val())) {
                $(txtField).css('border', '3px solid green');
                $(errorLbl).text('');

                /** this one is compatible for item form */
                if (e.key === "Enter" && txtField !== "#unitPriceTxt") {
                    $(nextTxtField).focus();

                } else if (e.key === "Enter" && txtField === "#unitPriceTxt") {
                    saveItem();
                    $(nextTxtField).focus();

                } else {
                    return false
                }

                /** this one is compatible for customer form */
                if (e.key === "Enter" && txtField !== "#cusContactTxt") {
                    $(nextTxtField).focus();

                } else if (e.key === "Enter" && txtField === "#cusContactTxt") {
                    saveCustomer();
                    $(nextTxtField).focus();

                } else {
                    return false;
                }

            } else {
                $(txtField).css('border', '3px solid red');
                $(errorLbl).text(warningText);

            }
        }
    )
}