@param String currentMenu

!{var isHome = "home".equals(currentMenu);}
!{var isIssues = "issues".equals(currentMenu);}

<nav class="navbar navbar-expand-lg bg-light" data-bs-theme="light">
    <div class="container">
        <a class="navbar-brand" href="/">
            Basic Web
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#main-navbar"
                aria-controls="main-navbar" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="main-navbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link ${isHome ? "active" : ""}"
                       href="/"
                       aria-current="${isHome ? "page" : null}"
                    >
                        Home
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${isIssues ? "active" : ""}"
                       href="/issues"
                       aria-current="${isIssues ? "page" : null}"
                    >
                        Issues
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>