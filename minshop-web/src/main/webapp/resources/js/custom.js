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
                image: image
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
            totalCost = totalCost + priceLine;
        })
        var format = (totalCost/1000).toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString() + " đ";
        $("#total-cost").html(format);
    }


    $(".quantity-shopping-cart").change(function () {
        var price = $(this).closest("tr").find(".price").attr("data-price");
        var quantity = $(this).val();
        var priceLine = price * quantity / 1000;
        var format = priceLine.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
        $(this).closest("tr").find(".price").html(format + " đ");
        TotalCost();
    })
})
