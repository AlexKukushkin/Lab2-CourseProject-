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
    <title>Личный кабинет пациента</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        /* Remove the navbar's default rounded borders and increase the bottom margin */
        .navbar {
            margin-bottom: 20px;
            border-radius: 0;
        }

        /* Remove the jumbotron's default bottom margin */
        .jumbotron {
            margin-bottom: 0px;
        }

        /* Add a gray background color and some padding to the footer */
        footer {
            background-color: #f2f2f2;
            padding: 10px;
        }

        .btn btn-lg btn-success {
            width: 80px;
        }
    </style>
</head>
<body>
<form method="post">
    <div class="jumbotron">
        <div class="container text-center">
            <h3>Личный кабинет пациента</h3>
        </div>
    </div>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">

            </div>
        </div>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <button name="edit" class="btn btn-lg btn-success" formaction="/web/patient_main/patient_edit"
                        value="edit"  type="submit" style="width: 330px">
                    <b>Изменить личные данные</b>
                </button>
            </div>
            <div class="col-sm-4">
                <button name="viewDoctor" class="btn btn-lg btn-success" formaction="/web/patient_main/patient_doctor_list"
                        value="viewDoctor" type="submit" style="width: 330px">
                    <b>Просмотр врачей</b>
                </button>
            </div>
            <div class="col-sm-4">
                <button name="viewSchedule" class="btn btn-lg btn-success" formaction="/web/patient_main/patient_doctor_schedule"
                        value="viewSchedule" type="submit" style="width: 330px">
                    <b>Просмотр графика работы врачей</b>
                </button>
            </div>
        </div>
    </div>
    <br>

    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <button name="viewTicket" class="btn btn-lg btn-success" formaction="/web/patient_main/patient_ticket"
                        value="viewTicket" type="submit" style="width: 330px">
                    <b>Просмотр талонов</b>
                </button>
            </div>
            <div class="col-sm-4">
                <button name="viewMedCenter" class="btn btn-lg btn-success" formaction="/web/patient_main/patient_medcenter"
                        value="viewMedCenter" type="submit" style="width: 330px">
                    <b>Просмотр Мед Учреждений</b>
                </button>
            </div>
            <div class="col-sm-4">
                <button name="info" class="btn btn-lg btn-success" formaction="/web/patient_main/patient_info"
                        value="info" type="submit" style="width: 330px">
                    <b>Справочная информация</b>
                </button>
            </div>
        </div>
    </div>
    <br>

    <div class="container">
        <div class="row">
            <div class="col-sm-4">
            </div>
            <div class="col-sm-4">
                <button name="location" class="btn btn-lg btn-success" formaction="/web/patient_main/patient_new_ticket"
                        value="location" type="submit" style="width: 330px">
                    <b>Записаться на приём</b>
                </button>
            </div>
            <div class="col-sm-4">
            </div>
        </div>
    </div>
    <br>

    </br>
    </br>
    </br>
    </br>
    <span class="logout-spn">
    <button name="exit" class="btn btn-lg btn-primary btn-block" formaction="/web/patient_main"
            value="exit" type="submit">Выход
    </button>
    </span>
    <footer class="container-fluid text-center">
        <div class="col-lg-12">
            &copy; 2017 alex kukushkin
        </div>
    </footer>
</form>
</body>
</html>
