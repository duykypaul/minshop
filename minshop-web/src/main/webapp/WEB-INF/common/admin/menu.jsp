<%--
    Created by IntelliJ IDEA.
    User: DuyKyPaul
    Date: 9/17/2019
    Time: 11:40 PM
    To change this template use File | Settings | File Templates.
    --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="sidebar" class="sidebar responsive ace-save-state" data-sidebar="true"
     data-sidebar-scroll="true" data-sidebar-hover="true">
    <script type="text/javascript">
        try {
            ace.settings.loadState('sidebar')
        } catch (e) {
        }
    </script>
    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>
            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>
            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>
            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>
        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>
            <span class="btn btn-info"></span>
            <span class="btn btn-warning"></span>
            <span class="btn btn-danger"></span>
        </div>
    </div>
    <!-- /.sidebar-shortcuts -->
    <ul class="nav nav-list" style="top: 0px;">
        <li class="active">
            <a href="<c:url value="/admin/home"/> ">
                <i class="menu-icon fa fa-tachometer"></i>
                <span class="menu-text"> Dashboard </span>
            </a>
            <b class="arrow"></b>
        </li>
        <li class="">
            <a href="<c:url value="/admin/user"/>">
                <i class="menu-icon fa fa-user"></i>
                <span class="menu-text"> Nhân Viên </span>
            </a>
            <b class="arrow"></b>
        </li>
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-cubes"></i>
                <span class="menu-text"> Sản Phẩm </span>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <c:forEach var="productLine" items="${productLineList}">
                    <li class="">
                        <a href="<c:url value="/admin/product-line/${productLine.getProduct_line_id()}"/> ">
                            <i class="menu-icon fa fa-caret-right"></i>
                                ${productLine.getName()}
                        </a>
                        <b class="arrow"></b>
                    </li>
                </c:forEach>
            </ul>
        </li>
        <li class="">
            <a href="">
                <i class="menu-icon fa fa-inr"></i>
                <span class="menu-text"> Hóa đơn </span>
            </a>
            <b class="arrow"></b>
        </li>
    </ul>
    <!-- /.nav-list -->
    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state"
           data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>
