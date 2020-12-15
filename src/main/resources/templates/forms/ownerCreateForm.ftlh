<#import "/spring.ftl" as spring />

<h4 class="mb-3">Create Owner</h4>
<form id="createForm" action="/owner/create" method="post">

    <div class="mb-3">
        <label for="title">AFM</label>
        <div class="input-group">
            <input type="text" class="form-control" id="afm" name="Afm">
        </div>
    </div>

    <div class="mb-3">
        <label for="title">First Name</label>
        <div class="input-group">
            <input type="text" class="form-control" id="first-name" name="firstName">
        </div>
    </div>

    <div class="mb-3">
        <label for="title">Last Name</label>
        <div class="input-group">
            <input type="text" class="form-control" id="last-name" name="lastName">
        </div>
    </div>

    <div class="mb-3">
        <label for="title">Address</label>
        <div class="input-group">
            <input type="text" class="form-control" id="address" name="address">
        </div>
    </div>


    <div class="mb-3">
        <label for="title">Telephone Number</label>
        <div class="input-group">
            <input type="text" class="form-control" id="telephone-number" name="telephoneNumber">
        </div>
    </div>

    <div class="mb-3">
        <label for="author-first-name">Email</label>
        <div class="input-group">
            <input type="text" class="form-control" id="email" name="email">
        </div>
    </div>

    <div class="mb-3">
        <label for="author-first-name">Password</label>
        <div class="input-group">
            <input type="text" class="form-control" id="password" name="password">
        </div>
    </div>


    <div class="mb-3">
        <label for="category">Property Type</label>
        <div class="input-group">
            <select class="custom-select d-block w-100" id="property-type" name="propertyType">
                <#list propertyType as type>
                    <option value="${type.getType()}">${type.getType()}</option>
                </#list>
            </select>
        </div>
    </div>

    <div class="mb-3">
        <label for="category">User Role</label>
        <div class="input-group">
            <select class="custom-select d-block w-100" id="user-role" name="userRole">
                <#list userRole as role>
                    <option value="${role.getRole()}">${role.getRole()}</option>
                </#list>
            </select>
        </div>
    </div>

    <button class="btn btn-primary btn-lg mt-4" type="submit">Create</button>
</form>