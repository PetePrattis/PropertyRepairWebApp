//feather.replace();

(function () {
    console.log("Hello World!");
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
    var yearpicker = $('#yearpicker');
    if (yearpicker.datepicker) {
        yearpicker.datepicker({format: 'yyyy'});
    }


    $('#modal').on('show.bs.modal', function (event) {
        const id = event.relatedTarget.dataset.id;
        $('#deleteForm').attr('action', `/admin/repair/${id}/delete`);
        $('.modal-title').text(function () {
            return `Repair`;
        });
    });

    $('#ownersModal').on('show.bs.modal', function (event) {
        const id = event.relatedTarget.dataset.id;
        $('#deleteForm').attr('action', `/admin/owner/${id}/delete`);
        $('.modal-title').text(function () {
            return `Owner`;
        });
    });

    $('#repairsModal').on('show.bs.modal', function (event) {
        const id = event.relatedTarget.dataset.id;
        $('#deleteForm').attr('action', `/admin/repair/${id}/delete`);
        $('.modal-title').text(function () {
            return `Repair`;
        });
    });

    $('#propertyModal').on('show.bs.modal', function (event) {
        const id = event.relatedTarget.dataset.id;
        $('#deleteForm').attr('action', `/admin/property/${id}/delete`);
        $('.modal-title').text(function () {
            return `Property`;
        });
    });
});