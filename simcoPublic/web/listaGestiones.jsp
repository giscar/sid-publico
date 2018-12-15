<!DOCTYPE html>
<!-- saved from url=(0046)http://apps.defensoria.gob.pe/notificacionsid/ -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="http://apps.defensoria.gob.pe/notificacionsid/favicon.ico?" type="image/x-icon">
        <title>Defensoría del Pueblo - Acceso a los ciudadanos</title>
        <link rel="stylesheet" href="recursos2/bootstrap.css">
        <style type="text/css">
            body{
                padding-top: 50px;
                font-size: 12px;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <!-- Fixed navbar -->
            <nav role="navigation" class="navbar navbar-inverse navbar-fixed-top">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a href="http://www.defensoria.gob.pe/" class="navbar-brand">
                            <span><img style="padding:0;margin: 0;" alt="Defensoría del Pueblo" src="./recursos/logo.png" width="50"></span>
                            <span>DEFENSORÍA DEL PUEBLO</span>
                        </a>
                    </div>
                    <!-- Collection of nav links and other content for toggling -->
                    <div id="navbarCollapse" class="collapse navbar-collapse">
                        <ul class="nav navbar-nav">
                            <!-- <li class="active"><a href="#">Expediente</a></li>
                            <li><a href="#">Expediente</a></li>						
                            <li><a href="#">Solicitud</a></li>
                            <li><a href="#">Ubícanos</a></li>
                            -->
                        </ul>
                        <ul class="nav navbar-nav navbar-right">

                        </ul>
                    </div><!--/.nav-collapse -->

                </div>

            </nav>

            <div class="container">            
                <div class="row">
                    <!-- <div class="col-md-4 col-md-offset-4"> -->
                    <div class="col-md-10 col-md-offset-4">
                        <form id="expediente" style="padding: 30px; margin: 0 auto;" action="http://apps.defensoria.gob.pe/notificacionsid/" method="post">
                            <table style="width: 100%" id="tblDatos" class="table table-bordered table-hover table-striped">
                        <%=request.getAttribute("datatable")%>
                    </table>

                        </form>					
                    </div>				
                </div>
                <div class="col-md-10 col-md-offset-1">
                    <div class="alert " role="alert" style="font-size: 14px; text-align: center;"></div>
                </div>
            </div> <!-- /container -->
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="recursos2/jquery.min.js" type="text/javascript"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="recursos2/bootstrap.min.js" type="text/javascript"></script>


    </body>
</html>