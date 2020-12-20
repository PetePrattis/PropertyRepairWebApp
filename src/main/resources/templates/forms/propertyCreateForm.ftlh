<#import "/spring.ftl" as spring />

<h4 class="mb-3">Create Property</h4>

<#if errorMessage??>
    <h4>${errorMessage}</h4>
</#if>


<form id="createForm" name="propertyForm" class="needs-validation" action="/admin/property/create" method="post" novalidate>

    <div class="form-row">
        <div class="col-md-4 mb-3">
            <label for="type">Type</label>
            <@spring.bind "propertiesForm.constructionYear"/>
            <select class="custom-select d-block w-100" id="status" name="propertyType">
                <#if propertyTypes??>
                <#list propertyTypes as type>
                    <option value="${type}">${type.getType()}</option>
                </#list>
                </#if>
            </select>
        </div>
        <div class="col-md-4 mb-3">
            <label for="propertyCode">Property Code</label>
            <@spring.bind "propertiesForm.propertyCode"/>
            <input type="text" class="form-control" id="propertyCode" name="propertyCode" placeholder="Property Code" value="${propertiesForm.propertyCode!''}" required>
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
                  <label for="address">Address</label>
                                  <@spring.bind "propertiesForm.address"/>
            <input type="text" class="form-control" id="address" name="address" placeholder="Address" value="${propertiesForm.constructionYear!''}" required>
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
                  <label for="owner-afm">Owner's AFM</label>
                                            <@spring.bind "propertiesForm.ownerAfm"/>

                  <input type="text" class="form-control" id="owner-afm" name="ownerAfm" placeholder="Owner's AFM" pattern="[0-9]{9}"  value="${propertiesForm.ownerAfm!''}" required>
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

                  <div class="col-md-8 mb-3">
                      <label for="yearpicker">Date</label>
                      <div class="input-group">
                          <div class="input-group-prepend">
                              <span class="input-group-text"><span data-feather="calendar"></span></span>
                          </div>
                          <input type="text" class="form-control" id="yearpicker" name="constructionYear" required>
                      </div>
                  </div>

            <button class="btn btn-primary btn-lg mt-4" type="submit">Create</button>
    </div>



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