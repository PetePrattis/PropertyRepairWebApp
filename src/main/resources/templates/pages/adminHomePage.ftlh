
<#import "/spring.ftl" as spring />
<html>
<head>
    <title>Repairs</title>
    <#include "../partials/head.ftlh">
</head>
<body>

<#include "../partials/navbar.ftlh">


<div class="container-fluid">
    <div class="row">
        <#include "../partials/sidebar.ftlh">
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <h3 class="mb-3">Repairs</h3>
  <#if repairList?has_content>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>#ID</th>
                        <th>Date</th>
                        <th>Status</th>
                        <th>Type</th>
                        <th>Cost</th>
                        <th>Address</th>
                        <th>Owner's AFM</th>
                        <th>Info</th>
                        <th class="text-center">Edit</th>
                        <th class="text-center">Remove</th>
                    </tr>
                    </thead>
                    <tbody>
                            <#list repairList as repair>
                            <tr data-id="${repair.id}">
                                <td><a href="/repair/${repair.id}/edit">#${repair.id}</a></td>
                                <td>${repair.date}</td>
                                <td>
                        <#if repair.repairStatus??>
                                ${repair.repairStatus}
                        </#if>
                                </td>
                                <td>
                        <#if repair.repairType??>
                                ${repair.repairType}
                        </#if>
                                </td>
                                <td>${repair.cost}</td>
                                <td>${repair.address}</td>
                                <td>${repair.ownerAfm}</td>
                                <td>${repair.extraInfo}</td>
                                <td class="text-center"><a class="btn btn-link" href="/repair/${repair.id}/edit"><span data-feather="edit"></span></a></td>
                                <td class="text-center">

                                <button
                                        class="btn btn-link"
                                        data-toggle="modal"
                                        data-target="#modal"
                                        data-id="${repair.id}"
                                >
                                    <span data-feather="x"></span>
                                </button>

                                </td>
                            </tr>
                            </#list>
                    </tbody>
                </table>

                <div id="modal" class="modal" tabindex="-1" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Repair</h5>
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
        There are no repairs in progress!
      </#if>
        </main>
    </div>
</div>

<#include "../partials/scripts.ftlh">
</body>
</html>