<#import "/spring.ftl" as spring />

<h4 class="mb-3">Create Property</h4>
<form id="createForm" action="/admin/property/create" method="post">


    <div class="mb-3">
        <label for="yearpicker">Construction Year</label>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><span data-feather="calendar"></span></span>
            </div>
            <input type="text" class="form-control" id="yearpicker" name="constructionYear">
        </div>
    </div>

    <div class="mb-3">
        <label for="title">Property Code</label>
        <div class="input-group">
            <input type="text" class="form-control" id="property-code" name="propertyCode">
        </div>
    </div>

    <div class="mb-3">
        <label for="title">Address</label>
        <div class="input-group">
            <input type="text" class="form-control" id="address" name="address">
        </div>
    </div>

    <div class="mb-3">
        <label for="category">Type</label>
        <div class="input-group">
            <select class="custom-select d-block w-100" id="status" name="propertyType">
                <#if propertyTypes??>
                <#list propertyTypes as type>
                <option value="${type}">${type.getType()}</option>
            </#list>
        </#if>
        </select>
    </div>
    </div>

    <div class="mb-3">
        <label for="owner-afm">Owner's AFM</label>
        <div class="input-group">
            <input type="text" class="form-control" id="owner-afm" name="ownerAfm">
        </div>
    </div>



    <button class="btn btn-primary btn-lg mt-4" type="submit">Create</button>
</form>