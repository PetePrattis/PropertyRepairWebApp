//feather.replace();

(function () {
    console.log("Hello World!");
})();

(() => {
  'use strict';

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms = document.querySelectorAll('.needs-validation');

  // Loop over them and prevent submission
  Array.prototype.slice.call(forms).forEach((form) => {
    form.addEventListener('submit', (event) => {
      if (!form.checkValidity()) {
        event.preventDefault();
        event.stopPropagation();
      }
      form.classList.add('was-validated');
    }, false);
  });
})();

// Date format
jQuery(function ($) {
    var $datePicker = $('#datepicker');
    if ($datePicker.datepicker) {
        $datePicker.datepicker({format: 'yyyy-mm-dd'});
    }
    var $datePicker2 = $('#datepicker2');
    if ($datePicker2.datepicker) {
        $datePicker2.datepicker({format: 'yyyy-mm-dd'});
    }
    const $createForm = $('#createForm');
        console.log($createForm);
//    if ($createForm.validate) {
//        $createForm.validate({
//            rules: {
//                firstName: {
//                    required: true
//                },
//                lastName: {
//                    required: true
//                },
//                Afm: {
//                    required: true,
//                    digits: true,
//                    minlength: 10,
//                    maxlength: 10
//                }
//            },
//            messages: {
//                lastName: {
//                    required: "Lastname is required."
//                },
//                Afm: {
//                    minlength: "It should be at 10 digits.",
//                    maxlength: "It should be at 10 digits."
//                }
//            }
//        });
    }


    $('#modal').on('show.bs.modal', function (event) {
        const id = event.relatedTarget.dataset.id;
        $('#deleteForm').attr('action', `/repair/${id}/delete`);
        $('.modal-title').text(function () {
            return `Repair #${id}`;
        });
    });

    $('#ownersModal').on('show.bs.modal', function (event) {
        const id = event.relatedTarget.dataset.id;
        $('#deleteForm').attr('action', `/owner/${id}/delete`);
        $('.modal-title').text(function () {
            return `Owner #${id}`;
        });
    });
});