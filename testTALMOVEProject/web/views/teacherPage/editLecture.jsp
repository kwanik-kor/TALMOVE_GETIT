<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teacher.model.vo.Teacher,course.model.vo.Course, lecture.model.vo.Lecture, section.model.vo.Section, java.util.ArrayList, java.sql.Date" %>

<%
    ArrayList<Section> SectionList =  (ArrayList<Section>)request.getAttribute("sectionList");
	String teacherName = (String)request.getAttribute("teacherName");
	String courseName = (String)request.getAttribute("courseName");
	String courseDescription = (String)request.getAttribute("courseDescription");
	int courseNumber = (int)(request.getAttribute("courseNumber"));
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>탈무브 | <%= courseName %></title>
    <meta name="viewport" content="width:device-width, initial-scale=1.0">

    <link rel="stylesheet" href="/testt/vendors/css/normalize.css">
    <link rel="stylesheet" href="/testt/vendors/css/bootstrap-grid.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/testt/resources/css/style.css">
    <link rel="stylesheet" href="/testt/resources/css/common/footer.css">
    <link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
    <link rel="stylesheet" href="/testt/resources/css/queries.css">
    <link href="/testt/views/teacherPage/css/editLecture.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>
    <meta charset="UTF-8">
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/12.4.0/classic/ckeditor.js"></script>
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>
    <link type="text/css" rel="stylesheet" href="/testt/views/teacherPage/css/dist/dropzone.css">
    <script src="/testt/views/teacherPage/css/dist/dropzone.js"></script>
    
    <script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <script src="//fast.wistia.com/assets/external/api.js" async></script>
    
    <link rel="stylesheet" href="//fast.wistia.com/assets/external/uploader.css" />
    <script src = "https://fast.wistia.com/embed/medias/epo27h3ur4.jsonp" async></script>
            <script src="https://fast.wistia.com/assets/external/E-v1.js" async></script>
            
            
     




</head>

<body>
    <%@ include file="../common/gnb.jsp" %>

    <section id="outline">
        <div id="body_left">
            <div id="name_zone">
                <span><%= teacherName %></span>님의 수업 
                <input  type="hidden" id="pageCourseNo" value="<%= courseNumber %>">
                <div class="hiddeninven"  id="" style=hidden></div>
            </div>
            <div id="list">
                <div id="contents">
                    <div id="info_zone">
                        <div>
                            <span><%= courseName %></span>
                        </div>
                        <div id="lectureIntro">
                            <span>강좌 소개</span>
                        </div>
                    </div>
                    <% for(Section s : SectionList ){%>
                    <!--#1. 섹션 추가-->
                    <div class="sect_zone">
                        <div class="sect_name">
                            <input type="text" class="placeSectionName" placeholder="SECTION NAME" value=" <%= s.getSectionName() %>" readOnly>
                            <input type="hidden" class="insect-sectNo" value=" <%= s.getSectionNo() %>">
                            <div>
                                <button class="del-btn"><i class="fas fa-times"></i></button>
                                <button class="modi-btn"><i class="fa fa-pen"></i></0>
                            </div>
                        </div>
                        <!--#2. 클래스추가-->

                        <ul class="ajax-zone" id="<%= s.getSectionNo()%>">
                        </ul>


                        <div class="create_nclass">새 수업</div>
                    </div>
                    <!--#1-->

                    <script type="text/javascript">
                        $(function() {
                            $.ajax({
                                url: "/testt/test1.do",
                                data: {
                                    no: <%= s.getSectionNo() %>
                                },
                                type: "get",
                                dataType: "json",
                                success: function(data) {
                                    var jsonStr = JSON.stringify(data);
                                    var json = JSON.parse(jsonStr);
                                    for (var i in json.list) {
                                        $("ul#<%= s.getSectionNo()%>.ajax-zone").html($("ul#<%= s.getSectionNo()%>.ajax-zone").html() +
                                            '<li><input type="text" class="lectureNameShow" placeholder="CLASS NAME" value="' +
                                            decodeURIComponent(json.list[i].LectureName).replace(/\+/gi, " ") +
                                            '" readOnly><div class="inventory" id="' +
                                            json.list[i].LectureNo+
                                            '" ><button class="del-btn"><i class="fas fa-times"></i></button><button class="modi-btn"><i class="fa fa-pen"></i></button></div></li>');

                                    }

                                }
                            });
                        });
                    </script>


                    <%} %>
                </div>
              <div class="create_nsect" value="<%= courseNumber%>">
                    새강좌 생성
            </div>              
            </div>

        </div>

        <div id="body_right">
        
            <div id="blank_zone">
            <form id ="lectureDetail-info"  action="/testt/attach-upload.do" enctype="multipart/form-data">
                강의 편집
            </div>
            <input type="hidden" id="checkVideo" value="null" name="videoHash">
			<input type="hidden"  id="lectureNo" value="" name="lectureNo">
            <div id="videoUploadZone" ></div>

            
           <!--  <% // if ((String temp =%>$('#checkVideo').value()<% //) ==null) { %>  -->
            
               <script>
           		
                var videoHash = ""
                {
                    window._wapiq = window._wapiq || [];
                    _wapiq.push(function(W) {
                        window.wistiaUploader = new W.Uploader({
                            accessToken: "444b3a939c84d07c96a501e139b41e58f25f3ed09fb263f093f6ed2dcc7520c4",
                            dropIn: "videoUploadZone",
                            projectId: "yl105easn1",
                            beforeUpload: function() {
                                wistiaUploader.setFileName('myfile');
                            }

                        });
                        wistiaUploader.bind('uploadsuccess', function(file, media) {
                            $("#videoUploadZone").val(function mo(){
                            	videoHash=media.id;
                            	$("#checkVideo").val(videoHash);
                            	console.log("업로드완료");
                            });
                        });
                    });
                }
				</script>	
 
           				

            <div>
                <textarea name="content" id="editor" placeholder="WELCOME TO TALMOVE!" >
				</textarea>
            </div>
            
            <div id="document-zone">
	               <span>첨부파일</span>
		              <div id="attach-docu">
							

		                <input id="file" name="file" type="file" >
	               </div>
			             

            </div>
            <div id="page-save">
            <input type="button" id="saveLecture" value="SAVE">
            <script>
            	
		           	$("#saveLecture").click(function(){
			            	saveLecture();
                  });
                </script>
        </div>
            
       
        

        </div>

    </section>
    <div style="clear: both; height: 30px"></div>
    <%@ include file="../common/footer.jsp" %>
