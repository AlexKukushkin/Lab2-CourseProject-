<%--
  Created by IntelliJ IDEA.
  User: Alex Kukushkin
  Date: 10/10/2017
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Registration form</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css"/>
    <link rel="stylesheet" href="assets/signup-form.css" type="text/css"/>
</head>

<body>

<div class="container">
    <div class="signup-form-container">
        <!-- form start -->
        <form method="post" id="register-form">
            <div class="form-header">
                <h3 class="form-title"><i class="fa fa-user"></i> Sign Up</h3>
                <div class="pull-right">
                    <h3 class="form-title"><span class="glyphicon glyphicon-pencil"></span></h3>
                </div>
            </div>

            <div class="form-body">
                <div class="alert alert-info" id="message" style="display:none;">
                    submitted
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="firstName" name="firstName" type="text" class="form-control" placeholder="Fist Name">
                    </div>
                    <span class="help-block" id="error1"></span>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="familyName" name="familyName" type="text" class="form-control"
                               placeholder="Family Name">
                    </div>
                    <span class="help-block" id="error2"></span>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="patronymic" name="patronymic" type="text" class="form-control"
                               placeholder="Patronymic">
                    </div>
                    <span class="help-block" id="error3"></span>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="birthDate" name="birthDate" type="text" class="form-control" placeholder="yyyy-mm-dd">
                    </div>
                    <span class="help-block" id="error4"></span>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="passport" name="passport" type="text" class="form-control" placeholder="Passport">
                    </div>
                    <span class="help-block" id="error5"></span>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="SNILS" name="SNILS" type="text" class="form-control" placeholder="SNILS">
                    </div>
                    <span class="help-block" id="error6"></span>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="medPolis" name="medPolis" type="text" class="form-control" placeholder="Medpolis">
                    </div>
                    <span class="help-block" id="error7"></span>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="registerLocation" name="registerLocation" type="text" class="form-control"
                               placeholder="Register Location">
                    </div>
                    <span class="help-block" id="error8"></span>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="address" name="address" type="text" class="form-control" placeholder="Address">
                    </div>
                    <span class="help-block" id="error9"></span>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="sexType" name="sexType" type="text" class="form-control" placeholder="Sex Type">
                    </div>
                    <span class="help-block" id="error10"></span>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
                        <input name="inputLogin" id="inputLogin" type="login" class="form-control"
                               placeholder="Username">
                    </div>
                    <span class="help-block" id="error11"></span>
                </div>
                <div class="row">
                    <div class="form-group col-lg-6">
                        <div class="input-group">
                            <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
                            <input name="inputPassword" id="inputPassword" type="password" class="form-control"
                                   placeholder="Password">
                        </div>
                        <span class="help-block" id="error12"></span>
                    </div>
                    <div class="form-group col-lg-6">
                        <div class="input-group">
                            <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
                            <input name="inputPassword" type="password" class="form-control"
                                   placeholder="Retype Password">
                        </div>
                        <span class="help-block" id="error13"></span>
                    </div>
                </div>
            </div>
            <div class="form-footer">
                <button class="button btn btn-lg btn-success" type="submit" formaction="/web/register"
                        value="register" style="margin: auto; display: block">
                    <span class="glyphicon glyphicon-log-in"></span> Sign Here
                </button>
            </div>
        </form>
    </div>
</div>

<script src="assets/jquery-1.11.2.min.js"></script>
<script src="assets/jquery.validate.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="assets/register.js"></script>

</body>
</html>
