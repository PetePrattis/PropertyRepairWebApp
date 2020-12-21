<#import "/spring.ftl" as spring />

<h4 class="mb-3">Create Owner</h4>
<form id="createForm" name="ownerForm" class="needs-validation" action="/admin/owners/create" method="post" novalidate>

<#if errorMessage??>
    <h4 class="validationmsg">${errorMessage}</h4>
</#if>

    <div class="form-row">
        <div class="col-md-4 mb-3">
            <label for="first-name">First Name</label>
                            <@spring.bind "ownersForm.firstName"/>

          <input type="text" class="form-control" id="first-name" name="firstName" placeholder="First Name" value="${ownersForm.firstName!''}" required>
        <#if spring.status.error>
            <ul>
                <#list spring.status.errorMessages as error>
                    <li style="color: #dc3545">${error}</li>
                </#list>
            </ul>
        </#if>
           <div class="invalid-feedback">
             This field is required.
           </div>
        </div>
        <div class="col-md-4 mb-3">
          <label for="last-name">Last Name</label>
                                      <@spring.bind "ownersForm.lastName"/>

          <div class="input-group">
            <input type="text" class="form-control" id="last-name" name="lastName" placeholder="Last Name" value="${ownersForm.lastName!''}" required>
        <#if spring.status.error>
            <ul>
                <#list spring.status.errorMessages as error>
                    <li style="color: #dc3545">${error}</li>
                </#list>
            </ul>
        </#if>
           <div class="invalid-feedback">
             This field is required.
           </div>
          </div>
        </div>
      </div>

    <div class="form-row">
       <div class="col-md-4 mb-3">
        <label for="afm">AFM</label>
                <@spring.bind "ownersForm.afm"/>
          <input type="text" class="form-control" id="afm" name="Afm" pattern="[0-9]{9}" placeholder="Afm" value="${ownersForm.afm!''}" required>
        <#if spring.status.error>
            <ul>
                <#list spring.status.errorMessages as error>
                    <li style="color: #dc3545">${error}</li>
                </#list>
            </ul>
        </#if>
           <div class="invalid-feedback">
             Please provide a valid afm.
           </div>
        </div>
        <div class="col-md-4 mb-3">
        <label for="address">Address</label>
                <@spring.bind "ownersForm.address"/>
          <input type="text" class="form-control" id="address" name="address" placeholder="Address" value="${ownersForm.address!''}" required>
        <#if spring.status.error>
            <ul>
                <#list spring.status.errorMessages as error>
                    <li style="color: #dc3545">${error}</li>
                </#list>
            </ul>
        </#if>
           <div class="invalid-feedback">
             This field is required.
           </div>
        </div>
      </div>

    <div class="form-row">
       <div class="col-md-4 mb-3">
           <label for="telephone-number">Telephone Number</label>
                <@spring.bind "ownersForm.telephoneNumber"/>
         <input type="text" class="form-control" id="telephone-number" name="telephoneNumber" pattern="^(\+\d{2})?[0-9]{10}" placeholder="Telephone Number" value="${ownersForm.telephoneNumber!''}" required>
        <#if spring.status.error>
            <ul>
                <#list spring.status.errorMessages as error>
                    <li style="color: #dc3545">${error}</li>
                </#list>
            </ul>
        </#if>
           <div class="invalid-feedback">
             Please provide a valid telephone number.
           </div>
       </div>
       <div class="col-md-4 mb-3">
         <label for="email">Email</label>
         <div class="input-group">
                <@spring.bind "ownersForm.email"/>
           <input type="email" class="form-control" id="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" placeholder="Email" aria-describedby="inputGroupPrepend" value="${ownersForm.email!''}" required>
        <#if spring.status.error>
            <ul>
                <#list spring.status.errorMessages as error>
                    <li style="color: #dc3545">${error}</li>
                </#list>
            </ul>
        </#if>
           <div class="invalid-feedback">
             Please provide a valid email.
           </div>
         </div>
       </div>
      </div>


          <div class="form-row">
            <div class="col-md-8 mb-3">
                  <label for="user-role">User Role</label>
                <select class="custom-select d-block w-100" id="user-role" name="userRole">
                    <#if ownersForm.userRole??>
                    <#list userRole as role>
                        <option value="${role}">${role.getRole()}</option>
                    </#list>
                    <#else>
                    <#list userRole as role>
                        <option value="${role}">${role.getRole()}</option>
                    </#list>
                    </#if>
                </select>
              </div>
            </div>


    <button class="btn btn-primary btn-lg mt-4" type="submit">Create</button>
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