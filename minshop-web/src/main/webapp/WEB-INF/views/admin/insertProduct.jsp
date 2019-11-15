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
    <div class="row">
        <h2>Form control: input</h2>
        <div class="col-sm-6 form-group">
            <form>
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="enter name product">
                </br>
                <label for="image">Image:</label>
                <input type="file" class="form-control" id="image" name="image">
                </br>
                <label for="price">Price:</label>
                <input type="number" class="form-control" id="price" name="price" min="1000" placeholder="1000">
                </br>
                <label class="radio-inline"><input type="radio" name="object" checked>Nam</label>
                <label class="radio-inline"><input type="radio" name="object">Nữ</label>
                </br>
                <label for="product_line_id">Product Line:</label>
                <select class="form-control" id="product_line_id" name="product_line_id">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                </select>
                </br>
                <label for="desciptions">Desciptions:</label>
                <textarea type="password" class="form-control" id="desciptions" rows="5" name="desciptions"></textarea>
                </br>
                <button class="btn btn-primary">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
