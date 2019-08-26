/**
 * showactors 作用就是，把页面静态组件的动态变化事件写在JS里，比如数据的加载，或者是保存啊，删除啊，这些动态的
 */
 $(document).ready(function(){
 var grid =$("#grid-data").bootgrid({
	 //拿到这个列表，然后给这个列表定义一个打开这个页面就要去做的事情，这个页面出来的一瞬间就要去干的事情
     ajax:true,
	 //所以这里就发一个AJAX请求，去JAVA端获取相应的数据
     url:"/actors",
     ajaxSettings: {
         method: "GET",
         cache: false
     },
     formatters: {
         "commands": function(column, row)
         {
             return "<button type=\"button\" class=\"btn btn-xs btn-default command-edit\" data-row-id=\"" + row.actor_id + "\">编辑<span class=\"glyphicon glyphicon-pencil\"></span></button> "
                 +"<button type=\"button\" class=\"btn btn-xs btn-default command-delete\" data-row-id=\'" + row.actor_id + "\'>删除<span class=\"glyphicon glyphicon-trash\"></span></button> ";
         }
     }
 }).on("loaded.rs.jquery.bootgrid", function()//前面的这个AJAX方法从JAVA端拿到数据后，就要调用这个ON方法，ON方法的作用就是把前面
 //你拿到的数据，给你塞到这个表格中去，至于ON里面写的东西，是固定语法，不用深究
	{
    /* Executes after data is loaded and rendered */
	    grid.find(".command-edit").on("click", function(e)
	    {
	        $(".actormodal").modal();
	        $.get("/actors/"+$(this).data("row-id"),function(str){
	        	$("#fname").val(str.first_name);
	        	$("#lname").val(str.last_name);
	        	$("#lupdate").val(str.last_update);
	        	$("#actorid").val(str.actor_id);
	        });
	    }).end().find(".command-delete").on("click", function(e)
		    {
		        $.ajax({  
			        url : "/actors/"+$(this).data("row-id"),  
			        type : "DELETE",  
			        success : function(result) { 
			        	alert("删除成功");
		        		$("#grid-data").bootgrid("reload");
		        		}
		    	});
		    	});
		    	});
  
 
  		$("#add").click(function(){
  	 		$(".addmodal").modal();
  	 	});
  	 	
  	 	 $("#lupdate").datetimepicker({
  	 	 format: 'yyyy-mm-dd hh:ii:ss',
  	 	 autoclose: true
  	 	 });
  	 	 $("#lupdate").datetimepicker('setStartDate', '2012-01-01 0:0:0');
  	 	 
  	 	 $("#lupdate2").datetimepicker({
  	 	 format: 'yyyy-mm-dd hh:ii:ss',
  	 	 autoclose: true
  	 	 });
  	 	 $("#lupdate2").datetimepicker('setStartDate', '2012-01-01 0:0:0');
  });
 