function sortPrice() {
	var radioBtns = document.getElementsByName('priceType');
	for (i=0; i<radioBtns.length; i++){
	    if(radioBtns[i].checked) {
	        $('#sortPrice').submit();
	    }
	}
}

function sortBrand() {
	var radioBtns = document.getElementsByName('brand');
	for (i=0; i < radioBtns.length; i++) {
		if (radioBtns[i].checked) {
			$('#sortBrand').submit();
		}
	}
}