</body>

<script>
    window.onload=function(){
        createLecture();
        createSection();
        clickon();
        getLectureForm();
        editorGo();
	 };

    function editorGo(){
        ClassicEditor
            .create(document.querySelector('#editor'))
            .then(editor => {
                console.log(editor);
            })
            .catch(error => {
                console.error(error);
            });	
    	}


    function createLecture() {
        $('.create_nclass').click(function() {
            var sectionNo=$(this).prevAll(".sect_name").children('.insect-sectNo').val();
            var courseName="<%= courseName %>";
            var kt = '<li> <input type="text" placeholder="CLASS NAME" value="new class"readOnly>   <div class="inventory" id="k" >   <button class="del-btn"><i class="fas fa-times"></i></button>   <button class="modi-btn"><i class="fa fa-pen"></i></button> </div>  </li>' ;
            $(this).prev("ul").append(kt);
            $.ajax({
            		url: "/testt/createNewLecture.do",
                    data: {
                        no:sectionNo.trim(),
                        name:courseName
                    },
                    type: "get",
                    success: function(data) {
                    	
                    	console.log("받은 렉쳐값 :"+data);
         				$(".inventory[id='k']").attr("id",data);
                    	//decodeURIComponent(data.lectureContent).replace(/\+/gi, " ")
                    
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        console.log("error : " + textStatus);
                    }
                });
            clickon();
            getLectureForm();
        });
    }
    function saveLecture(){
	                        var formData = new FormData();
	                        formData.append("lectureNo", $("#lectureNo").val());
	                        console.log(formData.get("lectureNo"));
	                        formData.append("videoHash", $("#checkVideo").val());
	                        formData.append("content", $(".ck").children("p").html());
	                        formData.append("courseNumber",  <%= courseNumber %>);
	                        formData.append("file",$('input[name=file]')[0].files[0]);
	                        console.log(formData.get("videoHash"));
	                        console.log(formData.get("content"));
	                        console.log(formData.get("courseNumber"));
			            	$.ajax({
	                            url: "/testt/attach-upload.do",
	                           type: "post",
	                           enctype:"multipart/form-data",
	                           processData : false,    
	                           contentType : false,  
	                            data : formData,
	                            sucsess:function(){
	                                alert("저장성공");
	                            },
	                            error:function(error){
	                            	alert("파일업로드에 실패하였습니다. 재실행 해주세요");
	                            	console.log(error);
	                            	console.log(error.status);
	                            }
	                            });
    }

    function createSection() {
    	$('.create_nsect').click(function() {
    	 var kt ='<div class="sect_zone"><div class="sect_name"><input type="text" class="placeSectionName" placeholder="SECTION NAME" value="" readOnly>'
           		 	+'<input type="hidden" class="insect-sectNo" value="" >	'
          			+'<div><button class="del-btn"><i class="fas fa-times"></i></button><button class="modi-btn"><i class="fa fa-pen"></i></0></div></div>' 
        			+'<ul class="ajax-zone" id=""></ul><div class="create_nclass">새 수업</div></div>' ;
        $("#contents").append(kt);
        		$.ajax({
        	                url: "/testt/createNewSection.do",
        	                data: {
        	                    no: $("#pageCourseNo").val()
        	                    	},
        	                type: "get",
        	                success: function(data) {
        	                	$(".insect-sectNo").last().val(data);
        	                	console.log("sectionNo 삽입완료(data)");
        	                },error: function(jqXHR, textStatus, errorThrown) {
        	                    console.log("error : " + textStatus);
        	                }
    			});
        		clickon();
        		createLecture();
    	});
    }
    

    function clickon() {
        $('.modi-btn').click(function() {
                        alert("클릭입력");
            var sectionNumber = null;
            var lectureNumber = null;
            var currentName=$(this).parent().prevAll("inp   ut.placeSectionName").val();
            var afterName="";
            
            if ($(this).parent(".inventory").attr('id') != null) {
                lectureNumber = $(this).parent(".inventory").attr('id');
                sectionNumber = $(this).parent().prev('.insect-sectNo').val();
                
                $(this).parent().prevAll("input").attr("readOnly", false);
                $(this).parent().prevAll("input").focus();
                $(this).parent().prevAll("input").attr("readOnly", false).keydown(function() {
                    if (event.which == 13) {
                    	afterName=$(this).val();
                        if (lectureNumber != null) {
                        	currentName= $(this).val()
                        	renameLecture(lectureNumber,currentName);
                        }
                        $(this).attr("readOnly", true);
                    };
              })
                clickon();
                getLectureForm();
            } else {
                sectionNumber = $(this).parent().prev('.insect-sectNo').val();
                $(this).parent().prevAll("input.placeSectionName").attr("readOnly", false);
                $(this).parent().prevAll("input.placeSectionName").focus();
                $(this).parent().prevAll("input.placeSectionName").attr("readOnly", false).keydown(function() {
                    if (event.which == 13) {
                    	afterName=$(this).val();
                        if (lectureNumber != null) {
                            //렉쳐넘버로 렉쳐명변경 ajax
                        } else {
                        	currentName= $(this).val();
                        	renameSection(sectionNumber,currentName);
                        }
                        $(this).attr("readOnly", true);
                    };
              })
            	clickon();
                getLectureForm();
            };
            function renameSection(sectionNumber,afterName){
	            $.ajax({
	                url: "/testt/sectionRename.do",
	                data: {
	                    no:sectionNumber.trim(),
	                    name:afterName
	                },
	                type: "get",
	                dataType: "json",
	                success: function(data) {
					}
                });
            }
            function renameLecture(lectureNumber,afterName){
            	 $.ajax({
 	                url: "/testt/lectureRename.do",
 	                data: {
 	                    no:lectureNumber.trim(),
 	                    name:afterName
 	                },
 	                type: "get",
 	                dataType: "json",
 	                success: function(data) {
 	                	alert("ajax성공");
                     }

                 });
            }
            });
            

        

        $('.del-btn').click(function() {
            var sectionNumber = null;
            var lectureNumber = null;
            if ($(this).parent(".inventory").attr('id') != null) {
                lectureNumber = $(this).parent(".inventory").attr('id')
            } else {
                sectionNumber = $(this).parent().prev('.insect-sectNo').val();
            }
            if (lectureNumber != null) {
                lectureDelete(lectureNumber);
            } else {
            	sectionDelete(sectionNumber); 
            	//하위 렉쳐 모두 삭제됨
            	
            }
            alert("dd");
            if ((this).closest("li")) {
                (this).closest("li").remove();
            } else {
                $(this).parents(".sect_zone").remove();
            }
            function lectureDelete(lectureNumber) {
                $(function() {
                    $.ajax({
                        url: "/testt/lectureDelete.do",
                        data: {
                            no: lectureNumber.trim()
                        },
                        type: "post",
                        error: function(jqXHR, textStatus, errorThrown) {
                            console.log("error : " + textStatus);
                        }
                    });
                });
            }
            function sectionDelete(sectionNumber) {
                $(function() {
                    $.ajax({
                        url: "/testt/sectionDelete.do",
                        data: {
                            no:sectionNumber.trim()
                        },
                        type: "post",
                        error: function(jqXHR, textStatus, errorThrown) {
                            console.log("error : " + textStatus);
                        }
                    });
                });
            }
            
       		
            getLectureForm();
    });
    }
	function getLectureForm(){
		$("li").click(function (){
			$.ajax({
				url: "/testt/getLectureByAjax.do",
				data: {no: $(this).children(".inventory").attr('id') },
				type: "get",
				dataType: "json",
				success: function(data){
						console.log($(".ck").html());
						$(".ck").children("p").html(decodeURIComponent(data.lectureContent).replace(/\+/gi, " "));
						$("#lectureNo").val(data.lectureNo);
						if(decodeURIComponent(data.lectureOFileName).replace(/\+/gi, " ") !='undefined' ){
								$("#checkVideo").val(decodeURIComponent(data.lectureOFileName).replace(/\+/gi, " "));
						}else{
						}
						console.log(decodeURIComponent(data.attachmentOfileName).replace(/\+/gi, " "));
						//$("#file").val(decodeURIComponent(data.attachmentOfileName).replace(/\+/gi, " "));
						//console.log(decodeURIComponent(data.attachmentOfileName).replace(/\+/gi, " "));
						//본문에 뿌려줌	//"'"+decodeURIComponent(data.lectureContent).replace(/\+/gi, " ")+"'"	
					//ck-blurred ck ck-content ck-editor__editable ck-rounded-corners ck-editor__editable_inline
				},
				error: function(jqXHR, textStatus, errorThrown){
					console.log("error : " + textStatus);
				}
			});
		});
		
	}

</script>




</html>