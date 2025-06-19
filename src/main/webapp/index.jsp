<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Covid Galicia</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            color: #333;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            width: 300px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input {
            padding: 8px;
            width: 100%;
            margin-bottom: 10px;
            box-sizing: border-box;
        }
        button {
            padding: 10px;
            width: 100%;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        .error {
            color: red;
            margin-bottom: 10px;
            text-align: center;
        }
    </style>
    <script>
        function validateDayForm() {
            var dayInput = document.forms["covidDayForm"]["day"].value;
            if (dayInput == "") {
                document.getElementById("error-day").textContent = "Por favor, introduce un día.";
                return false;
            }
            return true;
        }
        
        function validateCenterForm() {
            var centerInput = document.forms["covidCenterForm"]["center"].value;
            if (centerInput == "") {
                document.getElementById("error-center").textContent = "Por favor, introduce un centro.";
                return false;
            }
            return true;
        }

        function validateMunicipalityForm() {
            var municipality = document.forms["covidMunicipalityForm"]["municipality"].value;
            var date = document.forms["covidMunicipalityForm"]["date"].value;
            var errorMessage = "";

            if (municipality == "") {
                errorMessage += "Por favor, introduce un municipio. ";
            }

            if (errorMessage !== "") {
                document.getElementById("error-mun").textContent = errorMessage;
                return false;
            }
            return true;
        }
    </script>
</head>
<body>

<div class="container">
    <h1>Datos Covid Galicia</h1>

    <form action="datoscovid" method="GET">
        <button type="submit">Ver todos los datos covid</button>
    </form>

    <form name="covidDayForm" action="datoscoviddia" method="GET" onsubmit="return validateDayForm()">
        <label for="day">Día:</label>
        <input type="number" name="day" id="day">
        <div id="error-day" class="error"></div>
        <button type="submit">Ver datos covid del día seleccionado</button>
    </form>
    
    <form name="covidCenterForm" action="datoscovidcenter" method="GET" onsubmit="return validateCenterForm()">
        <label for="center">Centro:</label>
        <input type="text" name="center" id="center">
        <div id="error-center" class="error"></div>
        <button type="submit">Ver datos covid del centro seleccionado</button>
    </form>

    <form name="covidMunicipalityForm" action="datoscovidmun" method="GET" onsubmit="return validateMunicipalityForm()">
        <label for="municipality">Municipio:</label>
        <input type="text" name="municipality" id="municipality">
        <label for="date">Fecha:</label>
        <input type="date" name="date" id="date">
        <div id="error-mun" class="error"></div>
        <button type="submit">Ver datos covid del municipio en la fecha seleccionada</button>
    </form>

    <form action="cerrado" method="GET">
        <button type="submit">Ver datos covid de centros cerrados</button>
    </form>
</div>

</body>
</html>


    