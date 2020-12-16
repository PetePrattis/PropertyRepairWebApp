<#import "/spring.ftl" as spring />

<h4 class="mb-3">Search book by date</h4>

<form action="/admin/search/betweenDate/repair" method="post">

    <div class="mb-3">
        <label for="datepicker">From Date</label>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><span data-feather="calendar"></span></span>
            </div>
            <input type="text" class="form-control" id="datepicker" name="input">
        </div>
    </div>

    <div class="mb-3">
        <label for="datepicker2">To Date</label>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text"><span data-feather="calendar"></span></span>
            </div>
            <input type="text" class="form-control" id="datepicker2" name="input2">
        </div>
    </div>

    <button class="btn btn-primary btn-lg mt-4" type="submit">Search</button>
</form>