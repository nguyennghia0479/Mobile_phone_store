$(document).ready(function () {
    $('#product').autocomplete({
        minLength: 1,
        source: function (request, response) {
            $.ajax({
                url: '/MobilePhoneStore/search',
                method: 'get',
                data: { term: request.term },
                dataType: 'json',
                success: function (data) {
                    response(data);
                },
                error: function (err) {
                    alert(err);
                }
            });
        },
        focus: updateTextBox,
        select: updateTextBox
    })
    .autocomplete('instance')._renderItem = function (ul, item) {
   	 return $( "<li></li>" )  
        .data( "item.autocomplete", item )  
        .append( "<a style='text-decoration:none;' href='/MobilePhoneStore/" + item.productNameURL + "'>" + "<img class='imageClass' src='data:image/jpeg;base64," + item.base64 + "' alt=" + item.productName + "/> " + item.productName+ "</a>" )  
        .appendTo( ul );  
    };
    function updateTextBox(event, ui) {
    	var productName = ui.item.productName;
        $(this).val(productName);
        return false;
    }
});