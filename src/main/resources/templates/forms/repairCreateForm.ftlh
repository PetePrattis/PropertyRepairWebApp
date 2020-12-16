<#import "/spring.ftl" as spring />

<h4 class="mb-3">Create Repair</h4>
<form id="createForm" action="/admin/repair/create" method="post">


    <div class="mb-3">
        <label for="datepicker">Date</label>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><span data-feather="calendar"></span></span>
            </div>
            <input type="text" class="form-control" id="datepicker" name="date">
        </div>
    </div>

    <div class="mb-3">
        <label for="category">Status</label>
        <div class="input-group">
            <select class="custom-select d-block w-100" id="status" name="repairStatus">
                <#if repairStatus??>
                    <#list repairStatus as status>
                        <option value="${status}">${status.getStatus()}</option>
                    </#list>
                </#if>
            </select>
        </div>
    </div>

    <div class="mb-3">
        <label for="category">Type</label>
        <div class="input-group">
            <select class="custom-select d-block w-100" id="type" name="repairType">
                <#if repairTypes??>
                    <#list repairTypes as type>
                        <option value="${type}">${type.getType()}</option>
                    </#list>
                </#if>
            </select>
        </div>
    </div>

    <div class="mb-3">
        <label for="author-first-name">Cost</label>
        <div class="input-group">
            <input type="text" class="form-control" id="cost" name="cost">
        </div>
    </div>

    <div class="mb-3">
        <label for="title">Address</label>
        <div class="input-group">
            <input type="text" class="form-control" id="address" name="address">
        </div>
    </div>

    <div class="mb-3">
        <label for="title">Owner's AFM</label>
        <div class="input-group">
            <input type="text" class="form-control" id="owner-afm" name="ownerAfm">
        </div>
    </div>

    <div class="mb-3">
        <label for="title">Extra Info</label>
        <div class="input-group">
            <input type="text" class="form-control" id="extra-Info" name="extraInfo">
        </div>
    </div>

    <button class="btn btn-primary btn-lg mt-4" type="submit">Create</button>
</form>