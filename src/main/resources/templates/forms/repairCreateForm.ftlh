<#import "/spring.ftl" as spring />

<h4 class="mb-3">Create Repair</h4>

<#if errorMessage??>
    <h4 class="validationmsg">${errorMessage}</h4>
</#if>

<form id="createForm" name="repairForm" class="needs-validation" action="/admin/repair/create"  method="post" novalidate>

    <div class="form-row">
        <div class="col-md-4 mb-3">
            <label for="cost">Cost</label>
                <@spring.bind "repairsForm.cost"/>

      <input type="text" class="form-control" id="cost" name="cost" placeholder="Cost" pattern="[0-9]+(\.[0-9]+)?" value="${repairsForm.cost!''}" required>
        <#if spring.status.error>
            <ul>
                <#list spring.status.errorMessages as error>
                    <li style="color: #dc3545">${error}</li>
                </#list>
            </ul>
        </#if>
           <div class="invalid-feedback">
             Please insert a valid value.
           </div>
        </div>
        <div class="col-md-4 mb-3">
            <label for="address">Address</label>
                                      <@spring.bind "repairsForm.address"/>

          <div class="input-group">
            <input type="text" class="form-control" id="address" name="address" placeholder="Address" value="${repairsForm.address!''}" required>
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
        <label for="propertyCode">Property's Code</label>
                            <@spring.bind "repairsForm.propertyCode"/>

      <input type="text" class="form-control" id="propertyCode" name="propertyCode" placeholder="Property's Code" value="${repairsForm.propertyCode!''}" required>
        <#if spring.status.error>
            <ul>
                <#list spring.status.errorMessages as error>
                    <li style="color: #dc3545">${error}</li>
                </#list>
            </ul>
        </#if>
           <div class="invalid-feedback">
             Please provide a valid code.
           </div>
        </div>
        <div class="col-md-4 mb-3">
            <label for="extra-Info">Extra Info</label>
                                      <@spring.bind "repairsForm.extraInfo"/>

          <div class="input-group">
            <input type="text" class="form-control" id="extra-Info" name="extraInfo" placeholder="Extra Info" value="${repairsForm.extraInfo!''}">
           <div class="invalid-feedback">
             This field is required.
           </div>
          </div>
        </div>
      </div>

      <div class="form-row">
          <div class="col-md-4 mb-3">
          <label for="status">Status</label>
            <select class="custom-select d-block w-100" id="status" name="repairStatus">
                <#if repairsForm.repairStatus??>
                <#list repairStatus as status>
                    <option value="${status}" <#if repairsForm.repairStatus == status> selected</#if>>${status.getStatus()}</option>
                </#list>
                <#else>
                <#list repairStatus as status>
                    <option value="${status}">${status.getStatus()}</option>
                </#list>
                </#if>
            </select>
          </div>
          <div class="col-md-4 mb-3">
              <label for="type">Type</label>
            <select class="custom-select d-block w-100" id="type" name="repairType">
                <#if repairsForm.repairType??>
                    <#list repairTypes as type>
                        <option value="${type}"  <#if repairsForm.repairType == type> selected</#if>>${type.getType()}</option>
                    </#list>
                <#else>
                    <#list repairTypes as type>
                        <option value="${type}">${type.getType()}</option>
                    </#list>
                </#if>
            </select>
          </div>
        </div>


      <div class="form-row">
            <div class="col-md-8 mb-3">
                <label for="datepicker">Date</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><span data-feather="calendar"></span></span>
                    </div>
                    <input type="text" class="form-control" id="datepicker" name="date" value="${repairsForm.date!''}" required>
                </div>
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