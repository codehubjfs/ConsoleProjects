document.addEventListener('DOMContentLoaded', () => {
    fetchTeachers();

    // Function to show the appropriate section
    window.showSection = function(sectionId) {
        const sections = document.querySelectorAll('.content-section');
        sections.forEach(section => {
            section.style.display = 'none';
        });
        document.getElementById(sectionId).style.display = 'block';
});
