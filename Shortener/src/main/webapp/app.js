$(document).ready(function() {
	$(function () { $("input,select,textarea").not("[type=submeter]").jqBootstrapValidation(); } );
	
	carregarGrid();	
	
	
});

//http://jsfiddle.net/8svjf80g/1/
function carregarGrid(){
	$.ajax({
		url : 'http://localhost:8080/dashaboard',			
		type : 'GET',
		dataType: 'json',
		success : function(datas, textStatus) {			
			    
				$('#table').bootstrapTable({
			        data: datas
			    });			
		}
	});
}

function ajaxBuscaStatus() {
	
	var server = 'http://localhost:8080';
	var method = $('#methodId').val();
	var urlParam = $('#urlId').val();
	var aliasParam = $('#aliasId').val();
	var responseData = $('#responseService').val();
	
	var urlAjax ='';
	var dataAjax ='';
	var postOrGet = '';
	
	
	if(method=='P'){
		postOrGet = 'POST';
		urlAjax = server += '/create' ;
		dataAjax = "url="+urlParam;
		if(aliasParam!=""){
			dataAjax = dataAjax += "alias=";
			dataAjax = dataAjax += aliasParam;
		}		
	}
	
	if (method == 'G') {
		postOrGet = 'GET';
		urlAjax = server += '/retrive' ;
		dataAjax = "alias=" ;
		dataAjax = dataAjax += aliasParam;
	}
	
	if (method=='GT') {
		postOrGet = 'GET';
		urlAjax = server += '/dashaboard' ;
	}
	
	

	$.ajax({
		url : urlAjax,
		data : dataAjax,
		type : postOrGet,
		success : function(data, textStatus) {
			var ret = JSON.stringify(data,null, 4);			
			$('#responseService').val(ret);
		},
		error : function(data, textStatus) {
			var ret = JSON.stringify(data,null, 4);			
			$('#responseService').val(ret);
		}
	});
	carregarGrid();
}

function limpar() {
	$('#typeMethod').val("");
	$('#urlId').val("");
	$('#aliasId').val("");
	$('#responseService').val("");	
	carregarGrid();
}

function habiliadesabilita(){
	var urlParam = $('#urlId').val();
	var aliasParam = $('#aliasId').val();
	var method = $('#methodId').val();
	
	if(method=='P'){
		$("#urlId").prop('disabled',false);
		$("#aliasId").prop('disabled',false);
		$("#urlId").attr("required", true);
	}
	if(method=='G'){
		$("#urlId").prop('disabled',true);
		$("#aliasId").prop('disabled',false)
		$("#aliasId").attr("required", true);
		$("#urlId").attr("required", false);
	}
	
	if(method=='GT'){
		$("#urlId").prop('disabled',true);
		$("#aliasId").prop('disabled',true)
		$("#aliasId").attr("required", false);
		$("#urlId").attr("required", false);
	}	
}

function LinkFormatter(value, row, index) {
	  return "<a href='http://localhost:8080/retrive?alias="+row.alias+"' target='_blank'>"+value+"</a>";
	}

