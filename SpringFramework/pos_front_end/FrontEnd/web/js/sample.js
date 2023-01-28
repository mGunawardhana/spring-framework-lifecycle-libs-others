function loadAllCustomers() {
    $().empty();
    $.ajax({
        url: "http://localhost:8080/customer?option=GETALL"
    ,method:"GET",
        success : function (resp) {
        }
    })
}