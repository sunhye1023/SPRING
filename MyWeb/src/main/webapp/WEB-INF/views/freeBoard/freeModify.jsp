<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>인덱스를 만들어 보자</title>

    <link href="${pageContext.request.contextPath }/resources/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!--개인 디자인 추가-->
    <link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
	

</head>
<body>
	<%@ include file="../include/header.jsp" %>
    <!--게시판-->
    <section>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-9 write-wrap">
                        <div class="titlebox">
                            <p>수정하기</p>
                        </div>
                        
                        <form action="freeUpdate" name="updateForm">
                            <div>
                                <label>DATE</label>
                                <p>2019-12-12</p>
                            </div>   
                            <div class="form-group">
                                <label>번호</label>
                                <input class="form-control" name='bno' value="${vo.bno }" readonly>
                            </div>
                            <div class="form-group">
                                <label>작성자</label>
                                <input class="form-control" name='writer' value="${vo.writer }">
                            </div>    
                            <div class="form-group">
                                <label>제목</label>
                                <input class="form-control" name='title' value="${vo.title }">
                            </div>

                            <div class="form-group">
                                <label>내용</label>
                                <textarea class="form-control" rows="10" name='content'>${vo.content }</textarea>
                            </div>

                            <button type="button" class="btn btn-dark" onclick="location.href='freeList'">목록</button>    
                            <button type="button" class="btn btn-primary" id="updateBtn">변경</button>
                            <button type="button" class="btn btn-info" id="deleteBtn">삭제</button>
                    </form>
                                    
                </div>
            </div>
        </div>
        </section>
        
        <%@ include file="../include/footer.jsp" %>
        
        <script>
        	var updateBtn = document.getElementById("updateBtn");
        	updateBtn.onclick = function() {
        		
        		/*
        		1. 폼에 데이터가 공백인지 확인처리
        		2. 공백이 없으면 Controller에 freeUpdate요청으로 데이터를 전송
        		3. Controller에서는 int update()메서드를 사용해서 정보를 수정
        		4. Controller에서는 업데이트 성공시, "게시글 수정이 정상 처리되었습니다"를 출력해주세요
        		*/
        		if(document.updateForm.bno.value === '') {
    				alert("번호를 입력하세요");
    				document.updateForm.bno.focus();
    				return;
    			} else if(document.updateForm.writer.value === '') {
    				alert("작성자를 입력하세요");
    				document.updateForm.writer.focus();
        		} else if(document.updateForm.title.value === '') {
    				alert("제목을 입력하세요");
    				document.updateForm.title.focus();	
    				return;
    			} else if(document.updateForm.content.value === '') {
    				alert("내용을 입력하세요");
    				document.updateForm.content.focus();
    				return;
    			} else {
    				document.updateForm.submit();    				
    			}

        	}

        	
        	var deleteBtn = document.getElementById("deleteBtn");
        	deleteBtn.onclick = function() {
        		var bno = document.getElementsByName("bno").value;
        		/* console.log(bno); */
        		location.href="freeDelete?bno="+bno;
        		
        	}
        		
        </script>
        
</body>
</html>