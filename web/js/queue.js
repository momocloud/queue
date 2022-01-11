
const q_id = document.getElementById("qID").value;
const userIdentity = document.getElementById("identity").value;
loadTable();


function loadTable(){
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "/queueStatus/" + q_id,true);
    xhttp.send();

    xhttp.onload = function () {
        let json = JSON.parse(xhttp.responseText);
        constructTable(json)
    }

    setTimeout(loadTable, 500)
}


function deleteTask(id){
    console.log(id)
    const xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "/delete/" + id);
    xhttp.send();
}

function constructTable(json){
    let tableLength = Object.keys(json).length
    let joinTime;
    if (tableLength === 0) {
        document.getElementById("table").innerHTML = "<h1>The queue is empty now</h1>";
    } else {
        // common headers
        var table = "<table>" + "<tr>" +
            "<th>Rank</th>" +
            "<th>User</th>" +
            "<th>Location</th>" +
            "<th>Comment</th>" +
            "<th>Time</th>"

        // if the user is admin
        if(q_id === userIdentity){
            table += "<th class='controlButton'></th></tr>"

            for (let i = 0; i < tableLength; i++) {
                joinTime = parseInt((new Date() - new Date(json[i].joinTime)) / 60000)
                let timeUnit = " minute(s) before";

                if (joinTime === 0) {
                    joinTime = parseInt((new Date() - new Date(json[i].joinTime)) / 1000)
                    timeUnit = " second(s) before";
                }
                table += "<tr><td>" + (i+1) +
                    "</td><td>" + json[i].userName +
                    "</td><td>" + json[i].location +
                    "</td><td>" + json[i].comment +
                    "</td><td>" + joinTime + timeUnit +
                    "</td><td class='controlButton'>" + "<BUTTON class='deleteBtn' onclick='deleteTask(\"" + json[i].id + "\")'><i class=\"fa fa-close\"></i></BUTTON>" +
                    "</td><tr>";

                // document.getElementById ("btnsave").addEventListener ("click", task, false);
            }
        }
        //if the user is regular user
        else {
            table += "</tr>"

            for (let i = 0; i < tableLength; i++) {
                joinTime = parseInt((new Date() - new Date(json[i].joinTime)) / 60000)
                let timeUnit = " minute(s) before";
                if (joinTime === 0) {
                    joinTime = parseInt((new Date() - new Date(json[i].joinTime)) / 1000)
                    timeUnit = " second(s) before";
                }
                table += "<tr><td>" + (i+1) +
                    "</td><td>" + json[i].userName +
                    "</td><td>" + json[i].location +
                    "</td><td>" + json[i].comment +
                    "</td><td>" + joinTime + timeUnit +
                    "</td><tr>";
            }

        }
        // let table = "<table>" + "<tr>" +
        //     "<th>Rank</th>" +
        //     "<th>User</th>" +
        //     "<th>Location</th>" +
        //     "<th>Comment</th>" +
        //     "<th>Time</th></tr>"
        table += "</table>"
        document.getElementById("table").innerHTML = table;
    }


}

function joinAndLeaveQueue(){
    const button = document.getElementById("joinLeave")
    var comment = encodeURI(document.getElementById("comment").value);
    var location = encodeURI(document.getElementById("location").value);

    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "/submit/" + q_id, true);
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhttp.send("comment="+comment+"&location="+location);

    switch (button.getAttribute("value")){
        case "Join Queue":
            button.value ="Leave Queue";
            return;
        case "Leave Queue":
            button.value = "Join Queue";
            return;
    }
    loadTable();
}
