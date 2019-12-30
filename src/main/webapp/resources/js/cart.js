$(document).ready(function() {
	$('.quantityChange').click(function() {
		var number = $(this).parent().find('.number').val();
		var productId = $(this).parent().find('.productId').val();
		$.ajax({
			type : "POST",
			data : {
				number : number,
				productId: productId,
			},
			url : '/MobilePhoneStore/update-cart',
			success : function(result) {
				$("#totalPrice").html(result);

			}
		});
    });
	$('.quantityChange').keyup(function () {
		var number = $(this).parent().find('.number').val();
		var productId = $(this).parent().find('.productId').val();
		if (productId.which != 8 && productId.which != 0 && (productId.which < 48 || productId.which > 57)) {
    		return false
		}
		$.ajax({
			type : "POST",
			data : {
				number : number,
				productId: productId,
			},
			url : '/MobilePhoneStore/update-cart',
			success : function(result) {
				$("#totalPrice").html(result);
			}
		});
    });
});