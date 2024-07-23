function showDetails(name, date, marks, attempts) {
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

function filterStatus(status) {
    const cards = document.querySelectorAll('.course-card');
    const options = document.querySelectorAll('.filter-option');
    const slider = document.querySelector('.slider');

    options.forEach((option, index) => {
        if (option.textContent.toLowerCase() === status) {
            option.classList.add('active');
            option.classList.remove('inactive');
            slider.style.left = `${index * 25}%`;
        } else {
            option.classList.remove('active');
            option.classList.add('inactive');
        }
    });

    cards.forEach(card => {
        const cardStatus = card.getAttribute('data-status').toLowerCase();
        if (status === 'all' || cardStatus === status) {
            card.parentElement.style.display = 'block';
        } else {
            card.parentElement.style.display = 'none';
        }
    });
}

document.addEventListener('DOMContentLoaded', (event) => {
    // Show only "Not Yet Started" cards on page load
    filterStatus('not yet started');

    document.querySelectorAll('.nav-icons .material-symbols-outlined').forEach(icon => {
        icon.addEventListener('click', () => {
            if (icon.textContent.trim() === 'home') {
                window.location.href = '/TestPortal/student/home';
            } else if (icon.textContent.trim() === 'school') {
                window.location.href = '../course/course.html';
            } else if (icon.textContent.trim() === 'assessment') {
                window.location.href = 'views/Student/studentPerformance.jsp';
            }
        });
    });

    // Initially set the color for badges based on status
    const badges = document.querySelectorAll('.badge');
    badges.forEach(badge => {
        const status = badge.textContent.toLowerCase().trim();
        switch (status) {
            case 'not yet started':
                badge.classList.add('badge-primary');
                break;
            case 'started':
                badge.classList.add('badge-success');
                break;
            case 'completed':
                badge.classList.add('badge-danger');
                break;
            case 'missed':
                badge.classList.add('badge-warning');
                break;
            default:
                break;
        }
    });
});
