<#import "/spring.ftl" as spring />

<h4 class="mb-3">Edit Owner</h4>
<form action="/admin/owner/edit" method="post">


    <input type="hidden" name="id" value="${owner.id}">

    <div class="form-row">
        <div class="col-md-4 mb-3">
            <label for="first-name">First Name</label>
            <div class="input-group">
                <input type="text" class="form-control" id="first-name" name="firstName"  value="${owner.firstName}">
            </div>
        </div>
        <div class="col-md-4 mb-3">
            <label for="last-name">Last Name</label>
            <div class="input-group">
                <input type="text" class="form-control" id="last-name" name="lastName"  value="${owner.lastName}">
            </div>
        </div>
    </div>

    <div class="form-row">
        <div class="col-md-4 mb-3">
            <label for="afm">AFM</label>
            <div class="input-group">
                <input type="text" class="form-control" id="afm" name="Afm"  value="${owner.afm?replace(",","")?replace(".","")}">
            </div>
        </div>
        <div class="col-md-4 mb-3">
            <label for="address">Address</label>
            <div class="input-group">
                <input type="text" class="form-control" id="address" name="address" value="${owner.address}">
            </div>
        </div>
    </div>


    <div class="form-row">
        <div class="col-md-4 mb-3">
            <label for="telephone-number">Telephone Number</label>
            <div class="input-group">
                <input type="text" class="form-control" id="telephone-number" name="telephoneNumber"  value="${owner.telephoneNumber}">
            </div>
        </div>
        <div class="col-md-4 mb-3">
            <label for="email">Email</label>
            <div class="input-group">
                <input type="text" class="form-control" id="email" name="email" value="${owner.email}">
            </div>
        </div>
    </div>

    <button class="btn btn-primary btn-lg mt-4" type="submit">Update</button>
</form>