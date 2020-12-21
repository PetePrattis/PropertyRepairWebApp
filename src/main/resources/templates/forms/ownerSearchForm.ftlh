<#import "/spring.ftl" as spring />

<h4 class="mb-3">Search Repair</h4>

<form action="/admin/search/owner" method="post">
    <div>
        <label for="emailpicker">Pick Email:</label>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"></span>
            </div>
            <input type="text" class="form-control" id="emailpicker" name="email">
        </div>

        <label for="afmpicker">Pick AFM:</label>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"></span>
            </div>
            <input type="text" class="form-control" id="afmpicker" name="afm">
        </div>

    </div>
    <button class="btn btn-primary btn-lg mt-4" type="submit">Search</button>
</form>