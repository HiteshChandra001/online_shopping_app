function displayForm(formType) {
    const formContainer = document.getElementById('formContainer');
    if (formType === 'addProductForm') {
        formContainer.innerHTML = `
            <h3>Add Product</h3>
            <form onsubmit="addProduct(event)">
                Product ID: <input type="text" id="productID">
                Product Name: <input type="text" id="productName">
                Price: <input type="text" id="productPrice">
                <input type="submit" value="Add">
            </form>
        `;
    }
}

function addProduct(event) {
    event.preventDefault();

    const product = {
        id: document.getElementById('productID').value,
        name: document.getElementById('productName').value,
        price: parseFloat(document.getElementById('productPrice').value)
    };

    fetch('/products', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product)
    }).then(response => response.json())
      .then(data => {
          alert('Product added successfully!');
      })
      .catch(error => {
          console.error('Error:', error);
      });
}

function fetchAndDisplayAllProducts() {
    fetch('/products')
        .then(response => response.json())
        .then(data => {
            let productsDisplay = document.getElementById('productsDisplay');
            let output = '<h3>All Products</h3><ul>';
            data.forEach(product => {
                output += `<li>${product.name} - ₹${product.price}</li>`;
            });
            output += '</ul>';
            productsDisplay.innerHTML = output;
        });
}
