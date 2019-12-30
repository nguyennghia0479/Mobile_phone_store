$(document).ready(function() {
	$('.add-cart').click(function(e) {
		e.preventDefault();
		var productId = $(this).parent().find('.productId').val();
		$.ajax({
			url : '/MobilePhoneStore/add-cart',
			type : "POST",
			data : {
				productId : productId,
			},
			success : function(result) {
				$("#totalQuantity").html(result);
				jQuery('html, body').animate({scrollTop: 0}, 500);
			}
		});
	});
});