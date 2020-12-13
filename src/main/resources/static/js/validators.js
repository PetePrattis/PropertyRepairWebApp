(function () {
    $('#add-repair').validate({
        rules: {
            title: {
                required: true
            },
            year: {
                required: true
            }
        },
        messages: {
            title: {
                required: 'Please add a title.'
            },
            year: {
                required: 'Please pick a year.'
            }
        }
    });
})();