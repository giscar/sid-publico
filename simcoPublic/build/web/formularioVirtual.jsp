<!DOCTYPE html>
<!-- saved from url=(0057)https://www.defensoria.gob.pe/quejas/formulario-queja.php -->
<%@page pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no,initial-scale=1.0,minimun-scale=1.0">
        <link rel="stylesheet" href="./recursos/bootstrap.min.css">
        <link rel="stylesheet" href="./recursos/style.css">
        <link href="./recursos/datepicker-nintr.css" rel="stylesheet" type="text/css">
        <script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="./recursos/mootools.js"></script>
        <script type="text/javascript" src="./recursos/datepicker.js"></script>
        <script type="text/javascript" src="./recursos/es.js" charset="utf-8"></script>

        <meta http-equiv="Content-Language" content="es">
        <link rel="shortcut icon" href="https://www.defensoria.gob.pe/quejas/imagenes/favicon.png" type="image/gif">
        <title>Defensoría del Pueblo- Formulario de Quejas y Consultas - Dejanos tu caso</title>




        <script type="text/javascript">
 // <![CDATA[

            datePickerController.setGlobalVars({"split": ["-dd", "-mm"]});


            function disableEasterMonday(argObj) {

                var y = argObj.yyyy,
                        a = y % 4,
                        b = y % 7,
                        c = y % 19,
                        d = (19 * c + 15) % 30,
                        e = (2 * a + 4 * b - d + 34) % 7,
                        m = Math.floor((d + e + 114) / 31),
                        g = (d + e + 114) % 31 + 1,
                        yyyymmdd = y + "0" + m + String(g < 10 ? "0" + g : g);

                datePickerController.addDisabledDates(argObj.id, yyyymmdd);

                // The redraw callback expects an Object as a return value
                // so we just give it an empty Object...
                return {};
            }
            ;

            /*
            
             The following functions updates a span with an "English-ised" version of the
             currently selected date for the last datePicker on the page.
            
             NOTE: These functions are not needed, they are only present to show you how you
             might use callback functions to use the selected date in other ways!
            
             */
            function createSpanElement(argObj) {
                // Make sure the span doesn't exist already
                if (document.getElementById("EnglishDate"))
                    return;

                // create the span node dynamically...
                var spn = document.createElement('span');
                p = document.getElementById(argObj.id).parentNode;

                spn.id = "EnglishDate";
                p.parentNode.appendChild(spn);

                // Remove the bottom margin on the input's wrapper paragraph
                p.style.marginBottom = "0";

                // Add a whitespace character to the span
                spn.appendChild(document.createTextNode(String.fromCharCode(160)));
            }
            ;

            function showEnglishDate(argObj) {
                // Grab the span & get a more English-ised version of the selected date
                var spn = document.getElementById("EnglishDate"),
                        formattedDate = datePickerController.printFormattedDate(argObj.date, "l-cc-sp-d-S-sp-F-sp-Y", false);

                // Make sure the span exists before attempting to use it!
                if (!spn) {
                    createSpanElement(argObj);
                    spn = document.getElementById("EnglishDate");
                }
                ;

                // Note: The 3rd argument to printFormattedDate is a Boolean value that
                // instructs the script to use the imported locale (true) or not (false)
                // when creating the dates. In this case, I'm not using the imported locale
                // as I've used the "S" format mask, which returns the English ordinal
                // suffix for a date e.g. "st", "nd", "rd" or "th" and using an
                // imported locale would look strange if an English suffix was included

                // Remove the current contents of the span
                while (spn.firstChild)
                    spn.removeChild(spn.firstChild);

                // Add a new text node containing our formatted date
                spn.appendChild(document.createTextNode(formattedDate));
            }
            ;

 // ]]>
        </script>
        <script type="text/javascript" src="./recursos/validar.js"></script>
    </head>
    <body>
        <header>
            <div class="container justify-content-end" id="contenedor-menu">
                <div class="row justify-content-end">
                    <div class="col-lg-12 col-xl-12 justify-content-end">
                        <div class="row d-md-flex">
                            <div class="col-3 col-sm-2 col-md-2 col-lg-4 logotipo  ">
                                <figure>
                                    <a href="http://www.defensoria.gob.pe/">
                                        <img src="./recursos/logodef.svg" alt="logo defensoria">
                                    </a>
                                </figure>
                            </div>
                            <div class="col-6 col-sm-7 col-md-7 col-lg-6">
                                <div class="titulo">
                                    Defensoría del Pueblo</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <div class="container">
            <div class="clear"></div>

            <div><h1>Presente su caso en Línea</h1></div>

            <div id="texto">

                <p>En cumplimiento de lo previsto en  el artículo 162º de la Constitución
                    y la Ley Nº 26520, Ley Orgánica de la Defensoría del Pueblo, nuestra institución atiende solicitudes
                    de intervención de los ciudadanos ante una entidad de la Administración Pública o de las empresas prestadoras de servicios públicos. </p>
                <p>
                </p>
                <p>Estas pueden ser quejas, cuando exista alguna vulneración o el peligro de vulneración de un derecho fundamental; o, petitorios a manera de buenos oficios, para que se atienda o solucione una situación de indefensión que afecta o amenaza los derechos fundamentales, que no representa un incumplimiento de los deberes de la Administración Pública o de las empresas prestadoras de servicios públicos, pero que éstas pueden atender en ejercicio de sus competencias; asimismo, se absuelven consultas legales o se brinda información sobre las entidades o vías pertinentes a las que podría acudir para hacer valer sus derechos.</p>
            </div>

            <div id="formulario">

                <form method="post" action="FormularioVirtualController" onsubmit="return validarqueja();" name="f1" enctype="multipart/form-data">

                    <fieldset>
                        <legend>&nbsp;&nbsp;Datos Personales&nbsp;&nbsp;</legend>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2"><label for="nombre">Nombres (*)</label>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                <input type="text" id="nombres" tabindex="2" name="nombre" class="form-control" onpaste="return false" autocomplete="off">
                                <input type="hidden" name="tipoqueja" value="Q">
                                <input type="hidden" name="tipo" value="Q">
                                <input type="hidden" name="persona" value="1">
                            </div>


                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2"><label for="apaterno">Primer apellido  (*)</label>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                <input type="text" id="apaterno" tabindex="3" name="apaterno" class="form-control" onpaste="return false" autocomplete="off">
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2"><label for="amaterno">Segundo apellido (*)</label>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                <input type="text" id="amaterno" tabindex="4" name="amaterno" class="form-control" onpaste="return false" autocomplete="off">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2"><label for="tipo_doc">Tipo de Documento (*)</label>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                <select size="1" name="tipo_doc"  id="tipodocumento"  class="form-control" tabindex="5">
                                    <%=request.getAttribute("listaTipoDocumento")%>
                                </select>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2"><label for="documento">Numero de Documento(*)</label>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                <input type="text" id="documento" tabindex="6" name="documento" class="form-control" onpaste="return false" autocomplete="off">
                            </div>

                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2"><label for="telefono">Teléfono</label>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                <input type="text" id="telefono" name="telefono" class="form-control" tabindex="7" onpaste="return false" autocomplete="off">
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2"><label for="sexo">Sexo:</label>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                Masculino<input type="radio" id="m" name="sexo" value="M" checked="checked" tabindex="8">&nbsp;&nbsp; 
                                Femenino<input type="radio" id="f" name="sexo" value="F" tabindex="9">
                            </div>

                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2"><label for="mail">E-Mail(*)</label>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                <input type="text" id="mail" name="mail" tabindex="10" class="form-control" onpaste="return false" autocomplete="off">
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2"><label for="fecha_nac">Fecha de nacimiento</label>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                <input type="text" class="w16em dateformat-d-ds-m-ds-Y form-control" id="dp-2"  readonly="readonly" name="fecha_nac"  tabindex="1" value=""/>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2"><label for="direccion">Dirección (*):</label>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                <input type="text" id="direccion" name="direccion" size="35" tabindex="14" onpaste="return false" class="form-control" autocomplete="off">
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2"><label for="departamento">Departamento (*):</label>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                <select size="1" id="departamento" class="idDepartamento form-control" name="departamento" onchange ="Departamento(this.value)" tabindex="15">
                                    <%=request.getAttribute("listaDepartamentos")%> 
                                </select> 
                            </div>

                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2"><label for="provincia">Provincia (*):</label>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                <select id="provincia" size="1" name="provincia" onchange ='Provincia(this.value, document.getElementById("departamento").value)' tabindex="16" class="form-control">
                                    <option value = "" >---</option>
                                </select>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2"><label for="distrito">Distrito (*):</label>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                <select id="distrito" size="1" name="distrito" tabindex="17" class="form-control">
                                    <option value = "" >---</option>
                                </select>
                            </div>
                        </div>
                    </fieldset>
                    <br><br>
                    <fieldset>
                        <legend>&nbsp;&nbsp;Datos del Caso o Consulta&nbsp;&nbsp;</legend>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <label for="queja">Escriba una breve descripción de su caso (*)</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <textarea id="queja" rows="5" name="desc_queja" class="form-control" tabindex="18" onpaste="return false" autocomplete="off"></textarea>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <label for="adjunto1">Adjunte su archivo (Máximo: 20Mb)</label>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"><input id="adjunto1" type="file" name="adjunto1" tabindex="19">
                            </div>
                        </div>


                        <br>
                        Los campos marcados con (*) son obligatorios <br>
                    </fieldset>
                    <div>
                        <br><input type="submit" id="enviar" value="Enviar" name="B1" style="font-weight: bold" tabindex="20">
                        &nbsp;&nbsp;
                        <input type="reset" id="limpiar" name="reset" value="Limpiar" style="font-weight: bold" tabindex="21">
                    </div>
                </form>
            </div>
        </div>

        <script>
            //<![CDATA[
            <%=request.getAttribute("listaProvincias")%>
            <%=request.getAttribute("listaDistritos")%>

            function Departamento(cod_dep) {
                var xx, selOpcion, aa = 1;
                var long = 0;
                for (var i = document.forms.f1.provincia.options.length - 1; i >= 0; i--)
                {
                    document.forms.f1.provincia.options[i] = null;
                }

                for (var i = document.forms.f1.distrito.options.length - 1; i >= 0; i--)
                {
                    document.forms.f1.distrito.options[i] = null;
                }
                long = (mi_arreglo_prov.length - 1);
                for (x = 0; x <= long; x++)
                {
                    xx = mi_arreglo_prov[x][2].toString();
                    if (xx === cod_dep)
                    {
                        selOpcion = new Option(mi_arreglo_prov[x][1].toString(), mi_arreglo_prov[x][0].toString());
                        eval(document.forms.f1.provincia.options[aa] = selOpcion);
                        aa++
                    }
                }
            }

            function Provincia(cod_pro, cod_dep) {
                var xx, selOpcion, aa = 1;
                var long = 0;
                for (var i = document.forms.f1.distrito.options.length - 1; i >= 0; i--) {
                    document.forms.f1.distrito.options[i] = null;
                }
                long = (mi_arreglo_dist.length - 1);
                for (x = 0; x <= long; x++) {
                    xx = mi_arreglo_dist[x][2].toString();
                    yy = mi_arreglo_dist[x][3].toString();
                    if (xx === cod_pro && yy === cod_dep) {
                        selOpcion = new Option(mi_arreglo_dist[x][1].toString(), mi_arreglo_dist[x][0].toString());
                        eval(document.forms.f1.distrito.options[aa] = selOpcion);
                        aa++;
                    }
                }
            }
        </script>

        <script type="text/javascript">
            
            var nombre = document.getElementById("nombres");
            nombre.setAttribute("autocomplete", "off");
            var paterno = document.getElementById("apaterno");
            paterno.setAttribute("autocomplete", "off");
            var materno = document.getElementById("amaterno");
            materno.setAttribute("autocomplete", "off");
            var documento = document.getElementById("documento");
            documento.setAttribute("autocomplete", "off");
            var telefono = document.getElementById("telefono");
            telefono.setAttribute("autocomplete", "off");
            var mail = document.getElementById("mail");
            mail.setAttribute("autocomplete", "off");
            var direccion = document.getElementById("direccion");
            direccion.setAttribute("autocomplete", "off");
            var queja = document.getElementById("queja");
            queja.setAttribute("autocomplete", "off");


            //]]
        </script>



        <!-- Matomo -->
        <script type="text/javascript">
            var _paq = _paq || [];
            /* tracker methods like "setCustomDimension" should be called before "trackPageView" */
            _paq.push(['trackPageView']);
            _paq.push(['enableLinkTracking']);
            (function () {
                var u = "//www.defensoria.gob.pe/pvit/";
                _paq.push(['setTrackerUrl', u + 'piwik.php']);
                _paq.push(['setSiteId', '1']);
                var d = document, g = d.createElement('script'), s = d.getElementsByTagName('script')[0];
                g.type = 'text/javascript';
                g.async = true;
                g.defer = true;
                g.src = u + 'piwik.js';
                s.parentNode.insertBefore(g, s);
            })();
        </script>
        <!-- End Matomo Code -->


    </body></html>