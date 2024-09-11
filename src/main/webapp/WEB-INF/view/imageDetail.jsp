<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	text-align: center;
}

.flex {
	width: 100%;
	display: flex;
	justify-content: center;
	flex-wrap: wrap;
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
	<div class="flex">
		<div>
			<img src="upload/${image.imageName}" alt="" />
			</th>
		</div>
		<div>
			<p>タイトル：${image.title}</p>
			<p>ユーザー：${image.userName}</p>
			<p>登録日：
			<fmt:formatDate value="${image.created}" pattern="y年M月d日 HH時mm分" />
			</p>
		</div>
	</div>
	<a href="gallery">一覧へ戻る</a>

</body>
</html>