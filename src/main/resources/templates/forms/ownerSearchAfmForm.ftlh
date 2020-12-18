<#import "/spring.ftl" as spring />

<h4 class="mb-3">Search Owner</h4>
<form action="/admin/search/byAfm/owner" method="post">
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