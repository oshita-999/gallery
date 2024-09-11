<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/.css" rel="stylesheet" />
<title></title>
<style>
.flex {
	width: 100%;
	display: flex;
	justify-content: space-around;
	flex-wrap: wrap;
	text-align: center;
}

.flex img {
	object-fit: cover;
	object-position: center;
	height: 300px;
	width: 300px;
}
</style>
</head>
<body>
	<!-- 【N６】 -->
	<p>
		<a href="upload">アップロード</a>
	</p>
	<h1>画像ギャラリー</h1>
	<a href=""></a>
	<div class="flex">
		<!-- 【N８】 -->
		<c:forEach items="${imageList}" var="img">
			<a href="detail?id=${img.id}"> <!-- fileが持っているgetName()メソッドが呼び出される -->
				<img src="upload/${img.imageName}">
				<p>${img.title}</p>
			</a>
		</c:forEach>
	</div>


</body>
</html>