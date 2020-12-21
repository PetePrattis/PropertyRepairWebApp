<#import "/spring.ftl" as spring />

<h4 class="mb-3">Search repairs between date</h4>

<form class="needs-validation" action="/admin/search/betweenDate/repair" method="post" novalidate>

    <div class="mb-3">
        <label for="datepicker">From Date</label>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><span data-feather="calendar"></span></span>
            </div>
            <input type="text" class="form-control" id="datepicker" pattern="\d{4}-\d{2}-\d{2}" name="input" required>
           <div class="invalid-feedback">
                Please provide a valid date.
           </div>
        </div>
    </div>

    <div class="mb-3">
        <label for="datepicker2">To Date</label>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><span data-feather="calendar"></span></span>
            </div>
            <input type="text" class="form-control" id="datepicker2" pattern="\d{4}-\d{2}-\d{2}" name="input2" required>
           <div class="invalid-feedback">
                Please provide a valid date.
           </div>
        </div>
    </div>

    <button class="btn btn-primary btn-lg mt-4" type="submit">Search</button>
</form>

<script>
//JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>