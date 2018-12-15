// JavaScript Document
function validar()
{	
	 if ($("form input:text").val()=="")
		{ 	alert("Debe ingresar una palabra clave");
			$("form input:text").focus();
			return false;
		}
	
		else
		{
		  if($("form input:text").val().length < 3) 
			{  alert ("La palabra clave debe tener almenos 3 letras");
			   $("form input:text").focus();
			   return false;
			}
			
			/*else
			{	if(jQuery.contains("=",$("form input:text").val()))
				alert("Ha introducido un caracter no valido (' ó =)");
				return false;
			}*/
		}
		return true;

}

function deshabilitapersona()
{  if (document.f1.persona.value=="2")
  { document.f1.getElementById('cont').style.display="";
    document.f1.contacto.style.display="";
	document.f1.getElementById('trd').style.display="none";
	document.f1.getElementById('crt').style.display="none";
	document.f1.getElementById('fecha_nac').style.display="none";
	document.f1.getElementById('lfechanac').style.display="none";
	document.f1.getElementById('lsexo').style.display="none";
/*    document.f1.apaterno.disabled=true;
    document.f1.amaterno.disabled=true;
	document.f1.tipo_doc.disabled=true;
	document.f1.documento.disabled=true;*/
	document.f1.getElementById('s').style.display="none"; 
	document.f1.fecha_nac.disabled=true;
	
  }
   if (document.f1.persona.value==1)
   {
	   for(var i=0;i< document.f1.elements.length;i++)
	  { document.f1.elements[i].style.display="";
	    document.f1.elements[i].disabled=false; }
		document.f1.getElementById('cont').style.display="none";
	    document.f1.contacto.style.display="none";
		document.f1.getElementById('trd').style.display="";
	    document.f1.getElementById('crt').style.display="";
	
    document.f1.getElementById('lfechanac').style.display="";
	document.f1.getElementById('lsexo').style.display="";
	document.f1.getElementById('s').style.display="";
	document.f1.getElementById('contacto').style.display="none";
    document.f1.getElementById('cont').style.display="none";
	
	} 
  
 }
 function HayEspacio(s)
{ 	var i;
	var espacio =" ";
	// buscar a traves de lo caracteres hasta encontrar un no espacio en blanco.
	for (i = 0; i < s.length; i++)
	{ var c = s.charAt(i);
		if (espacio.indexOf(c) == -1) return false;
	}
	return true;
}

