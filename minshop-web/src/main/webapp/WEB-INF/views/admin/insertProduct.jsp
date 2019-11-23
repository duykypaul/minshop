<%--
  Created by IntelliJ IDEA.
  User: DuyKyPaul
  Date: 15/11/2019
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../taglib/taglib.jsp" %>
<html>
<head>
    <title>Insert Product</title>
</head>
<body>
<div class="container">
    <div class="row well">
        <c:if test="${product != null}">
            <h3> Add Product ${product.getProduct_id()}</h3>
        </c:if>

        <div class="col-md-5 col-sm-9 form-group">
            <form action="" id="form-product">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter name product">
                </br>
                <label for="image">Image:</label>
                <input type="file" class="form-control" id="image" name="image">
                </br>
                <label for="price">Price:</label>
                <input type="number" class="form-control" id="price" name="price" min="1000" value="1000" step="1000">
                </br>
                <label class="radio-inline"><input type="radio" name="object" checked value="Nam">Male</label>
                <label class="radio-inline"><input type="radio" name="object" value="Nữ">Female</label>
                </br>
                </br>
                <label for="product_line_id">Product Line:</label>
                <select class="form-control" id="product_line_id" name="product_line_id">
                    <c:forEach var="productLine" items="${productLineList}">
                        <option value="${productLine.getProduct_line_id()}">${productLine.getName()}</option>
                    </c:forEach>
                </select>
                </br>
                <label for="descriptions">Descriptions:</label>
                <textarea type="password" class="form-control" id="descriptions" rows="5" name="descriptions" placeholder="Enter product descriptions"></textarea>
                </br>
                <input type="button" id="btn-save-product" class="btn btn-primary" value="Save Product"></input>
            </form>
        </div>
        <div class="col-md-5 col-sm-12 form-group">
            <form id="form-product-details">
            <div class="container-product-details">
                <div class="add-product-details">
                    <div class="row">
                        <div class="col-md-4 col-sm-2">
                            <label for="product_color_id">Color:</label>
                            <select class="form-control" id="product_color_id" name="product_color_id">
                                <c:forEach var="productColor" items="${productColorList}">
                                    <option value="${productColor.getProduct_color_id()}">${productColor.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-3 col-sm-2">
                            <label for="product_size_id">Size:</label>
                            <select class="form-control" id="product_size_id" name="product_size_id">
                                <c:forEach var="productSize" items="${productSizeList}">
                                    <option value="${productSize.getProduct_size_id()}">${productSize.getSize()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-2 col-sm-2">
                            <label for="price">Quantity:</label>
                            <input type="number" class="form-control" id="quantity" name="quantity" min="1" value="1">
                        </div>
                        <div class="col-md-2 col-sm-2">
                            <label style="height: 41px;"></label>
                            <input type="button" class="btn btn-outline-danger btn-sm remove-product-details" value="X" ></input>
                        </div>
                    </div>
                </div>
            </div>
            </form>
            <br>
            <input type="button" class="btn btn-info btn-sm btn-add-product-details" value="Add Product Details" />
            <div id="add-product-details" class="add-product-details">
                <div class="row">
                    <div class="col-md-4 col-sm-2">
                        <br>
                        <label>&nbsp;</label>
                        <select class="form-control" id="product_color_id" name="product_color_id">
                            <c:forEach var="productColor" items="${productColorList}">
                                <option value="${productColor.getProduct_color_id()}">${productColor.getName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-3 col-sm-2">
                        <br>
                        <label>&nbsp;</label>
                        <select class="form-control" id="product_size_id" name="product_size_id">
                            <c:forEach var="productSize" items="${productSizeList}">
                                <option value="${productSize.getProduct_size_id()}">${productSize.getSize()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-2 col-sm-2">
                        <br>
                        <label>&nbsp;</label>
                        <input type="number" class="form-control" id="quantity" name="quantity" min="1" value="1">
                    </div>
                    <div class="col-md-2 col-sm-2">
                        <br>
                        <label style="height: 41px;"></label>
                        <input type="button" class="btn btn-outline-danger btn-sm remove-product-details" value="X" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value='/resources/assets/js/jquery-2.1.4.min.js'/>"></script>
<script type="text/javascript">
    if ('ontouchstart' in document.documentElement) document.write("<script src='<c:url value='/resources/assets/js/jquery.mobile.custom.min.js'/>'>" + "<" + "/script>");
</script>
<script src="<c:url value='/resources/assets/js/bootstrap.min.js'/>"></script>
<!-- ace scripts -->
<script src="<c:url value='/resources/assets/js/ace-elements.min.js'/>"></script>
<script src="<c:url value='/resources/assets/js/ace.min.js'/>"></script>
<script>
    var files = [];
    forms = new FormData()
    $("#image").change(function (event) {
        files = event.target.files;
        forms.append("file", files[0]);
    })
    $(".btn-add-product-details").on('click', function () {
        $("#add-product-details" ).clone().appendTo( ".container-product-details").removeAttr("id");
    })
    $("#btn-save-product").click(function (event) {
        event.preventDefault();
        var formProduct = $("#form-product").serializeArray();
        var formProductDetails = $("#form-product-details").serializeArray();
        console.log(formProductDetails);
        data = {};
        objectProductDetails = {};
        arrayProductDetails = [];
        $.each(formProduct, function (i, field) {
            data[field.name] = field.value;
        });
        $.each(formProductDetails, function (i, field) {
            objectProductDetails[field.name] = field.value;
            if((i + 1) % 3 == 0) {
                arrayProductDetails.push(objectProductDetails);
                objectProductDetails = {};
            }
        });
        data["image"] = files[0].name;
        data["productDetails"] = arrayProductDetails;
        $.ajax({
            url: "/minshop/api/SaveProduct",
            type: "POST",
            data: {
                dataJson: JSON.stringify(data)
            },
            success: function () {
                console.log("save product  " + JSON.stringify(data));
                $.ajax({
                    url: "/minshop/api/UploadFile",
                    type: "POST",
                    data: forms,
                    contentType: false,
                    processData: false,
                    enctype: "multipart/form-data",
                    success: function () {
                        console.log(files[0].name);
                    }
                })
            }
        });
    });

    $('body').on("click", ".remove-product-details", function () {
        $(this).closest(".add-product-details").remove();
    })
</script>
</body>
</html>
