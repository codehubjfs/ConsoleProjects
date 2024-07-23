let currentQuestionIndex = 0;
const questions = document.querySelectorAll('.question');
const totalQuestions = questions.length;
let answers = {};

// Initialize answers with "NA"
questions.forEach((question, index) => {
    const qid = question.dataset.qid;
    answers[qid] = "NA";
});

document.addEventListener('DOMContentLoaded', function () {
    showQuestion(currentQuestionIndex);
    loadNavigation();
    $('#rulesModal').modal('show');
    preventBackNavigation();
    handleTabNavigation();
    handlePageReload();
});

function startExam() {
    $('#rulesModal').modal('hide');
    startTimer(3600); // Start a 60-minute timer
}

function showQuestion(index) {
    questions.forEach((question, i) => {
        question.style.display = i === index ? 'block' : 'none';
    });
    document.getElementById('prevButton').disabled = index === 0;
    document.getElementById('nextButton').disabled = index === totalQuestions - 1;
    updateNavigation();
}

function saveAnswer(questionIndex, answer) {
    const qid = questions[questionIndex].dataset.qid;
    answers[qid] = answer;
    updateNavigation();
}

function nextQuestion() {
    if (currentQuestionIndex < totalQuestions - 1) {
        showQuestion(++currentQuestionIndex);
    }
}

function prevQuestion() {
    if (currentQuestionIndex > 0) {
        showQuestion(--currentQuestionIndex);
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
    questions.forEach((_, index) => {
        const button = document.getElementById(`nav-button-${index}`);
        button.addEventListener('click', () => jumpToQuestion(index));
    });
    updateNavigation(); // Ensure initial state is correct
}

function jumpToQuestion(index) {
    currentQuestionIndex = index;
    showQuestion(index);
}

function updateNavigation() {
    questions.forEach((_, index) => {
        const button = document.getElementById(`nav-button-${index}`);
        const qid = questions[index].dataset.qid;

        if (answers[qid] !== "NA") {
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

    // Convert the answers map to a JSON string
    const answerMap = JSON.stringify(answers);

    // Set the value of the hidden input field
    document.getElementById('answerMap').value = answerMap;

    // Submit the form
    document.getElementById('submitForm').submit();
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

function handleTabNavigation() {
    let tabSwitchCount = 0;
    document.addEventListener('visibilitychange', function () {
        if (document.hidden) {
            tabSwitchCount++;
            if (tabSwitchCount === 1 || tabSwitchCount === 2) {
                alert(`You have switched tabs ${tabSwitchCount} time(s). On the third switch, the test will be submitted.`);
            } else if (tabSwitchCount === 3) {
                alert("You have switched tabs 3 times. The test will now be submitted.");
                submitTest();
            }
        }
    });
}

function handlePageReload() {
    window.addEventListener('beforeunload', function (e) {
        e.preventDefault();
        e.returnValue = "Are you sure you want to reload the page? Your test will be submitted.";
    });

    window.addEventListener('unload', function () {
        if (!sessionStorage.getItem('testCompleted')) {
            submitTest();
        }
    });
}
