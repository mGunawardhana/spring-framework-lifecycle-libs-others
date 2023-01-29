
/*
 * Developed by - mGunawardhana
 * Contact email - mrgunawardhana27368@gmail.com
 * what's app - 071 - 9043372
 */

let baseURL = "http://localhost:8080/Spring_With_Maven_war/";

getAllCustomers();

/** save customer option */
$("#addCustomerBtn").on('click', function () {
    saveCustomer();
    console.log("hello")
});

function saveCustomer() {
    let formData = $("#customerFormController").serialize();
    $.ajax({
        url: baseURL + "customer",
        method: "post",
        data: formData,
        dataType: "json",
        success: function (res) {
            getAllCustomers();
            alert(res.message);
        }, error: function (error) {
            alert(JSON.parse(error.responseText).message);
        }
    });
}

/** delete customer option */
$("#deleteCustomerBtn").on('click', function () {
    let id = $("#srcCustomerId").val();
    $.ajax({
        url: baseURL + "customer",
        method: "delete",
        dataType: "json",
        success: function (resp) {
            getAllCustomers();
            alert(resp.message);
        }, error: function (error) {
            alert(JSON.parse(error.responseText).message);
        }
    });
});

/** update customer option */
$("#updateCustomerBtn").on('click', function () {

    let cusId = $('#cusIdTxt').val();
    let cusName = $('#cusNameTxt').val();
    let cusAddress = $('#cusAddressTxt').val();
    let cusContact = $('#cusContactTxt').val();

    var customerObj = {
        id: cusId,
        name: cusName,
        address: cusAddress,
        contact: cusContact
    }

    $.ajax({
        url: baseURL + "customer",
        method: "put",
        contentType: "application/json",
        data: JSON.stringify(customerObj),
        dataType: "json",
        success: function (res) {
            getAllCustomers();
            alert(res.message);
            clearTextFields();
        }, error: function (error) {
            alert(JSON.parse(error.responseText).message);
        }
    });
});

/** getting all customer details function */
function getAllCustomers() {
    $("#customerTableBody").empty();
    $.ajax({
        url: baseURL + "customer",
        success: function (res) {
            for (let c of res.data) {

                let cusID = c.id;
                let cusName = c.name;
                let cusAddress = c.address;
                let contact = c.contact;

                let row = "<tr>" +
                    "<td>" + cusID + "</td>" +
                    "<td>" + cusName + "</td>" +
                    "<td>" + cusAddress + "</td>" +
                    "<td>" + contact + "</td>" +
                    "</tr>"
                ;

                $("#customerTableBody").append(row);
            }
            bindRowClickEvents();
            clearTextFields();
        }, error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
}

/** binding click events */
function bindRowClickEvents() {
    $("#customerTableBody>tr").on('click', function () {
        let id = $(this).children(":eq(0)").text();
        let name = $(this).children(":eq(1)").text();
        let address = $(this).children(":eq(2)").text();
        let contact = $(this).children(":eq(3)").text();


        $('#cusIdTxt,#srcItemID').val(id);
        $('#cusNameTxt').val(name);
        $('#cusAddressTxt').val(address);
        $('#cusContactTxt').val(contact);
    });
}

/** clearing text fields */
function clearTextFields() {
    $('#cusIdTxt').val('');
    $('#cusNameTxt').val('');
    $('#cusAddressTxt').val('');
    $('#cusContactTxt').val('');
    $('#srcItemID').val('');
}


/** validator for customer id txt  */
validator(
    '#cusIdTxt', /^(C00-00)[0-9]{1,4}$/,
    "Your input can't be validated, Ex - C-001",
    '#customerIdLbl', '#cusNameTxt'
)

/** validator for customer name txt  */
validator(
    '#cusNameTxt', /^[A-z]{3,30}$/,
    "Your input can't be validated, Ex - mr.Gunawardhana",
    '#customerNameLbl', '#cusAddressTxt'
)

/** validator for customer address txt  */
validator(
    '#cusAddressTxt', /^[A-z]{3,30}$/,
    "Your input can't be validated, Ex - Galle ",
    '#customerAddressLbl', '#cusContactTxt'
)

/** validator for customer contact txt  */
validator(
    '#cusContactTxt', /^(07([1245678])|091)(-)[0-9]{7}$/,
    "Your input can't be validated, Ex - 0719028827",
    '#CustomerContactLbl', '#cusNameTxt'
)