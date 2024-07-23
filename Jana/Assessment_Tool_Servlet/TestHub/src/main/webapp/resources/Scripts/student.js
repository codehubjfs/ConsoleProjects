// Add any interactivity you need, for example, handling navigation
document.addEventListener('DOMContentLoaded', (event) => {
    document.querySelectorAll('.nav-icons .material-symbols-outlined').forEach(icon => {
        icon.addEventListener('click', () => {
            if (icon.textContent.trim() === 'home') {
                window.location.href = '../Home/index.html';
            } else if (icon.textContent.trim() === 'school') {
                window.location.href = '../course/course.html';
            } else if (icon.textContent.trim() === 'assessment') {
                window.location.href = '../../views/Student/studentPerformance.jsp';
            }
        });
        });

    });

    
        window.addEventListener("scroll", function() {
            var header = document.getElementById("header");
            var nav = document.getElementById("navigation");
            if (window.scrollY > 150) {
                header.classList.add("scrolled");
                nav.classList.add("scrolled");
            } else {
                header.classList.remove("scrolled");
                nav.classList.remove("scrolled");
            }
        });
    

    if (sessionStorage.getItem('testCompleted')) {
        history.pushState(null, null, location.href);
        window.onpopstate = function () {
            history.go(1);
        };
    }

   

