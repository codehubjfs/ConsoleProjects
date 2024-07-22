document.addEventListener('DOMContentLoaded', function () {
    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['OCT Task', 'NOV Task', 'DEC Task', 'JAN Task', 'FEB Task', 'MAR Task'],
            datasets: [{
                label: '# of Votes',
                data: [12, 19, 3, 5, 2, 3],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ],
                borderWidth: 0.5
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    document.addEventListener('DOMContentLoaded', function () {
        const taskForm = document.getElementById('taskForm');
        const taskTableBody = document.getElementById('taskTable').querySelector('tbody');
    
        taskForm.addEventListener('submit', function (e) {
            e.preventDefault();
    
            const taskName = document.getElementById('taskName').value;
            const assignedTo = document.getElementById('assignedTo').value;
            const dueDate = document.getElementById('dueDate').value;
            const status = document.getElementById('status').value;
    
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${taskName}</td>
                <td>${assignedTo}</td>
                <td>${dueDate}</td>
                <td>${status}</td>
            `;
    
            taskTableBody.appendChild(row);
    
            taskForm.reset();
        });
    });

    // Toggle sidebar functionality
    const sidebar = document.getElementById('sidebar');
    const toggleSidebarButton = document.getElementById('toggleSidebar');

    toggleSidebarButton.addEventListener('click', function () {
        sidebar.classList.toggle('collapsed');
    });
});

   
$(document).ready(function(){
    $('.second').hide();
 $('.first').hide();
    $('.card ').hover(function(){

    if($(this).find('.first').length)
    {   
        $(this).css('border-bottom' , '5px solid orange ');
    }
    if($(this).find('.second').length)
    {   
    
        $(this).css('border-bottom' , '5px solid #0275d8 ');
    }
    
    $(this).find('.second').css('padding-top' , '.8rem  ');
    $(this).find('.first').css('padding-top' , '.8rem  ');
    $(this).find('.second').css('padding-bottom' , '.8rem  ');
    $(this).find('.first').css('padding-bottom' , '.8rem  ');
    $(this).find('.first').show(200);
    $(this).find('.second').show(200);

} ,
function(){
    $(this).css('border-bottom' , 'none ');
    $('.second').hide(100 );
    $('.first').hide(100);
}); 

});

