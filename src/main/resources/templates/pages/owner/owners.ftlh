
<#import "/spring.ftl" as spring />
<html>
<head>
    <title>Owners</title>
    <#include "../../partials/head.ftlh">
</head>
<body>

<#include "../../partials/navbar.ftlh">


<div class="container-fluid">
    <div class="row">
        <#include "../../partials/sidebar.ftlh">
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <h3 class="mb-3">Owners</h3>
  <#if ownerList?has_content>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>#ID</th>
                        <th>AFM</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Address</th>
                        <th>Telephone Number</th>
                        <th>Email</th>
                        <th class="text-center">Edit</th>
                        <th class="text-center">Remove</th>
                    </tr>
                    </thead>
                    <tbody>
                            <#list ownerList as owner>
                            <tr data-id="${owner.id}">
                                <td><a href="/admin/owner/${owner.id}/edit">#${owner.id}</a></td>
                                <td>${owner.afm}</td>
                                <td>${owner.firstName}</td>
                                <td>${owner.lastName}</td>
                                <td>${owner.address}</td>
                                <td>${owner.telephoneNumber}</td>
                                <td>${owner.email}</td>
                                <td class="text-center"><a class="btn btn-link" href="/admin/owner/${owner.id}/edit"><span data-feather="edit"></span></a></td>
                                <td class="text-center">

                                <button
                                        class="btn btn-link"
                                        data-toggle="modal"
                                        data-target="#ownersModal"
                                        data-id="${owner.id}"
                                >
                                    <span data-feather="x"></span>
                                </button>

                                </td>
                            </tr>
                            </#list>
                    </tbody>
                </table>

                <div id="ownersModal" class="modal" tabindex="-1" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Owner</h5>
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
        There are no owners!
      </#if>
        </main>
    </div>
</div>

<#include "../../partials/scripts.ftlh">
</body>
</html>