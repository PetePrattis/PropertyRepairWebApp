(function () {
    const $modalElement = $('#remove');

    $modalElement.on('show.bs.modal', function (event) {
        let modalButton = $(event.relatedTarget);
        let id = modalButton.closest('[data-id]').data('id');

        let modalTitle = $('.modal-title');
        modalTitle.text(`Confirm delete ${id}`);

        let deleteForm = $('.modal-delete-action');

        let baseActionUrl = deleteForm.closest('[data-action-url]').data('action-url');

        deleteForm.attr('action', baseActionUrl + id);
    });
})();