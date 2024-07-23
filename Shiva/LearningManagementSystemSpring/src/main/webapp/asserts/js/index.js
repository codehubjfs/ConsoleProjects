/**
 * 
 */
function getDeatails()
{
    document
}
function addCourseCard(courseName, instructorUserName, department, startDate, endDate) {
    const cardHtml = `
        <div class="col-md-4">
            <div class="card mb-4 shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">${courseName}</h5>
                    <p class="card-text"><strong>Instructor:</strong> ${instructorUserName}</p>
                    <p class="card-text"><strong>Department:</strong> ${department}</p>
                    <p class="card-text"><strong>Start Date:</strong> ${startDate}</p>
                    <p class="card-text"><strong>End Date:</strong> ${endDate}</p>
                </div>
            </div>
        </div>
    `;
    document.getElementsByTagName('main').innerHTML += cardHtml;
}