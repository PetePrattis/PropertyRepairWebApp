<#import "/spring.ftl" as spring />

<h4 class="mb-3">Search Repair</h4>
<form action="/admin/search/byAfm/repair" method="post">
    <div>
        <label for="afmpicker">AFM:</label>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"></span>
            </div>
            <input type="text" class="form-control" id="afmpicker" name="input">
        </div>

    </div>
    <button class="btn btn-primary btn-lg mt-4" type="submit">Search</button>
</form>