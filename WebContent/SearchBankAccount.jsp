<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<html>
<head>

<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<style>
body {
	background-color: rgba(201, 76, 76, 0.3);
}
</style>
<body>

	<div class="
                  container">
		<h1>Welcome to DMK Bank</h1>
		<h2 style="background-color: DodgerBlue;"></h2>
		<form
			style="margin-top: 50px; margin-left: 300px; margin-right: 300px">
	</div>
	<ul class="nav">
		<li class="nav-item"><a class="nav-link" href="a.html">New
				Account</a></li>
		<li class="nav-item"><a class="nav-link" href="b.html">Withdraw</a>
		</li>

		<li class="nav-item"><a class="nav-link" href="c.html">Deposit</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="d.html">Fund
				transfer</a></li>
		<li class="nav-item"><a class="nav-link" href="e.html">check
				balance</a></li>
		<li class="nav-item"><a class="nav-link" href="f.html">Display
				All Account</a></li>
		<li class="nav-item"><a class="nav-link" href="delete.html">Delete
				Account</a></li>
		<li class="nav-item"><a class="nav-link"
			href="SearchBankAccount.html">Search Account</a></li>
		<li class="nav-item"><a class="nav-link" href="update.html">Update
				Bank Account</a></li>
		<li class="nav-item"><a class="nav-link" href="#"></a></li>

	</ul>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<form >
	<div class="form-group">

		<table class="table table-dark table-hover">
			<thead>
				<tr>
					<th>Account number</th>
					<th>Customer Name</th>
					<th>Account Type</th>
					<th>Account Balance</th>
					<th></th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td>${search.accountId}</td>
					<td>${search.accountHolderName}</td>
					<td>${search.accountType}</td>
					<td>${search.accountBalance}</td>
				</tr>




			</tbody>
		</table>
</form>
</body>
</html>
