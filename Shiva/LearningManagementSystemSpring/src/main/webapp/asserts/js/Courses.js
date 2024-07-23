/**
 * 
 */
document.addEventListener('DOMContentLoaded', function() {
    var collapseOptions = document.querySelectorAll('.collapse-option');

    collapseOptions.forEach(function(option) {
        option.addEventListener('click', function(e) {
            e.preventDefault();
            var target = document.querySelector(option.dataset.target);
            var collapseContents = document.querySelectorAll('.collapse-content');

            collapseContents.forEach(function(content) {
                content.style.display = 'none';
            });

            if (target) {
                target.style.display = 'block';
            }
        });
    });
});

/*$(document).ready(function() {
    $('.collapse-option').click(function(e) {
        e.preventDefault();
        var target = $(this).data('target');
        $('.collapse-content').hide();
        $(target).show();
    });
});*/
 document.addEventListener('DOMContentLoaded', function() {
            var addCardButton = document.getElementById('addCardButton');
            var cardContainer = document.getElementById('cardContainer');

            addCardButton.addEventListener('click', function() {
                // Create a new card element
                var newCard = document.createElement('div');
                newCard.className = 'card';
                //newCard.textContent = 'This is a new card';
                newCard.innerHTML+=`
                <div class="col-sm-4 p-3 ">
                <div id="card" class="card shadow-sm p-3 d-flex" style="width:350px; display:flex">    
                            <div class="card-body">
                                <img src="../../asserts/images/book-half (1).svg" height="50px" width="50px"  class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image 1">
                                <h5 class="text-center pb-1">Python</h5>
                                <div class="progress pb-1">
                                    <div class="progress-bar" role="progressbar" style="width: 45%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                  </div>
                            <div class="d-flex"> 
                                <a href="#" class="pr-2">
                                  <div class="d-flex">
                                  <img src="../../asserts/images/file-text.svg" class="pr-1">
                                  <p class="text pt-3">14 Assessments</p>
                                  </div>
                                </a>
                                <a href="#">
                                    <div class="d-flex">
                                    <img src="../../asserts/images/file-text.svg" class="pr-1">
                                    <p class="text pt-3">13 Assignments</p>
                                    </div>
                                </a>
                                </div>
                                <div class="d-flex pb-3 "> 
                                <a href="#" class="pr-2">
                                    <div class="d-flex">
                                    <img src="../../asserts/images/calendar-date.svg" class="pr-1">
                                    <p class="text pt-3">10 AUG 2025</p>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="d-flex pl-3">
                                    <img src="../../asserts/images/calendar-date.svg" class="pr-1">
                                    <p class="text pt-3">1 JUN 2026 </p>
                                    </div>
                                </a>
                            </div>
                            <div class="d-flex ">
                                <a href="../Modules/Module_Course-2_1.html" class="btn btn-primary">View Course</a>    
                                <div class="pr-5"></div>
                                 <a href="#" class="pr-2" data-toggle="modal" data-target="#editNameModal"><img src="../../asserts/images/pencil-square.svg"></a>
                                <a href="#" class="pr-2  pl-2" data-toggle="modal" data-target="#uploadModal"><img src="../../asserts/images/upload.svg"></a>
                                <a href="#" ><img src="../../asserts/images/trash3-fill.svg"  id="triggerModalBtn" data-toggle="modal" data-target="#confirmModal"></a>
                                </div>
                            </div>
                        </div>
                        </div>`;
                // Add the new card to the card container
                cardContainer.appendChild(newCard);
            });
        });
function trash()
{
    confirm("do you want to delete this content ?")
}
document.addEventListener('DOMContentLoaded', function() {
    const triggerModalBtn = document.getElementById('triggerModalBtn');
    const confirmModal = new bootstrap.Modal(document.getElementById('confirmModal'));
    const confirmBtn = document.getElementById('confirmBtn');

    triggerModalBtn.addEventListener('click', function() {
        confirmModal.show();
    });

    confirmBtn.addEventListener('click', function() {
        console.log("Confirmed!");
        confirmModal.hide();
    });
});
function validateFormCourseName()
    {
    let isusername=document.getElementById("courseName").value;
    if(/\d/.test(isusername))
    {
        const errmsg= document.getElementById("errcourseName");
        errmsg.innerText="Do not Enter number"
    }
    else
    {
         const errmsg= document.getElementById("errcourseName");
        errmsg.innerText=""
    }
    }
function validateStartDate()
{
    let startDate=document.getElementById("startDate").value;
    const inputDate=new Date(startDate);
    var today=new Date();
    today.setHours(0,0,0,0)
    if(inputDate<today)
    {
        const err= document.getElementById("startDateerr")
        err.innerText="Start Date should be greater than today"
    }
    else
    {
        const err= document.getElementById("startDateerr")
        err.innerText=""
    }
}
function validateEndDate()
{
    let endDate=document.getElementById("endDate").value;
    const end=new Date(endDate);
    let startDate=document.getElementById("startDate").value;
    const start=new Date(startDate);
    if(start>end)
    {
        const err= document.getElementById("endDateerr")
        err.innerText="End Date should be greater than Start Date"
    }
    else
    {
        const err= document.getElementById("endDateerr")
        err.innerText=""
    }
}
// Custom JavaScript to toggle sidebar visibility on button click
document.getElementById('sidebarToggle').addEventListener('click', function() {
    document.getElementById('navbarNav').classList.toggle('show');
});

function addCard()
{
	document.getElementById("");
}
