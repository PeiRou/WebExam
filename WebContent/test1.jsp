<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Bootstrap Core CSS -->
    <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">

<link rel='stylesheet' href='<%= request.getContextPath() %>/css/icon/src/font/typicons.min.css' />

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ext-5.1.1/packages/ext-theme-classic/build/resources/ext-theme-classic-all.css" />
<!-- GC -->
<style type="text/css">
        .employee-add {
            background-image: url('../shared/icons/fam/user_add.gif') !important;
        }

        .employee-remove {
            background-image: url('../shared/icons/fam/user_delete.gif') !important;
        }
    </style>
</style> 
<script type="text/javascript" src="<%=request.getContextPath()%>/ext-5.1.1/ext-all.js"></script>
<script type="text/javascript" src="row-editing.js"></script> 
<script type="text/javascript"></script>
</head>
<body>
  <h1>Row Editing Grid Example</h1>
  <span class="typcn typcn-home"></span> 
<a class="btn btn-small" href="#"><i class="typcn icon-star"></i> Star</a>
<a class="btn btn-mini" href="#"><i class="icon-star"></i> Star</a>
  <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
    <p>This example shows how to create a grid with inline row based editing using the row editing plugin.</p>
    <p>Note that the js is not minified so it is readable. See <a href="row-editing.js">row-editing.js</a>.</p>
        
    <div id="editor-grid"></div>
    
</body>
</html>