<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 【N1】 -->
	<h1>画像アップロード</h1>
	<!-- enctype="multipart/form-data"は必須！ -->
	<form action="" method="post" enctype="multipart/form-data">
		タイトル:
		<input type="text" name="title">
		<input type="file"name="upfile">
		<input type="hidden" name="id" value="1"/>
		<input type="submit">
	</form>

	<!-- 【N５】 -->
	<c:if test="${!empty error}">
		<p>
			<c:out value="${error}" />
		</p>
	</c:if>

	<p>
		<a href="gallery">ギャラリー</a>
	</p>

</body>
</html>