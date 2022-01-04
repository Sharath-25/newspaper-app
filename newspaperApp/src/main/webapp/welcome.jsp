<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h1>Welcome to newspaper App</h1>
	<h1>${validationMessage}</h1>
	<form action="submitnewspaper.abc">
		<pre>
	NAME: <input type="text" name="newsPaperName">
	
	Price: <input type="text" name="price">
	
	Lang: <input type="text" name="langauge">
	
	noOfPages: <input type="text" name="noOfPages">
	
	
	
	<input type="submit" value="submit">
	</pre>

	</form>

	<h2>${searchvalidationMessage}</h2>
	<form action="searchNewspaper.abc">
		<label>Search</label> <input type="text" name="searchNewsPaper">
		<input type="submit" value="searchNewsPaper">
	</form>
	<h2>${NOTFOUND }</h2>
	<ol>
	<li>${NEWSPAPERNAME}</li>
	<li>${PRICE}</li>
	<li>${LANGAUGE}</li>
	<li>${NOOFPAGES}</li>
	</ol>
	
</body>
</html>