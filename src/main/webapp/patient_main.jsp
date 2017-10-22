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
    <meta charset="utf-8"/>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1.0" />--%>
    <title>Электронная регистрация на приём к врачу</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet"/>
    <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet"/>
    <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet"/>
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>
</head>
<body>
<form method="post">
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
                <span class="logout-spn">
                    <button name="exit" class="btn btn-lg btn-primary btn-block" formaction="/web/patient_main"
                            value="exit" type="submit">Выход
                    </button>
                </span>
            </div>
        </div>
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <%--<a href="registration3.jsp"><i class="fa fa-desktop "></i>Просмотр всех врачей</a>--%>
                        <button name="exit" class="btn btn-lg btn-info btn-block" formaction="/web/patient_main"
                                value="exit" type="submit">Просмотр всех врачей
                        </button>
                    </li>
                    <li>
                        <%--<a href="ui.html"><i class="fa fa-table "></i>Выбор населённого пункта</a>--%>
                        <button name="exit" class="btn btn-lg btn-info btn-block" formaction="/web/patient_main"
                                value="exit" type="submit">Выбор населённого пункта
                        </button>
                    </li>
                    <li>
                        <button name="exit" class="btn btn-lg btn-info btn-block" formaction="/web/patient_main"
                                value="exit" type="submit">Выбор Мед Учреждения
                        </button>
                        <%--<a href="blank.html"><i class="fa fa-edit "></i>Выбор медицинского учреждения</a>--%>
                    </li>
                    <li>
                        <button name="exit" class="btn btn-lg btn-info btn-block" formaction="/web/patient_main"
                                value="exit" type="submit">Выбор специализации
                        </button>
                        <%--<a href="#"><i class="fa fa-qrcode "></i>Выбор специализации врача</a>--%>
                    </li>
                    <li>
                        <button name="exit" class="btn btn-lg btn-info btn-block" formaction="/web/patient_main"
                                value="exit" type="submit">Выбор врача и даты
                        </button>
                        <%--<a href="#"><i class="fa fa-bar-chart-o"></i>Выбор врача и даты</a>--%>
                    </li>

                    <li>
                        <button name="exit" class="btn btn-lg btn-info btn-block" formaction="/web/patient_main"
                                value="exit" type="submit">Выбор времени приёма
                        </button>
                        <%--<a href="#"><i class="fa fa-edit "></i>Выбор времени посещения врача</a>--%>
                    </li>
                    <li>
                        <button name="exit" class="btn btn-lg btn-info btn-block" formaction="/web/patient_main"
                                value="exit" type="submit">Получение талона
                        </button>
                        <%--<a href="#"><i class="fa fa-table "></i>Получение талона</a>--%>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-lg-12">
                        <h2>Личный кабинет пациента</h2>
                    </div>
                </div>
                <!-- /. ROW  -->
                <hr/>
                <!-- /. ROW  -->
                <div class="row text-center pad-top">
                    <%--<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">--%>
                        <div class="div-square">
                            <button name="exit" class="btn btn-md btn-default" formaction="/web/patient_main"
                                    value="exit" type="submit">
                                Изменить личные данные
                            </button>
                        </div>
                    <%--</div>--%>
                    <%--<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">--%>
                        <div class="div-square">
                            <button name="exit" class="btn btn-md btn-default" formaction="/web/patient_main"
                                    value="exit" type="submit">
                                Просмотр врачей
                            </button>
                        </div>                       <%--</div>--%>
                    <%--<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">--%>
                        <div class="div-square">
                            <button name="exit" class="btn btn-md btn-default" formaction="/web/patient_main"
                                    value="exit" type="submit">
                                Просмотр графика работы врачей
                            </button>
                        </div>
                    <%--</div>--%>
                    <%--<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">--%>
                        <div class="div-square">
                            <button name="exit" class="btn btn-md btn-default" formaction="/web/patient_main"
                                    value="exit" type="submit">
                                Просмотреть список талонов
                            </button>
                        </div>
                    <%--</div>--%>
                    <%--<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">--%>
                        <div class="div-square">
                            <button name="exit" class="btn btn-md btn-default" formaction="/web/patient_main"
                                    value="exit" type="submit">
                                Просмотреть список медицинских учреждений
                            </button>
                        </div>
                    <%--</div>--%>
                    <%--<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">--%>
                        <div class="div-square">
                            <button name="exit" class="btn btn-md btn-default" formaction="/web/patient_main"
                                    value="exit" type="submit">
                                Справочная информация
                            </button>
                        </div>
                    <%--</div>--%>
                </div>
                <!-- /. ROW  -->
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <div class="footer">
        <div class="row">
            <div class="col-lg-12">
                &copy; 2017 alex kukushkin
            </div>
        </div>
    </div>
</form>
<script src="assets/js/jquery-1.10.2.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/custom.js"></script>

</body>
</html>

