<#import "/spring.ftl" as spring />

<h4 class="mb-3">Create Owner</h4>
<form id="createForm" class="needs-validation" action="/admin/owners/create" method="post" novalidate>


    <div class="form-row">
        <div class="col-md-4 mb-3">
            <label for="first-name">First Name</label>
          <input type="text" class="form-control" id="first-name" name="firstName" placeholder="Last Name" required>
           <div class="invalid-feedback">
             This field is required.
           </div>
        </div>
        <div class="col-md-4 mb-3">
          <label for="last-name">Last Name</label>
          <div class="input-group">
            <input type="text" class="form-control" id="last-name" name="lastName" placeholder="Last Name" aria-describedby="inputGroupPrepend" required>
           <div class="invalid-feedback">
             This field is required.
           </div>
          </div>
        </div>
      </div>

    <div class="form-row">
       <div class="col-md-4 mb-3">
        <label for="afm">AFM</label>
          <input type="text" class="form-control" id="afm" name="Afm" pattern="[0-9]{9}" placeholder="Afm" required>
           <div class="invalid-feedback">
             Please provide a valid afm.
           </div>
        </div>
        <div class="col-md-4 mb-3">
        <label for="address">Address</label>
          <input type="text" class="form-control" id="address" name="address" placeholder="Address" required>
           <div class="invalid-feedback">
             This field is required.
           </div>
        </div>
      </div>

    <div class="form-row">
       <div class="col-md-4 mb-3">
           <label for="telephone-number">Telephone Number</label>
         <input type="text" class="form-control" id="telephone-number" name="telephoneNumber" pattern="^(\+\d{2})?[0-9]{10}" placeholder="Telephone Number" required>
           <div class="invalid-feedback">
             Please provide a valid telephone number.
           </div>
       </div>
       <div class="col-md-4 mb-3">
         <label for="email">Email</label>
         <div class="input-group">
           <input type="email" class="form-control" id="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" placeholder="Email" aria-describedby="inputGroupPrepend" required>
           <div class="invalid-feedback">
             Please provide a valid email.
           </div>
         </div>
       </div>
      </div>


          <div class="form-row">
              <div class="col-md-4 mb-3">
              <label for="property-type">Property Type</label>
                <select class="custom-select d-block w-100" id="property-type" name="propertyType">
                    <#list propertyType as type>
                        <option value="${type}">${type.getType()}</option>
                    </#list>
                </select>
              </div>
              <div class="col-md-4 mb-3">
                  <label for="user-role">User Role</label>
                <select class="custom-select d-block w-100" id="user-role" name="userRole">
                    <#list userRole as role>
                        <option value="${role}">${role.getRole()}</option>
                    </#list>
                </select>
              </div>
            </div>


    <button class="btn btn-primary btn-lg mt-4" type="submit">Create</button>
</form>

<script>
// Example starter JavaScript for disabling form submissions if there are invalid fields
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