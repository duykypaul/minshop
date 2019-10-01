<%--
  Created by IntelliJ IDEA.
  User: DuyKyPaul
  Date: 9/24/2019
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../taglib/taglib.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>
<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <div class="row">
            <div class="col-xs-12">
                <h3 class="header smaller lighter blue">jQuery dataTables</h3>

                <div class="clearfix">
                    <div class="pull-right tableTools-container"></div>
                    <div class="pull-left"></div>
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
                            <th>Hình ảnh</th>
                            <th>Sản phẩm</th>
                            <th>giá tiền</th>
                            <th></th>
                        </tr>
                        </thead>

                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
</div><!-- /.row -->
<%@include file="../../taglib/admin/footer/user.jsp" %>
</body>
</html>
