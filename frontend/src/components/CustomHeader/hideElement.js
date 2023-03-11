var btnSideBar = document.querySelector(".btn-button-side-bar")

    btnSideBar.addEventListener("click", function() {
        var container = document.getElementById("side-bar-menu")

        if (container.style.display === 'none') {
            container.style.display = 'blcok'
        } else {
            container.style.display = 'none'
        }
    })