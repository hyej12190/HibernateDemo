/**
 * Function readme
 * * It is normal
 * ! This is important
 * ? This is a function
 * TODO add a log later
 * @param name the name of the param
 */

// function showClickMe() {
//     alert("You click me!");
//   }
  
function getUser() {
  $.ajax({
    type: "GET",
    url: "/users",
    async: true,
    success: function(data) {
      let html = '<div style="float:right; font-weight: bold; font-size: 16px;" >count : ' + data.length + '</div>'
                + '<div> </div>'
                + '<div style="float:right;"><button type = "" id = "delete" value = "delete">delete</button></div>'
                + '<table><tr><th>Index</th><th>ID</th><th>PWD</th><th>LAST</th><th>FIRST</th><th>GROUP CD</th><th>GROUP NM</th></tr>';
      for (let index = 0; index < data.length; index++) {
        const element = data[index];

        // const group = element.userGroup
        // const group_CD = group.group_CD
        // const group_NM = group.group_NM

        html += '<tr><td><input type="checkbox" name="delete"/></td>'
              +'<td>' + element.id + '</td>' 
              + '<td>' + element.pwd + '</td>'
              + '<td>' + element.last + '</td>'
              + '<td>' + element.first + '</td>'
              + '<td>' + element.userGroup.group_CD + '</td>'
              + '<td>' + element.userGroup.group_NM + '</td><tr>'
      }
      html += + '</table>';
      $("#userTable").append(html);
    },
    error: function(xhr, status, error) {},
    complete: function(data) {}
  });
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

function deleteUser(){
  $.ajax({  


  });
}

window.onload = function() {
  // document.getElementById("photo1").addEventListener("click", showClickMe);
  // document.getElementById("photo2").addEventListener("click", getUser);

  document.getElementById("showUsers").addEventListener("click", getUser);
  // document.getElementById("delete").addEventListener("click", deleteUser);

  // getUser();
  getUserGroup();
};




// =============================


// /**
//  * Function readme
//  * * It is normal
//  * ! This is important
//  * ? This is a function
//  * TODO add a log later
//  * @param name the name of the param
//  */

// function showClickMe() {
//     alert("You click me!");
//   }
  
//   function getUser() {
//     $.ajax({
//       type: "GET",
//       url: "/users",
//       async: true,
//       success: function(data) {
//         let html = '<div style="float:right; font-weight: bold; font-size: 16px;" >count : ' + data.length + '</div>'
//                  + '<table><tr><th>ID</th><th>PWD</th><th>LAST</th><th>FIRST</th><th>GROUP CD</th><th>GROUP NM</th></tr>';
//         for (let index = 0; index < data.length; index++) {
//           const element = data[index];
  
//           html += '<tr><td>' + element.id + '</td>' 
//                 + '<td>' + element.pwd + '</td>'
//                 + '<td>' + element.last + '</td>'
//                 + '<td>' + element.first + '</td>'
//                 + '<td>' + element.group_CD + '</td>'
//                 + '<td>' + element.group_NM + '</td><tr>'
//         }
//         html += + '</table>';
//         $("#userTable").append(html);
//       },
//       error: function(xhr, status, error) {},
//       complete: function(data) {}
//     });
//   }
  
//   function getUserGroup() {
//     $.ajax({    
//       type: "GET",
//       url: "/userGroup",
//       async: true,
//       success: function(data) {
//         let html = '<select id="group" name="group">';
//         for (let index = 0; index < data.length; index++) {
//           const element = data[index];
  
//           html += '<option value="' + element.group_CD + '">' + element.group_NM + '</option>'
//         }
//         html += + '</select>';
//         $("#userGroup").append(html);
//       },
//       error: function(xhr, status, error) {},
//       complete: function(data) {}
//     });
//   }
  
//   window.onload = function() {
//     document.getElementById("photo1").addEventListener("click", showClickMe);
//     document.getElementById("photo2").addEventListener("click", getUser);
  
//     getUserGroup();
//   };
  