(()=>{
    const select = document.querySelector("select");
    const form = document.querySelector("#form")
    form.action= form.action+select.value;
    console.log(form.action);
})();