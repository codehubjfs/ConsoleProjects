document.addEventListener('DOMContentLoaded', () => {
    document.querySelectorAll('.nav-icons .material-symbols-outlined').forEach(icon => {
        icon.addEventListener('click', () => {
            console.log('Icon clicked:', icon.textContent.trim());
            switch (icon.textContent.trim()) {
                case 'home':
                    window.location.href = '/TestPortal/student/home';
                    break;
                case 'school':
                    window.location.href = 'views/Student/studentHome.jsp';
                    break;
                case 'assessment':
                    window.location.href = 'views/Student/studentPerformance.jsp';
                    break;
              //  case 'logout':
              //      console.log('Logout clicked');
              //      logoutUser();
              //      break;
                default:
                    console.log('Unexpected icon:', icon.textContent.trim());
                    break;
            }
        });
    });

    function logoutUser() {
    console.log('Logging out...');
    var logoutUrl = `/TestPortal/logout`;
    console.log('Logout URL:', logoutUrl);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", logoutUrl, true); // Updated URL with context path
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            console.log('XHR state:', xhr.readyState);
            if (xhr.status === 200) {
                console.log('Logout successful');
                window.location.href = `/TestPortal/loginPage`;
            } else {
                console.log('Logout failed with status:', xhr.status);
            }
        }
    };
    xhr.send();
}

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

$(document).ready(function() {
        $('#confirmLogout').click(function() {
            var email = '<%= session1.getAttribute("email") %>';
            if (email === null || email === '') {
                window.location.href = '/TestPortal/logout';
            } else {
                window.location.href = '/TestPortal/logout';
            }
        });
    });
