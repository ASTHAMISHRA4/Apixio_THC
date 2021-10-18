<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>HCC And IDP Mapping</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <!-- Custom CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.13.0/css/all.css">
    <style>
        body{color:black;background-color:#111522;}
        .btn{margin:5em; padding: 1em; background-color:#288c6c; color: white;}
    </style>
</head>
<body>
    <div class="container-fluid" id="content">
        <div class="btn-group-horizontal">
            <a href="showhccform"><button type="button" class="btn col-2" id="showhccform">Add new HCC</button></a>
            <a href="showallhcc"><button type="button" class="btn col-2" id="showallhcc">Show All HCC</button></a>
            <a href="showallhccfromcode"><button type="button" class="btn col-2" id="showallhccfromcode">Get HCC by Code</button></a>
            <a href="showallhccfromindex"><button type="button" class="btn col-2" id="showallhccfromindex">Get HCC by Index</button></a>
            <a href="deletehcc"><button type="button" class="btn col-2" id="deletehcc">Delete HCC</button></a>
            <a href="gethccchildrenform"><button type="button" class="btn col-2" id="gethccchildrenform">Get HCC Children</button></a>
            <a href="gethccparentform"><button type="button" class="btn col-2" id="gethccparentform">Get HCC Parent</button></a>
            <a href="showicdform"><button type="button" class="btn col-2" id="showicdform">Add new ICD</button></a>
            <a href="showallicd"><button type="button" class="btn col-2" id="showallicd">Show All ICD</button></a>
            <a href="showallicdfromcode"><button type="button" class="btn col-2" id="showallicdfromcode">Get ICD by Code</button></a>
            <a href="showallicdfromindex"><button type="button" class="btn col-2" id="showallicdfromindex">Get ICD by Index</button></a>
            <a href="deleteicd"><button type="button" class="btn col-2" id="deleteicd">Delete ICD</button></a>
            <a href="addmapping"><button type="button" class="btn col-2" id="addmapping">Add Mapping</button></a>
            <a href="deletemapping"><button type="button" class="btn col-2" id="deletemapping">Delete Mapping</button></a>
            <a href="getmappedhccform"><button type="button" class="btn col-2" id="getmappedhccform">Get Mapped HCC</button></a>
            <a href="getmappedicdform"><button type="button" class="btn col-2" id="getmappedicdform">Get Mapped ICD</button></a>
        </div>
    </div>

        <script src="https://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
        <!-- Bootstrap JS -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

        <!-- Font Awesome -->
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
        <!-- Custom Js -->
        <script src="js/scripts.js"></script>
</body>
</html>