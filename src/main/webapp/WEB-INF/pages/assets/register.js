// JavaScript Validation For Registration Page

$('document').ready(function () {
    // name validation

    //var nameregex = /^([a-zA-Z ].*[ А-Яа-я ]|[ А-Яа-я ].*[a-zA-Z ])+$/;
    var nameregex = /^[а-яА-ЯёЁa-zA-Z]+$/;

    $.validator.addMethod("validname1", function (value, element) {
        return this.optional(element) || nameregex.test(value);
    });
    $.validator.addMethod("validname2", function (value, element) {
        return this.optional(element) || nameregex.test(value);
    });
    $.validator.addMethod("validname3", function (value, element) {
        return this.optional(element) || nameregex.test(value);
    });

    // valid email pattern
    var eregex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    $("#register-form").validate({

        rules:
            {
                firstName: {
                    required: true,
                    validname1: true
                },
                familyName: {
                    required: true,
                    validname2: true
                },
                patronymic: {
                    required: true,
                    validname3: true
                },
                birthDate: {
                    required: true
                },
                passport: {
                    required: true
                },
                SNILS: {
                    required: true
                },
                medPolis: {
                    required: true
                },
                registerLocation: {
                    required: true
                },
                address: {
                    required: true
                },
                sexType: {
                    required: true
                },
                inputLogin: {
                    required: true
                },
                inputPassword: {
                    required: true,
                    minlength: 5,
                    maxlength: 15
                },
                retypeInputPassword: {
                    required: true,
                    equalTo: '#inputPassword'
                },
            },
        messages:
            {
                firstName: {
                    required: "Введите Имя",
                    validname1: "Имя может содержать только буквы латинского алфавита, кириллицы и знак пробел"
                },
                familyName: {
                    required: "Введите Фамилию",
                    validname2: "Фамилия может содержать только буквы латинского алфавита, кириллицы и знак пробел"
                },

                patronymic: {
                    required: "Введите Отчество",
                    validname3: "Отчесвто может содержать только буквы латинского алфавита, кириллицы и знак пробел"
                },
                birthDate: {
                    required: "Введите Дату Рождения"
                },
                passport: {
                    required: "Введите Паспортные данные"
                },
                SNILS: {
                    required: "Введите номер СНИЛСа"
                },
                medPolis: {
                    required: "Введите номер Медицинского полиса"
                },
                registerLocation: {
                    required: "Введите Место Регистрации"
                },
                address: {
                    required: "Введите Адрес проживания"
                },
                sexType: {
                    required: "Укажите пол"
                },
                inputLogin: {
                    required: "Введите Логин"
                },
                inputPassword: {
                    required: "Введите Пароль",
                    minlength: "Пароль должен содержать не менее 5 символов"
                },
                retypeInputPassword: {
                    required: "Пожалуйста повторите пароль",
                    equalTo: "Пароль не совпадает!"
                }
            },
        errorPlacement: function (error, element) {
            $(element).closest('.form-group').find('.help-block').html(error.html());
        },
        highlight: function (element) {
            $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
            $(element).closest('.form-group').find('.help-block').html('');
        }
        //,

        // submitHandler: function(form){
        //
        // 	// alert('submitted');
        // 	// form.submit();
        // 	//var url = $('#register-form').attr('action');
        // 	//location.href=url;
        //
        // }

        /*submitHandler: function()
                       {
                               alert("Submitted!");
                            $("#register-form").resetForm();
                       }*/

    });


    /*function submitForm(){


        /*$('#message').slideDown(200, function(){

            $('#message').delay(3000).slideUp(100);
            $("#register-form")[0].reset();
            $(element).closest('.form-group').find("error").removeClass("has-success");

        });

        alert('form submitted...');
        $("#register-form").resetForm();

    }*/
});