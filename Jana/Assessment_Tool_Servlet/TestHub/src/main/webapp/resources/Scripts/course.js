function showDetails(section, date, marks, attempts) {
    const details = `
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>S.No</th>
                    <th>Section</th>
                    <th>Questions</th>
                    <th>Marks</th>
                    <th>Attempts</th>
                    <th>Duration</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>Aptitude</td>
                    <td>20</td>
                    <td>20</td>
                    <td>${attempts}</td>
                    <td>20 mins</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Technical MCQ</td>
                    <td>15</td>
                    <td>30</td>
                    <td>${attempts}</td>
                    <td>30 mins</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Coding</td>
                    <td>2</td>
                    <td>50</td>
                    <td>${attempts}</td>
                    <td>40 mins</td>
                </tr>
            </tbody>
        </table>
    `;
    document.getElementById('assessment-details').innerHTML = details;
}
// course.js
// function showDetails(title, date, marks, attempts) {
//     const detailsHtml = `
//         <p><strong>Title:</strong> ${title}</p>
//         <p><strong>Date:</strong> ${date}</p>
//         <p><strong>Marks:</strong> ${marks}</p>
//         <p><strong>Attempts:</strong> ${attempts}</p>
//     `;
//     document.getElementById('assessment-details').innerHTML = detailsHtml;
// }

function filterCards() {
    const input = document.getElementById('searchInput').value.toLowerCase();
    const cards = document.querySelectorAll('.course-card');

    cards.forEach(card => {
        const title = card.querySelector('h4').textContent.toLowerCase();
        if (title.includes(input)) {
            card.parentElement.style.display = '';
        } else {
            card.parentElement.style.display = 'none';
        }
    });
}

function showPending() {
    const cards = document.querySelectorAll('.course-card');
    cards.forEach(card => {
        if (card.getAttribute('data-status') === 'pending') {
            card.parentElement.style.display = '';
        } else {
            card.parentElement.style.display = 'none';
        }
    });
}

function showCompleted() {
    const cards = document.querySelectorAll('.course-card');
    cards.forEach(card => {
        if (card.getAttribute('data-status') === 'completed') {
            card.parentElement.style.display = '';
        } else {
            card.parentElement.style.display = 'none';
        }
    });
}
document.getElementById('showPending').addEventListener('click', showPending);
document.getElementById('showCompleted').addEventListener('click', showCompleted);
document.getElementById('searchInput').addEventListener('keyup', filterCards);

// Initially show pending assessments
document.addEventListener('DOMContentLoaded', showPending);

function startTest() {
    // Logic to start the test
    alert("Test started!");
}
document.addEventListener('DOMContentLoaded', (event) => {
document.querySelectorAll('.nav-icons .material-symbols-outlined').forEach(icon => {
    icon.addEventListener('click', () => {
        if (icon.textContent.trim() === 'home') {
            window.location.href = '../../views/Student/studentHome.jsp';
        } else if (icon.textContent.trim() === 'school') {
            window.location.href = '../course/course.html';
        } else if (icon.textContent.trim() === 'assessment') {
            window.location.href = '../../views/Student/studentPerformance.jsp';
        }
    });
});
});