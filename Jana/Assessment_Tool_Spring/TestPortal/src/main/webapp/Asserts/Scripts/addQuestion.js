$(document).ready(function(){
    $("#showExistingQuestions").click(function(){
        $("#existingQuestions").toggle();
    });
    
    // Fill the edit modal with the current question data
    $('.edit-question').click(function(){
        $('#editQuestionText').val($(this).data('questions'));
        $('#editOption1').val($(this).data('option1'));
        $('#editOption2').val($(this).data('option2'));
        $('#editOption3').val($(this).data('option3'));
        $('#editOption4').val($(this).data('option4'));
        $('#editCorrectAnswer').val($(this).data('correctanswer'));
        $('#editMark').val($(this).data('mark'));
        $('#editQid').val($(this).data('qid'));
    });

    // Form validation
    $("#addQuestionForm").submit(function(event){
        var isValid = true;

        $("#addQuestionForm input:not([type=hidden]), #addQuestionForm textarea, #addQuestionForm select").each(function(){
            if ($(this).val() === "") {
                isValid = false;
                $(this).addClass("is-invalid");
                $(this).next('.invalid-feedback').remove(); // Remove existing feedback
                $(this).after('<div class="invalid-feedback">This field is required.</div>'); // Add feedback
            } else {
                $(this).removeClass("is-invalid");
                $(this).next('.invalid-feedback').remove();
            }
        });

        var correctAnswer = $("#correctAnswer").val();
        if (correctAnswer !== "A" && correctAnswer !== "B" && correctAnswer !== "C" && correctAnswer !== "D") {
            isValid = false;
            $("#correctAnswer").addClass("is-invalid");
            $("#correctAnswer").next('.invalid-feedback').remove(); // Remove existing feedback
            $("#correctAnswer").after('<div class="invalid-feedback">Correct answer must be A, B, C, or D.</div>'); // Add feedback
        } else {
            $("#correctAnswer").removeClass("is-invalid");
            $("#correctAnswer").next('.invalid-feedback').remove();
        }

        if (!isValid) {
            event.preventDefault();
        }
    });
    
    // Form validation for edit question
    $("#editQuestionForm").submit(function(event){
        var isValid = true;

        $("#editQuestionForm input:not([type=hidden]), #editQuestionForm textarea, #editQuestionForm select").each(function(){
            if ($(this).val() === "") {
                isValid = false;
                $(this).addClass("is-invalid");
                $(this).next('.invalid-feedback').remove(); // Remove existing feedback
                $(this).after('<div class="invalid-feedback">This field is required.</div>'); // Add feedback
            } else {
                $(this).removeClass("is-invalid");
                $(this).next('.invalid-feedback').remove();
            }
        });

        var correctAnswer = $("#editCorrectAnswer").val();
        if (correctAnswer !== "A" && correctAnswer !== "B" && correctAnswer !== "C" && correctAnswer !== "D") {
            isValid = false;
            $("#editCorrectAnswer").addClass("is-invalid");
            $("#editCorrectAnswer").next('.invalid-feedback').remove(); // Remove existing feedback
            $("#editCorrectAnswer").after('<div class="invalid-feedback">Correct answer must be A, B, C, or D.</div>'); // Add feedback
        } else {
            $("#editCorrectAnswer").removeClass("is-invalid");
            $("#editCorrectAnswer").next('.invalid-feedback').remove();
        }

        if (!isValid) {
            event.preventDefault();
        }
    });

    // Clear validation errors when typing
    $("#addQuestionForm input, #addQuestionForm textarea, #addQuestionForm select").on('input', function(){
        if ($(this).val() !== "") {
            $(this).removeClass("is-invalid");
            $(this).next('.invalid-feedback').remove();
        }
    });


$("#editQuestionForm input, #editQuestionForm textarea, #editQuestionForm select").on('input', function(){
        if ($(this).val() !== "") {
            $(this).removeClass("is-invalid");
            $(this).next('.invalid-feedback').remove();
        }
    });
});