<html>
<head>
    <title>Admin page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Repairs</h2>
  <#if repairList?has_content>
      <p>Here are the 10 in progress repairs ordered by date</p>
      <div class="table-responsive">
      <table class="table table-striped">
        <thead>
          <tr>
            <th>#</th>
            <th>Date</th>
            <th>Status</th>
            <th>Type</th>
            <th>Cost</th>
            <th>Address</th>
            <th>Owner's AFM</th>
            <th>Info</th>
          </tr>
        </thead>
        <tbody>
            <#list repairList as repair>
              <tr>
                <td>${repair.id}</td>
                <td>${repair.date?string.short_short}</td>
                <td>${repair.repairStatus}</td>
                <td>${repair.repairType}</td>
                <td>${repair.cost}</td>
                <td>${repair.address}</td>
                <td>${repair.owner.afm}</td>
                <td>${repair.extraInfo}</td>
                <td>
                    <button type="button" class="btn btn-info">Edit Repair</button>
                </td>
                <td>
                    <button type="button" class="btn btn-danger">Delete Repair</button>
                </td>
              </tr>
            </#list>
        </tbody>
      </table>
      </div>
  <#else>
    There are no repairs in progress!
  </#if>
</div>

</body>


</html>