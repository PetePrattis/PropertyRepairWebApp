<#import "/spring.ftl" as spring />
<html>
<head>
    <#include "../../partials/head.ftlh">
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <#include "../../partials/sidebar.ftlh">
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
                        <th class="text-center">Edit</th>
                        <th class="text-center">Remove</th>
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
                        <td class="text-center"><a class="btn btn-link" href="/property/${property.id}/edit"><span data-feather="edit"></span></a></td>
                        <td class="text-center">

                            <button
                                    class="btn btn-link"
                                    data-toggle="modal"
                                    data-target="#propertyModal"
                                    data-id="${property.id}"
                            >
                                <span data-feather="x"></span>
                            </button>

                        </td>
                    </tr>
                    </#list>
                    </tbody>
                </table>

                <div id="propertyModal" class="modal" tabindex="-1" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">repair</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <p>Are you sure?</p>
                            </div>
                            <div class="modal-footer">
                                <form method="post" id="deleteForm">
                                    <button type="submit" class="btn btn-danger">Delete</button>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <#else>
            No properties found!
        </#if>
        </main>
    </div>
</div>

<#include "../../partials/scripts.ftlh">
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