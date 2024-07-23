/**
 * 
 */

var instructorTable=[
    {
        "firstname": "John",
        "lastname": "Doe",
        "Department": "Computer Science",
        "Age": 40,
        "DOJ": "2020-01-15",
        "Salary": "$100,000",
        "Username": "JohnDoe"
    },
    {
        "firstname": "Jane",
        "lastname": "Smith",
        "Department": "Mathematics",
        "Age": 35,
        "DOJ": "2018-05-20",
        "Salary": "$90,000",
        "Username": "JaneSmith"
    },
    {
        "firstname": "Michael",
        "lastname": "Johnson",
        "Department": "Physics",
        "Age": 45,
        "DOJ": "2019-11-10",
        "Salary": "$110,000",
        "Username": "MichealJohnson"
    },
    {
        "firstname": "Alice",
        "lastname": "Williams",
        "Department": "Chemistry",
        "Age": 38,
        "DOJ": "2017-08-15",
        "Salary": "$95,000",
        "Username": "AliceWilliams"
    },
    {
        "firstname": "Robert",
        "lastname": "Anderson",
        "Department": "Biology",
        "Age": 42,
        "DOJ": "2016-04-25",
        "Salary": "$105,000",
        "Username": "RobertAnderson"
    },
    {
        "firstname": "Sarah",
        "lastname": "Miller",
        "Department": "English",
        "Age": 37,
        "DOJ": "2021-03-05",
        "Salary": "$85,000",
        "Username": "SarahMiller"
    },
    {
        "firstname": "David",
        "lastname": "Thompson",
        "Department": "History",
        "Age": 48,
        "DOJ": "2015-09-30",
        "Salary": "$120,000",
        "Username": "DavidThompson"
    },
    {
        "firstname": "Emily",
        "lastname": "Clark",
        "Department": "Art",
        "Age": 32,
        "DOJ": "2014-07-10",
        "Salary": "$80,000",
        "Username": "EmilyClark"
    },
    {
        "firstname": "James",
        "lastname": "Young",
        "Department": "Geography",
        "Age": 50,
        "DOJ": "2013-02-20",
        "Salary": "$130,000",
        "Username": "JamesYoung"
    },
    {
        "firstname": "Olivia",
        "lastname": "Adams",
        "Department": "Economics",
        "Age": 34,
        "DOJ": "2012-11-05",
        "Salary": "$75,000",
        "Username": "OliviaAdams"
    },
    {
        "firstname": "Peter",
        "lastname": "Parker",
        "Department": "Physics",
        "Age": 25,
        "DOJ": "2019-01-15",
        "Salary": "$70,000",
        "Username": "PeterParker"
    },
    {
        "firstname": "Tony",
        "lastname": "Stark",
        "Department": "Engineering",
        "Age": 35,
        "DOJ": "2015-05-20",
        "Salary": "$150,000",
        "Username": "TonyStark"
    },
    {
        "firstname": "Steve",
        "lastname": "Rogers",
        "Department": "History",
        "Age": 100,
        "DOJ": "1945-05-08",
        "Salary": "$80,000",
        "Username": "SteveRogers"
    },
    {
        "firstname": "Bruce",
        "lastname": "Wayne",
        "Department": "Political Science",
        "Age": 45,
        "DOJ": "1992-01-01",
        "Salary": "$200,000",
        "Username": "BruceWayne"
    },
    {
        "firstname": "Clark",
        "lastname": "Kent",
        "Department": "Journalism",
        "Age": 35,
        "DOJ": "2000-06-01",
        "Salary": "$120,000",
        "Username": "BruceWayne"
    },
    {
        "firstname": "Diana",
        "lastname": "Prince",
        "Department": "International Relations",
        "Age": 50,
        "DOJ": "2000-06-01",
        "Salary": "120,000",
        "Username": "DianaPrince"
    },
    {
        "firstname": "Bruce",
        "lastname": "Banner",
        "Department": "Environmental Science",
        "Age": 45,
        "DOJ": "2012-05-04",
        "Salary": "$95,000",
        "Username": "BruceBanner"
    },
    {
        "firstname": "Wade",
        "lastname": "Wilson",
        "Department": "Chemistry",
        "Age": 35,
        "DOJ": "2016-02-14",
        "Salary": "$90,000",
        "Username": "WadeWilson"
    },
    {
        "firstname": "Arthur",
        "lastname": "Curry",
        "Department": "Marine Biology",
        "Age": 30,
        "DOJ": "2018-12-01",
        "Salary": "$85,000",
        "Username": "AurthurCurry"
    },
    {
        "firstname": "Barry",
        "lastname": "Allan",
        "Department": "Forensic Science",
        "Age": 30,
        "DOJ": "2014-03-13",
        "Salary": "$80,000",
        "Username": "BarryAllen"
    }
]

function readAll()
{
    localStorage.setItem("object",JSON.stringify(instructorTable))
    var dataTable=document.getElementById('instructorsTable');
    var object=localStorage.getItem('object');
    var dataTableData=JSON.parse(object)
    var elements="";
    dataTableData.map(record=>(
        elements+=`<tr>
        <td>${record.firstname}</td>
        <td>${record.lastname}</td>
        <td>${record.Department}</td>
        <td>${record.Age}</td>
        <td>${record.Age}</td>
        <td>${record.DOJ}</td>
        <td>${record.Salary}</td>
        <td>${record.Username}</td>
        <td><button><img src="../images/pencil-square.svg" alt="Edit" class="action-icon edit-icon pr-1" data-toggle="modal" data-target="#editModal"></button></td>
        <td><button onclick="deleteRow()"><img src="../images/trash3-fill.svg" alt="Delete" id="del" onclick="deleteRow()"></button></td>
        `
    )
    )
    dataTable.innerHTML=elements;
}

$(document).ready(function() {
    $('#instructorsTable').DataTable();
});

$('.edit-icon').click(function() {
    // Get the row data
    var row = $(this).closest('tr');
    var data = row.children('td').map(function() {
        return $(this).text();
    }).get();

    // Populate modal fields
    $('#editFirstName').val(data[0]);
    $('#editLastName').val(data[1]);
})

function deleteRow(id)
{
    var conf =confirm("do you really want to delete this row ?")
    if(conf==true)
        {
            instructorTable.splice(id,1);
            readAll();
        }
}
function editRow(id)
{
    const record=instructorTable.filter(d=>d.id===id);
    //alert(JSON.stringify(record));
    alert(record.firstname)
}
function addRow()
{
    var firstname= document.getElementById('editFirstName');
    var lastname=document.getElementById('editLastName');
    var dept=document.getElementById('editDepartment');
    var age=document.getElementById('editAge');
    var DOJ=document.getElementById('editDateOfJoining');
    var salary=document.getElementById('editDateOfJoining');
    instructorTable.push({firstname:firstname,lastname:lastname,Department:dept,Age:age,DOJ:DOJ,Salary:salary})
}
