<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		document.getElementsByTagName("a")[0].onclick = function() {
			var request = new XMLHttpRequest();
			var url = this.href;
			var method = "GET";
			request.open(method, url);
			request.send(null);
			request.onreadystatechange = function(){
				if(request.readyState == 4){
					if(request.status == 200 || request.status == 304){
						alert(request.responseText);
					}
				}
				
			}
			return false;
		}
	}
</script>
<link rel="stylesheet" href="./css/bootstrap.css">
<script type="text/javascript" src="scripts/jquery-3.2.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.js"></script>
</head>
<body>
<a href="Hello.txt">Helloajax</a>
<form>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Email"/>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  <div class="form-group">
    <label for="exampleInputFile">File input</label>
    <input type="file" id="exampleInputFile">
    <p class="help-block">Example block-level help text here.</p>
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox"> Check me out
    </label>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
</body>
</html>