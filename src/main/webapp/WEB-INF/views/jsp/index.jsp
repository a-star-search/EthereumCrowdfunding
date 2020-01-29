<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Crowdfunding</title>

<c:url var="home" value="/" scope="request" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<style>
	a.btn {
		-webkit-appearance: button;
		-moz-appearance: button;
		appearance: button;
		color: #fff;
		background-color: #007bff;
		border-color: #007bff;
	}
</style>
</head>

<div class="container">
	<div class="modal-body row">
		<div class="col-md-12">
			<h1>Crowdfunding</h1>
		</div>
	</div>
	<div class="modal-body row">
		<div class="col-md-12">
				<div class="modal-body row">
					<div class="col-md-6">
						<h3>Actuar como:</h3>
						<select class="browser-default custom-select custom-select-lg mb-3"
							id="select-usuario" style="width: 500px;" onclick='javascript:actualizarFondosViaAjax()'>
							<option selected value="A">A</option>
						</select>
					</div>
					<div class="col-md-6">
						<h3>Fondos (ETH)</h3>
						<label id="fondos">0</label>
					</div>
				</div>
		</div>
	</div>
	<div class="modal-body row">
		<div class="col-md-6">
			<form class="form-horizontal" id="opinion-form">
				<div class="form-group form-group-lg">
					<div class="col-sm-10">
						<h3>Nueva causa</h3>
						<input type=text class="form-control" id="causa">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" id="bth-search"
							class="btn btn-primary btn-lg">Publicar</button>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-6">
			<h2>Donaciones</h2>
			<div id="panel_donaciones"></div>
		</div>
	</div>

</div>

<script>
	jQuery(document).ready(function($) {
		$("#opinion-form").submit(function(event) {
			enableOpinionButton(false);
			event.preventDefault();
			submitViaAjax();
		});
		retrieveIds();
	});

	function retrieveIds() {
		$.ajax({
			type : "GET",
			url : "${home}crowdfunding/api/listaIds",
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				setIds(data);
				actualizarFondosViaAjax();
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	}
	
	function actualizarFondosViaAjax() {
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${home}crowdfunding/api/obtenerFondos",
			data : JSON.stringify($("#select-usuario").val()),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				$("#fondos").text(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				//display(e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});

	}
	function submitViaAjax() {
		var causa = {}
		causa["causa"] = $("#causa").val();
		causa["usuario"] = $("#select-usuario").val();
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${home}crowdfunding/api/publicarCausa",
			data : JSON.stringify(causa),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				nuevaEntradaDonacion(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				//display(e);
			},
			done : function(e) {
				console.log("DONE");
				enableOpinionButton(true);
			}
		});

	}

	function donar(idDonacion) {
		var donacion = {}
		donacion["idDonacion"] = idDonacion;
		donacion["donante"] = $("#select-usuario").val();
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${home}crowdfunding/api/donar",
			data : JSON.stringify(donacion),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				var id = data.idDonacion;
				var total = data.totalDonado;
				$("#totalDonado" + id).text(total);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				//display(e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	}

	function enableOpinionButton(flag) {
		$("#btn-search").prop("disabled", flag);
	}

	function setIds(data) {
	  var arr = data.ids;

	  var optionsAsString = "";
	  for(var i = 0; i < arr.length; i++) {
	      optionsAsString += "<option value='" + arr[i] + "'>" + arr[i] + "</option>";
	  }
	  $("select[id='select-usuario']").find('option').remove().end().append($(optionsAsString));
	}

	function nuevaEntradaDonacion(data) {
		//var json = JSON.stringify(data, null, 4)
		var fun = 'javascript:donar("' + data.result.id + '")';
		var newLink = $("<a />", {
			id : "donacion" + data.result.id,
			class: "btn",
			name : "donar",
			href : "#",
			text : "Donar 1 ETH",
			onClick : fun
		});
		$('#panel_donaciones').append(newLink);
		$('#panel_donaciones').append(
				'<br/>Causa: ' + JSON.stringify(data.result.causa) + 
				'<br/>Usuario: ' + JSON.stringify(data.result.usuario) + 
				'<br/><label>Total donado (ETH):&nbsp</label><label id="totalDonado' + data.result.id + '">0</label><br/><label>---</label><br/>');
	}
</script>

</body>
</html>