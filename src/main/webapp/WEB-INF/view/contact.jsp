<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="<%= request.getContextPath() %>/css/style.css" rel="stylesheet" />
<title></title>
</head>
<body>
<img src="upload/IMG_3501.jpg" alt="" />
	<h1>お問い合わせ</h1>
	<form action="" method="post" id="myForm">
		<p>
			名前: <input type="text" name="name">
		</p>
		<style>
		input[type="checkbox"] {
					opacity: 0;
				}
		</style>
  <input type="number" value="" name="1"> 
  <input type="number" value="" name="2"> 
  <input type="number" value="" name="3"> 
  <input type="number" value="" name="4"> 
  <input type="checkbox" name="item" value="a" id="1"> 
  <input type="checkbox" name="item" value="b" id="2"> 
  <input type="checkbox" name="item" value="c" id="3">
  <input type="checkbox" name="item" value="d" id="4">

<input type="submit">
</form>
<script>
document.querySelectorAll('input[type="number"]')
.forEach(function(e){
  e.addEventListener('change', function(){
    let chexbox = document.getElementById(this.name);
    chexbox.setAttribute('value',this.name + "-" + this.value);
   if(this.value > 0){
	   chexbox.setAttribute('checked', 'checked'); 
   }else{
	   chexbox.removeAttribute('checked'); 
   }
    console.log(document.getElementById(this.name));
  });
});
</script>

</body>
</html>