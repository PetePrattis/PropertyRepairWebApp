<#import "/spring.ftl" as spring />

<h4 class="mb-3">Edit Property</h4>
<form action="/admin/property/edit" method="post">


    <input type="hidden" name="id" value="${property.id}">


    <div class="mb-3">
        <label for="datepicker">Construction Year</label>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><span data-feather="calendar"></span></span>
            </div>
            <input type="text" class="form-control" id="datepicker" name="date" value="${property.constructionYear?replace(",","")?replace(".","")}">
        </div>
    </div>

    <div class="mb-3">
        <label for="title">Property Code</label>
        <div class="input-group">
            <input type="text" class="form-control" name="propertyCode" value="${property.propertyCode}">
        </div>
    </div>

    <div class="mb-3">
        <label for="title">Property Address</label>
        <div class="input-group">
            <input type="text" class="form-control" name="address" value="${property.address}">
        </div>
    </div>

    <div class="mb-3">
        <label for="category">Property Type</label>
        <div class="input-group">
            <select class="custom-select d-block w-100" id="type" name="propertyType">
                <#if propertyType??>
                <#list propertyType as type>
                <option value="${type}"<#if property.propertyType == type> selected</#if>>${type.getType()}</option>
        </#list>
    </#if>
    </select>
    </div>
    </div>

    <div class="mb-3">
        <label for="title">Owner's AFM</label>
        <div class="input-group">
            <input type="text" class="form-control" id="owner-afm" name="ownerAfm"  value="${property.ownerAfm?replace(",","")?replace(".","")}">
        </div>
    </div>

    <button class="btn btn-primary btn-lg mt-4" type="submit">Update</button>
</form>