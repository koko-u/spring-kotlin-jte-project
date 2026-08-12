@import jp.co.kokou.basicwebapp.shared.viewmodel.IPage

@param IPage page

<!doctype html>
<html lang="en">

@template.components.head(title = page.getTitle())

<body class="d-flex flex-column min-vh-100">

@template.components.header(currentMenu = page.getCurrentMenu())

<main class="flex-grow-1">
    <div class="container">
        <h1 class="my-4">Top Page</h1>
    </div>
</main>

</body>
</html>
