<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Levon
  Date: 13.03.2021
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Add Product - Dashboard HTML Template</title>
    <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
    />

    <!-- https://fonts.google.com/specimen/Roboto -->

    <link rel="stylesheet" href="../admin/css/imageUpload.css"/>
    <link rel="stylesheet" href="../admin/css/fontawesome.min.css"/>
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="../admin/jquery-ui-datepicker/jquery-ui.min.css" type="text/css"/>
    <!-- http://api.jqueryui.com/datepicker/ -->
    <link rel="stylesheet" href="../admin/css/bootstrap.min.css"/>
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="../admin/css/templatemo-style.css">
    <!--
	Product Admin CSS Template
	https://templatemo.com/tm-524-product-admin
	-->
</head>

<body>
<nav class="navbar navbar-expand-xl">
    <div class="container h-100">
        <a class="navbar-brand" href="/admin">
            <h1 class="tm-site-title mb-0">Product Admin</h1>
        </a>
        <button
                class="navbar-toggler ml-auto mr-0"
                type="button"
                data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <i class="fas fa-bars tm-nav-icon"></i>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mx-auto h-100">
                <li class="nav-item">
                    <a class="nav-link" href="index.html">
                        <i class="fas fa-tachometer-alt"></i> Dashboard
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="navbarDropdown"
                            role="button"
                            data-toggle="dropdown"
                            aria-haspopup="true"
                            aria-expanded="false"
                    >
                        <i class="far fa-file-alt"></i>
                        <span> Reports <i class="fas fa-angle-down"></i> </span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Daily Report</a>
                        <a class="dropdown-item" href="#">Weekly Report</a>
                        <a class="dropdown-item" href="#">Yearly Report</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="products.html">
                        <i class="fas fa-shopping-cart"></i> Products
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="accounts.html">
                        <i class="far fa-user"></i> Accounts
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="navbarDropdown"
                            role="button"
                            data-toggle="dropdown"
                            aria-haspopup="true"
                            aria-expanded="false"
                    >
                        <i class="fas fa-cog"></i>
                        <span> Settings <i class="fas fa-angle-down"></i> </span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Profile</a>
                        <a class="dropdown-item" href="#">Billing</a>
                        <a class="dropdown-item" href="#">Customize</a>
                    </div>
                </li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link d-block" href="login.html">
                        Admin, <b>Logout</b>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container tm-mt-big tm-mb-big">
    <div class="row">
        <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
            <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                <div class="row">
                    <div class="col-12">
                        <h2 class="tm-block-title d-inline-block">Add Product</h2>
                    </div>
                </div>
                <div class="row tm-edit-product-row">
                    <div class="col-xl-6 col-lg-6 col-md-12">
                        <spring:form action="/admin/addProduct" method="post" class="tm-edit-product-form"
                                     modelAttribute="product" enctype="multipart/form-data">
                        <div class="form-group mb-3">
                            <spring:label path="name">?????????????? ????????????</spring:label>
                            <spring:input id="name" path="name" type="text" class="form-control validate"/>
                        </div>
                        <div class="form-group mb-3">
                            <spring:label path="description">????????????????????????????</spring:label>
                            <spring:textarea id="description" path="description" class="form-control validate"
                                             rows="3"/>
                        </div>
                        <div class="form-group mb-3">
                            <spring:label path="category">??????????????????</spring:label>
                                <%--                                <input class="custom-select tm-select-accounts" list="category" name="category">--%>
                                <%--                                <datalist id="category">--%>
                                <%--                                    <option  value="??????????">--%>
                                <%--                                    <option  value="??????????????????">--%>
                                <%--                                    <option  value="????????????????????">--%>

                                <%--                                </datalist>--%>
                            <spring:select class="custom-select tm-select-accounts" path="category">
                                <option selected>???????????? ????????????</option>
                                <c:forEach var="category" items="${allCategory}">
                                    <option value="${category.id}">${category.name}</option>
                                </c:forEach>
                            </spring:select>
                        </div>
                        <div class="row">
                            <div class="form-group mb-3 col-xs-12 col-sm-6">
                                <spring:label path="price">????????</spring:label>
                                <spring:input id="price" path="price" type="text" class="form-control validate"/>
                            </div>
                            <div class="form-group mb-3 col-xs-12 col-sm-6">
                                <spring:label path="discount">???????? ??????????????</spring:label>
                                <spring:input id="discount" path="discount" type="text" class="form-control validate"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
                            <%--                        <div class="tm-product-img-dummy mx-auto">--%>
                            <%--                            <i class="fas fa-cloud-upload-alt tm-upload-icon"--%>
                            <%--                               onclick="document.getElementById('fileInput').click();"></i>--%>
                            <%--                        </div>--%>
                            <%--                        <div class="custom-file mt-3 mb-3">--%>
                            <%--                            <input type="file" id="fileInput" name="picture" style="display:none;"/>--%>
                            <%--                            <input type="button" class="btn btn-primary btn-block mx-auto" value="?????????????????? ????????"--%>
                            <%--                                   onclick="document.getElementById('fileInput').click();"/>--%>

                        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
                        <main class="main_full">
                            <div class="container">
                                <div class="panel">
                                    <div class="button_outer">
                                        <div class="btn_upload">
                                            <input type="file" id="upload_file" name="picture">
                                            ?????????????????? ????????
                                        </div>
                                        <div class="processing_bar"></div>
                                        <div class="success_box"></div>
                                    </div>
                                </div>
                                <div class="error_msg"></div>
                                <div class="uploaded_file_view" id="uploaded_view">
                                    <span class="file_remove">X</span>
                                </div>
                            </div>
                        </main>
                    </div>

                </div>


                <div class="col-12">
                    <button type="submit" class="btn btn-primary btn-block text-uppercase">??????????????????</button>
                </div>
                </spring:form>

            </div>
        </div>
    </div>
</div>
</div>
<footer class="tm-footer row tm-mt-small">
    <div class="col-12 font-weight-light">
        <p class="text-center text-white mb-0 px-4 small">
            Copyright &copy; <b>2018</b> All rights reserved.

            Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Template Mo</a>
        </p>
    </div>
</footer>

<script src="../admin/js/imageUpload.js"></script>

<script src="../admin/js/jquery-3.3.1.min.js"></script>
<!-- https://jquery.com/download/ -->
<script src="../admin/jquery-ui-datepicker/jquery-ui.min.js"></script>
<!-- https://jqueryui.com/download/ -->
<script src="../admin/js/bootstrap.min.js"></script>
<!-- https://getbootstrap.com/ -->
<script>
    $(function () {
        $("#expire_date").datepicker();
    });
</script>


</body>
</html>