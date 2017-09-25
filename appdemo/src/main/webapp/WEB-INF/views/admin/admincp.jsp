<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="common/meta.jsp"%>

<title>Admin Dasboard - divided by section</title>

<%@ include file="common/header.jsp"%>
<body class="admin-dashboard">
<!-- NAVBAR -->
	<%@ include file="common/navbar.jsp"%>

	<div class="container-fluid">
		<div class="row">
<!-- Sidebar -->
			<%@ include file="common/sidebar.jsp" %>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">Dashboard</h1>

				<div class="row placeholders">
					<div class="col-xs-6 col-sm-3 placeholder">
						<img
							src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
							width="200" height="200" class="img-responsive"
							alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<img
							src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
							width="200" height="200" class="img-responsive"
							alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<img
							src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
							width="200" height="200" class="img-responsive"
							alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<img
							src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
							width="200" height="200" class="img-responsive"
							alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
				</div>

				<h2 class="sub-header">Korisnici</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>Ime</th>
								<th>Prezime</th>
								<th>Korisničko Ime</th>
								<th>Datum unosa</th>
								<th>Datum promjene</th>
								<th>Status</th>
								<th>IP Adresa</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="korisnik" items="${listaKorisnika}">
								<tr>
									<td>${korisnik.id}</td>
									<td>${korisnik.ime}</td>
									<td>${korisnik.prezime}</td>
									<td>${korisnik.korisnickoIme}</td>
									<td>${korisnik.datumUnosa}</td>
									<td>${korisnik.datumPromjene}</td>
									<td><span>${korisnik.status}</span></td>
									<td><span>${korisnik.ipAdresa}</span></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
				
				<h2 class="sub-header">Portiri</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>Korisničko Ime</th>
								<th>Zadnja prijava</th>
								<th>Token</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="portir" items="${listaPortira}">
								<tr>
									<td>${portir.id}</td>
									<td>${portir.korisnickoIme}</td>
									<td>${portir.zadnjiPristup}</td>
									<td><span>${portir.token}</span></td>
									<td><span>${portir.status}</span></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>				
			</div>
		</div>
	</div>
	<%@ include file="common/footer.jsp"%>