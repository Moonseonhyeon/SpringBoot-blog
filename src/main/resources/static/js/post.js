let index = { // 변수는 let쓰고 /index라는 obeject만들었다.
		init : function(){
			//여기 등록되는게 리스너임 
			//console.log(this); // 인덱스
			//let _this=this;
			//여기 등록되는게 리스너임 1번 리스너
			$("#btn-save").on("click", ()=>{ // 리스너가 계속 지켜보고 있음.
				//callback 스택	
				console.log(this); // 버튼
				this.save();
			});
			
			$("#btn-delete").on("click", ()=>{ // 리스너가 계속 지켜보고 있음.
				//callback 스택	
				console.log(this); // 버튼
				this.deleteById();
			});
			
			$("#btn-update-mode").on("click", ()=>{ // 리스너가 계속 지켜보고 있음.
				//callback 스택	
				console.log(this); // 버튼
				this.updateMode();
			});
			
			$("#btn-update").on("click", ()=>{ // 리스너가 계속 지켜보고 있음.
				//callback 스택	
				console.log(this); // 버튼
				this.update();
			});
			$("#btn-update").hide();
			
			
		},

		save : function(){
			let data = {
					title:$('#title').val(),
					content:$('#content').val(),
					userId:$('#userId').val()
			};
			
			$.ajax({
				type: "POST",
				url:"/post", //insert
				data:JSON.stringify(data), // JSON으로 바껴서 날라감.
				contentType: "application/json; charset=utf-8",
				dataType: "json" /* 서버로 부터 응답받을 때 데이터 타입 */
			}).done((resp)=>{
				console.log(resp);
					alert("글쓰기 성공");
					location.href="/";
				
				console.log(resp); //commentRespDto가 resp로 쏙 들어온다
				//console.log(JSON.parse(resp));
			}).fail(function(error){
				alert("글쓰기 실패");
				console.log(error);
			}) // fetch 써도 됨.
		},
		
		deleteById : function(){
			let data = {
					id:$('#id').val(),
					
			};
			
			$.ajax({
				type: "DELETE",
				url:"/post/"+data.id, //insert
				data:JSON.stringify(data), // JSON으로 바껴서 날라감.
				dataType: "json" /* 서버로 부터 응답받을 때 데이터 타입 */
			}).done((resp)=>{
				console.log(resp);
					alert("삭제 성공");
					location.href="/";
				
				console.log(resp); //commentRespDto가 resp로 쏙 들어온다
			}).fail(function(error){
				alert("삭제 실패");
				console.log(error);
			}) // fetch 써도 됨.
		},
		
		updateMode : function(){
			$("#btn-update-mode").hide();
			$("#btn-update").show();
			
			$("#title").attr("readOnly", false);
			$("#content").attr("readOnly", false);
			
		},
		
		update : function(){
			let data = {
					id:$('#id').val(),
					title:$('#title').val(),
					content:$('#content').val(),					
			};
			
			$.ajax({
				type: "PUT",
				url:"/post/"+data.id, //insert
				data:JSON.stringify(data), // JSON으로 바껴서 날라감.
				contentType: "application/json; charset=utf-8",
				dataType: "json" /* 서버로 부터 응답받을 때 데이터 타입 */
			}).done((resp)=>{
				console.log(resp);
					alert("수정 성공");
					location.href="/post/"+data.id;
				
				console.log(resp); //commentRespDto가 resp로 쏙 들어온다
				//console.log(JSON.parse(resp));
			}).fail(function(error){
				alert("수정 실패");
				console.log(error);
			}) // fetch 써도 됨.
		},
			
}
index.init();

// 한 페이지 안에 있는거 한 object에 다 추가 해두면 함수명 충돌날 일도 없고 좋아요.
