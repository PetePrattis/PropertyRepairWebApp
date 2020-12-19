<nav class="col-md-2 d-none d-md-block bg-light sidebar">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="/admin/home">
                    <span data-feather="home"></span>
                    Home
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link active" href="/admin/repairs">
                    <span data-feather="tool"></span>
                    Repairs
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link">
                    <span data-feather="search"></span>
                    Search for Repairs
                </a>
                <ul>
                  <li class="nav-item">
                    <a class="nav-link" href="/admin/search/byDate/repair">Search By Date</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/admin/search/betweenDate/repair">Search Between Date</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/admin/search/byOwnersAfm/repair">Search By Owner's Afm</a>
                  </li>
                </ul>
            </li>



            <li class="nav-item">
                <a class="nav-link" href="/repair/create">
                    <span data-feather="plus-circle"></span>
                    Create Repair
                </a>
            </li>


            <li class="nav-item">
                <a class="nav-link" href="/admin/owners">
                    <span data-feather="users"></span>
                    Owners
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link">
                    <span data-feather="search"></span>
                    Search for Owners
                </a>
                <ul>
                  <li class="nav-item">
                    <a class="nav-link" href="/admin/search/byAFM/owner">Search By AFM</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/admin/search/byEmail/owner">Search By Email</a>
                  </li>
                </ul>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/admin/owners/create">
                    <span data-feather="plus-circle"></span>
                    Create Owner
                </a>
            </li>


            <li class="nav-item">
                <a class="nav-link" href="/admin/properties">
                    <span data-feather="home"></span>
                    Properties
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link">
                    <span data-feather="search"></span>
                    Search for Properties
                </a>
                <ul>
                  <li class="nav-item">
                    <a class="nav-link" href="/admin/search/byPropertyCode/property">Search By Code</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/admin/property/byOwnersAfm/property">Search By Owner's AFM</a>
                  </li>
                </ul>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/admin/property/create">
                    <span data-feather="plus-circle"></span>
                    Create property
                </a>
            </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
            <span>User</span>
        </h6>
        <ul class="nav flex-column mb-2">
            <li class="nav-item">
                <a class="nav-link" href="/">
                    <span data-feather="log-out"></span>
                    Logout
                </a>
            </li>
        </ul>
    </div>
</nav>