function validarqueja()
{   
	if (document.f1.nombre.value.length==0 || document.f1.nombre.value.length ==undefined)
	{ 	alert ("Debe de escribir su nombre");
		document.f1.nombre.focus();
		return false;
	}
	/* else 
	 {	var charpos = document.f1.nombre.value.search("[^A-Za-z]"); 
		if(charpos >= 0) { 
			alert("Solo se permiten letras en el campo nombre \n [Posicion del caracter erróneo: " + eval(charpos+1)+"]"); 
			document.f1.nombre.focus();
			return false; 
			} 
		   		
	 }*/
		
		
	if (document.f1.apaterno.value.length==0 || document.f1.apaterno.value.length ==undefined)
	{ 	alert ("Debe de escribir su apellido paterno");
		document.f1.apaterno.focus();
		return false;
	}
	 /*else 
	 {	var charpos = document.f1.apaterno.value.search("[^A-Za-z]"); 
		if(charpos >= 0) { 
			alert("Solo se permiten letras en el campo apellido paterno \n [Posicion del caracter erróneo: " + eval(charpos+1)+"]"); 
			document.f1.apaterno.focus();
			return false; 
			} 
		   		
	 }*/
	 
	 if (document.f1.amaterno.value.length==0 || document.f1.amaterno.value.length ==undefined)
	{ 	alert ("Debe de escribir su apellido materno");
		document.f1.amaterno.focus();
		return false;
	}
	/* else 
	 {	var charpos = document.f1.amaterno.value.search("[^A-Za-z]"); 
		if(charpos >= 0) { 
			alert("Solo se permiten letras en el campo apellido materno \n [Posicion del caracter erróneo: " + eval(charpos+1)+"]"); 
			document.f1.amaterno.focus();
			return false; 
			} 
		   		
	 }*/
	 
	  if ( document.f1.tipo_doc.value=="")
		   { 	alert ("Debe elegir un tipo de documento");
				document.f1.tipo_doc.focus();
				return false;
		   }
		
		
	if (document.f1.documento.value.length==0 || document.f1.documento.value.length ==undefined)
	{ 	alert ("Debe de escribir el número del documento");
		document.f1.documento.focus();
		return false;
	}
	 else 
	 {	var charpos = document.f1.documento.value.search("[^0-9]"); 
    	if (document.f1.documento.value.length > 0 &&  charpos >= 0)  { 
    	strError = "El número de documento solo acepta digitos "; 
	    alert(strError + "\n [El caracter erróneo esta en la posicion: " + eval(charpos+1)+"]"); 
		document.f1.documento.focus();
	    return false; 
		}
		   		
	 }
	 
	 if (document.f1.telefono.value.length>0 || document.f1.telefono.value.length!=undefined) 
	 {	var charpos = document.f1.telefono.value.search("[^0-9]"); 
    	if (document.f1.telefono.value.length > 0 &&  charpos >= 0)  { 
    	strError = "El número telefono solo acepta digitos "; 
	    alert(strError + "\n [El caracter erróneo esta en la posicion: " + eval(charpos+1)+"]"); 
		document.f1.telefono.focus();
	    return false; 
		}
		   		
	 }
	 if (document.f1.mail.value=="")
	   {	alert ("Debe de escribir su correo electrónico");
			document.f1.mail.focus();
			return false;
		}
		parte1 = document.f1.mail.value.indexOf("@");
		parte2 = document.f1.mail.value.indexOf(".",parte1);
		 parte3 = document.f1.mail.value.length;
		 
		if (!(parte1 >= 3 && parte2 >= 6 && parte3 >= 9)) {
		alert ("Debe escribir una dirección de correo válida");
		document.f1.mail.focus();
		return false;
		 }
		 

	if (document.f1.direccion.value.length==0 || document.f1.direccion.value.length ==undefined)
	{ 	alert ("Debe de escribir su dirección");
		document.f1.direccion.focus();
		return false;
	}
		
 
	if (document.f1.departamento.value=="")
	   {	alert ("Debe seleccionar un Departamento");
			document.f1.departamento.focus();
			return false;
		}
		if (document.f1.provincia.value=="")
	   {	alert ("Debe seleccionar una provincia");
			document.f1.provincia.focus();
			return false;
		}
			if (document.f1.distrito.value=="")
	   {	alert ("Debe seleccionar un Distrito");
			document.f1.distrito.focus();
			return false;
		}
		
	if (document.f1.desc_queja.value.length==0 || document.f1.desc_queja.value.length ==undefined)
	{ 	alert ("Debe de escribir el texto de la queja o consulta");
		document.f1.desc_queja.focus();
		return false;
	}
		
		
		extensiones_nopermitidas = new Array(".dat",".exe",".bat",".bin",".bmp",".com",".sh"); 
	   if (document.f1.adjunto1.value != "") 
	   {       
		   extension = (f1.adjunto1.value.substring(f1.adjunto1.value.lastIndexOf("."))).toLowerCase(); 
			permitida = false; 
			for (var i = 0; i < extensiones_nopermitidas.length; i++) { 
				 if (extensiones_nopermitidas[i] == extension) { 
				   alert("No se pueden adjuntar archivos con extensiones: \n" + extensiones_nopermitidas.join()); 
				   document.f1.adjunto1.focus();
					return false;
					} 
				 } 
		  if (!permitida) { 
		   permitida = true; 
		   }
	   }
	
		document.f1.B1.disabled=true;
		return true;
}

