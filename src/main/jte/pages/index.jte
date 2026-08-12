@import jp.co.kokou.basicwebapp.features.home.viewmodel.IndexPage

@param IndexPage page

<!doctype html>
<html lang="en">
<head>
    @template.components.head(title = page.getTitle())
</head>

<body class="d-flex flex-column min-vh-100">

@template.components.header(currentMenu = page.getCurrentMenu())

<main class="flex-grow-1">
    <div class="container">
        <h1 class="my-4">Top Page</h1>
        <div>
            <form method="post" class="row row-cols-lg-auto g-3">
                <div class="col align-self-center">
                    <label class="form-label" for="name">Name</label>
                </div>
                <div class="col align-self-center">
                    <input type="text" class="form-control" id="name" name="name" placeholder="Input your name">
                </div>

                <div class="col align-self-center">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
            @if (!page.getErrors().isEmpty())
                <ul class="list-unstyled">
                    @for (var error : page.getErrors())
                        <li class="text-danger">
                            ${error.getErrorMessage()}
                        </li>
                    @endfor
                </ul>
            @endif
        </div>
    </div>
</main>

</body>
</html>
