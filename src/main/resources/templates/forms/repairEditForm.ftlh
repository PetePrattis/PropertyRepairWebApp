<#import "/spring.ftl" as spring />

<h4 class="mb-3">Edit Repair</h4>
<form action="/repair/edit" method="post">


    <input type="hidden" name="id" value="${repair.id}">


  <div class="form-row">
    <div class="col-md-4 mb-3">
        <label for="cost">Cost</label>
        <div class="input-group">
            <input type="text" class="form-control" id="cost" name="cost" value="${repair.cost}">
        </div>
    </div>

    <div class="col-md-4 mb-3">
        <label for="address">Address</label>
        <div class="input-group">
            <input type="text" class="form-control" id="address" name="address" value="${repair.address}">
        </div>
    </div>
  </div>

  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="status">Status</label>
      <div class="input-group">
          <select class="custom-select d-block w-100" id="status" name="repairStatus">
              <#if repairStatus??>
                  <#list repairStatus as status>
                      <option value="${status}"<#if repair.repairStatus == status> selected</#if>>${status.getStatus()}</option>
                  </#list>
              </#if>
          </select>
      </div>
    </div>

    <div class="col-md-4 mb-3">
        <label for="type">Type</label>
        <div class="input-group">
            <select class="custom-select d-block w-100" id="type" name="repairType">
                <#if repairTypes??>
                    <#list repairTypes as type>
                        <option value="${type}"<#if repair.repairType == type> selected</#if>>${type.getType()}</option>
                    </#list>
                </#if>
            </select>
        </div>
    </div>
  </div>

  <div class="form-row">
    <div class="col-md-4 mb-3">
        <label for="propertyCode">Property's Code</label>
        <div class="input-group">
            <input type="text" class="form-control" id="propertyCode" name="propertyCode"  value="${repair.propertyCode}">
        </div>
    </div>
    <div class="col-md-4 mb-3">
        <label for="extra-info">Extra Info</label>
        <div class="input-group">
            <input type="text" class="form-control" id="extra-info" name="extraInfo"  value="${repair.extraInfo}">
        </div>
    </div>

  </div>

  <div class="form-row">
    <div class="col-md-8 mb-3">
        <label for="datepicker">Date</label>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><span data-feather="calendar"></span></span>
            </div>
            <input type="text" class="form-control" id="datepicker" name="date" value="${repair.date}">
        </div>
    </div>
  </div>

    <button class="btn btn-primary btn-lg mt-4" type="submit">Update</button>
</form>