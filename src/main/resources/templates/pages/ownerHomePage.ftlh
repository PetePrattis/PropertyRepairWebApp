
<#import "/spring.ftl" as spring />
<html>
<head>
    <#include "../partials/head.ftlh">
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <#include "../partials/ownersidebar.ftlh">
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <h3 class="mb-3">Repairs</h3>
  <#if repairList?has_content>
  <p>Search by any repair attribute</p>
  <input class="form-control" id="myInput" type="text" placeholder="Search..">
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>Date</th>
                        <th>Status</th>
                        <th>Type</th>
                        <th>Cost</th>
                        <th>Address</th>
                        <th>Owner's AFM</th>
                        <th>Info</th>
                    </tr>
                    </thead>
                    <tbody id="myTable">
                            <#list repairList as repair>
                            <tr data-id="${repair.id}">
                                <td>${repair.date}</td>
                                <td>
                        <#if repair.repairStatus??>
                                ${repair.repairStatus.getStatus()}
                        </#if>
                                </td>
                                <td>
                        <#if repair.repairType??>
                                ${repair.repairType.getType()}
                        </#if>
                                </td>
                                <td>${repair.cost}</td>
                                <td>${repair.address}</td>
                                <td>${repair.ownerAfm}</td>
                                <td>${repair.extraInfo}</td>
                            </tr>
                            </#list>
                    </tbody>
                </table>
            </div>
      <#else>
        No repairs found!
      </#if>
        </main>
    </div>
</div>

<#include "../partials/scripts.ftlh">
<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
</body>
</html>