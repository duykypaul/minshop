<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../taglib/taglib.jsp" %>
<%@ page import="com.duykypaul.core.common.constant.CoreConstant" %>
<html>
<head>
    <title>User List</title>
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
                            <th>User Id</th>
                            <th>Email</th>
                            <th>Full Name</th>
                            <th>Phone Number</th>
                            <th>Role</th>
                            <th></th>
                        </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="user" items="${userList}">
                                <tr>
                                    <td class="center">
                                        <label class="pos-rel">
                                            <input type="checkbox" class="ace"/>
                                            <span class="lbl"></span>
                                        </label>
                                    </td>

                                    <td>
                                        <a href="#">${user.getUser_id()}</a>
                                    </td>
                                    <td>${user.getEmail()}</td>
                                    <td class="hidden-480">${user.getFull_name()}</td>
                                    <td>${user.getPhone_number()}</td>

                                    <td class="hidden-480">
                                        <span class="label label-xs
                                                <c:choose>
                                                    <c:when test="${user.getRole().getName() == CoreConstant.ADMIN }">
                                                        label-info
                                                    </c:when>
                                                    <c:when test="${user.getRole().getName() == CoreConstant.EMPLOYEE }">
                                                        label-success
                                                    </c:when>
                                                    <c:when test="${user.getRole().getName() == CoreConstant.USER }">
                                                        label-default
                                                    </c:when>
                                                </c:choose>">
                                            ${user.getRole().getName()}</span>
                                    </td>

                                    <td>
                                        <div class="hidden-sm hidden-xs action-buttons">
                                            <a class="blue" href="#">
                                                <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                            </a>

                                            <a class="green" href="#">
                                                <i class="ace-icon fa fa-pencil bigger-130"></i>
                                            </a>

                                            <a class="red" href="#">
                                                <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                            </a>
                                        </div>

                                        <div class="hidden-md hidden-lg">
                                            <div class="inline pos-rel">
                                                <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown"
                                                        data-position="auto">
                                                    <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                </button>

                                                <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                    <li>
                                                        <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
																				<span class="blue">
																					<i class="ace-icon fa fa-search-plus bigger-120"></i>
																				</span>
                                                        </a>
                                                    </li>

                                                    <li>
                                                        <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
																				<span class="green">
																					<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																				</span>
                                                        </a>
                                                    </li>

                                                    <li>
                                                        <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
																				<span class="red">
																					<i class="ace-icon fa fa-trash-o bigger-120"></i>
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

        <div id="modal-table" class="modal fade" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header no-padding">
                        <div class="table-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                <span class="white">&times;</span>
                            </button>
                            Results for "Latest Registered Domains
                        </div>
                    </div>

                    <div class="modal-body no-padding">
                        <table class="table table-striped table-bordered table-hover no-margin-bottom no-border-top">
                            <thead>
                            <tr>
                                <th>Domain</th>
                                <th>Price</th>
                                <th>Clicks</th>

                                <th>
                                    <i class="ace-icon fa fa-clock-o bigger-110"></i>
                                    Update
                                </th>
                            </tr>
                            </thead>

                            <tbody>
                            <tr>
                                <td>
                                    <a href="#">ace.com</a>
                                </td>
                                <td>$45</td>
                                <td>3,330</td>
                                <td>Feb 12</td>
                            </tr>

                            <tr>
                                <td>
                                    <a href="#">base.com</a>
                                </td>
                                <td>$35</td>
                                <td>2,595</td>
                                <td>Feb 18</td>
                            </tr>

                            <tr>
                                <td>
                                    <a href="#">max.com</a>
                                </td>
                                <td>$60</td>
                                <td>4,400</td>
                                <td>Mar 11</td>
                            </tr>

                            <tr>
                                <td>
                                    <a href="#">best.com</a>
                                </td>
                                <td>$75</td>
                                <td>6,500</td>
                                <td>Apr 03</td>
                            </tr>

                            <tr>
                                <td>
                                    <a href="#">pro.com</a>
                                </td>
                                <td>$55</td>
                                <td>4,250</td>
                                <td>Jan 21</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>

                    <div class="modal-footer no-margin-top">
                        <button class="btn btn-sm btn-danger pull-left" data-dismiss="modal">
                            <i class="ace-icon fa fa-times"></i>
                            Close
                        </button>

                        <ul class="pagination pull-right no-margin">
                            <li class="prev disabled">
                                <a href="#">
                                    <i class="ace-icon fa fa-angle-double-left"></i>
                                </a>
                            </li>

                            <li class="active">
                                <a href="#">1</a>
                            </li>

                            <li>
                                <a href="#">2</a>
                            </li>

                            <li>
                                <a href="#">3</a>
                            </li>

                            <li class="next">
                                <a href="#">
                                    <i class="ace-icon fa fa-angle-double-right"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>

        <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
</div><!-- /.row -->
<%@include file="../../taglib/admin/footer/user.jsp" %>
</body>
</html>
