(()=>{
    const select = document.querySelector("select");
    const form = document.querySelector("#form")
    select.addEventListener("change", (event) => {
        const selectedValue = event.target.value;
        form.action = form.action + selectedValue;
    });

})();