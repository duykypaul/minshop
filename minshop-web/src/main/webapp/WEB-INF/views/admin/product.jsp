<%--
  Created by IntelliJ IDEA.
  User: DuyKyPaul
  Date: 9/24/2019
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../taglib/taglib.jsp"%>
<c:url var="formUrl" value="/admin/product-line/search"/>
<html>
<head>
    <title></title>
</head>
<body>
<div class="row">
    <div>
        <form action="${formUrl}" method="get" id="formUrl" commandName="productSearchBean">
            <c:if test="${ProductSearchBean != null}">
                <div class="form-group col-md-3">
                    <label for="nameProduct">name:</label>
                    <input type="text" class="form-control" id="nameProduct" name="nameProduct" value="${ProductSearchBean.getNameProduct()}">
                </div>
                <div class="form-group col-md-3">
                    <label for="priceFrom">Price From:</label>
                    <input type="number" class="form-control" id="priceFrom" name="priceFrom" value="${ProductSearchBean.getPriceFrom()}">
                </div>
                <div class="form-group col-md-3">
                    <label for="priceTo">Price To:</label>
                    <input type="number" class="form-control" id="priceTo" name="priceTo" value="${ProductSearchBean.getPriceTo()}">
                </div>

                <input name="maxResult" type="hidden" id="maxResult" value="${ProductSearchBean.getMaxResult()}"/>
                <input name="pageNumber" type="hidden" id="pageNumber" value="${ProductSearchBean.getPageNumber()}"/>
            </c:if>

            <c:if test="${ProductSearchBean == null}">
                <div class="form-group col-md-3">
                    <label for="nameProduct">name:</label>
                    <input type="text" class="form-control" id="nameProduct" name="nameProduct" >
                </div>
                <div class="form-group col-md-3">
                    <label for="priceFrom">Price From:</label>
                    <input type="number" class="form-control" id="priceFrom" name="priceFrom">
                </div>
                <div class="form-group col-md-3">
                    <label for="priceTo">Price To:</label>
                    <input type="number" class="form-control" id="priceTo" name="priceTo">
                </div>
                <input name="maxResult" type="hidden" id="maxResult"/>
                <input name="pageNumber" type="hidden" id="pageNumber"/>
            </c:if>

        </form>
        </br>
        <button id="btn-search" type="button" class="btn btn-primary">Search</button>
        <button id="btn-clear" type="button" class="btn btn-primary">Clear</button>
    </div>
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <div class="row">
            <div class="col-xs-12">
                <h3 class="header smaller lighter blue">jQuery dataTables</h3>
                <button id="update-test" class="btn btn-success" >update test</button>
                <div class="clearfix">
                    <div class="pull-right tableTools-container"></div>
                </div>

                <div class="table-header">
                    Results for "Latest Registered Domains"
                </div>

                <!-- div.table-responsive -->

                <!-- div.dataTables_borderWrap -->
                <div>
                    <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="center">
                                <label class="pos-rel">
                                    <input type="checkbox" class="ace"/>
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th>Mã sản phẩm</th>
                            <th>Sản phẩm</th>
                            <th class="hide"></th>
                            <th class="">Giành cho</th>
                            <th >giá tiền</th>
                            <th></th>
                        </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="product" items="${productList}">

                            <tr>
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" value="${product.getProduct_id()}"/>
                                        <span class="lbl"></span>
                                    </label>
                                </td>

                                <td>
                                    <a href="#">${product.getProduct_id()}</a>
                                </td>
                                <td>${product.getName()}</td>
                                <td class="hidden-480 hide"></td>
                                <td class="hidden-480">${product.getObject()}</td>
                                <td class="hidden-480"><span class="price price-test"><fmt:formatNumber type = "number" pattern="###,###" value="${product.getPrice()}" /> đ</span></td>
                                <td>
                                    <div class="hidden-sm hidden-xs action-buttons">

                                        <a class="green" href="#">
                                            <i onclick="updateProductById(${product.getProduct_id()}, event)" class="ace-icon fa fa-pencil bigger-130"></i>
                                        </a>

                                        <a class="red" href="#">
                                            <i onclick="deleteProductById(${product.getProduct_id()}, event)" class="ace-icon fa fa-trash-o bigger-130"></i>
                                        </a>
                                    </div>

                                    <div class="hidden-md hidden-lg">
                                        <div class="inline pos-rel">
                                            <button class="btn btn-minier btn-yellow dropdown-toggle"
                                                    data-toggle="dropdown"
                                                    data-position="auto">
                                                <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                            </button>

                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">

                                                <li>
                                                    <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
                                                        <span class="green">
                                                            <i onclick="updateProductById(${product.getProduct_id()}, event)" class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                        </span>
                                                    </a>
                                                </li>

                                                <li>
                                                    <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
                                                        <span class="red">
                                                            <i onclick="deleteProductById(${product.getProduct_id()}, event)" class="ace-icon fa fa-trash-o bigger-120"></i>
                                                        </span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- PAGE CONTENT ENDS -->
        <div class="row">
            <c:if test="${ProductSearchBean != null}">
                <div class="form-group col-md-1">
                    <label for="display-result">Display Product</label>
                    <select class="form-control" id="display-result" type="number" >
                        <option>5</option>
                        <option>10</option>
                        <option>15</option>
                        <option>20</option>
                        <option>40</option>
                    </select>
                </div>
                <div class="form-group col-md-offset-4">

                    <ul id="pagination" class="pagination-md"></ul>
                </div>
            </c:if>

        </div>

    </div><!-- /.col -->
