/*
 * Developed by - mGunawardhana
 * Contact email - mrgunawardhana27368@gmail.com
 * what's app - 071 - 9043372
 */
let baseURL = "http://localhost:8080/app/";
getAllItems();

/** save item option */
$("#addItemBtn").on('click', function () {
    saveItem();
});

function saveItem() {
    let formData = $("#itemFormController").serialize();
    $.ajax({
        url: baseURL + "item",
        method: "post",
        data: formData,
        dataType: "json",
        success: function (res) {
            getAllItems();
            alert(res.message);
        }, error: function (error) {
            alert(JSON.parse(error.responseText).message);
        }
    });
}

/** delete item option */
$("#deleteItemBtn").on('click', function () {
    $.ajax({
        url: baseURL + "item",
        method: "delete",
        dataType: "json",
        success: function (resp) {
            getAllItems();
            alert(resp.message);
        }, error: function (error) {
            alert(JSON.parse(error.responseText).message);

        }
    });
});


/** update item option */
$("#updateItemBtn").on('click', function () {

    let itemId = $('#itemIdTxt').val();
    let itemName = $('#ItemNameTxt').val();
    let itemQty = $('#itemQtyTxt').val();
    let unitPrice = $('#unitPriceTxt').val();

    var itemObject = {
        itemId: itemId,
        itemName: itemName,
        qty: itemQty,
        unitPrice: unitPrice
    };

    $.ajax({
        url: baseURL + "item",
        method: "put",
        contentType: "application/json",
        data: JSON.stringify(itemObject),
        success: function (res) {
            getAllItems();
            alert(res.message);
            clearItemTextFields()
        }, error: function (error) {
            alert(JSON.parse(error.responseText).message);
        }
    });
});

/** getting all item details function */
function getAllItems() {
    $("#itemTblBody").empty();
    $.ajax({
        url: baseURL + "item",
        success: function (res) {
            for (let i of res.data) {

                let Id = i.itemId;
                let itemName = i.itemName;
                let itemQty = i.qty;
                let unitPrice = i.unitPrice;


                let row = "<tr>" +
                    "<td>" + Id + "</td>" +
                    "<td>" + itemName + "</td>" +
                    "<td>" + itemQty + "</td>" +
                    "<td>" + unitPrice + "</td>" +
                    "</tr>"
                ;

                $("#itemTblBody").append(row);
            }
            bindRowClickEventsForItems();
            clearItemTextFields();
        }, error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
}

/** binding click events */
function bindRowClickEventsForItems() {
    $("#itemTblBody>tr").on('click', function () {
        let Id = $(this).children(":eq(0)").text();
        let itemName = $(this).children(":eq(1)").text();
        let itemQty = $(this).children(":eq(2)").text();
        let unitPrice = $(this).children(":eq(3)").text();

        $('#itemIdTxt').val(Id);
        $('#ItemNameTxt').val(itemName);
        $('#itemQtyTxt').val(itemQty);
        $('#unitPriceTxt').val(unitPrice);
    });
}


function clearItemTextFields() {
    $('#itemIdTxt').val('');
    $('#ItemNameTxt').val('');
    $('#itemQtyTxt').val('');
    $('#unitPriceTxt').val('');
}


/** disabling tab press */
$('#ItemNameTxt,#itemIdTxt,#itemQtyTxt,#unitPriceTxt').on('keydown', function (e) {
    if (e.key === "Tab") {
        e.preventDefault();
    }
})

/** validator for item id txt   */
validator('#itemIdTxt', /^I00-0[0-9]{1,5}$/,
    "Your input can't be validated, Ex - I-001",
    '#itemIdTxtLbl', '#ItemNameTxt'
);

/** validator for item name txt  */
validator('#ItemNameTxt', /^[A-z]{2,10}$/,
    "Your input can't be validated, Ex - Burger",
    '#itemNameTxtLbl', '#itemQtyTxt'
);

/** validator for item Qty txt  */
validator('#itemQtyTxt', /^[0-9]{1,4}$/,
    "Your input can't be validated, 10 ",
    '#itemQtyTxtLbl', '#unitPriceTxt'
);

/** validator for item unit price txt  */
validator('#unitPriceTxt', /^([0-9]{2,6}.[0-9]{1,2})$/,
    "Your input can't be validated, Ex - 120.99",
    '#itemUnitPriceTxtLbl', '#ItemNameTxt'
);
