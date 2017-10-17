<%--
  Created by IntelliJ IDEA.
  User: Alex Kukushkin
  Date: 10/10/2017
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Электронная регистрация на приём к врачу</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
<div id="wrapper">
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="adjust-nav">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <span class="logout-spn" >
                  <a href="#" style="color:#fff;">Выход</a>
                </span>
        </div>
    </div>
    <!-- /. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li class="active-link">
                    <a href="index.html" ><i class="fa fa-desktop "></i>Просмотр всех врачей</a>
                </li>
                <li>
                    <a href="ui.html"><i class="fa fa-table "></i>Выбор населённого пункта</a>
                </li>
                <li>
                    <a href="blank.html"><i class="fa fa-edit "></i>Выбор медицинского учреждения</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-qrcode "></i>Выбор специализации врача</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o"></i>Выбор врача и даты</a>
                </li>

                <li>
                    <a href="#"><i class="fa fa-edit "></i>Выбор времени посещения врача</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-table "></i>Получение талона</a>
                </li>
            </ul>
        </div>
    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper" >
        <div id="page-inner">
            <div class="row">
                <div class="col-lg-12">
                    <h2>Личный кабинет пациента</h2>
                </div>
            </div>
            <!-- /. ROW  -->
            <hr />
            <div class="row">
                <div class="col-lg-12 ">
                    <div class="alert alert-info">
                        <strong>Добро пожаловать ! </strong>
                    </div>

                </div>
            </div>
            <!-- /. ROW  -->
            <div class="row text-center pad-top">
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                    <div class="div-square">
                        <a href="blank.html" >
                            <i class="fa fa-circle-o-notch fa-5x"></i>
                            <h4>Просмотр врачей</h4>
                        </a>
                    </div>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                    <div class="div-square">
                        <a href="blank.html" >
                            <i class="fa fa-spinner fa-5x"></i>
                            <h4>Просмотр графиков работы врачей</h4>
                        </a>
                    </div>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                    <div class="div-square">
                        <a href="blank.html" >
                            <i class="fa fa-spinner fa-5x"></i>
                            <h4>Действие 3</h4>
                        </a>
                    </div>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                    <div class="div-square">
                        <a href="blank.html" >
                            <i class="fa fa-spinner fa-5x"></i>
                            <h4>Действие 4</h4>
                        </a>
                    </div>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                    <div class="div-square">
                        <a href="blank.html" >
                            <i class="fa fa-spinner fa-5x"></i>
                            <h4>Действие 5 </h4>
                        </a>
                    </div>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                    <div class="div-square">
                        <a href="blank.html" >
                            <i class="fa fa-spinner fa-5x"></i>
                            <h4>Справочная информация</h4>
                        </a>
                    </div>
                </div>
            </div>
            <!-- /. ROW  -->
        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<div class="footer">
    <div class="row">
        <div class="col-lg-12" >
            &copy;  2017 alexkukushkin
        </div>
    </div>
</div>

<script src="assets/js/jquery-1.10.2.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/custom.js"></script>

</body>
</html>