</div><!-- /.row -->
<%@include file="../../taglib/admin/footer/product.jsp" %>
<script type="text/javascript">
    $(document).ready(function () {
        // jQuery(function ($) {
        //     alert("cleck");
        //     $('body').on('click','#btn-search', function (e) {
        //         $('#formUrl').submit();
        //     });
        //     $('#btn-clear').on('click', function (e) {
        //         $('#nameProduct').val("");
        //         $('#priceFrom').val("");
        //         $('#priceTo').val("");
        //         $('#maxResult').val(10);
        //         $('#pageNumber').val(1);
        //         $('#dynamic-table').DataTable().clear().draw();
        //     });
        // })
        if(${ProductSearchBean != null}) {
            for(var i = 0; i< $('#display-result option').length; i++) {
                if( $('#display-result option').eq(i).text() == $('#maxResult').val()) {
                    $('#display-result option').eq(i).attr("selected","selected");
                    break;
                }
            }

            var totalPages = ${totalPage};
            var startPage = ${pageNumber};
            var visiblePages =  7;
            $('#display-result').change(function() {
                $('#maxResult').val($(this).val());
                $('#pageNumber').val(1);
                startPage = 1;
                $('#formUrl').submit();
            });
            $('#pagination').twbsPagination({
                totalPages: totalPages,
                startPage: startPage,
                visiblePages: visiblePages,
                first: "<<",
                prev: "<",
                next: ">",
                last: ">>",
                onPageClick: function(event, page) {
                    if(page != startPage){
                        $('#pageNumber').val(page);
                        // $('#maxResult').val($('#maxResult').val());
                        $('#formUrl').submit();
                    }
                }
            });
        }

    });


</script>
</body>
</html>
<%-- <nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item">
            <span>Previous</span>
        </li>
        <c:forEach var="i" begin="1" end="${totalPage}" >
            <c:choose>
                <c:when test = "${i == pageNumber}">
                    <li class="page-item active">
                        <a href="#">${i}</a>
                    </li>
                </c:when>

                <c:otherwise>
                    <li class="page-item">
                        <a href="#">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <li class="page-item">
            <a href="#">Next</a>
        </li>
    </ul>
</nav> --%>
