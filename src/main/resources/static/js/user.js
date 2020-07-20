let index = { // 변수는 let쓰고 /index라는 obeject만들었다.
		init : function(){
			//console.log(this); // 인덱스
			//let _this=this;
			$("#btn-save").on("click", ()=>{ // 리스너가 계속 지켜보고 있음.
				console.log(this); // 버튼
				this.save();
			});
					
		},

		save : function(){
			let data = {
					username:$('#username').val(),
					password:$('#password').val(),
					email:$('#email').val()
			};
			$.ajax({
				type: "POST",
				url:"/auth/joinProc",
				data:JSON.stringify(data), // JSON으로 바껴서 날라감.
				contentType: "application/json; charset=utf-8",
				dataType: "json" /* 서버로 부터 응답받을 때 데이터 타입 */
			}).done((resp)=>{
				if(resp.statusCode == 1){ //테이블에 잘 들어갔다.
					alert("회원가입이 성공");
					location.href="/";
				}
				console.log(resp);
				//console.log(JSON.parse(resp));
			}).fail(function(error){
				console.log(error);
			}) // fetch 써도 됨.
		}
		
		

}
index.init();

// 한 페이지 안에 있는거 한 object에 다 추가 해두면 함수명 충돌날 일도 없고 좋아요.
