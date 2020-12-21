<#import "/spring.ftl" as spring />
<html>
<head>
    <#include "../partials/head.ftlh">
</head>
<body>

<#include "../partials/navbar.ftlh">


<div class="container-fluid">
    <div class="row">
        <#include "../partials/ownersidebar.ftlh">
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <h3 class="mb-3">Properties</h3>
            <#if propertyList?has_content>
  <p>Search by any property attribute</p>
  <input class="form-control" id="myInput" type="text" placeholder="Search..">
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>Property Code</th>
                        <th>Property Address</th>
                        <th>Property Construction Year</th>
                        <th>Property Type</th>
                        <th>Property's Owner Id</th>
                    </tr>
                    </thead>
                    <tbody id="myTable">
                    <#list propertyList as property>
                    <tr data-id="${property.id}">
                        <td>${property.propertyCode}</td>
                        <td>${property.address}</td>
                        <td>${property.constructionYear}</td>
                        <td>${property.propertyType}</td>
                        <td>${property.ownerAfm}</td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
            <#else>
            No properties found!
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