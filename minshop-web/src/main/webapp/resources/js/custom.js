$(document).ready(function () {
    $("#btn-login").click(function () {
        var email = $("#email").val();
        var password = $("#password").val();
        $.ajax({
            url: "/minshop/api/CheckLogin",
            data: {
                email: email,
                password: password
            },
            success: function (value) {
                if (value == "true") {
                    currentPath = window.location.href;
                    window.location = currentPath.replace("dang-nhap/", "");
                } else {
                    $("#status_login").html("Đăng nhập thất bại!");
                }

            },
            error: function (value) {
                $("#status_login").html("fail!");
            }
        })
    });

    $("#header-login").click(function () {
        $(this).addClass("actived");
        $("#header-signup").removeClass("actived");
        $(".form-login").show();
        $(".form-signup").hide();
    });

    $("#header-signup").click(function () {
        $(this).addClass("actived");
        $("#header-login").removeClass("actived");
        $(".form-login").hide();
        $(".form-signup").show();
    });


    $(".btn-shopping-cart").click(function () {
        var product_id = $(this).closest("tr").attr("data-product-id");
        var product_name = $("#product_name").attr("data-product-name");
        var product_color_id = $(this).closest("tr").find(".color").attr("data-color-id");
        var color_name = $(this).closest("tr").find(".color").text();
        var product_size_id = $(this).closest("tr").find(".size").attr("data-size-id");
        var size_name = $(this).closest("tr").find(".size").text();
        var price = $("#product_price").attr("data-product-price");
        var image = $("#image").attr("data-product-image");
        var quantity = $(this).closest("tr").find(".quantity").attr("data-quantity");
        var product_details_id = $(this).attr("data-product-details-id");
        $.ajax({
            url: "/minshop/api/AddToCart",
            data: {
                product_id: product_id,
                product_name: product_name,
                product_color_id: product_color_id,
                color_name: color_name,
                product_size_id: product_size_id,
                size_name: size_name,
                price: price,
                quantity: quantity,
                image: image,
                product_details_id : product_details_id
            },
            success: function (value) {
                if(!$("#cart").hasClass("cart")){
                    $("#cart").addClass("cart");
                }
                $("#cart").html("<span>" + value + "</span>");
            }
        })
        /*.done(function () {
            $.ajax({
                url: "/minshop/api/GetSizeOfShoppingCart",
                success: function (value) {
                    if(!$("#cart").hasClass("cart")){
                        $("#cart").addClass("cart");
                    }
                    $("#cart").html("<span>" + value + "</span>");
                }
            })
        })*/
    });

    TotalCost();
    function TotalCost(){
        var totalCost = 0;
        $("tbody .price").each(function () {
            var priceLine = $(this).attr("data-price") * $(this).closest("tr").find(".quantity-shopping-cart").val();
            var format = (priceLine/1000).toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString() + " đ";
            $(this).html(format);
            totalCost = totalCost + priceLine;
        })
        var format = (totalCost/1000).toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString() + " đ";
        $("#total-cost").html(format);
    };
    
    $(".quantity-shopping-cart").change(function () {
        var price = $(this).closest("tr").find(".price").attr("data-price");
        var quantity = $(this).val();
        var priceLine = price * quantity / 1000;
        var format = priceLine.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
        $(this).closest("tr").find(".price").html(format + " đ");
        TotalCost();
        var product_id = $(this).closest("tr").attr("data-product-id");
        var product_color_id = $(this).closest("tr").find(".color").attr("data-color-id");
        var product_size_id = $(this).closest("tr").find(".size").attr("data-size-id");
        $.ajax({
            url: "/minshop/api/UpdateShoppingCartList",
            data: {
                product_id: product_id,
                product_color_id: product_color_id,
                product_size_id: product_size_id,
                quantity: quantity
            }
        })
    });
    
    $(".remove-product").click(function () {
        var product_id = $(this).closest("tr").attr("data-product-id");
        var product_color_id = $(this).closest("tr").find(".color").attr("data-color-id");
        var product_size_id = $(this).closest("tr").find(".size").attr("data-size-id");
        var ele = $(this).closest("tr");
        $.ajax({
            url: "/minshop/api/RemoveProduct",
            data: {
                product_id: product_id,
                product_color_id: product_color_id,
                product_size_id: product_size_id
            },
            success: function (value) {
                ele.remove();
                TotalCost();
                $("#cart").html("<span>" + value + "</span>");
                if(value == "0"){
                    $("#cart").removeClass("cart");
                    $("#cart").html("");
                }
            }
        });
    });
})
