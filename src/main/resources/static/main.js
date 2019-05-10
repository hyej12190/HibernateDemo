
function getUser() {
  
  let page = 0;

  $.ajax({
    type: "GET",
    url: "/users",
    async: true,
    data : {'page' : page},
    success: function(data) {

      const pageCount = data.totalPages

      let html = '<div style="float:right; font-weight: bold; font-size: 16px;" >count : ' + data.content.length + '</div><br>'
                + '<div style="float:right;">'
                + '<button id = "delete" value = "delete" onclick="checkDeleteUser()">delete</button>'
                + '</div>'
                + '<table><tr><th>Index</th><th>ID</th><th>PWD</th><th>LAST</th><th>FIRST</th><th>GROUP CD</th><th>GROUP NM</th></tr>';

      html = userTableData(data, html);
      
      $(window).scroll(function(){
        if($(window).scrollTop() >= $(document).height() - $(window).height()){
          page++;
          
          if (page < pageCount){
            $.ajax({
              type: "GET",
              url: "/users",
              async: true,
              data : {'page' : page},
              success: function(data, html){
                html += '<table>';
                html = userTableData(data, html);
  
              }
            });
          }
        }
      });
    },
    error: function(xhr, status, error) {},
    complete: function(data) {
    }
  });
}

function userTableData(data, html){
  for (let index = 0; index < data.content.length; index++) {
    const element = data.content[index];

    html += '<tr><td><input type="checkbox" id = "' + element.id + '" value = "' + element.id + '"/></td>'
          +'<td>' + element.id + '</td>' 
          + '<td>' + element.pwd + '</td>'
          + '<td>' + element.last + '</td>'
          + '<td>' + element.first + '</td>'
          + '<td>' + element.userGroup.group_CD + '</td>'
          + '<td>' + element.userGroup.group_NM + '</td><tr>'
  }
  $("#userTable").append(html);

  return html;
}


function getUserGroup() {
  $.ajax({    
    type: "GET",
    url: "/userGroup",
    async: true,
    success: function(data) {
      let html = '<select id="group" name="group">';
      for (let index = 0; index < data.length; index++) {
        const element = data[index];

        html += '<option value="' + element.group_CD + '">' + element.group_NM + '</option>'
      }
      html += + '</select>';
      $("#userGroup").append(html);
    },
    error: function(xhr, status, error) {},
    complete: function(data) {}
  });
}

function checkDeleteUser(){
  var id = $("input:checkbox:checked").val();
  
  if($("input:checkbox:checked").is(":checked") == true){
    $.ajax({
      type: "DELETE",
      url: "/deleteUser",
      data : {'id' : id},
      async: true,
      success: function(data){
        alert(id + ' Delete Success');
      },
      error: function(xhr, status, error) {
        alert(id + ' Delete fail');
      },
      complete: function(data) {}
    });
  } else {
    alert ('Delete user not found');
  }

}

window.onload = function() {
  document.getElementById("showUsers").addEventListener("click", getUser);

  getUserGroup();
};

