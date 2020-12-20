<style>

#logo{
    width: 65%;
}

/* On mouse-over */
.sidenav a:hover, .dropdown-btn:hover {
  color: cadetblue;
}

.nav-link:hover {
    color: blue;
}

.dropdown-btn {
    background: inherit;
    border: none;
        border-bottom-color: currentcolor;
        border-bottom-style: none;
        border-bottom-width: medium;
    border-bottom: ridge;
    text-align: left;
    margin: 10;
}


/* Add an active class to the active dropdown button */
.active {
  background-color: gainsboro;
}

/* Dropdown container (hidden by default). Optional: add a lighter background color and some left padding to change the design of the dropdown content */
.dropdown-container {
  display: none;
  padding-left: 8px;
}

.downBtn {
  float: right;
}
</style>

<nav class="col-md-2 d-none d-md-block bg-light sidebar">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
                <a class="nav-link" href="/owner/home">
                    <span><img id="logo" src="/images/logo.png" alt="Logo Image"></span>
                </a>

            <li class="nav-item">
                <a class="nav-link" href="/owner/home">
                    <span data-feather="tool"></span>
                    My Repairs
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/owner/properties">
                    <span data-feather="home"></span>
                    My Properties
                </a>
            </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
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


<script>
/* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
var dropdown = document.getElementsByClassName("dropdown-btn");
var i;

for (i = 0; i < dropdown.length; i++) {
  dropdown[i].addEventListener("click", function() {
  this.classList.toggle("active");
  var dropdownContent = this.nextElementSibling;
  if (dropdownContent.style.display === "block") {
  dropdownContent.style.display = "none";
  } else {
  dropdownContent.style.display = "block";
  }
  });
}

</script>