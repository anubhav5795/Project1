function add_to_cart(pid, pname, price) {
   console.log("Add to card")
	let cart = localStorage.getItem("cart");
	if (cart == null) {
		let products = [];
		let product = {productId:pid,productname:pname,productQuantity:1,productPrice:price}
		products.push(product);
		localStorage.setItem("cart",JSON.stringify(products));
		//console.log("Product is added for thr First Time");
		showToast("Item is added to cart")
		
	}else{
		let pcart = JSON.parse(cart);
		let oldProduct =  pcart.find( (item)=> item.productId == pid)
		console.log(oldProduct);
		if (oldProduct) {
			oldProduct.productQuantity = oldProduct.productQuantity+1;
			pcart.map((itam)=> {
				if (itam.productId == oldProduct.productId) {
					itam.productQuantity = oldProduct.productQuantity;
				}
			} )
				localStorage.setItem("cart",JSON.stringify(pcart));
			  //  console.log("Product Quantity is increased");
			    showToast(oldProduct.productname +  "  Quantity is increased =" +oldProduct.productQuantity)
			    
		}else{
			let product = {productId:pid,productname:pname,productQuantity:1,productPrice:price}
			pcart.push(product);
			localStorage.setItem("cart",JSON.stringify(pcart));
			//console.log("Product is added");
			showToast("Product is added to cart")
		}
	}
	updateCart();
}

// Update cart

function updateCart(){
	
	let cartString = localStorage.getItem("cart");
	let cart =  JSON.parse(cartString);
	 
	if (cart == null || cart.length == 0) {
		console.log("Cart is empty !!")
		$(".cart-items").html("(0)");
		$(".cart-body").html("<h3>cart does not have any items </h3>")
		$(".checkout-btn").addClass('disabled');
		
	}else{
// $(".cart-items").html((cart.length))
		$(".cart-items").html(`(${cart.length})`)
		let table = `
		     <table class = 'table'>
		     <thead class = 'thead-light'>
		     <tr>
		      <th>Item name </th>
		      <th>Price</th>
		      <th>Quantity</th>
		      <th>Total Price </th>
		      <th>Action </th>
		     
		     </tr>
		     </thead>
		
		`;
		
		
		let totalPrice = 0;
		
		cart.map((item)=>{
			
			table+= `
			<tr>
			     <td>${item.productname}</td>
			     <td>${item.productPrice}</td>
			     <td>${item.productQuantity}</td>
			     <td>${item.productQuantity * item.productPrice}</td>
			     <td><button onclick='deleteItemFromCart(${item.productId})' class='btn btn-danger btn-sm'>Remove</button></td>
			     
			</tr>
			`
				totalPrice+= item.productPrice*item.productQuantity;
				
		})
		
		table = table + `
		     <tr><td colspan = '5' class= 'text-right font-weight-bold m-5'> Total Price : ${totalPrice}</td></tr>
		
		</table>`
		$(".cart-body").html(table);
		$(".checkout-btn").removeClass('disabled');

	}
}


function deleteItemFromCart(pid)
{
	console.log(pid);
	let cart = JSON.parse(localStorage.getItem('cart'));
	let newcart = cart.filter((item)  => item.productId != pid)
	localStorage.setItem('cart',JSON.stringify(newcart))
	updateCart();
	
	showToast("Item is removed from cart")
}

$(document).ready(function (){
	updateCart();

})

function showToast(content){
		$('#toast').addClass("display");
		$('#toast').html(content);

		setTimeout(() => {
		$('#toast').removeClass("display");
		}, 2000);
}


function gotocheckout() {
	window.location = "checkout.jsp";
}


