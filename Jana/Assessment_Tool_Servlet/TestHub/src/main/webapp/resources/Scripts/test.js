// script.js

const questions = [
    {
        question: "What is the capital of France?",
        options: ["Paris", "London", "Berlin", "Madrid"],
        correct: 0
    },
    {
        question: "What is 2 + 2?",
        options: ["3", "4", "5", "6"],
        correct: 1
    },
    {
        question: "Which planet is known as the Red Planet?",
        options: ["Earth", "Mars", "Jupiter", "Saturn"],
        correct: 1
    }
];

let currentQuestionIndex = 0;
let answers = new Array(questions.length).fill(null);
let timer;

document.addEventListener('DOMContentLoaded', function () {
    loadNavigation();
    $('#rulesModal').modal('show');
    preventBackNavigation();
});

function startExam() {
    $('#rulesModal').modal('hide');
    loadQuestion(currentQuestionIndex);
    startTimer(3600); // Start a 60-minute timer
}

function loadQuestion(index) {
    const questionContainer = document.getElementById('questionContainer');
    const question = questions[index];

    questionContainer.innerHTML = `
        <div class="question">
            <h4>${question.question}</h4>
            ${question.options.map((option, i) => `
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="question${index}" id="option${i}" ${answers[index] === i ? 'checked' : ''} onclick="saveAnswer(${index}, ${i})">
                    <label class="form-check-label" for="option${i}">
                        ${option}
                    </label>
                </div>
            `).join('')}
            <div class="answer-saved" id="answer-saved-${index}">${answers[index] !== null ? 'Answer saved!' : ''}</div>
        </div>
    `;

    document.getElementById('prevButton').disabled = index === 0;
    document.getElementById('nextButton').disabled = index === questions.length - 1;
}

function saveAnswer(questionIndex, answerIndex) {
    answers[questionIndex] = answerIndex;
    document.getElementById(`answer-saved-${questionIndex}`).innerText = 'Answer saved!';
    updateNavigation();
}

function nextQuestion() {
    if (currentQuestionIndex < questions.length - 1) {
        loadQuestion(++currentQuestionIndex);
        updateNavigation();
    }
}

function prevQuestion() {
    if (currentQuestionIndex > 0) {
        loadQuestion(--currentQuestionIndex);
        updateNavigation();
    }
}

function startTimer(seconds) {
    const timerElement = document.getElementById('timer');
    timer = setInterval(function () {
        if (seconds <= 0) {
            clearInterval(timer);
            submitTest();
        } else {
            seconds--;
            const minutes = Math.floor(seconds / 60);
            const secs = seconds % 60;
            timerElement.innerText = `Time: ${minutes}:${secs < 10 ? '0' : ''}${secs}`;
        }
    }, 1000);
}

function loadNavigation() {
    const navigationContainer = document.getElementById('questionNavigation');
    let navigationHtml = '<h4>Questions</h4>';
    questions.forEach((_, index) => {
        navigationHtml += `
            <button class="btn btn-unvisited" id="nav-button-${index}" onclick="jumpToQuestion(${index})">${index + 1}</button>
        `;
    });
    navigationContainer.innerHTML = navigationHtml;
    updateNavigation();
}

function jumpToQuestion(index) {
    currentQuestionIndex = index;
    loadQuestion(index);
    updateNavigation();
}

function updateNavigation() {
    questions.forEach((_, index) => {
        const button = document.getElementById(`nav-button-${index}`);
        if (answers[index] !== null) {
            button.classList.add('btn-answered');
            button.classList.remove('btn-unvisited', 'btn-unanswered');
        } else if (index === currentQuestionIndex) {
            button.classList.add('btn-unanswered');
            button.classList.remove('btn-unvisited', 'btn-answered');
        } else {
            button.classList.add('btn-unvisited');
            button.classList.remove('btn-unanswered', 'btn-answered');
        }
    });
}

function confirmSubmit() {
    $('#confirmModal').modal('show');
}

function submitTest() {
    clearInterval(timer);
    $('#confirmModal').modal('hide');

    const score = calculateScore();
    document.getElementById('score').innerText = score;
    $('#resultModal').modal('show');
    sessionStorage.setItem('testCompleted', true); // Set the flag in session storage
}

function calculateScore() {
    let score = 0;
    answers.forEach((answer, index) => {
        if (answer === questions[index].correct) {
            score++;
        }
    });
    return score;
}

function redirectToHome() {
    window.location.href = "../../views/Student/studentHome.jsp"; 
}

function preventBackNavigation() {
    history.pushState(null, null, location.href);
    window.onpopstate = function () {
        history.go(1);
    };
    window.onbeforeunload = function () {
        if (!sessionStorage.getItem('testCompleted')) {
            return "Are you sure you want to leave? Your progress will be lost.";
        }
    };
}
