<#import "/spring.ftl" as spring />

<h4 class="mb-3">Search Repair</h4>

<form action="/search-repair" method="post">
    <div class="mb-3">
        <label for="datepickerfrom">Date from:</label>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><span data-feather="calendar"></span></span>
            </div>
            <input type="text" class="form-control" id="datepickerfrom" name="date">
        </div>

        <label for="datepickerto">Date to:</label>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><span data-feather="calendar"></span></span>
            </div>
            <input type="text" class="form-control" id="datepickerto" name="date">
        </div>

    </div>
    <button class="btn btn-primary btn-lg mt-4" type="submit">Search</button>
</form>