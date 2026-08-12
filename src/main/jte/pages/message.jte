@import jp.co.kokou.basicwebapp.features.home.viewmodel.MessagePage

@param MessagePage page

<!doctype html>
<html lang="en">
<head>
    @template.components.head(title = page.getTitle())
</head>

<body class="d-flex flex-column min-vh-100">

@template.components.header(currentMenu = page.getCurrentMenu())

<main class="flex-grow-1">
    <div class="container">
        <h2>Response Page</h2>
        <p class="my-4">
            ${page.getMessage()}
        </p>
    </div>
</main>

</body>
</html>
