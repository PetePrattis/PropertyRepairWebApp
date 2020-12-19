<#import "/spring.ftl" as spring />

<h4 class="mb-3">Search Property</h4>
<form action="/admin/search/byPropertyCode/property" method="post">
    <div>
        <label for="propertycodepicker">Property Code:</label>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"></span>
            </div>
            <input type="text" class="form-control" id="propertycodepicker" name="input">
        </div>
    </div>
    <button class="btn btn-primary btn-lg mt-4" type="submit">Search</button>
</form>