<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">

	var a;
	var alist;
	$(document).ready(function(){
		$.ajax({
			url : "http://203.236.209.217:8070/inp/getmyJsonp", 
		/* 	url : "/inp/getmyJsonp", */
			/* url : "/mysts01/getJsonByMap", */
			dataType: "jsonp",
			jsonp : "callback",
			jsonpCallback: "my",
			success : function(msg) {
				alist=msg.result_list;
				for(var i=0; i< alist.length; i++)
					{
						table_td='';
						table_td = '<tr><td>' + alist[i].ID + '</td>'
								+ '<td>' + alist[i].Name + '</td>'
								+ '<td>' + alist[i].CountryCode + '</td>'
								+ '<td>' + alist[i].District + '</td>'
								+ '<td>' + alist[i].Population + '</td></tr>';
						$("#test_table").append(table_td);
					}//for
			},
			error:function(jqXHR,textStatus){
                alert(textStatus +":"+jqXHR.status);
            }
		});
	});
</script>

</head>
<body>
	<h1> MySQL TEST</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>CotCode</th>
			<th>Dist</th>
			<th>Popul</th>
		</tr>
		<tbody id="test_table">
		</tbody>
	</table>
</body>
</html>