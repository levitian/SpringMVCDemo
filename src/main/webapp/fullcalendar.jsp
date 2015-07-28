<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset='utf-8' />
<link href='${pageContext.request.contextPath}/css/fullcalendar.css' rel='stylesheet' />
<link href='${pageContext.request.contextPath}/css/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='${pageContext.request.contextPath}/js/moment.min.js'></script>
<script src='${pageContext.request.contextPath}/js/jquery.min.js'></script>
<script src='${pageContext.request.contextPath}/js/jquery-ui.custom.min.js'></script>
<script src='${pageContext.request.contextPath}/js/fullcalendar.min.js'></script>
<script src='${pageContext.request.contextPath}/js/lang-all.js'></script>
<script>
	function insertUsers(){
		$.ajax({ 
        	type: "GET", 
        	url: "/SpringMVCDemo/user/lists", 
        	dataType: "json", 
        	async: false,
        	success: function (data) { 
            	var da = data;
            	var context = "";
            	for(var i=0;i<da.length;i++){
            		context += '<div class="fc-event ui-draggable ui-draggable-handle" uid="' + da[i].userId + '">' + da[i].username + '</div>';
            	}
            	$("#external-events h4").after(context);
           	}, 
           	error: function (XMLHttpRequest, textStatus, errorThrown) { 
                   alert(errorThrown); 
           	} 
	    });
	}
	function updateEvent(event){
		if(confirm("确定要修改数据吗")){
			var start = event.start.format();
			var end = start;
			if(event.end != null){
				end = event.end.format();
			}
			$.ajax({ 
	        	type: "POST", 
	        	url: "/SpringMVCDemo/event/update",
	        	data:{"id":event.id, "title":event.title, "uid":event.uid, "start":start, "end":end},
	        	dataType: "json", 
	        	async: false,
	        	success: function (data) { 
					//XXX renderEvent
					//location.reload();
	        	}, 
	           	error: function (XMLHttpRequest, textStatus, errorThrown) { 
	                alert(errorThrown); 
	           	} 
		    });
	    }
	}
	$(document).ready(function() {
		
		insertUsers();

		/* initialize the external events
		-----------------------------------------------------------------*/

		$('#external-events .fc-event').each(function() {

			// store data so the calendar knows to render an event upon drop
			$(this).data('event', {
				title: $.trim($(this).text()), // use the element's text as the event title
				stick: true, // maintain when user navigates (see docs on the renderEvent method)
			});

			// make the event draggable using jQuery UI
			$(this).draggable({
				zIndex: 999,
				revert: true,      // will cause the event to go back to its
				revertDuration: 0  //  original position after the drag
			});

		});


		/* initialize the calendar
		-----------------------------------------------------------------*/
		var uid = 0;
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
//				right: 'month,agendaWeek,agendaDay'
				right: 'month'
			},
			lang: 'zh-cn',
			editable: true,
			droppable: true, // this allows things to be dropped onto the calendar
			drop: function() {
				// is the "remove after drop" checkbox checked?
				if ($('#drop-remove').is(':checked')) {
					// if so, remove the element from the "Draggable Events" list
					$(this).remove();
				}
				uid = Number($(this).attr("uid"));
			},
			eventReceive:function( event ) { //Called when an external element, containing event data, is dropped on the calendar.
				var start = event.start.format();
				var end = start;
				if(event.end != null){
					end = event.end.format();
				}
				$.ajax({ 
		        	type: "POST", 
		        	url: "/SpringMVCDemo/event/add",
		        	data:{"title":event.title, "uid":uid, "start":start, "end":end},
		        	dataType: "json", 
		        	async: false,
		        	success: function (data) { 
						//XXX renderEvent
						location.reload();
		        	}, 
		           	error: function (XMLHttpRequest, textStatus, errorThrown) { 
		                   alert(errorThrown); 
		           	} 
			    });
			},
			eventClick:function(event, element){
				console.log(event);	
				//alert('a event has been clicked!');
				if(confirm("确定要删除数据吗")){
					$.ajax({ 
			        	type: "POST", 
			        	url: "/SpringMVCDemo/event/delete/" + event._id,
			        	dataType: "json", 
			        	async: false,
			        	success: function (data) { 
			        		$('#calendar').fullCalendar( 'removeEvents', event._id);
			        	}, 
			           	error: function (XMLHttpRequest, textStatus, errorThrown) { 
			                   alert(errorThrown); 
			           	} 
				    });
			    }
			},
			dayClick: function(event, jsEvent, view) {
				console.log(event);
	        	alert('a day has been clicked!');
	    	},
	    	eventDrop: function(event, delta, revertFunc) {
				console.log(event);
		/*         alert(event.title + " was dropped on " + event.start.format());
		
		        if (!confirm("Are you sure about this change?")) {
		            revertFunc();
		        } */
		        updateEvent(event);
		
		    },
		    eventResize:function( event, jsEvent, ui, view ) { 
		    	//alert("eventResizeStop---:" + event.title + " was dropped on " + event.start.format());
		    	updateEvent(event);
		    },
			eventSources: [
                {
                    url: '/SpringMVCDemo/event/list',
                    type: 'GET',
                    data: {},
                    error: function() {
                        alert('数据读取发生错误！');
                    }
                }
            ]
		});
	});

</script>
<style>

	body {
		margin-top: 40px;
		text-align: center;
		font-size: 14px;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
	}
		
	#wrap {
		width: 1100px;
		margin: 0 auto;
	}
		
	#external-events {
		float: left;
		width: 150px;
		padding: 0 10px;
		border: 1px solid #ccc;
		background: #eee;
		text-align: left;
	}
		
	#external-events h4 {
		font-size: 16px;
		margin-top: 0;
		padding-top: 1em;
	}
		
	#external-events .fc-event {
		margin: 10px 0;
		cursor: pointer;
	}
		
	#external-events p {
		margin: 1.5em 0;
		font-size: 11px;
		color: #666;
	}
		
	#external-events p input {
		margin: 0;
		vertical-align: middle;
	}

	#calendar {
		float: right;
		width: 900px;
	}

</style>
</head>
<body>
	<div id='wrap'>

		<div id='external-events'>
			<h4>值班人员列表</h4>
<!-- 			<p>
				<input type='checkbox' id='drop-remove' />
				<label for='drop-remove'>排班后删除</label>
			</p> -->
			<p></p>
		</div>

		<div id='calendar'></div>

		<div style='clear:both'></div>

	</div>
</body>
</html>
