$(document).ready(function() {
    $('#new-form').on('submit', function() {
        var $form = $(this);
        var url = form.attr('action');
        $.ajax({
            type: "POST",
            url: url,
            data: form.serialize(), // serializes the form's elements.
            success: function(data)
            {
                alert(data); // show response from the script.
            }});
        }
    );
});
